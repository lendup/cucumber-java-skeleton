package skeleton;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class LdcStepdefs {

    WebDriver driver;

    @Before({"@LdcTest"})
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/qliu/Documents/workspace/cucumber-java-skeleton/chromedriver");
        driver = new ChromeDriver();
    }

    @After({"@LdcTest"})
    public void teardown() {
        driver.close();
    }

    @When("^they go to ldc$")
    public void theyGoToLdc() throws Throwable {
        driver.navigate().to("https://www.lendup.com");
    }

    @Given("^user is not logged in$")
    public void userIsNotLoggedIn() throws Throwable {
    }

    @Then("^they should see sign-in$")
    public void theyShouldSeeSignIn() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        if (driver.findElement(By.className("ss-icon")).isDisplayed()) {
            System.out.println("Passed");
        } else {
            fail();
        }
    }
}
