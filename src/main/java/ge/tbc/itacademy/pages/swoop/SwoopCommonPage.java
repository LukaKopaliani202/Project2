package ge.tbc.itacademy.pages.swoop;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static ge.tbc.itacademy.data.swoop.Constants.*;
import static com.codeborne.selenide.Selenide.*;

public class SwoopCommonPage {
    public SelenideElement loader = $(loaderSelector);
    public ElementsCollection allDeals = $$(allDealsSelector);
    public ElementsCollection holidayButton = $$(holidayButtonSelector);
    public SelenideElement categoriesButton = $(categoriesButtonSelector);
    public ElementsCollection categories = $$(categoriesSelector);
    public ElementsCollection subCategories = $$(subCategoriesSelector);
}
