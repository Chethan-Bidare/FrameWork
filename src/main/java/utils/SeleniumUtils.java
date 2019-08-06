package utils;

import org.openqa.selenium.WebElement;
import superBase.TestBase;

public class SeleniumUtils extends TestBase {

    public void clickAndWait(WebElement webElement){
        webElement.click();
        captureScreenshotRuntime();
    }
}
