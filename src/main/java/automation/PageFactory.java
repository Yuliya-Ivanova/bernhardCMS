package automation;

import automation.components.BodyPanel;
import automation.components.LoginPanel;
import automation.components.secondaryTabs.ItemTab;
import automation.components.secondaryTabs.RoomTab;
import automation.steps.LifecycleSteps;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ivanova_YA on 2/27/2017.
 */
public class PageFactory {

    private final WebDriver webDriver;

    public PageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    public LoginPanel newLoginPanel() {
        return new LoginPanel(webDriver);
    }

    public BodyPanel newBodyPanel() {
        return new BodyPanel(webDriver);
    }

    public LifecycleSteps newLifecycleSteps() {
        return new LifecycleSteps(this, webDriver);
    }

    public ItemTab newItemsTab() {
        return new ItemTab(webDriver);
    }

    public RoomTab newRoomTab() {
        return new RoomTab(webDriver);
    }
}
