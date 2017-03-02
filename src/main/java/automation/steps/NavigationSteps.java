package automation.steps;

import automation.PageFactory;
import automation.components.BodyPanel;
import automation.components.secondaryTabs.ItemTab;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class NavigationSteps{

    private final BodyPanel bodyPanel;
    private final LifecycleSteps lifecycle;
    private final ItemTab itemTab;

    public NavigationSteps(PageFactory pageFactory) {

        bodyPanel = pageFactory.newBodyPanel();
        lifecycle = pageFactory.newLifecycleSteps();
        itemTab = pageFactory.newItemsTab();
    }

    @Given("login as a admin")
    public void logIn() {
        lifecycle.performLogin();
    }

    @When("I navigate to $tabName tab")
    public void navigateToTab(String tabName){
        bodyPanel.tabSecondary(tabName).click();
        itemTab.waitForVisibilityListCategories();
    }

    @When("I select $tabName tab of header navigation")
    public void navigateToHeaderTab(String tabName) {
        bodyPanel.headerTab(tabName).click();
    }

    @Then("the body of app is loaded")
    public void pageIsLoaded() {
        assert bodyPanel.bodyOfApp().isDisplayed();
    }

    @Then("assert that header tab $tabName is active")
    public void assertHeaderTab(String tabName) {
        assert bodyPanel.headerTab(tabName).getAttribute("class").toString().contains("active");
    }

    @Then("I assert that secondary tabs are displayed")
    public void secondaryTabsIsLoaded() {
        assert bodyPanel.secondaryTabs().isDisplayed();
    }

}