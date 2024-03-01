package test;

import com.google.common.collect.ImmutableMap;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

public class TesteJenkinsFuncionalTest {

    @Test
    public void testExemplo(){
        Assert.assertEquals(2,1+1);
    }
}
