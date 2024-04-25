package ge.tbc.itacademy.pages.swoop;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static ge.tbc.itacademy.data.swoop.Constants.*;
import static com.codeborne.selenide.Selenide.*;

public class SwoopCategoryPage {
    public SelenideElement minPriceField = $x(minPriceFieldXpath);
    public SelenideElement maxPriceField = $x(maxPriceFieldXpath);
    public SelenideElement submitPriceRange = $x(submitPriceRangeXpath);
    public ElementsCollection specialOfferPrices = $$x(specialOfferPricesXpath);
    public SelenideElement locationDropDownButton = $x(locationDropDownButtonXpath);
    public SelenideElement locationDropDownElements = $x(locationDropDownElementsXpath);
    public SelenideElement paymentMethodOptions = $x(paymentMethodOptionsXpath);
    public SelenideElement clearFilterButton = $x(clearFilterButtonXpath);
}
