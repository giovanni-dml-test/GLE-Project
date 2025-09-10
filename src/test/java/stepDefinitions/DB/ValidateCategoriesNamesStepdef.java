package stepDefinitions.DB;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ValidateCategoriesNamesStepdef {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    @Given("i have the access to the database")
    public void i_have_the_access_to_the_database() throws SQLException {

        connection = DBUtils.createConnection();
        statement = connection.createStatement();

    }

    @When("i fetch the structure of the {string} table")
    public void i_fetch_the_structure_of_the_table(String tableName) throws SQLException {
        tableName = tableName.toLowerCase();

        // Query to fetch column names and data types
        String query = "SELECT column_name, data_type " +
                "FROM information_schema.columns " +
                "WHERE table_schema = 'public' " +
                "AND table_name = ?";

        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, tableName);
        resultSet = pstmt.executeQuery();

    }


    @Then("the table should have the following columns:")
    public void the_table_should_have_the_following_columns(io.cucumber.datatable.DataTable dataTable) throws SQLException {
        List<String> expectedColumns = dataTable.asList();
        System.out.println("expected column " + expectedColumns);

        List<String> actualColumns = new ArrayList<>();
        while (resultSet.next()) {
            actualColumns.add(resultSet.getString("column_name"));
        }

        System.out.println("actual columns " + actualColumns);

        for (String column : expectedColumns) {
            assertTrue("Column missing: " + column, actualColumns.contains(column));

        }


    }

    @Then("i fetch all records from the categories table")
    public void i_fetch_all_records_from_the_categories_table() throws SQLException {
        resultSet = statement.executeQuery("SELECT * FROM categories");
    }


    @Then("each category record should have valid data")
    public void each_category_record_should_have_valid_data() throws SQLException {

        while (resultSet.next()) {

            // ID validation (must not be NULL)
            Object id = resultSet.getObject("id");
            assertNotNull("ID should not be null", id);

            // created_at, updated_at, title validation
            assertNotNull("created_at should not be null", resultSet.getTimestamp("created_at"));
            String title = resultSet.getString("title");
            assertNotNull("title should not be null", title);
            assertFalse("title should not be empty", title.trim().isEmpty());

            // boolean validation
            boolean isActive = resultSet.getBoolean("is_active");
            boolean builtIn = resultSet.getBoolean("built_in");

            //  validate non-null
            assertFalse("is_active column was NULL", resultSet.wasNull());

            // slug and icon validation
            String slug = resultSet.getString("slug");
            assertNotNull("slug should not be null", slug);
            assertFalse("slug should not be empty", slug.trim().isEmpty());

            String icon = resultSet.getString("icon");
            if (icon != null) {  // optional column
                assertFalse("icon should not be empty if present", icon.trim().isEmpty());
            }
        }


    }
}
