package ge.tbc.itacademy.steps.swoop;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.PartialText;
import ge.tbc.itacademy.utils.ElementsCollectionUtils;
import ge.tbc.itacademy.pages.swoop.SwoopCommonPage;
import io.qameta.allure.Step;
import static ge.tbc.itacademy.data.swoop.Constants.*;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SwoopCommonPageSteps extends SwoopCommonPage {

    @Step("Add offer to favourites")
    public SwoopCommonPageSteps addOfferToFavourites(SelenideElement deal){
        deal.$(basketButtonSelector).click();
        return this;
    }

    @Step("Check if voucher is sold out")
    public boolean checkVoucherSoldOut(SelenideElement deal){
        String barFullness = deal.$(dealBarSelector).getAttribute(attributeDataWidth);
        return Double.parseDouble(barFullness)<100;
    }

    @Step("Navigate to offer")
    public SwoopCommonPageSteps navToOffer(SelenideElement deal){
        deal.click();
        return this;
    }

    @Step("Find offer with no sold amount")
    public SelenideElement findNoSoldOffer() {
        for (SelenideElement element: allDeals) {
            String soldAmount = element.$(soldAmountSelector)
                    .lastChild().text();
            Integer soldAmountInt = Integer.parseInt(soldAmount.split(" ")[1]);
            if (soldAmountInt == 0) {
                return element;
            }
        }
        SelenideElement nextPageButton = $(paginationSelector).closest(divType).sibling(1);
        if (!nextPageButton.exists()) {
            throw new NoSuchElementException(noSuchElementErrorMessage);
        }
        nextPageButton.click();
        return findNoSoldOffer();
    }

    @Step("Validate voucher bar with amount {1}")
    public boolean validateVoucherBar(SelenideElement deal, Double amount){
        String barFullness = deal.$(dealBarSelector).getAttribute(attributeDataWidth);
        return Double.parseDouble(barFullness) == amount;
    }

    @Step("Wait for loader to disappear")
    public SwoopCommonPageSteps waitForLoaderToDisappear(){
        loader.shouldNotBe(visible);
        return this;
    }

    @Step("Navigate to main category page {0}")
    public SwoopCommonPageSteps navToMainCategoryPage(String name){
        holidayButton.findBy(new PartialText(name)).click();
        return this;
    }

    @Step("Show categories")
    public SwoopCommonPageSteps showCategories(){
        categoriesButton.click();
        return this;
    }

    @Step("Select category {0}")
    public SwoopCommonPageSteps selectCategory(String categoryName){
        categories.findBy(new PartialText(categoryName)).hover();
        return this;
    }

    @Step("Select random sub-category")
    public SwoopCommonPageSteps selectRandomSubCategory(){
        ElementsCollectionUtils.getRandomElement(subCategories).click();
        return this;
    }
}
