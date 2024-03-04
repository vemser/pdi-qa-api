package com.pdi.tests.client;

import io.restassured.response.Response;
import com.pdi.tests.specs.InitialPDISpecs;

import static io.restassured.RestAssured.given;

public class TrilhaClient {
    private static final String PATH = "/trilha/{nome}";

    public Response getTrilha(String name) {
        return
                given()
                        .spec(InitialPDISpecs.setup())
                .when()
                        .with()
                        .pathParam("nome", name)
                        .get(PATH)
                ;
    }
}
