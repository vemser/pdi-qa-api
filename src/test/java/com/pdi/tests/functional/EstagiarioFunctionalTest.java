package com.pdi.tests.functional;

import com.pdi.tests.client.EstagiarioClient;
import com.pdi.tests.model.enums.StatusEnum;
import com.pdi.tests.model.responses.EstagiarioResponse;
import com.pdi.tests.model.responses.EstagiarioTrilhaResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class EstagiarioFunctionalTest {
    private static final StatusEnum[] status = StatusEnum.values();
    private final EstagiarioClient estagiarioClient = new EstagiarioClient();

    @Test
    @DisplayName("Retornar apenas um estagiário com a paginação")
    public void testValidateAValidCaseOfListAllEstagiariosFunctional() {
        EstagiarioResponse estagiarioResponse = estagiarioClient.searchAllWithPagination("1", "1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(EstagiarioResponse.class)
                ;

        Assertions.assertAll(
                () -> Assert.assertNotNull(estagiarioResponse.content),
                () -> Assert.assertEquals(1, estagiarioResponse.content.size()),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).idEstagiario),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).nome),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).trilha),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).email),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).programa),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).status)
        );
    }

    @Test
    @DisplayName("Retornar uma página de estagiários")
    public void testSearchEstagiariosByPageFunctional() {
        EstagiarioResponse estagiarioResponse = estagiarioClient.searchAllWithPagination("1", "10")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(EstagiarioResponse.class)
                ;

        Assertions.assertAll(
                () -> Assert.assertNotNull(estagiarioResponse.content),
                () -> Assert.assertFalse(estagiarioResponse.content.isEmpty()),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).idEstagiario),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).nome),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).trilha),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).email),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).programa),
                () -> Assert.assertTrue(Arrays.asList(status).contains(estagiarioResponse.content.get(0).status))
        );
    }

    @Test
    @DisplayName("Retornar todos os estagiários")
    public void testSearchAllEstagiariosFunctional() {
        EstagiarioResponse estagiarioResponse = estagiarioClient.searchAll()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(EstagiarioResponse.class)
                ;

        Assertions.assertAll(
                () -> Assert.assertNotNull(estagiarioResponse.content),
                () -> Assert.assertFalse(estagiarioResponse.content.isEmpty()),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).idEstagiario),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).nome),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).trilha),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).email),
                () -> Assert.assertNotNull(estagiarioResponse.content.get(0).programa),
                () -> Assert.assertTrue(Arrays.asList(status).contains(estagiarioResponse.content.get(0).status))

        );
    }

    @Test
    @DisplayName("Contar estagiários por trilha")
    public void testCountEstagiarioPerTrilhaFunctional() {
        List<EstagiarioTrilhaResponse> estagiarioTrilhaResponseList = estagiarioClient.countEstagiariosByTrilha()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().jsonPath().getList("", EstagiarioTrilhaResponse.class)
                ;

        Assertions.assertAll(
                () -> Assert.assertFalse(estagiarioTrilhaResponseList.isEmpty()),
                () -> Assert.assertNotNull(estagiarioTrilhaResponseList.get(0).idAgrupamento),
                () -> Assert.assertNotNull(estagiarioTrilhaResponseList.get(0).programa),
                () -> Assert.assertNotNull(estagiarioTrilhaResponseList.get(0).trilha),
                () -> Assert.assertNotNull(estagiarioTrilhaResponseList.get(0).quantidade)
        );
    }

}
