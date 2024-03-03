package client;

import io.restassured.response.Response;
import specs.InitialPDISpecs;

import static io.restassured.RestAssured.given;

public class TrilhaClient {
    private static final String PATH = "/trilha/{nome}";
    private static final Boolean IS_IN_RELEASE = false;

    public Response getTrilha(String name) {
        return
                given()
                        .spec(InitialPDISpecs.setup(IS_IN_RELEASE))
                .when()
                        .with()
                        .pathParam("nome", name)
                        .get(PATH)
                ;
    }
}
