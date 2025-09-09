package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class HooksAPI {

    private static final String BASE_URL = "http://64.227.123.49:8092";

    @Before("@api")
    public void setUpApi() {
        baseURI = BASE_URL;
        System.out.println("🔧 Setting API base URI: " + baseURI);
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
