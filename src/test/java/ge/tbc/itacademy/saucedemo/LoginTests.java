package ge.tbc.itacademy.saucedemo;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import ge.tbc.itacademy.pages.saucedemo.SauceDemoAuthorizationPage;
import ge.tbc.itacademy.pages.saucedemo.SauceDemoInventoryPage;
import ge.tbc.itacademy.steps.saucedemo.SauceDemoAuthorizationSteps;
import ge.tbc.itacademy.steps.saucedemo.SauceDemoInventorySteps;
import ge.tbc.itacademy.utils.ModdedAllureSelenide;
import ge.tbc.itacademy.utils.WebDriverUtils;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.sql.SQLException;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static ge.tbc.itacademy.data.saucedemo.Constants.*;

@Feature("Login")
@Story("SauceDemo Login")
@Test(groups = "SauceDemoLogin")
public class LoginTests {
    SauceDemoAuthorizationPage sauceDemoAuthorizationPage;
    SauceDemoAuthorizationSteps sauceDemoAuthorizationSteps;
    SauceDemoInventoryPage sauceDemoInventoryPage;
    SauceDemoInventorySteps sauceDemoInventorySteps;

    @BeforeClass
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) throws SQLException {
        WebDriverUtils.webDriverSetup(browser);
        sauceDemoAuthorizationPage = new SauceDemoAuthorizationPage();
        sauceDemoAuthorizationSteps = new SauceDemoAuthorizationSteps();
        sauceDemoInventorySteps = new SauceDemoInventorySteps();
        sauceDemoInventoryPage = new SauceDemoInventoryPage();
        WebDriverUtils.turnOffChromePopUpsBrowsing();
        SelenideLogger.addListener("AllureSelenide", new ModdedAllureSelenide());

    }

    @BeforeMethod
    public void openBrowser() {
        open(sauceDemoUrl);
    }

    @AfterMethod
    public void closeBrowser() {
        closeWebDriver();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Successful login scenario with valid credentials.")
    @Story("Validate successful login")
    public void successfulLoginTest() throws SQLException {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        sauceDemoAuthorizationSteps
                .enterUserName(standardUserUserName)
                .enterPassword(standardUserUserName)
                .submitForm();
        sauceDemoInventorySteps
                .validatePageImgLoading();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Login scenario with a banned user.")
    @Story("Validate login with banned user")
    public void bannedUserLoginTest() throws SQLException {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        sauceDemoAuthorizationSteps
                .enterUserName(lockedOutUserName)
                .enterPassword(lockedOutUserName)
                .submitForm()
                .checkErrorAppeared()
                .checkRedXAppeared();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Login scenario with a problematic user.")
    @Story("Validate login with problematic user")
    public void problematicLoginTest() throws SQLException {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        sauceDemoAuthorizationSteps
                .enterUserName(problemUserName)
                .enterPassword(problemUserName)
                .submitForm();
        sauceDemoInventorySteps
                .validatePageImgLoading();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Logout scenario after successful login.")
    @Story("Validate logout functionality")
    public void logOutTest() throws SQLException {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        sauceDemoAuthorizationSteps
                .enterUserName(standardUserUserName)
                .enterPassword(standardUserUserName)
                .submitForm();
        sauceDemoInventorySteps
                .openCategories()
                .clickLogoutButton();
        sauceDemoAuthorizationSteps
                .validateUserNameFieldText(userNameFieldValidationText)
                .validatePasswordFieldText(passwordFieldValidationText);
    }
}
