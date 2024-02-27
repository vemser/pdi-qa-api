package client;

import data.factory.LoginEcosDataFactory;
import io.restassured.response.Response;
import model.Login;
import model.LoginResponse;
import model.enums.PermissoesEnum;
import specs.LoginEcosSpecs;

import static io.restassured.RestAssured.given;

public class LoginEcosClient {
    private static final String LOGINPATH = "/usuario/login";

    public Response fazerLogin(Login login) {
        return
            given()
                .spec(LoginEcosSpecs.loginEcosReqSpecs())
                .body(login)
                .when()
                .post(LOGINPATH)
            ;
    }
    public Login gerarCredencias(PermissoesEnum permissao){
        switch (permissao){
            case ADMIN:
                return LoginEcosDataFactory.dadosAdmin();
            case GP:
                return LoginEcosDataFactory.dadosGP();
            case INSTRUTOR:
                return LoginEcosDataFactory.dadosInstrutor();
            default:
                return null;
        }
    }
    public String gerarToken(PermissoesEnum permissao) {
        Login login = gerarCredencias(permissao);
            return fazerLogin(login)
            .then()
            .extract().asString()
            ;
    }
}
