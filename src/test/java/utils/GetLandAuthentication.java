package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

   public class GetLandAuthentication {

        public static String generateToken() {

            String url = "http://64.227.123.49:8092/users/login";


            String credentials = "{\"email\": \"admin@gmail.com\",\"password\": \"admin123!\"}";
            Response response = given().when().
                    contentType(ContentType.JSON).
                    body(credentials).post(url);
            return response.jsonPath().getString("token");

        }

    }
