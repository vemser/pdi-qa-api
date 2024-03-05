package com.pdi.tests.contract;

import com.pdi.tests.client.TrilhaClient;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrilhaContractTest {
    private final TrilhaClient trilhaClient = new TrilhaClient();

    @Test
    @Epic("Trilha")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Bruno Moraes Scarpari")
    @DisplayName("Validar o retorno de uma trilha com um nome válido")
    public void testValidateAValidCaseOfGetTrilhaContract() {
        trilhaClient.getTrilha("QA")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    // TODO: teste pode falhar por variar a quantia de objetos
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/trilha/obter_trilhas_por_nome.json"))
                ;
    }
    
    // TODO: test quebrado justamente porque o contrato não está sendo respeitado
    @Test
    @Epic("Trilha")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Bruno Moraes Scarpari")
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
    @Epic("Trilha")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Bruno Moraes Scarpari")
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
