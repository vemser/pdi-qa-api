package test;

import com.google.common.collect.ImmutableMap;
import org.testng.annotations.BeforeTest;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class BaseTest {
    @BeforeTest
    public void setAllureEnvironment() {
        allureEnvironmentWriter(
            ImmutableMap.<String, String>builder()
                .put("PDI.API.URL", "https://pdi-back-hml.onrender.com/swagger-ui/index.html")
                .put("PDI.API.VERSION", "v1.0.0")
                .put("Chronus.API.URL","http://vemser-dbc.dbccompany.com.br:39000/vemser/usuario-back/swagger-ui/index.html")
                .put("Chronus.API.VERSION", "v1.0.0")
                .put("JAVA_VERSION","17.0.9")
                .build(), System.getProperty("user.dir")
                + "/allure-results/");
    }
}
