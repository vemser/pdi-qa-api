//package com.pdi.tests.login_ecos;
//
//import client.LoginEcosClient;
//import data.factory.LoginEcosDataFactory;
//import io.qameta.allure.Epic;
//import io.qameta.allure.Feature;
//import io.qameta.allure.Story;
//import model.Login;
//import org.junit.Test;
//@Epic("Login Ecos")
//public class LoginEcosFuncionalTest {
//    LoginEcosClient loginEcosClient = new LoginEcosClient();
//    @Test
//    @Feature("Login")
//    @Story("Autentificação")
//    public void logarEcosComoAdminComSucesso(){
//        Login loginAdmin = LoginEcosDataFactory.dadosAdmin();
//        loginEcosClient.fazerLogin(loginAdmin)
//            .then()
//                .statusCode(200)
//            ;
//    }
//}
