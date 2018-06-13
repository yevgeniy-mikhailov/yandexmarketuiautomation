package framework;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class YandexMainPage extends AbstractPage{
    SelenideElement TabMarket = $(By.xpath("//a[@data-id='market']"));

    @Step("Open Yandex.Market")
    public YandexMarketPage openMarketPage() {
        Selenide.open("https://www.yandex.ru");
        TabMarket.hover().click();
        return new YandexMarketPage();
    }
}
