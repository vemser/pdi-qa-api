package com.pdi.tests.client;

import io.restassured.response.Response;
import com.pdi.tests.specs.InitialPDISpecs;

import static io.restassured.RestAssured.given;

public class AcompanhamentoClient {
    private static final String PATH = "/acompanhamento/listarAcompanhamentos";
    private static final String PAGE = "?page=";
    private static final String SIZE = "&size=";

    public AcompanhamentoClient() {}

    public Response listarTodos() {
        return
                given()
                        .spec(InitialPDISpecs.setup())
                .when()
                        .get(PATH)
                ;
    }


    public Response listarTodosComPaginacao(String page, String size) {
        return
                given()
                        .spec(InitialPDISpecs.setup())
                .when()
                        .get(PATH + PAGE + page + SIZE + size)
                ;
    }
}
