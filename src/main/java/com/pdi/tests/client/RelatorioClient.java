package com.pdi.tests.client;

import io.restassured.response.Response;
import com.pdi.tests.specs.InitialPDISpecs;

import static io.restassured.RestAssured.given;

public class RelatorioClient {
    private static final String PATH = "/relatorio/{idEstagiario}";
    private static final Boolean IS_IN_RELEASE = false;

    public RelatorioClient() {}

    public Response generateAPDFRelatory(String idEstagiario) {
        return
                given()
                        .spec(InitialPDISpecs.setup(IS_IN_RELEASE))
                .when()
                        .with()
                        .pathParam("idEstagiario", idEstagiario)
                        .get(PATH)
                ;
    }
}
