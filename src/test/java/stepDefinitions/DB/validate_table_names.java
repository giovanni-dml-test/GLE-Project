package stepDefinitions.DB;


import io.cucumber.java.en.*;
import utils.DBUtils;
import org.junit.Assert;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class validate_table_names {

    private List<String> actualTables;

    Connection connection;
    Statement statement;


    @Given("the database connection is established")
    public void connectToDatabase() throws SQLException {

        connection = DBUtils.createConnection();
        statement = connection.createStatement();

    }

    @When("I retrieve the list of tables")
    public void retrieveTables() throws SQLException {
        List<Map<String, Object>> tables = DBUtils.getQueryResultMap("SELECT table_name FROM information_schema.tables WHERE table_schema='public'");


        actualTables = new ArrayList<>();
        for (Map<String, Object> row : tables) {

            for (Object tableName : row.values()) {
                actualTables.add(tableName.toString().toLowerCase());
                System.out.println(tableName.toString());
            }
        }
    }

    @Then("the following tables should exist:")
    public void verifyTables(io.cucumber.datatable.DataTable dataTable) {
        List<String> expectedTables = dataTable.asList();

        for (String expected : expectedTables) {
            Assert.assertTrue("Table not found: " + expected,
                    actualTables.contains(expected.toLowerCase()));
        }
    }
}
