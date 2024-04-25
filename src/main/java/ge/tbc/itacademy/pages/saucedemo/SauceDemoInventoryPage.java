package ge.tbc.itacademy.pages.saucedemo;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static ge.tbc.itacademy.data.saucedemo.Constants.*;

public class SauceDemoInventoryPage {
    public ElementsCollection allImages = $$(imgType);
    public SelenideElement moreCategoriesButton = $(moreCategoriesClass);
    public SelenideElement logoutButton = $(logoutButtonId);
}
