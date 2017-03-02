package automation.steps.secondaryTabs;

import automation.PageFactory;
import automation.components.secondaryTabs.RoomTab;
import org.jbehave.core.annotations.Then;

/**
 * Created by Ivanova_YA on 2/28/2017.
 */
public class RoomTabSteps {
    private final RoomTab roomTab;
    public RoomTabSteps(PageFactory pageFactory) {
        roomTab = pageFactory.newRoomTab();
    }


    @Then("room tab is opened")
    public void roomTabsIsOpened() {
        assert roomTab.roomPanel().getAttribute("class").toString().contains("active");
    }
}
