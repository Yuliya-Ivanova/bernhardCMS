package automation.components.secondaryTabs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.id;

/**
 * Created by Ivanova_YA on 2/28/2017.
 */
public class RoomTab {
    WebDriver driver;
    private final static By ROOM_PANEL = id("rooms-panel");

    public RoomTab(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement roomPanel() {
        return driver.findElement(ROOM_PANEL);
    }
}
