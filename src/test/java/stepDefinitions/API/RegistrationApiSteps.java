package stepDefinitions.API;

import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class RegistrationApiSteps {

    private static String BASE_URL = "http://64.227.123.49:8092";
    private Response response;
    private String requestBody;

    @Given("the base API URL is set")
    public void setBaseUrl() {
        baseURI = BASE_URL;
    }

    @When("I send a POST request to {string} with the following body:")
    public void sendPostRequest(String endpoint, String body) {
        requestBody = body;

        response = given()
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void validateStatusCode(int expectedStatus) {
        assertEquals(expectedStatus, response.getStatusCode());
    }

    @Then("the response body should contain {string}")
    public void validateResponseBodyContains(String expectedText) {
        String responseBody = response.getBody().asString();
        assertTrue("Response body does not contain expected text: " + expectedText,
                responseBody.contains(expectedText));
    }

    @Given("a user already exists with email {string}")
    public void ensureUserAlreadyExists(String email) {
        // Reuse API to create a user before testing duplicate case
        String duplicateUser = "{\n" +
                "  \"firstName\": \"Jane\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"phone\": \"0987654321\",\n" +
                "  \"email\": \"" + email + "\",\n" +
                "  \"password\": \"ValidPass123!\"\n" +
                "}";

        given()
                .header("Content-Type", "application/json")
                .body(duplicateUser)
                .when()
                .post("/users/register");
    }
}
