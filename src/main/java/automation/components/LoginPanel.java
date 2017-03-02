package automation.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.className;
import static org.openqa.selenium.By.xpath;

/**
 * Created by Ivanova_YA on 2/27/2017.
 */
public class LoginPanel {
    WebDriver driver;
    private final static By USER_INPUT = xpath(".//fieldset/div[1]/input");
    private final static By PWD_INPUT = xpath(".//fieldset/div[2]/input");
    private final static By SUBMIT = className("btn-default");

    public LoginPanel(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement loginInputed() {
        return driver.findElement(USER_INPUT);
    }

    public WebElement passwordInputed() {
        return driver.findElement(PWD_INPUT);
    }

    public WebElement submit() {
        return driver.findElement(SUBMIT);
    }
}