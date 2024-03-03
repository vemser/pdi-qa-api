package com.pdi.tests.functional;

import client.EstagiarioClient;
import model.responses.BaseResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EstagiarioFunctionalTest {
    private final EstagiarioClient estagiarioClient = new EstagiarioClient();

    @Test
    public void testValidateAValidCaseOfListAllEstagiariosFunctional() {
        BaseResponse baseResponse = estagiarioClient.searchAllWithPagination("1", "1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(BaseResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertNotNull(baseResponse.content)
        );
    }

    @Test
    public void testSearchAllEstagiariosFunctional() {
        BaseResponse baseResponse = estagiarioClient.searchAll()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(BaseResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertNotNull(baseResponse.content)
        );
    }

    @Test
    public void testCountEstagiarioPerTrilhaFunctional() {
        BaseResponse baseResponse = estagiarioClient.countEstagiariosByTrilha()
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(BaseResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertNotNull(baseResponse.content)
        );
    }
}
