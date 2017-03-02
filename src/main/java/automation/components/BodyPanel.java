package automation.components;

import com.sun.jna.platform.mac.Carbon;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.By.className;

/**
 * Created by Ivanova_YA on 2/27/2017.
 */
public class BodyPanel {
    WebDriver driver;
    private final static By BODY_PANEL = id("cms_iframe");
    private final static By SECONDARY_TABS = className("nav-pills");


    public BodyPanel(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement bodyOfApp() {
   return driver.findElement(BODY_PANEL);
    }

    public WebElement secondaryTabs() {
        return driver.findElement(SECONDARY_TABS);
    }

    public WebElement tabSecondary(String tabName) {
        WebElement myFrame = driver.findElement(By.id("cms_iframe"));
        return driver.switchTo().frame(myFrame).findElement((By.xpath(".//li/a[contains(text(), '" + tabName.toUpperCase()+ "')]")));
    }

    public WebElement headerTab(String tabName) {
        return driver.findElement(id("header-" + tabName.toLowerCase()));
    }
}