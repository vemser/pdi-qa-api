package com.pdi.tests.functional;

import com.pdi.tests.client.TrilhaClient;
import com.pdi.tests.model.responses.ErrorResponse;
import com.pdi.tests.model.responses.TrilhaResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TrilhaFunctionalTest {
    private final TrilhaClient trilhaClient = new TrilhaClient();

    @Test
    @DisplayName("Retornar uma trilha filtrada por nome")
    public void testValidateAValidCaseOfGetTrilhaFunctional() {
        TrilhaResponse trilhaResponse = trilhaClient.getTrilha("QA")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract()
                    .as(TrilhaResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertFalse(trilhaResponse.content.isEmpty()),
                () -> Assertions.assertEquals(1, trilhaResponse.content.size()),
                () -> Assertions.assertNotNull(trilhaResponse.content.get(0).idTrilha),
                () -> Assertions.assertNotNull(trilhaResponse.content.get(0).nome),
                () -> Assertions.assertEquals("QA", trilhaResponse.content.get(0).nome),
                () -> Assertions.assertNotNull(trilhaResponse.content.get(0).descricao),
                () -> Assertions.assertNotNull(trilhaResponse.content.get(0).status),
                () -> Assertions.assertNotNull(trilhaResponse.content.get(0).ativo),
                () -> Assertions.assertNotNull(trilhaResponse.content.get(0).idPrograma)
                //() -> Assertions.assertNotNull(trilhaResponse.content.get(0).link)
        );
    }

    @Test
    @DisplayName("Retornar uma trilha filtrada por nome inválido")
    public void testValidateAnInvalidCaseOfGetTrilhaFunctional() {
        ErrorResponse trilhaResponse = trilhaClient.getTrilha("-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_BAD_REQUEST)
                    .extract()
                    .as(ErrorResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertNotNull(trilhaResponse.timestamp),
                () -> Assertions.assertEquals(400, trilhaResponse.status),
                () -> Assertions.assertEquals("Trilha não encontrada", trilhaResponse.message)
        );
    }
}
