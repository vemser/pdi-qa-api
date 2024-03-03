package com.pdi.tests.contract;

import client.AcompanhamentoClient;
import io.restassured.module.jsv.JsonSchemaValidator;
import model.responses.AcompanhamentoResponse;
import model.responses.ErrorResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;


public class AcompanhamentoContractTest {
    private AcompanhamentoClient acompanhamentoClient = new AcompanhamentoClient();

    @Test
    public void testValidateAValidCaseOfListAllAgendamentosContract() {
        acompanhamentoClient.listarTodos()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/acompanhamento/listar_todos.json"))
                    .extract().as(AcompanhamentoResponse.class);
    }

    @Test
    public void testAInvalidCaseOfListAllWithInvalidPaginationContract() {
        acompanhamentoClient.listarTodosComPaginacao("-1", "-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/error_response.json"))
                    .extract().as(ErrorResponse.class);
    }

    @Test
    public void testAInvalidCaseOfListAllWithInvalidPaginationWithTextContract() {
        acompanhamentoClient.listarTodosComPaginacao("a", "a")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }

    @Test
    public void testAInvalidCaseOfListAllWithEmptyPaginationContract() {
        acompanhamentoClient.listarTodosComPaginacao(" ", " ")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/error_response.json"))
                    .extract().as(ErrorResponse.class);
        ;
    }
}
