package com.pdi.tests.contract;

import client.EstagiarioClient;
import io.restassured.module.jsv.JsonSchemaValidator;
import model.responses.BaseResponse;
import model.responses.ErrorResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;


public class EstagiarioContractTest {
    private EstagiarioClient estagiarioClient = new EstagiarioClient();

    @Test
    public void testValidateAValidCaseOfListAllEstagiariosContract() {
        estagiarioClient.searchAll()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/estagiario/buscar_todos_estagiarios.json"))
                    .extract().as(BaseResponse.class);
    }

    @Test
    public void testValidateAValidCaseOfListAllEstagiariosWithPaginationContract() {
        estagiarioClient.searchAllWithPagination("1", "1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/estagiario/buscar_todos_estagiarios.json"))
                    .extract().as(BaseResponse.class);
    }

    @Test
    public void testAInvalidCaseOfListAllWithInvalidPaginationContract() {
        estagiarioClient.searchAllWithPagination("-1", "-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/error_response.json"))
                    .extract().as(ErrorResponse.class);
    }

    // TODO: teste quebrado por ter sofrido alterações no contrato
    @Test
    public void testValidateAValidCaseOfGetRelatoryInformationsAboutEstagiarioContract() {
        estagiarioClient.getRelatory("1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/estagiario/obter_infos_relatorio_do_estagiario.json"))
                    .extract().as(BaseResponse.class);
    }

    @Test
    public void testAInvalidCaseOfGetRelatoryInformationsAboutEstagiarioContract() {
        estagiarioClient.getRelatory("-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/error_response.json"))
                    .extract().as(ErrorResponse.class);
    }
}
