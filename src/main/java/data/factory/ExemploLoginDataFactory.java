package data.factory;

import model.Login;
import utils.Manipulation;

import java.util.Properties;

public class ExemploLoginDataFactory {
    public ExemploLoginDataFactory(){

    }
    //Método busca informações de login(email,senha) e retorna um objeto de login
    public static Login dados(){
        Properties props = Manipulation.getProp(); //busca informações de um arquivo (.properties)
        return new Login(props.getProperty("email"), props.getProperty("senha"));//Passa como parametro email e senha retornadas de getProperties()
    }
}
