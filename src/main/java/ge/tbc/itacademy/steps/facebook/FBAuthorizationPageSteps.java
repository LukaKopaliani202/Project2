package ge.tbc.itacademy.steps.facebook;

import ge.tbc.itacademy.pages.facebook.FBAuthorizationPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;

public class FBAuthorizationPageSteps extends FBAuthorizationPage {
    @Step("Validate the existence of the Facebook Authorization Page")
    public FBAuthorizationPageSteps validatePageExistence(){
        facebookBody.shouldBe(visible);
        return this;
    }
}
