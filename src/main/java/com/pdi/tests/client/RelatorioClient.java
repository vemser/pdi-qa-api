package com.pdi.tests.client;

import io.restassured.response.Response;
import com.pdi.tests.specs.InitialPDISpecs;

import static io.restassured.RestAssured.given;

public class RelatorioClient {
    private static final String PATH = "/relatorio/{idEstagiario}";

    public RelatorioClient() {}

    public Response generateAPDFRelatory(String idEstagiario) {
        return
                given()
                        .spec(InitialPDISpecs.setup())
                .when()
                        .with()
                        .pathParam("idEstagiario", idEstagiario)
                        .get(PATH)
                ;
    }
}
