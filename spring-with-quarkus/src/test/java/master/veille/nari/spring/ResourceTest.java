package master.veille.nari.spring;

import static io.restassured.RestAssured.given;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class ResourceTest {
	
    @Test
    public void test() {
        given()
          .when().get("/users")
          .then()
            .statusCode(200);
    }
}