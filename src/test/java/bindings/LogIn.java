package bindings;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class LogIn {



    private String emailFieldXPath = "//input[@name='email']";
    private String continueButtonXPath = "//button[contains(.,'Continue')]";
    private String backButtonXPath = "//*[@id=\"login__global-login__tenant-select__btn-back__icon-button__icon\"]";
    private String validEmail ="pooja@perkbox.co.uk";
    private String invalidEmail = "pooja";
    private String invalidEmailErrorXPath = "//*[@id=\"login__global-login__field-email__copy-error__icon-text\"]";
    private WebDriver driver;


    @Before
    public void beforeScenario(){
        System.setProperty("webdriver.gecko.driver", GeckoDriverSetup.getPathToDriver());
        driver = new FirefoxDriver();
    }

    @After
    public void afterScenario(){

        driver.close();
    }

    @Given("^that I'm on Login Page$")
    public void that_I_m_on_Login_Page() {
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://app.perkbox.com");
        driver.manage().window().maximize();
    }

    @When("^I enter Email$")
    public void i_enter_Email() {
        WebElement emailField =  driver.findElement(By.xpath(emailFieldXPath));
        emailField.sendKeys(validEmail);
    }

    @When("^I click continue button$")
    public void i_click_continue_button() {
        WebElement continueButton =  driver.findElement(By.xpath(continueButtonXPath));
        continueButton.click();
        }

    @Then("^I'm taken to account selection page$")
    public void i_m_taken_to_account_selection_page() {

        assertTrue(driver.findElement(By.xpath(backButtonXPath)).isDisplayed());
        }

    @Then("^Error message : \"([^\"]*)\" is shown$")
    public void errorMessageIsShown(String errorMessage) {
        WebElement error = driver.findElement(By.xpath(invalidEmailErrorXPath));
        assertEquals(error.getText(), errorMessage);
        assertTrue(error.isDisplayed());
        assertEquals(error.getCssValue("color"), "rgb(179, 0, 0)");
    }



    @When("^I enter invalid Email$")
    public void iEnterInvalidEmail() {
        WebElement emailField =  driver.findElement(By.xpath(emailFieldXPath));
        emailField.sendKeys(invalidEmail);
    }
}
