package ge.tbc.itacademy.steps.tnet;

import ge.tbc.itacademy.pages.tnet.TNETAuthorizationPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class TNETAuthorizationPageSteps extends TNETAuthorizationPage {

    @Step("Validate the existence of the authorization page")
    public TNETAuthorizationPageSteps validatePageExistence(){
        authorizationText.shouldBe(visible);
        return this;
    }
}
