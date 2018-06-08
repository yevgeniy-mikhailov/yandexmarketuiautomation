package framework;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

public class YandexMainPage extends AbstractPage{
    SelenideElement TabMarket = $(By.xpath("//a[@data-id='market']"));

    @Step("Open Yandex.Market")
    public YandexMarketPage openMarketPage() {
        TabMarket.click();
        return new YandexMarketPage();
    }
}
