package com.pdi.tests.contract;

import com.pdi.tests.client.EstagiarioClient;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

public class EstagiarioContractTest {
    private final EstagiarioClient estagiarioClient = new EstagiarioClient();

    @Test
    @DisplayName("Validar contrato do retorno de todos os estagiários")
    public void testValidateAValidCaseOfListAllEstagiariosContract() {
        estagiarioClient.searchAll()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/estagiario/buscar_todos_estagiarios.json"))
                ;
    }

    @Test
    @DisplayName("Validar contrato do retorno de todos os estagiários com paginação válida")
    public void testValidateAValidCaseOfListAllEstagiariosWithPaginationContract() {
        estagiarioClient.searchAllWithPagination("1", "1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/estagiario/buscar_todos_estagiarios.json"))
                ;
    }

    @Test
    @DisplayName("Validar contrato do retorno de todos os estagiários com paginação inválida")
    public void testAInvalidCaseOfListAllWithInvalidPaginationContract() {
        estagiarioClient.searchAllWithPagination("-1", "-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/error_response.json"))
                ;
    }

    @Test
    @DisplayName("Validar contrato do retorno ao solicitar informações do relatório do estagiário com id válido")
    public void testValidateAValidCaseOfGetRelatoryInformationsAboutEstagiarioContract() {
        estagiarioClient.getRelatory("1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/estagiario/obter_infos_relatorio_do_estagiario.json"))
                ;
    }

    @Test
    @DisplayName("Validar contrato do retorno ao solicitar informações do relatório do estagiário com id inválido")
    public void testAInvalidCaseOfGetRelatoryInformationsAboutEstagiarioContract() {
        estagiarioClient.getRelatory("-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/error_response.json"))
                ;
    }

    @Test
    @DisplayName("Validar contrato ao contar todos os estagiários")
    public void testValidateAValidCaseOfCountAllEstagiariosContract() {
        estagiarioClient.countEstagiariosByTrilha()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/estagiario/contar_estagiarios_por_trilha.json"))
                ;
    }
}
