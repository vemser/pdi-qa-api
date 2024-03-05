package com.pdi.tests.functional;

import com.pdi.tests.client.AcompanhamentoClient;
import com.pdi.tests.model.responses.AcompanhamentoResponse;
import io.qameta.allure.Epic;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.http.HttpStatus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AcompanhamentoFunctionalTest {
    private final AcompanhamentoClient acompanhamentoClient = new AcompanhamentoClient();

    @Test
    @Epic("Acompanhamento")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Bruno Moraes Scarpari")
    @DisplayName("Validar o retorno de todos os acompanhamentos")
    public void testValidateGetAllAcompanhamentosFunctional() {
        AcompanhamentoResponse acompanhamentoResponse = acompanhamentoClient.listarTodos()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(AcompanhamentoResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertNotNull(acompanhamentoResponse.content),
                () -> Assertions.assertTrue(acompanhamentoResponse.content.size() > 0),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).idAcompanhamento),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).idEstagiario),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).nomeEstagiario),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).trilha),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).email),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).dataInicio),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).horarioInicio),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).dataFim),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).horarioFim),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).nome),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).titulo),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).descricao),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).duracao),
                () -> Assertions.assertNotNull(acompanhamentoResponse.content.get(0).status)
        );
    }
}
