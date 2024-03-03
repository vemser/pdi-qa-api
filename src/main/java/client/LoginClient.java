package client;

import data.factory.LoginDataFactory;
import io.restassured.response.Response;
import model.Login;
import model.enums.PermissoesEnum;
import specs.LoginEcosSpecs;

import static io.restassured.RestAssured.given;

public class LoginClient {
    private static final String PATH = "/usuario/login";

    public Response login(Login login) {
        return
                given()
                        .spec(LoginEcosSpecs.loginEcosReqSpecs())
                        .body(login)
                        .when()
                        .post(PATH)
                ;
    }

    public Login manageRoleCredentials(PermissoesEnum permissao) {
        switch (permissao) {
            case ADMIN:
                return LoginDataFactory.dadosAdmin();
            case COORDENADOR:
                return LoginDataFactory.dadosCoordenador();
            case GP:
                return LoginDataFactory.dadosGP();
            case INSTRUTOR:
                return LoginDataFactory.dadosInstrutor();
            case COLABORADOR:
                return LoginDataFactory.dadosColaborador();
            case ALUNO:
                return LoginDataFactory.dadosEstagiario();
            default:
                return null;
        }
    }

    public String generateToken(PermissoesEnum permissao) {
        Login login = manageRoleCredentials(permissao);

        return
                login(login)
                        .then()
                        .extract().asString()
                ;
    }
}
