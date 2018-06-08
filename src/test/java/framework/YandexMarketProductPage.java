package framework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class YandexMarketProductPage extends AbstractPage {
    SelenideElement ProductTitle = $(By.xpath("//div[@class='n-title__text']/h1[contains(@class, 'title')]"));

    @Step("Get product title")
    public String getProductTitle() {
        return ProductTitle.shouldBe(Condition.visible).getText();
    }
}
