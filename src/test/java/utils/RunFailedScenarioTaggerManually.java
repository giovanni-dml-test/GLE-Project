package utils;

public class RunFailedScenarioTaggerManually {

    // Entry point to run the FailedScenarioTagger from the command line or manually
    public static void main(String[] args) {
        try {
            // Inform the user that tagging is starting
            System.out.println("Running FailedScenarioTagger...");

            // Call the static method to begin tagging failed scenarios with @failed tag
            FailedScenarioTagger.tagFailedScenarios();

            // Inform the user that tagging has finished
            System.out.println("Tagging complete.");
        } catch (Exception e) {
            // Catch any exceptions that occur during tagging and print the stack trace
            System.out.println("Exception occurred during tagging:");
            e.printStackTrace();
        }
    }
}
