package com.pdi.tests.specs;

import com.pdi.tests.utils.Manipulation;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.LogConfig.logConfig;
import static io.restassured.config.RestAssuredConfig.config;

public class InicialEcosSpecs {
    private static final String BASE_LOGIN_URL = Manipulation.getProp().getProperty("BASE_LOGIN_URL");

    public static RequestSpecification setup() {
        return new RequestSpecBuilder()
            .setBaseUri(BASE_LOGIN_URL)
            .setConfig(config().logConfig(
                logConfig().enableLoggingOfRequestAndResponseIfValidationFails()
            ))
            .build();
    }
}
