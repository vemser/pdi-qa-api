package com.pdi.tests.functional;

import client.RelatorioClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RelatorioFunctionalTest {
    private final RelatorioClient relatorioClient = new RelatorioClient();

    @Test
    public void testGerarRelatorioDoEstagiarioEmPdf() {
        relatorioClient.generateAPDFRelatory("1")
                .then()
                    .log().body()
                    .assertThat().statusCode(200)
                ;

        Assertions.assertAll(
                () -> Assertions.assertTrue(true)
        );
    }
}
