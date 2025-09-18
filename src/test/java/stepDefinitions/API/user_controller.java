package stepDefinitions.API;

import baseUrl.GetLandEstateBaseUrl;
import io.cucumber.java.en.*;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class user_controller {

    private Response response;

    @Given("the base URL")
    public void setBaseUrl() {
        GetLandEstateBaseUrl.setUp();  // initialize spec with BASE_URL + token
    }

    @When("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = given()
                .spec(GetLandEstateBaseUrl.spec)   // use the spec instead of baseUri
                .when()
                .get(endpoint);
    }

    @When("I send a DELETE request to {string} with body:")
    public void sendDeleteRequest(String endpoint, String body) {
        response = given()
                .spec(GetLandEstateBaseUrl.spec)
                .body(body)
                .when()
                .delete(endpoint);
    }

    @When("I send a POST request to {string} with body:")
    public void sendPostRequest(String endpoint, String body) {
        response = given()
                .spec(GetLandEstateBaseUrl.spec)
                .body(body)
                .when()
                .post(endpoint);
    }

    @When("I send a PUT request to {string} with body:")
    public void sendPutRequest(String endpoint, String body) {
        response = given()
                .spec(GetLandEstateBaseUrl.spec)
                .body(body)
                .when()
                .put(endpoint);
    }

    @When("I send a PATCH request to {string} with body:")
    public void sendPatchRequest(String endpoint, String body) {
        response = given()
                .spec(GetLandEstateBaseUrl.spec)
                .body(body)
                .when()
                .patch(endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int statusCode) {
        assertEquals("Status code mismatch", statusCode, response.getStatusCode());
    }

    @Then("the response should contain {string}")
    public void verifyResponseContains(String key) {
        response.then().body("$", hasKey(key));
    }
}

