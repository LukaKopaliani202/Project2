package ge.tbc.itacademy.pages.facebook;

import com.codeborne.selenide.SelenideElement;
import static ge.tbc.itacademy.data.facebook.Constants.*;
import static com.codeborne.selenide.Selenide.$;

public class FBAuthorizationPage {
    public SelenideElement facebookBody = $(faceBookBodySelector);
}
