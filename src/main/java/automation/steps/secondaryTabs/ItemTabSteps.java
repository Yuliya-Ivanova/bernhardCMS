package automation.steps.secondaryTabs;

import automation.PageFactory;
import automation.components.secondaryTabs.ItemTab;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Ivanova_YA on 2/27/2017.
 */
public class ItemTabSteps {
    private final ItemTab itemsTab;
    public ItemTabSteps(PageFactory pageFactory) {
        itemsTab = pageFactory.newItemsTab();
    }



    @When("input in category name field $nameCategory")
    public void inputNameCategory(String nameCategory) {
        itemsTab.categoryNameField().sendKeys(nameCategory);
    }

    @When("input in category email field $emailCategory")
    public void inputEmailCategory(String emailCategory) {
        itemsTab.categoryEmailField().sendKeys(emailCategory);
    }

    @When("add image to new category")
    public void importFile() {
        itemsTab.addImageForm().click();
        itemsTab.importPicture();
    }

    @When("select New Category button")
    public void clickOnButton() {
        itemsTab.buttonNewCategory().click();
    }

    @When("I click on Save button")
    public void clickButtonSave() {
        itemsTab.saveButton().click();
        itemsTab.waitForVisibilityPublishButton();
    }

    @When("I click on Publish button")
    public void clickButtonPublish() {
        itemsTab.publishButton().click();
        itemsTab.waitForPageToLoad();
    }

    @When("I click on Delete button")
    public void clickButtonDelete() {
        itemsTab.deleteButton().click();
    }

    @Then("items tab is opened")
    public void itemTabsIsOpened() {
        assert itemsTab.itemPanel().getAttribute("class").toString().contains("active");
    }

    @Then("New Category button is displayed")
    public void buttonIsDisplayed() {
        assert itemsTab.buttonNewCategory().isDisplayed();
    }

    @Then("category name field is displayed")
    public void categoryNameFieldIsDisplayed() {
        assert itemsTab.categoryNameField().isDisplayed();
    }

    @Then("assert that image is loaded")
    public void assertImageIsLoaded() {
        assert itemsTab.imageOnNewCategoryPage().isDisplayed();
    }

    @Then("created category $nameCategory is displayed in left menu")
    public void assertThatCategoryIsCreated(String nameCategory) {
        assert itemsTab.categoryInLeftPanel(nameCategory).isDisplayed();
    }

    @Then("created category $nameCategory is not displayed in left menu")
    public void assertThatCategoryIsNotDisplayed(String nameCategory) {
        assertThat(itemsTab.categoryInLeftPanel(nameCategory).isSelected(), is(false));
    }

    @Then("buttom Publish is not displayed")
    public void assertThatTopButtonNotDisplayed() {
        assertThat(itemsTab.publishButton().isSelected(), is(false));
    }
}
