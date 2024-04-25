package ge.tbc.itacademy.steps.swoop;

import ge.tbc.itacademy.pages.swoop.SwoopOfferPage;
import io.qameta.allure.Step;

public class SwoopOfferPageSteps extends SwoopOfferPage {

    @Step("Share the offer")
    public SwoopOfferPageSteps shareOffer(){
        shareButton.click();
        return this;
    }
}
