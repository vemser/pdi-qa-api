package client;

import io.restassured.response.Response;
import specs.InitialPDISpecs;

import static io.restassured.RestAssured.given;

public class EstagiarioClient {
    private static final String PATH = "/estagiario";
    private static final String RELATORY = "/relatorio-cliente/{id}";
    private static final String LIST_ALL = "/listarEstagiarios";
    private static final String LIST_BY_TRILHA = "/agrupar-estagiario-por-trilha";

    private static final Boolean IS_IN_RELEASE = false;

    public EstagiarioClient() {}

    public Response getRelatory(String id) {
        return
                given()
                        .spec(InitialPDISpecs.setup(IS_IN_RELEASE))
                .when()
                        .with()
                        .pathParam("id", id)
                        .get(PATH + RELATORY)
                ;
    }

    public Response searchAll() {
        return
                given()
                        .spec(InitialPDISpecs.setup(IS_IN_RELEASE))
                .when()
                        .get(PATH + LIST_ALL)
                ;
    }

    public Response searchAllWithPagination(String page, String size) {
        return
                given()
                        .spec(InitialPDISpecs.setup(IS_IN_RELEASE))
                .when()
                        .get(PATH + LIST_ALL + "?page=" + page + "&size=" + size)
                ;
    }

    public Response countEstagiariosByTrilha() {
        return
                given()
                        .spec(InitialPDISpecs.setup(IS_IN_RELEASE))
                .when()
                        .get(PATH + LIST_BY_TRILHA)
                ;
    }
}
