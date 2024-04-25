package ge.tbc.itacademy.steps.swoop;

import com.codeborne.selenide.selector.ByText;
import ge.tbc.itacademy.pages.swoop.SwoopCategoryPage;
import ge.tbc.itacademy.utils.ScrollUtils;
import org.testng.asserts.SoftAssert;
import io.qameta.allure.Step;

import static ge.tbc.itacademy.data.swoop.Constants.inputType;

public class SwoopCategoryPageSteps extends SwoopCategoryPage {
    SoftAssert softAssert = new SoftAssert();
    ScrollUtils scrollUtils = new ScrollUtils(100);

    @Step("Set minimum price to {0}")
    public SwoopCategoryPageSteps setMinPrice(int minPrice){
        scrollUtils.scrollToElement(minPriceField).setValue(String.valueOf(minPrice));
        return this;
    }

    @Step("Set maximum price to {0}")
    public SwoopCategoryPageSteps setMaxPrice(int maxPrice){
        scrollUtils.scrollToElement(maxPriceField).setValue(String.valueOf(maxPrice));
        return this;
    }

    @Step("Submit the price range")
    public SwoopCategoryPageSteps submitPriceRange(){
        scrollUtils.scrollToElement(submitPriceRange).click();
        return this;
    }

    @Step("Validate the price range between {0} and {1}")
    public SwoopCategoryPageSteps validatePriceRange(int minPrice, int maxPrice){
        specialOfferPrices.forEach(element -> {
            String price = element.text();
            price = price.substring(0, price.length()-1);
            int priceInt = Integer.parseInt(price);
            softAssert.assertTrue(minPrice <= priceInt && priceInt <= maxPrice);
        });
        softAssert.assertAll();
        return this;
    }

    @Step("Click the location drop box")
    public SwoopCategoryPageSteps clickLocationDropBox(){
        locationDropDownButton.click();
        return this;
    }

    @Step("Choose location option {0}")
    public SwoopCategoryPageSteps chooseLocationOption(String option){
        locationDropDownElements.$(new ByText(option)).click();
        return this;
    }

    @Step("Choose payment option {0}")
    public SwoopCategoryPageSteps choosePaymentOption(String option){
        paymentMethodOptions.$(new ByText(option)).$(inputType).setSelected(true);
        return this;
    }

    @Step("Clear the filter")
    public SwoopCategoryPageSteps clearFilter(){
        clearFilterButton.click();
        return this;
    }
}
