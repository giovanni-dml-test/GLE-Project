package stepDefinitions.DB;



import io.cucumber.java.en.*;
import org.junit.Assert;
import utils.APIUtils;
import utils.DBUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import static utils.DBUtils.executeQuery;

public class CustomerRegistrationDBSteps {

        private String latestEmail;
        private int latestApiStatus;

        @Given("a database connection is established")
        public void a_database_connection_is_established() {
            DBUtils.createConnection();
        }

        @Given("a new customer registers via API with the following details:")
        public void a_new_customer_registers_via_api(io.cucumber.datatable.DataTable dataTable) {
            Map<String, String> customerData = dataTable.asMaps().get(0);

            // Call API to create customer (utility wrapper for RestAssured or HttpClient)
            latestApiStatus = APIUtils.registerCustomer(customerData);

            // Save email for later validation
            latestEmail = customerData.get("email");
        }

        @Then("the customer with email {string} should exist in the database")
        public void the_customer_with_email_should_exist_in_the_database(String email) throws SQLException {
            ResultSet rs = executeQuery("SELECT * FROM customers WHERE email = '" + email + "'");
            Assert.assertTrue("Customer not found in DB", rs.next());
        }

        @Then("the customer first name should be {string}")
        public void the_customer_first_name_should_be(String expected) throws SQLException {
            ResultSet rs = executeQuery("SELECT first_name FROM customers WHERE email = '" + latestEmail + "'");
            if (rs.next()) {
                Assert.assertEquals(expected, rs.getString("first_name"));
            } else {
                Assert.fail("Customer not found for email: " + latestEmail);
            }
        }

        @Then("the customer last name should be {string}")
        public void the_customer_last_name_should_be(String expected) throws SQLException {
            ResultSet rs = executeQuery("SELECT last_name FROM customers WHERE email = '" + latestEmail + "'");
            if (rs.next()) {
                Assert.assertEquals(expected, rs.getString("last_name"));
            } else {
                Assert.fail("Customer not found for email: " + latestEmail);
            }
        }

        @Then("the customer phone should be {string}")
        public void the_customer_phone_should_be(String expected) throws SQLException {
            ResultSet rs = executeQuery("SELECT phone FROM customers WHERE email = '" + latestEmail + "'");
            if (rs.next()) {
                Assert.assertEquals(expected, rs.getString("phone"));
            } else {
                Assert.fail("Customer not found for email: " + latestEmail);
            }
        }

        @Then("the registration API should return status {int}")
        public void the_registration_api_should_return_status(Integer expectedStatus) {
            Assert.assertEquals(expectedStatus.intValue(), latestApiStatus);
        }

        @Then("the customer with email {string} should still have first name {string}")
        public void the_customer_with_email_should_still_have_first_name(String email, String expected) throws SQLException {
            ResultSet rs = executeQuery("SELECT first_name FROM customers WHERE email = '" + email + "'");
            if (rs.next()) {
                Assert.assertEquals(expected, rs.getString("first_name"));
            } else {
                Assert.fail("Customer not found for email: " + email);
            }
        }

        @Then("the customer with email {string} should not exist in the database")
        public void the_customer_with_email_should_not_exist_in_the_database(String email) throws SQLException {
            ResultSet rs = executeQuery("SELECT * FROM customers WHERE email = '" + email + "'");
            Assert.assertFalse("Customer should not exist in DB", rs.next());
        }

        @Given("I delete the customer with email {string} from the database")
        public void i_delete_the_customer_with_email_from_the_database(String email) {
            DBUtils.executeUpdate("DELETE FROM customers WHERE email = '" + email + "'");
        }

}
