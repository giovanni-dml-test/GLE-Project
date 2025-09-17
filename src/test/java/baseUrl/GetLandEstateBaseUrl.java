package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static utils.GetLandAuthentication.generateToken;

public class GetLandEstateBaseUrl {

    protected static RequestSpecification spec;
    private static final String BASE_URL = "http://64.227.123.49:8092/";

    public static void setUp() {
        spec = new RequestSpecBuilder().
                setBaseUri(BASE_URL).
                setContentType(ContentType.JSON).
                addHeader("Authorization", "Bearer " + generateToken()).
                build();

    }
}