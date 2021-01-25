package Rest;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class RestTest {

    @Test
    public void validarStausCode200AcceptanceTest() {


        given()
                .when()
                .get("https://api.chucknorris.io/jokes/random")
                .then().statusCode(200);
    }


    @Test
    public void validarTextoResponseBody() {
        given()
                .when()
                .get("https://api.chucknorris.io/jokes/categories")
                .then().statusCode(200)
                .body(Matchers.containsString("animal"))
                .body(Matchers.is(Matchers.notNullValue()));

    }


    @Test
    public void testeConsultaDeInfosFilmeRocky() {

        //pré condições para a requisição
        given()

                .header("x-rapidapi-key", "27fd4b46afmsh0ddb4302ff5d417p1013d9jsn0014ab1b129d")
                .header("x-rapidapi-host", "imdb-internet-movie-database-unofficial.p.rapidapi.com")
                .accept(ContentType.fromContentType("application/json"))
                //Requisição e Método HTTP
                .when()
                .get("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/film/Rocky")
                //Validação de Critérios de Aceite
                .then()
                //Validação de Status Code
                .statusCode(200)
                //Validação de Objetos de primeiro nível no Json Response Body
                .body("length", Matchers.is("2h"))
                .body("id", Matchers.is("tt0075148"))
                //Validação de objetos de segundo nível no JSON Response Body
                .body("trailer.id", Matchers.is("vi2997093657"))
                //Validação de objetos em lista no JSON Response Body
                .body("cast[0].actor", Matchers.is("Sylvester Stallone"))
                .body("cast[4].character", Matchers.is("Mickey"))
        ;

    }


}
