package hooks;

import baseUrl.GetLandEstateBaseUrl;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.ExtentReportUtils;

import static io.restassured.RestAssured.given;


public class HooksAPI {


        @Before
        public void setUpApi() {

            GetLandEstateBaseUrl.setUp();
            ExtentReportUtils.createTestReport("Test Report", "User Controller");
        }




       @After("@api")
        public void cleanUpTestData() {
            // Example cleanup logic:
            // If you inserted a user with a known test email, delete it after the scenario.
            String testEmail = "john.doe@test.com";

            try {
                given()
                        .header("Content-Type", "application/json")
                        .queryParam("email", testEmail)
                        .when()
                        .delete("/users/delete")
                        .then()
                        .statusCode(200);

                System.out.println("Cleaned up test user: " + testEmail);
            } catch (Exception e) {
                System.out.println("No cleanup needed or API delete not implemented");
            }


        }


    }

