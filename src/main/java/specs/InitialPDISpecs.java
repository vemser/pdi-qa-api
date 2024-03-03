package specs;

import client.LoginClient;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import model.enums.PermissoesEnum;
import utils.Manipulation;

public class InitialPDISpecs {
    private static final LoginClient loginClient = new LoginClient();
    private static final String BASE_URL = Manipulation.getProp().getProperty("BASE_URL");
    private static final String BASE_RELEASE_URL = Manipulation.getProp().getProperty("BASE_RELEASE_URL");
    private static final String ROLE_CHOOSED = Manipulation.getProp().getProperty("ROLE_CHOOSED");

    public static RequestSpecification setup(Boolean release) {
        return new RequestSpecBuilder()
            .addHeader("Authorization", loginClient.generateToken(PermissoesEnum.valueOf(ROLE_CHOOSED)))
            .setBaseUri(release ? BASE_RELEASE_URL : BASE_URL)
            .log(LogDetail.BODY)
            .build();
    }
}
