package ge.tbc.itacademy.swoop;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import ge.tbc.itacademy.data.saucedemo.dataproviders.OfferTestsDataProvider;
import ge.tbc.itacademy.pages.facebook.FBAuthorizationPage;
import ge.tbc.itacademy.pages.swoop.*;
import ge.tbc.itacademy.steps.facebook.FBAuthorizationPageSteps;
import ge.tbc.itacademy.steps.swoop.*;
import ge.tbc.itacademy.steps.tnet.TNETAuthorizationPageSteps;
import ge.tbc.itacademy.utils.ModdedAllureSelenide;
import ge.tbc.itacademy.utils.WebDriverUtils;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;
import static ge.tbc.itacademy.data.swoop.Constants.*;

@Feature("Offer")
@Story("Swoop Offer")
@Test(groups = "SwoopRegression")
public class OfferTests {
    SwoopCommonPageSteps commonSteps;
    TNETAuthorizationPageSteps authorizationSteps;
    SwoopOfferPageSteps offerSteps;
    SwoopOfferPage offerPage;
    SwoopCommonPage commonPage;
    FBAuthorizationPage fbAuthorizationPage;
    FBAuthorizationPageSteps fbAuthorizationPageSteps;
    SwoopCategoryPage swoopCategoryPage;
    SwoopCategoryPageSteps swoopCategoryPageSteps;


    @BeforeClass
    @Parameters("browser")
    public void setup(@Optional("chrome") String browser) {
        WebDriverUtils.webDriverSetup(browser);
        authorizationSteps = new TNETAuthorizationPageSteps();
        commonSteps = new SwoopCommonPageSteps();
        offerPage = new SwoopOfferPage();
        offerSteps = new SwoopOfferPageSteps();
        fbAuthorizationPage = new FBAuthorizationPage();
        fbAuthorizationPageSteps = new FBAuthorizationPageSteps();
        swoopCategoryPage = new SwoopCategoryPage();
        swoopCategoryPageSteps = new SwoopCategoryPageSteps();
        commonPage = new SwoopCommonPage();
        WebDriverUtils.turnOffChromePopUpsBrowsing();
        SelenideLogger.addListener("AllureSelenide", new ModdedAllureSelenide());
    }

    @BeforeMethod
    public void openBrowser() {
        open(swoopPageUrl);
    }

    @AfterMethod
    public void closeBrowser() {
        closeWebDriver();
    }

    @Test(dataProvider = "priceRangeProvider", dataProviderClass = OfferTestsDataProvider.class)
    @Severity(SeverityLevel.MINOR)
    @Description("Test Description: Validate the price range filter.")
    @Story("Validate price range filter")
    public void rangeTest(int minPrice, int maxPrice) {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        commonSteps.navToMainCategoryPage(holidayCategoryPageText);
        swoopCategoryPageSteps
                .setMinPrice(minPrice)
                .setMaxPrice(maxPrice)
                .submitPriceRange();
        commonSteps.waitForLoaderToDisappear();
        swoopCategoryPageSteps.validatePriceRange(minPrice, maxPrice);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Validate the functionality of adding an offer to favourites.")
    @Story("Validate add to favourites functionality")
    public void favouriteOfferTest() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        commonSteps
                .showCategories()
                .selectCategory(foodCategoryPageText)
                .selectRandomSubCategory();
        Assert.assertTrue(commonSteps.checkVoucherSoldOut(commonPage.allDeals.get(0)));
        commonSteps.addOfferToFavourites(commonPage.allDeals.get(0));
        authorizationSteps.validatePageExistence();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Validate the functionality of sharing an offer.")
    @Story("Validate share offer functionality")
    public void shareOfferTest() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        commonSteps
                .showCategories()
                .selectCategory(foodCategoryPageText)
                .selectRandomSubCategory()
                .navToOffer(commonPage.allDeals.get(0));
        offerSteps.shareOffer();
        switchTo().window(1);
        fbAuthorizationPageSteps.validatePageExistence();
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Validate that no offers are sold.")
    @Story("Validate no offers sold")
    public void noOffersSoldTest() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        commonSteps
                .navToMainCategoryPage(childrenCategoryPageText);
        commonSteps.validateVoucherBar(commonSteps.findNoSoldOffer(), 0D);
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Validate the functionality of clearing the filter.")
    @Story("Validate clear filter functionality")
    public void clearFilterTest() {
        WebDriverRunner.getWebDriver().manage().window().maximize();
        commonSteps
                .navToMainCategoryPage(childrenCategoryPageText);
        swoopCategoryPageSteps
                .clickLocationDropBox()
                .chooseLocationOption(locationAllOptionText);
        commonSteps.waitForLoaderToDisappear();
        swoopCategoryPageSteps
                .clickLocationDropBox()
                .choosePaymentOption(fullPaymentOptionText)
                .setMinPrice(50)
                .setMaxPrice(500)
                .submitPriceRange()
                .clearFilter();
    }
}
