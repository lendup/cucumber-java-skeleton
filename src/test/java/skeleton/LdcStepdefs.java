package skeleton;

import com.google.common.collect.ImmutableMap;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.eclipse.jetty.util.ajax.JSON;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.fail;

public class LdcStepdefs {

    WebDriver driver;
    private static final String ldcUrl = "dev.lendup.com:9999";

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
        driver.navigate().to(ldcUrl);
    }

    @Given("^user is not logged in$")
    public void userIsNotLoggedIn() throws Throwable {
    }

    @Then("^they should see sign-in$")
    public void theyShouldSeeSignIn() throws Throwable {
        if (driver.findElement(By.className("ss-icon")).isDisplayed()) {
            System.out.println("Passed");
        } else {
            fail();
        }
    }

    @Given("^user is logged in$")
    public void userIsLoggedIn() throws Throwable {
        driver.navigate().to(ldcUrl + String.format("/rest/test/user/test_create?user=%s",
            JSON.toString(ImmutableMap.of(
            "paystubGross", "60000",
            "paystubNet", "50000",
            "lastName", "20707144",
            "points", "0",
            "userState", "CA"
            ))));
    }

    @Then("^they should see their dashboard$")
    public void theyShouldSeeTheirDashboard() throws Throwable {
        if (driver.findElement(By.className("your-dashboard")).isDisplayed()) {
            System.out.println("Passed");
        } else {
            fail();
        }
    }
}
