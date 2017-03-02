package automation.steps;

import automation.PageFactory;
import automation.components.BodyPanel;
import automation.components.LoginPanel;
import org.jbehave.core.annotations.AfterStory;
import org.jbehave.core.annotations.BeforeStory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Ivanova_YA on 2/27/2017.
 */
public class LifecycleSteps  {
     WebDriver driver;
    private final LoginPanel loginPanel;

    public LifecycleSteps(PageFactory pageFactory, WebDriver driver) {
        this.driver = driver;
        loginPanel = pageFactory.newLoginPanel();
    }



    /**
     * Performs log in
     */

    @AfterStory
    public void afterStory(){driver.quit();}



    public void performLogin() {
        driver.get("http://bernhardtnginx-dev.mybluemix.net/auth/");
        loginPanel.loginInputed().sendKeys("admin");
        loginPanel.passwordInputed().sendKeys("admin");
        loginPanel.submit().click();
    }


}
