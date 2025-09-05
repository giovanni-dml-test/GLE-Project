package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FailedScenarioTagger {

    // Path to the Cucumber rerun file containing failed scenarios with line numbers
    private static final String RERUN_FILE_PATH = "target/failedRerun.txt";

    // Base directory where the feature files are stored
    private static final String FEATURE_BASE_DIR = "src/test/resources/";

    // Tag to mark failed scenarios
    private static final String FAILED_TAG = "@failed";

    // Main method to add @failed tags above scenarios that failed
    public static void tagFailedScenarios() throws IOException {
        System.out.println("Starting tagging of failed scenarios...");

        // Read and parse failed scenario line numbers from failedRerun.txt
        Map<Path, List<Integer>> failureMap = extractFailures();

        if (failureMap.isEmpty()) {
            System.out.println("No failures found in rerun file.");
            return;
        }

        // Iterate through each feature file and its corresponding failed line numbers
        for (Map.Entry<Path, List<Integer>> entry : failureMap.entrySet()) {
            Path featurePath = entry.getKey();                  // The path to the feature file
            List<Integer> failedLines = entry.getValue();       // The line numbers where failures occurred

            System.out.println("Processing file: " + featurePath.toAbsolutePath());

            // Skip if the feature file does not exist
            if (!Files.exists(featurePath)) {
                System.err.println("Feature file not found: " + featurePath);
                continue;
            }

            // Read all lines from the feature file into memory
            List<String> lines = Files.readAllLines(featurePath);

            // Reverse sort the failed lines so that we can safely insert lines without affecting indices
            failedLines.sort(Collections.reverseOrder());

            // Process each failed line
            for (int lineNumber : failedLines) {
                // Find the line number of the corresponding Scenario or Scenario Outline
                int scenarioLineIndex = findScenarioLineIndex(lines, lineNumber);

                // Skip if scenario header could not be found
                if (scenarioLineIndex == -1) {
                    System.err.println("Could not find scenario line for line " + lineNumber + " in " + featurePath);
                    continue;
                }

                // Skip if the scenario already has a @failed tag above it
                if (scenarioLineIndex > 0 && lines.get(scenarioLineIndex - 1).trim().equals(FAILED_TAG)) {
                    System.out.println("Skipping line " + scenarioLineIndex + " as it already has @failed tag.");
                    continue;
                }

                // Insert the @failed tag one line before the scenario header
                System.out.println("Inserting @failed tag at line " + scenarioLineIndex + " in file " + featurePath.getFileName());
                lines.add(scenarioLineIndex, FAILED_TAG);
            }

            // Write the updated content back to the feature file
            Files.write(featurePath, lines);
            System.out.println("Updated feature file: " + featurePath.getFileName());
        }

        System.out.println("Tagging completed.");
    }

    /**
     * Reads the rerun file and builds a map of feature file paths to lists of failed line numbers.
     * Handles both single line and range formats in rerun.txt like:
     * - classpath:features/Login.feature:10
     * - classpath:features/Login.feature:15:17
     */
    private static Map<Path, List<Integer>> extractFailures() throws IOException {
        Map<Path, List<Integer>> failureMap = new HashMap<>();

        // Regex to extract file path and line numbers from lines like: classpath:features/Login.feature:12:14
        Pattern pattern = Pattern.compile("classpath:(.+?):(\\d+)(?::(\\d+))?");

        Path rerunPath = Paths.get(RERUN_FILE_PATH);
        if (!Files.exists(rerunPath)) {
            System.err.println("Rerun file not found: " + RERUN_FILE_PATH);
            return failureMap;
        }

        // Read and parse each line in the rerun file
        for (String line : Files.readAllLines(rerunPath)) {
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()) {
                String relativePath = matcher.group(1);              // e.g., features/Login.feature
                int from = Integer.parseInt(matcher.group(2));       // start line number
                int to = matcher.group(3) != null
                        ? Integer.parseInt(matcher.group(3))        // end line if range exists
                        : from;                                     // else use same line

                // Full path to the feature file
                Path fullPath = Paths.get(FEATURE_BASE_DIR + relativePath);

                // Add line numbers to the map, adjusting for 0-based index
                failureMap.putIfAbsent(fullPath, new ArrayList<>());
                for (int i = from; i <= to; i++) {
                    failureMap.get(fullPath).add(i - 1);
                }
            }
        }

        return failureMap;
    }

    /**
     * Given the line index of a failed step, backtrack to find the line where
     * the scenario or scenario outline starts.
     *
     * @param lines All lines from the feature file
     * @param failedLineIndex Index of the failed line (0-based)
     * @return Index of the scenario/outline line that the failed step belongs to
     */
    private static int findScenarioLineIndex(List<String> lines, int failedLineIndex) {
        for (int i = failedLineIndex; i >= 0; i--) {
            String line = lines.get(i).trim();
            if (line.startsWith("Scenario") || line.startsWith("Scenario Outline")) {
                return i;
            }
        }
        return -1;  // No scenario header found
    }
}
