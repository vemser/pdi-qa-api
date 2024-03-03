package data.factory.login;

import client.LoginClient;
import data.factory.LoginDataFactory;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import model.Login;
import org.junit.jupiter.api.Test;

@Epic("Login Ecos")
public class LoginFunctionalTest {
    LoginClient loginClient = new LoginClient();

    @Test
    @Feature("Login")
    @Story("Autentificação")
    public void logarEcosComoAdminComSucesso() {
        Login loginAdmin = LoginDataFactory.dadosAdmin();
        loginClient.login(loginAdmin)
                .then()
                .statusCode(200)
        ;
    }
}
