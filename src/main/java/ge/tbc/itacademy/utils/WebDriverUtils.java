package ge.tbc.itacademy.utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;

public class WebDriverUtils {
    public static void webDriverSetup(String browser){
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeDriver chromeDriver = new ChromeDriver();
            WebDriverRunner.setWebDriver(chromeDriver);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxDriver firefoxDriver = new FirefoxDriver();
            WebDriverRunner.setWebDriver(firefoxDriver);
        } else if (browser.equalsIgnoreCase("edge")){
            EdgeDriver edgeDriver = new EdgeDriver();
            WebDriverRunner.setWebDriver(edgeDriver);
        }
    }
    public static void turnOffChromePopUpsBrowsing(){
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("safebrowsing.enabled", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("credentials_enable_service", false);
        prefs.put("password_manager_enabled", false);
        options.setExperimentalOption("prefs", prefs);
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

    }
    //conflict4
}
