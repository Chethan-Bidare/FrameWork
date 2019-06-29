package testCaseModules.module1;

import modules.module1.Page1;
import org.testng.annotations.Test;
import superBase.TestBase;

public class module1_TC1 extends TestBase {

    @Test
    public void TC1(){
        Page1 page1 = new Page1();
        page1.clickOnSignUp();
    }
}
