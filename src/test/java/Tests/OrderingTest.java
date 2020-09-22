package Tests;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class OrderingTest {

    @Test
    public void orderingPurchase(){
        Configuration.timeout = 8000;
        open("https://allo.ua/");
        String oldCartValue = $(By.xpath(".//span[@class='shopping-cart__count']"))
                .shouldBe(Condition.visible).getText();
        $(By.xpath(".//input[@id='search-form__input']"))
                .shouldBe(Condition.visible).sendKeys("Iphone" + Keys.ENTER);
        ElementsCollection list = $$(By.xpath(".//div[@class = 'product-card v-loaded']")).filter(Condition.text("MWM02"))
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        list.first().$(By.xpath(".//button[contains(@class,'buy-button--animation')]")).click();
        $(By.xpath(".//button[@class='order-now']")).shouldBe(Condition.visible).click();
        $(By.xpath(".//input[@id='onepage-customer-name']")).shouldBe(Condition.visible)
                .sendKeys("Андрей");
        $(By.xpath(".//input[@id='onepage-customer-telephone']")).shouldBe(Condition.visible)
                .sendKeys("994567634");
        $(By.xpath(".//input[@id='onepage-customer-email']")).shouldBe(Condition.visible)
                .sendKeys("test@gmail.com");
        Assert.assertTrue($(By.xpath(".//button[@id='second-step-button']")).isEnabled());
    }

    @Test
    public void orderingPurchaseIncorrectData(){
        Configuration.timeout = 8000;
        open("https://allo.ua/");
        String oldCartValue = $(By.xpath(".//span[@class='shopping-cart__count']"))
                .shouldBe(Condition.visible).getText();
        $(By.xpath(".//input[@id='search-form__input']"))
                .shouldBe(Condition.visible).sendKeys("Iphone" + Keys.ENTER);
        ElementsCollection list = $$(By.xpath(".//div[@class = 'product-card v-loaded']")).filter(Condition.text("MWM02"))
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        list.first().$(By.xpath(".//button[contains(@class,'buy-button--animation')]")).click();
        $(By.xpath(".//button[@class='order-now']")).shouldBe(Condition.visible).click();
        Assert.assertTrue($(By.xpath(".//button[@id='second-step-button']")).shouldBe(Condition.visible).isEnabled());
    }
}
