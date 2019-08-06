package modules.module1;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import superBase.TestBase;
import utils.SeleniumUtils;

public class Page1 extends SeleniumUtils {

    @FindBy(xpath = "//span[contains(text(),'Login / Signup')]")
    WebElement SignUp ;

    public Page1(){
        PageFactory.initElements(driver,this);
    }

    public void clickOnSignUp(){
        clickAndWait(SignUp);
    }
}
