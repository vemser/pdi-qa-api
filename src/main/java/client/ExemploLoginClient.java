package client;

import data.factory.ExemploLoginDataFactory;
import io.restassured.response.Response;
import model.Login;
import specs.ExemploSpecs;

import static io.restassured.RestAssured.given;

public class ExemploLoginClient {
    private static final String LOGINPATH = "/login"; // caminho para o endpoint de login

    //método auxiliar para fazer login na aplicação
    public Response fazerLogin(Login login) { // login {email, senha}
        return
            given()//Parâmetros que vão ser passados na requisição
                .spec(ExemploSpecs.exemploReqSpecs())// espeficações de da montagem da requisição
                .body(login)//Body com a requisição para efetuar o login
                .when() //Tipo de requisição (get,post,patch,delete,put)
                .post(LOGINPATH)//definição da requisição
            ;
    }

    //Método para retornar token de autentificação
    public String pegarTokenAdm() {
        Login login = ExemploLoginDataFactory.dados(); //Objeto com os dados de login
        return fazerLogin(login)//Requisição
            .then()//Response da requisição
            .extract().path("authorization")//retira da response o valor que tenha a chave igual a authorization
            ;
    }
}
