package Rest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;

public class Generator {

    public void cadastrarBrutusDog() {

        baseURI="https://petstore.swagger.io/v2";
        given()
                .log().all()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 122,\n" +
                        "  \"category\": {\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"dog\"\n" +
                        "  },\n" +
                        "  \"name\": \"Brutus\",\n" +
                        "  \"photoUrls\": [\n" +
                        "    \"string\"\n" +
                        "  ],\n" +
                        "  \"tags\": [\n" +
                        "    {\n" +
                        "      \"id\": 0,\n" +
                        "      \"name\": \"string\"\n" +
                        "    }\n" +
                        "  ],\n" +
                        "  \"status\": \"available\"\n" +
                        "}")
                .when()
                .post("/pet")
                .then()
                .statusCode(200);
    }

    public void CadastrarUser() {


        baseURI="https://petstore.swagger.io/v2";
        given()
                .log().all()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 12345,\n" +
                        "  \"username\": \"mariana123\",\n" +
                        "  \"firstName\": \"Mariana\",\n" +
                        "  \"lastName\": \"Assunção\",\n" +
                        "  \"email\": \"mariana123@email.com\",\n" +
                        "  \"password\": \"123456\",\n" +
                        "  \"phone\": \"1199887766554\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when()
                .post("/user")
                .then()
                .log().all()
                .statusCode(200)
                .body("message", is(notNullValue()));
    }

}
