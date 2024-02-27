package data.factory;

import model.Login;
import utils.Manipulation;

import java.util.Properties;

public class LoginEcosDataFactory {
    public LoginEcosDataFactory(){

    }
    public static Login dadosAdmin(){
        Properties props = Manipulation.getProp();
        return new Login(props.getProperty("username-admin"), props.getProperty("password"));
    }
    public static Login dadosInstrutor(){
        Properties props = Manipulation.getProp();
        return new Login(props.getProperty("username-instrutor"), props.getProperty("password"));
    }
    public static Login dadosGP(){
        Properties props = Manipulation.getProp();
        return new Login(props.getProperty("username-gp"), props.getProperty("password"));
    }

}
