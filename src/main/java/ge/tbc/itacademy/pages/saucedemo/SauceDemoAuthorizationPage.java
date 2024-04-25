package ge.tbc.itacademy.pages.saucedemo;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import static ge.tbc.itacademy.data.saucedemo.Constants.*;
import static com.codeborne.selenide.Selenide.$;

public class SauceDemoAuthorizationPage {
    public SelenideElement userNameField = $(userNameFieldSelector);
    public SelenideElement passwordField = $(passwordFieldSelector);
    public SelenideElement submitButton = $(loginButtonSelector);
    public SelenideElement errorMessage = $(new ByText(errorMessageText));
    public SelenideElement redXButton = $(errorButtonSelector);
}
