package client;

import io.restassured.response.Response;
import specs.InitialPDISpecs;

import static io.restassured.RestAssured.given;

public class AcompanhamentoClient {
    private static final String PATH = "/acompanhamento/listarAcompanhamentos";
    private static final String PAGE = "?page=";
    private static final String SIZE = "&size=";
    private static final Boolean IS_IN_RELEASE = false;

    public AcompanhamentoClient() {}

    public Response listarTodos() {
        return
                given()
                        .spec(InitialPDISpecs.setup(IS_IN_RELEASE))
                .when()
                        .get(PATH)
                ;
    }


    public Response listarTodosComPaginacao(String page, String size) {
        return
                given()
                        .spec(InitialPDISpecs.setup(IS_IN_RELEASE))
                .when()
                        .get(PATH + PAGE + page + SIZE + size)
                ;
    }
}
