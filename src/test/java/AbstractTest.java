import com.codeborne.selenide.Configuration;
import io.qameta.allure.Step;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.*;

public class AbstractTest {

    @BeforeTest
    @Step("Initialization")
    public void setUp() {
        baseUrl = "www.yandex.ru";
        System.setProperty("webdriver.ie.driver", "libs/IEDriverServerX32.exe");
        Configuration.reportsFolder = "allure-results/screenshots";
        Configuration.timeout = 20000;
        Configuration.browser = INTERNET_EXPLORER;
        DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
        capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        capability.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "");
        Configuration.browserCapabilities = capability;
        Configuration.startMaximized = true;
    }

    @AfterClass
    @Step("Close IE driver")
    public static void ieRelax() {
        if (isIE()) {
            closeWebDriver();
            sleep(500);
        }
    }

    @BeforeClass
    @Step("Clear cache for IE")
    public void clearIeCache() {
        if (isIE()) {
            clearBrowserCache();
        }
    }
}
