package com.pdi.tests.contract;

import com.pdi.tests.client.AcompanhamentoClient;
import io.restassured.module.jsv.JsonSchemaValidator;
import com.pdi.tests.model.responses.ErrorResponse;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class AcompanhamentoContractTest {
    private final AcompanhamentoClient acompanhamentoClient = new AcompanhamentoClient();

    @Test
    @DisplayName("Validar contrato do retorno de todos os acompanhamentos")
    public void testValidateAValidCaseOfListAllAgendamentosContract() {
        acompanhamentoClient.listarTodos()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/acompanhamento/listar_todos.json"))
                ;
    }

    @Test
    @DisplayName("Validar contrato do retorno de todos os acompanhamentos com paginação inválida - variação 01")
    public void testAInvalidCaseOfListAllWithInvalidPaginationContract() {
        acompanhamentoClient.listarTodosComPaginacao("-1", "-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/error_response.json"))
                ;
    }

    // TODO: futuramente o backend deve retornar um erro 400, mas atualmente está retornando body vazio
    @Test
    @DisplayName("Validar contrato do retorno de todos os acompanhamentos com paginação invalida - variação 02")
    public void testAInvalidCaseOfListAllWithInvalidPaginationWithTextContract() {
        acompanhamentoClient.listarTodosComPaginacao("a", "a")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_BAD_REQUEST)
        ;
    }

    @Test
    @DisplayName("Validar contrato do retorno de todos os acompanhamentos com paginação vazia")
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
