package test;

import org.junit.Assert;
import org.junit.Test;

public class TesteJenkinsFuncionalTest {
    @Test
    public void testExemplo(){
        Assert.assertEquals(2,1+1);
    }
    @Test
    public void testExemploFalho(){
        Assert.assertEquals(2,1+2);
    }
}
