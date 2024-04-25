package ge.tbc.itacademy.utils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.selenide.AllureSelenide;

public class ModdedAllureSelenide extends AllureSelenide {
    public boolean saveScreenshots;
    @Override
    public ModdedAllureSelenide screenshots(boolean saveScreenshots) {
        if (WebDriverRunner.hasWebDriverStarted()){
            this.saveScreenshots = saveScreenshots;
        }

        return this;
    }
    //conflict2Fix
}