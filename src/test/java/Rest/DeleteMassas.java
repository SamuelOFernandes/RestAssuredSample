package Rest;

import static io.restassured.RestAssured.given;

public class DeleteMassas {

    public void deletarUser() {


        given()
                .log().all()
                .contentType("application/json")
                .pathParam("userName", "mariana123")
                .when()
                .delete("https://petstore.swagger.io/v2/user/{userName}")
                .then()
                .statusCode(200);

    }

    public void deletarPet() {

        given()
                .log().all()
                .contentType("application/json")
                .pathParam("petId", "122")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/{petId}")
                .then()
                .statusCode(200);
    }
}