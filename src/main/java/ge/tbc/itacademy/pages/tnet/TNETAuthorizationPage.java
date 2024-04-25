package ge.tbc.itacademy.pages.tnet;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
import static ge.tbc.itacademy.data.tnet.Constants.*;
public class TNETAuthorizationPage {
    public SelenideElement authorizationText = $x(authorizationTextSelector);
}
