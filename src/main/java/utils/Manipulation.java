package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Manipulation {
    //questão de segurança
    private Manipulation() {}
    //Retorna um objeto Properties com os dados buscados de um arquivo
    public static Properties getProp() {
        Properties props = new Properties();
        try {
            FileInputStream file = new FileInputStream("src/properties/dados.properties");//Busca o arquivo
            props.load(file);//escreve os valores do arquivo no objeto
        } catch (IOException e) {
            e.printStackTrace();
        }
        return props;
    }
}
