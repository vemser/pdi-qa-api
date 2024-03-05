package com.pdi.tests.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Manipulation {
    public Manipulation() {}

    public static Properties getProp() {
        Properties props = new Properties();

        try {
            FileInputStream file = new FileInputStream("src/main/resources/application.properties"); //Busca o arquivo
            props.load(file);//escreve os valores do arquivo no objeto
        } catch (IOException e) {
            e.printStackTrace();
        }

        return props;
    }
}
