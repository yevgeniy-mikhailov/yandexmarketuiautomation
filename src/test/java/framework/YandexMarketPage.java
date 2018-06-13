package framework;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;

public class YandexMarketPage extends AbstractPage {
    SelenideElement MenuComputers = $(By.xpath("//li[contains(@class,'topmenu')][@data-department='Компьютеры']/a"));
    SelenideElement SubMenuTablets = $(By.xpath("//div/a[text()='Планшеты'][@class='link topmenu__subitem']"));
    SelenideElement OpenAllFilters = $(By.xpath("//a[text()='Перейти ко всем фильтрам']"));
    SelenideElement InputSearch = $(By.id("header-search"));
    SelenideElement ButtonSearch = $(By.xpath("//button[@type='submit']/span[@class='button2__text']"));

/*    @Step("Move cursor to Computers")
    public void clickOnComputers() {
        MenuComputers.hover().click();
        $(By.xpath("//div/h1[@title='Компьютерная техника']")).shouldBe(Condition.visible);
    }

    @Step("Click on tablets")
    public void clickTablets() {
        SubMenuTablets.hover().click();
        $(By.xpath("//div/h1[@title='Планшеты']")).shouldBe(Condition.visible);
    }*/

    @Step("Open Y.Market tablets page")
    public YandexMarketPage openTablets() {
        actions().moveToElement(MenuComputers).perform();
        MenuComputers.shouldBe(Condition.visible).hover();
        actions().moveToElement(SubMenuTablets).perform();
        SubMenuTablets.shouldBe(Condition.visible).hover();

        SubMenuTablets.click();
        $(By.xpath("//div/h1[@title='Планшеты']")).shouldBe(Condition.visible);
        return new YandexMarketPage();
    }

    @Step("Open all filters")
    public AllFIltersPage openAllFilters() {
        OpenAllFilters.click();
        $(By.xpath("//div/h1[@title='Все фильтры']")).shouldBe(Condition.visible);
        return new AllFIltersPage();
    }

    @Step("Search item: {0}")
    public YandexMarketProductPage search(String srch) {
        InputSearch.clear();
        System.out.println("Searchavble:" + srch);
        InputSearch.setValue(srch.toLowerCase());
        ButtonSearch.click();
        MenuComputers.shouldBe(Condition.visible);
        return new YandexMarketProductPage();
    }
}
