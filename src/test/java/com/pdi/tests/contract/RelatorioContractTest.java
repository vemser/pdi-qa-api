package com.pdi.tests.contract;

import com.pdi.tests.client.RelatorioClient;
import io.qameta.allure.*;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RelatorioContractTest {
    private final RelatorioClient relatorioClient = new RelatorioClient();

    // TODO: instável por ser uma funcionalidade dependente de um estagiário mock (id 2)
    @Test
    @Epic("Relatório")
    @Story("US003 - Relatório")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Validar o retorno de um relatório de um estagiário com um id válido")
    public void testValidateAValidCaseOfGetRelatoryContract() {
        relatorioClient.generateAPDFRelatory("2")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/relatorio/gerar_relatorio_do_estagiario.json"))
                ;
    }

    @Test
    @Epic("Relatório")
    @Story("US003 - Relatório")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Validar o retorno de um relatório de um estagiário com um id inválido - variação 01")
    public void testAInvalidCaseOfGetRelatoryWithInvalidIdContract() {
        relatorioClient.generateAPDFRelatory("-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/error_response.json"))
                ;
    }

    @Test
    @Epic("Relatório")
    @Story("US003 - Relatório")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Validar o retorno de um relatório de um estagiário com um id inválido - variação 02")
    public void testAInvalidCaseOfGetRelatoryWithInvalidStringIdContract() {
        relatorioClient.generateAPDFRelatory("a")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_BAD_REQUEST)
                ;
    }

    @Test
    @Epic("Relatório")
    @Story("US003 - Relatório")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Validar o retorno de um relatório de um estagiário com um id inválido - variação 03")
    public void testAInvalidCaseOfGetRelatoryWithInvalidEmptyIdContract() {
        relatorioClient.generateAPDFRelatory("")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_NOT_FOUND)
                ;
    }
}
