package com.pdi.tests.functional;

import com.pdi.tests.client.RelatorioClient;
import com.pdi.tests.model.responses.ErrorResponse;
import com.pdi.tests.model.responses.RelatorioResponse;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RelatorioFunctionalTest {
    private final RelatorioClient relatorioClient = new RelatorioClient();

    // TODO: funcionalidade pendente de dados mockados para testes
    @Test
    @DisplayName("Gerar relatório do estagiário em PDF")
    public void testGerarRelatorioDoEstagiarioEmPdf() {
        RelatorioResponse relatorioResponse = relatorioClient.generateAPDFRelatory("1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_OK)
                    .extract().as(RelatorioResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertEquals("application/pdf", relatorioResponse.fileType),
                () -> Assertions.assertNotNull(relatorioResponse.data)
        );
    }

    // TODO: status code 500 é um erro genérico
    // neste caso seria mais adequado um status code 404 = NOT FOUND
    @Test
    @DisplayName("Gerar relatório do estagiário em PDF indevidamente")
    public void testGerarRelatorioDoEstagiarioIndevidamente() {
        ErrorResponse relatorioResponse = relatorioClient.generateAPDFRelatory("-1")
                .then()
                    .log().body()
                    .assertThat().statusCode(HttpStatus.SC_INTERNAL_SERVER_ERROR)
                    .extract().as(ErrorResponse.class)
                ;

        Assertions.assertAll(
                () -> Assertions.assertNotNull(relatorioResponse.timestamp),
                () -> Assertions.assertNotNull(relatorioResponse.status),
                () -> Assertions.assertNotNull(relatorioResponse.error),
                () -> Assertions.assertNotNull(relatorioResponse.path),
                () -> Assertions.assertEquals("Internal Server Error", relatorioResponse.error),
                () -> Assertions.assertEquals(500, relatorioResponse.status),
                () -> Assertions.assertEquals("/relatorio/-1", relatorioResponse.path)
        );
    }
}
