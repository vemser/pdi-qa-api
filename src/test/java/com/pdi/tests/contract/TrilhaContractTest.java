package com.pdi.tests.contract;

import client.TrilhaClient;
import io.restassured.module.jsv.JsonSchemaValidator;
import model.responses.BaseResponse;
import model.responses.ErrorResponse;
import org.apache.http.HttpStatus;
import org.junit.Test;

public class TrilhaContractTest {
    private TrilhaClient trilhaClient = new TrilhaClient();

    @Test
    public void testValidateAValidCaseOfGetTrilhaContract() {
        trilhaClient.getTrilha("1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/trilha/obter_trilhas_por_nome.json"))
                    .extract().as(BaseResponse.class)
                ;
    }

    // TODO: test quebrado justamente porque o contrato não está sendo respeitado
    @Test
    public void testValidateAnInvalidCaseOfGetTrilhaContract() {
        trilhaClient.getTrilha("-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/error_response.json"))
                    .extract().as(ErrorResponse.class)
                ;
    }
}
