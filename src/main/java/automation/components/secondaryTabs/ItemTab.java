package automation.components.secondaryTabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.By.*;
import static org.openqa.selenium.Keys.ENTER;
import static org.openqa.selenium.Keys.LEFT_ALT;

/**
 * Created by Ivanova_YA on 2/27/2017.
 */
public class ItemTab {
    WebDriver driver;
    private final static By NEW_CATEGORY_BUTTON = className("new-category");
    private final static By ITEM_PANEL = id("items-panel");
    private final static By CATEGORY_NAME = xpath(".//*[@class='Field-group'][1]//input");
    private final static By CATEGORY_EMAIL = xpath(".//*[@class='Field-group'][2]//input");
    private final static By ADD_IMAGE_FORM = xpath(".//*[@class='preview']");
    private final static By IMAGE_ON_NEW_CATEGORY_PAGE = cssSelector("div.preview>div.image>img");
    private final static By TOP_PANEL = cssSelector("div.top");

    public ItemTab(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement buttonNewCategory() {
        return driver.findElement(NEW_CATEGORY_BUTTON);
    }

    public WebElement itemPanel() {
        return driver.findElement(ITEM_PANEL);
    }

    public WebElement categoryNameField() {
        return driver.findElement(CATEGORY_NAME);
    }

    public WebElement categoryEmailField() {
        return driver.findElement(CATEGORY_EMAIL);
    }

    public WebElement addImageForm() {
         return driver.findElement(ADD_IMAGE_FORM);
    }

    public void importPicture() {
        driver.switchTo().activeElement().sendKeys("C:\\Users\\Public\\Pictures\\Sample Pictures\\Koala.jpg");
        driver.switchTo().activeElement().sendKeys(ENTER);
    }

    public WebElement imageOnNewCategoryPage() {
        return driver.findElement(IMAGE_ON_NEW_CATEGORY_PAGE);
    }

    public WebElement saveButton() {
        return driver.findElement(TOP_PANEL).findElement(xpath(".//button[contains(text(), 'Save')]"));
    }

    public WebElement deleteButton() {
        return driver.findElement(TOP_PANEL).findElement(xpath(".//button[contains(text(), 'Delete')]"));
    }

    public WebElement publishButton() {
        return driver.findElement(TOP_PANEL).findElement(xpath(".//button[contains(text(), 'Publish')]"));
    }

    public WebElement categoryInLeftPanel(String nameButton) {
        return driver.findElement(xpath(".//button[contains(text(), '" + nameButton + "')]"));
    }

    public void waitForVisibilityListCategories() {
        WebDriverWait some_element = new WebDriverWait(driver,10);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@class='list ps-container ps-theme-default ps-active-y']//button")));
    }

    public void waitForVisibilityPublishButton() {
        WebDriverWait some_element = new WebDriverWait(driver,30);
        some_element.until(ExpectedConditions.visibilityOfElementLocated(xpath(".//*[@class='top']//button[3]")));
    }

    public void waitForPageToLoad() {
        driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
    }
}
