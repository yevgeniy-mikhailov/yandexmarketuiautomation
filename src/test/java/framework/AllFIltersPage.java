package framework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AllFIltersPage extends AbstractPage {
    SelenideElement PriceFrom = $(By.xpath("//input[@id='glf-pricefrom-var']"));
    SelenideElement PriceTo = $(By.xpath("//input[@id='glf-priceto-var']"));
    SelenideElement ButtonShowFitted = $(By.xpath("//a[@type='button']/span[text()='Показать подходящие']"));
    SelenideElement ManufacturerShowAll = $(By.xpath("//div/div/h4/span[text()='Производитель']/../../..//button/span[text()='Показать всё']"));

    @Step("Set priceFrom = {0}")
    public void setPriceFrom(Double priceFrom) {
        PriceFrom.shouldBe(Condition.visible).clear();
        PriceFrom.shouldBe(Condition.visible).setValue(Double.toString(priceFrom));
    }

    @Step("Set priceTo = {0}")
    public void setPriceTo(Double priceTo) {

        PriceTo.shouldBe(Condition.visible).clear();
        PriceTo.shouldBe(Condition.visible).setValue(Double.toString(priceTo));
    }

    @Step("Check manufacturer: {0}")
    public void selectManufacturer(String manufacturer) {
        ManufacturerShowAll.click();
        $(By.xpath("//div/div/h4/span[text()='Производитель']/../../..//label[text()='"+ manufacturer+ "']")).click();
    }

    @Step("Apply filters and show results")
    public YandexMarketPage apply() {
        ButtonShowFitted.click();
        return new YandexMarketPage();
    }
}
