package ge.tbc.itacademy.utils;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.executeJavaScript;

public class ScrollUtils {
    private final Integer headerHeight;
    public ScrollUtils(Integer headerHeight){
        this.headerHeight = headerHeight;
    }
    public SelenideElement scrollToElement(SelenideElement element) {
        executeJavaScript("window.scrollTo(0, arguments[0])", element.getCoordinates().inViewPort().getY() - headerHeight);
        return element;
    }
    //conflict3Fix
}
