package specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.config.RestAssuredConfig.config;
//Classe com configurações padrão para ser usado em todas as classes que Specs
public class InicialExemploSpecs {

    private InicialExemploSpecs() {
    }

    public static RequestSpecification setup() {
        return new RequestSpecBuilder()
            .setBaseUri("http://localhost") //URI da API
            .setPort(8080) // Porta da API
            .setConfig(config().logConfig(
                logConfig().enableLoggingOfRequestAndResponseIfValidationFails() // configuracao para log mensagem de erro
            ))
            .build();
    }
}
