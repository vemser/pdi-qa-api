package com.pdi.tests.functional;

import com.pdi.tests.client.EstagiarioClient;
import com.pdi.tests.model.enums.StatusEnum;
import com.pdi.tests.model.responses.EstagiarioResponse;
import com.pdi.tests.model.responses.EstagiarioTrilhaResponse;
import io.qameta.allure.*;
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
    @Epic("Estagiário")
    @Story("US002 - Dashboard")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Retornar apenas um estagiário com a paginação")
    public void testValidateAValidCaseOfListAllEstagiariosFunctional() {
        EstagiarioResponse estagiarioResponse = estagiarioClient.searchAllWithPagination("1", "1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(EstagiarioResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertNotNull(estagiarioResponse.content),
                () -> Assertions.assertEquals(1, estagiarioResponse.content.size()),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).idEstagiario),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).nome),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).trilha),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).email),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).programa),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).status)
        );
    }

    @Test
    @Epic("Estagiário")
    @Story("US002 - Dashboard")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Retornar uma página de estagiários")
    public void testSearchEstagiariosByPageFunctional() {
        EstagiarioResponse estagiarioResponse = estagiarioClient.searchAllWithPagination("1", "10")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(EstagiarioResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertNotNull(estagiarioResponse.content),
                () -> Assertions.assertFalse(estagiarioResponse.content.isEmpty()),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).idEstagiario),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).nome),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).trilha),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).email),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).programa),
                () -> Assertions.assertTrue(Arrays.asList(status).contains(estagiarioResponse.content.get(0).status))
        );
    }

    @Test
    @Epic("Estagiário")
    @Story("US002 - Dashboard")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Retornar todos os estagiários")
    public void testSearchAllEstagiariosFunctional() {
        EstagiarioResponse estagiarioResponse = estagiarioClient.searchAll()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(EstagiarioResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertNotNull(estagiarioResponse.content),
                () -> Assertions.assertFalse(estagiarioResponse.content.isEmpty()),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).idEstagiario),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).nome),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).trilha),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).email),
                () -> Assertions.assertNotNull(estagiarioResponse.content.get(0).programa),
                () -> Assertions.assertTrue(Arrays.asList(status).contains(estagiarioResponse.content.get(0).status))

        );
    }

    @Test
    @Epic("Estagiário")
    @Story("US002 - Dashboard")
    @Owner("Bruno Moraes Scarpari")
    @Severity(SeverityLevel.MINOR)
    @DisplayName("Contar estagiários por trilha")
    public void testCountEstagiarioPerTrilhaFunctional() {
        List<EstagiarioTrilhaResponse> estagiarioTrilhaResponseList = estagiarioClient.countEstagiariosByTrilha()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().jsonPath().getList("", EstagiarioTrilhaResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertFalse(estagiarioTrilhaResponseList.isEmpty()),
                () -> Assertions.assertNotNull(estagiarioTrilhaResponseList.get(0).idAgrupamento),
                () -> Assertions.assertNotNull(estagiarioTrilhaResponseList.get(0).programa),
                () -> Assertions.assertNotNull(estagiarioTrilhaResponseList.get(0).trilha),
                () -> Assertions.assertNotNull(estagiarioTrilhaResponseList.get(0).quantidade)
        );
    }
}
