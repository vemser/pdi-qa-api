package com.pdi.tests.specs;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.config.RestAssuredConfig.config;

public class InicialEcosSpecs {
    public static RequestSpecification setup() {
        return new RequestSpecBuilder()
            .setBaseUri("http://vemser-dbc.dbccompany.com.br:39000/vemser/usuario-back")
            .setConfig(config().logConfig(
                logConfig().enableLoggingOfRequestAndResponseIfValidationFails()
            ))
            .build();
    }
}
