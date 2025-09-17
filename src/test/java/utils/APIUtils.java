package utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.Map;

public class APIUtils {

    // Base URL - you can externalize this in ConfigReader
    private static final String BASE_URL = "http://64.227.123.49:8092/api";

    /**
     * Registers a new customer via API
     *
     * @param customerData Map with keys: firstName, lastName, phone, email, password, confirmPassword
     * @return HTTP status code of the response
     */
    public static int registerCustomer(Map<String, String> customerData) {
        Response response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .body(customerData)
                .when()
                .post("/users/register") // adjust if Swagger shows different endpoint
                .then()
                .extract()
                .response();

        System.out.println("API Response: " + response.asPrettyString());
        return response.getStatusCode();
    }

    /**
     * Fetch customer details by email
     *
     * @param email customer's email
     * @return Response body as string
     */
    public static String getCustomerByEmail(String email) {
        Response response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .queryParam("email", email) // adjust if endpoint expects path param instead
                .when()
                .get("/users")
                .then()
                .extract()
                .response();

        System.out.println("Get Customer Response: " + response.asPrettyString());
        return response.asPrettyString();
    }

    /**
     * Delete customer by email
     *
     * @param email customer's email
     * @return HTTP status code
     */
    public static int deleteCustomer(String email) {
        Response response = RestAssured
                .given()
                .baseUri(BASE_URL)
                .queryParam("email", email) // adjust if Swagger shows different
                .when()
                .delete("/users")
                .then()
                .extract()
                .response();

        System.out.println("Delete Customer Response: " + response.asPrettyString());
        return response.getStatusCode();
    }


}
