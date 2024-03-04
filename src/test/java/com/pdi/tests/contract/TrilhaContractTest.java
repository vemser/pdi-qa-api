package com.pdi.tests.contract;

import com.pdi.tests.client.TrilhaClient;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class TrilhaContractTest {
    private final TrilhaClient trilhaClient = new TrilhaClient();

    @Test
    @DisplayName("Validar o retorno de uma trilha com um nome válido")
    public void testValidateAValidCaseOfGetTrilhaContract() {
        trilhaClient.getTrilha("QA")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/trilha/obter_trilhas_por_nome.json"))
                ;
    }
    
    // TODO: test quebrado justamente porque o contrato não está sendo respeitado
    @Test
    @DisplayName("Validar o retorno de uma trilha com um nome inválido - variação 01")
    public void testValidateAnInvalidCaseOfGetTrilhaContract() {
        trilhaClient.getTrilha("-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_BAD_REQUEST)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/error_response.json"))
                ;
    }

    @Test
    @DisplayName("Validar o retorno de uma trilha com um nome inválido - variação 02")
    public void testValidateAnInvalidCaseOfGetTrilhaContractVariation03() {
        trilhaClient.getTrilha("")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_NOT_FOUND)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/error_response.json"))
                ;
    }
}
