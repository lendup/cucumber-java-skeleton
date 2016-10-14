package skeleton;

import com.google.common.collect.ImmutableMap;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.eclipse.jetty.util.ajax.JSON;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IvrStepdefs {

    WebDriver driver;
    private static final String ldcUrl = "dev.lendup.com:9999";

    @Before({"@IvrTest"})
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "/Users/qliu/Documents/workspace/cucumber-java-skeleton/chromedriver");
        driver = new ChromeDriver();
    }

    @After({"@IvrTest"})
    public void teardown() {
        driver.close();
    }

    @Given("^A user is authenticated through IVR$")
    public void aUserIsAuthenticatedThroughIVR() throws Throwable {
        driver.navigate().to(ldcUrl + String.format("/rest/test/user/test_create?user=%s",
            JSON.toString(ImmutableMap.of(
                "paystubGross", "60000",
                "paystubNet", "50000",
                "lastName", "20707144",
                "points", "0",
                "userState", "CA"
            ))));
    }

    @And("^He is in the main menu$")
    public void heIsInTheMainMenu() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^number (\\d+) is pressed$")
    public void numberIsPressed(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the user should hear the list of recent transactions$")
    public void theUserShouldHearTheListOfRecentTransactions() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
