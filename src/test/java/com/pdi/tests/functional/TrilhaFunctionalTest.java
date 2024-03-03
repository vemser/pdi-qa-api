package com.pdi.tests.functional;

import client.TrilhaClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TrilhaFunctionalTest {
    private final TrilhaClient trilhaClient = new TrilhaClient();

    @Test
    public void testValidateAValidCaseOfGetTrilhaFunctional() {
        trilhaClient.getTrilha("1")
                .then()
                    .log().body()
                    .assertThat().statusCode(200)
                ;

        Assertions.assertAll(
                () -> Assertions.assertTrue(true)
        );
    }

    @Test
    public void testValidateAnInvalidCaseOfGetTrilhaFunctional() {
        trilhaClient.getTrilha("-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(400)
                ;

        Assertions.assertAll(
                () -> Assertions.assertTrue(true)
        );
    }
}
