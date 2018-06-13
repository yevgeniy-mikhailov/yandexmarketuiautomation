import com.codeborne.selenide.SelenideElement;
import framework.AllFIltersPage;
import framework.YandexMainPage;
import framework.YandexMarketPage;
import framework.YandexMarketProductPage;
import helper.ScreenShotOnFailListener;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static org.assertj.core.api.Assertions.assertThat;

@Listeners({ ScreenShotOnFailListener.class})
public class YandexMarketTests extends AbstractTest {

    @Test
    @Description("Yandex.Market test")
    @Severity(SeverityLevel.NORMAL)
    public void yandexMarketTest() {
        YandexMainPage ymain = new YandexMainPage();
        YandexMarketPage marketPage = ymain.openMarketPage();
        marketPage = marketPage.openTablets();
        AllFIltersPage fIltersPage = marketPage.openAllFilters();
        fIltersPage.setPriceFrom(20000.0);
        fIltersPage.setPriceTo(25000.0);
        fIltersPage.selectManufacturer("Acer");
        marketPage = fIltersPage.apply();
        List<SelenideElement> resultList = $$(By.xpath("//*[contains(@class,'n-snippet-card2__title')]"));
        String secondElement = resultList.get(1).getText();
        YandexMarketProductPage productPage = marketPage.search(secondElement);
        assertThat(productPage.getProductTitle()).isEqualToIgnoringCase(secondElement);
    }

}
