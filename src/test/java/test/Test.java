package test;

import org.junit.Assert;
import org.junit.Ignore;
import utils.TestClass;

public class Test {

    @org.junit.Test
    public void testHello(){
        TestClass testClass = new TestClass("tho");
        Assert.assertEquals("tho",testClass.hello());
    }
}
