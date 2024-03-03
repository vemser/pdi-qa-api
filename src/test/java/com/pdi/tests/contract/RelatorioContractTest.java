package com.pdi.tests.contract;

import client.RelatorioClient;
import io.restassured.module.jsv.JsonSchemaValidator;
import model.responses.BaseResponse;
import model.responses.ErrorResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

public class RelatorioContractTest {
    private RelatorioClient relatorioClient = new RelatorioClient();

    // TODO: teste válido quebrado por não existir um usuário mockado preparado
    @Test
    public void testValidateAValidCaseOfGetRelatoryContract() {
        relatorioClient.generateAPDFRelatory("1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/relatorio/gerar_relatorio_do_estagiario.json"))
                    .extract().as(BaseResponse.class)
                ;
    }

    @Test
    public void testAInvalidCaseOfGetRelatoryWithInvalidIdContract() {
        relatorioClient.generateAPDFRelatory("-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/error_response.json"))
                    .extract().as(ErrorResponse.class)
                ;
    }

    @Test
    public void testAInvalidCaseOfGetRelatoryWithInvalidStringIdContract() {
        relatorioClient.generateAPDFRelatory("a")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_BAD_REQUEST)
                ;
    }
}
