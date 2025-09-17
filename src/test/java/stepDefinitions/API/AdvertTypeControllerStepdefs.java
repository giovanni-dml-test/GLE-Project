package stepDefinitions.API;

import baseUrl.GetLandEstateBaseUrl;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static io.restassured.RestAssured.given;

import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static utils.GetLandAuthentication.generateToken;


public class AdvertTypeControllerStepdefs extends GetLandEstateBaseUrl {

    Response response;
    private static Integer advertTypeId;   // to store created id
    private static String advertTitle; // to store created title

    // ------------------ GET ------------------

    @Given("I send a GET request")
    public void i_send_a_get_request() {
        spec.pathParams("first", "advert-types", "second", "all");
        response = given(spec).when().get("{first}/{second}");
        response.prettyPrint();
    }

    @Then("Response status code should be {int}")
    public void response_status_code_should_be(Integer expectedStatusCode) {
        assertEquals(expectedStatusCode.intValue(), response.statusCode());
    }

    @Then("Response body should contain title")
    public void response_body_should_contain_title() {
        response.then().body("title", notNullValue());
    }

    // ------------------ POST ------------------

    @When("I send a POST request to create advert type")
    public void i_send_a_post_request_to_create_advert_type() {
        spec.pathParam("first", "advert-types");

        // generate unique title
        Faker faker = new Faker();
        advertTitle = faker.company().name();
        advertTitle = advertTitle.replaceAll("[^A-Za-z\\- ]", "");

        Map<String, Object> payloadMap = new HashMap<>();
        payloadMap.put("title", advertTitle);

        response = given(spec)
                .body(payloadMap)
                .when()
                .post("{first}");

        response.prettyPrint();

        // store id for later use
        if (response.statusCode() == 200) {
            advertTypeId = response.then().extract().path("id");
        } else {
            advertTypeId = null;
        }

    }

    @Then("Response should contain created title")
    public void response_should_contain_created_title() {
        response.then().body("title", equalTo(advertTitle));
    }

    // ------------------ PUT ------------------

    @When("I send a PUT request to update advert type")
    public void i_send_a_put_request_to_update_advert_type() {
        System.out.println("put AdvertTypeid: " + advertTypeId);
        spec.pathParams("first", "advert-types", "second", advertTypeId);

        String updatedTitle = advertTitle + "-Updated";

        Map<String, Object> payloadMap = new HashMap<>();
        payloadMap.put("title", updatedTitle);

        response = given(spec)
                .body(payloadMap)
                .when()
                .put("{first}/{second}");

        advertTitle = updatedTitle; // update stored value
        response.prettyPrint();
    }

    @Then("Response should contain updated title")
    public void response_should_contain_updated_title() {
        response.then().body("title", equalTo(advertTitle));
    }

    // ------------------ DELETE ------------------

    /* @When("I send a DELETE request")
     public void i_send_a_delete_request() {
         spec.pathParams("first", "advert-types", "second", advertTypeId);
         System.out.println("advertypeId " + advertTypeId);
         response = given(spec).log().all().when().delete("{first}/{second}").then().log().all();
         response.prettyPrint();

     */
    @When("I send a DELETE request")
    public void i_send_a_delete_request() {
        if (advertTypeId == null) {
            System.out.println("Skipping DELETE: advertTypeId is null");
            return;
        }

        spec.pathParams("first", "advert-types", "second", advertTypeId);
        // System.out.println("advertTypeId: " + advertTypeId);

        // Send DELETE and store response as Response
        response = given(spec)
                .log().all() // log request
                .when()
                .delete("{first}/{second}");

        response.prettyPrint(); // log response body

        //  log status code
        System.out.println("DELETE status code: " + response.statusCode());


    }

}