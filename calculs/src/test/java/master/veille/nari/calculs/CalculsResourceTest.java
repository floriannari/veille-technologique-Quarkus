package master.veille.nari.calculs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class CalculsResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/calculs/levenshtein?str1=azer&str2=azet")
          .then()
             .statusCode(200)
             .body(is("1"));
    }

}