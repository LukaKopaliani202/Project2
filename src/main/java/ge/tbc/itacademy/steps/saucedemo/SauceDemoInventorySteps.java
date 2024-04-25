package ge.tbc.itacademy.steps.saucedemo;

import com.codeborne.selenide.SelenideElement;
import ge.tbc.itacademy.pages.saucedemo.SauceDemoInventoryPage;
import io.qameta.allure.Step;

public class SauceDemoInventorySteps extends SauceDemoInventoryPage{

    @Step("Validate that all images on the page are loading correctly")
    public SauceDemoInventorySteps validatePageImgLoading(){
        allImages.forEach(SelenideElement::isImage);
        return this;
    }

    @Step("Open the categories menu")
    public SauceDemoInventorySteps openCategories(){
        moreCategoriesButton.click();
        return this;
    }

    @Step("Click the logout button")
    public SauceDemoInventorySteps clickLogoutButton(){
        logoutButton.click();
        return this;
    }
}
