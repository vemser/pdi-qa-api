package com.pdi.tests.functional;

import com.pdi.tests.client.AcompanhamentoClient;
import com.pdi.tests.model.responses.AcompanhamentoResponse;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

public class AcompanhamentoFunctionalTest {
    private final AcompanhamentoClient acompanhamentoClient = new AcompanhamentoClient();

    @Test
    @DisplayName("Validar o retorno de todos os acompanhamentos")
    public void testValidateGetAllAcompanhamentosFunctional() {
        AcompanhamentoResponse acompanhamentoResponse = acompanhamentoClient.listarTodos()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(AcompanhamentoResponse.class)
                ;

        Assertions.assertAll(
                () -> Assert.assertNotNull(acompanhamentoResponse.content),
                () -> Assert.assertTrue(acompanhamentoResponse.content.size() > 0),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).idAcompanhamento),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).idEstagiario),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).nomeEstagiario),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).trilha),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).email),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).dataInicio),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).horarioInicio),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).dataFim),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).horarioFim),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).nome),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).titulo),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).descricao),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).duracao),
                () -> Assert.assertNotNull(acompanhamentoResponse.content.get(0).status)
        );
    }
}
