package testCaseModules.module1;

import modules.module1.Page1;
import org.testng.annotations.Test;
import superBase.TestBase;
import utils.DateUtils;

public class module1_TC1 extends TestBase {

    @Test
    public void TC1(){
        Page1 page1 = new Page1();
        page1.clickOnSignUp();
        System.out.println(DateUtils.getDateFullPatternAsString());
        System.out.println(DateUtils.getDateByChangingMonths(-2));
        System.out.println(DateUtils.getDateByChangingMonths(2));
        System.out.println(DateUtils.getDateByChangingYears(-2));
        System.out.println(DateUtils.getDateByChangingYears(2));
        System.out.println(DateUtils.getTimeAsString());
    }
}
