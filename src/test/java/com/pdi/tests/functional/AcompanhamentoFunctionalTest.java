package com.pdi.tests.functional;

import client.AcompanhamentoClient;
import model.responses.AcompanhamentoResponse;
import org.apache.http.HttpStatus;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AcompanhamentoFunctionalTest {
    private final AcompanhamentoClient acompanhamentoClient = new AcompanhamentoClient();

    @Test
    public void testValidateGetAllAcompanhamentosFunctional() {
        AcompanhamentoResponse acompanhamentoResponse = acompanhamentoClient.listarTodos()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(AcompanhamentoResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertNotNull(acompanhamentoResponse.content)
        );
    }
}
