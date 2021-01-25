package Rest;

import org.junit.*;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.Is.is;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PetstoreApiTest {



    @BeforeClass
   public static void setUp(){

        Generator generator =new Generator();
        generator.CadastrarUser();
        generator.cadastrarBrutusDog();
    }






    @Test
    public void testA_atualizarAOrdemDeVendaDoBrutus() {

        baseURI="https://petstore.swagger.io/v2";
        given()
                .log().all()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"petId\": 122,\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"status\": \"delivered\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .when()
                .post("/store/order")
                .then()
                .statusCode(200);

    }

    @Test
    public void testB_ValidarIdDeOrdemDeVendaBrutus() {

        baseURI="https://petstore.swagger.io/v2";
        given()
                .log().all()
                .contentType("application/json")
                .pathParam("orderId", "1")
                .when()
                .get("/store/order/{orderId}")
                .then()
                .statusCode(200)
                .body("id", is(1))
                .body("petId",is(122))
                .body("status", is("delivered"));


    }


    @AfterClass
    public static void deletarMassas() {
        DeleteMassas delete = new DeleteMassas();
        delete.deletarUser();
        delete.deletarPet();

    }


}







