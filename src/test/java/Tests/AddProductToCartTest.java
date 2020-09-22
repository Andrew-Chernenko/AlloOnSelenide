package Tests;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class AddProductToCartTest {

    @Test
    public void checkAddProduct() {
        Configuration.timeout = 8000;
        open("https://allo.ua/");
        String oldCartValue = $(By.xpath(".//span[@class='shopping-cart__count']"))
                .shouldBe(Condition.visible).getText();
        $(By.xpath(".//input[@id='search-form__input']"))
                .shouldBe(Condition.visible).sendKeys("Samsung" + Keys.ENTER);
        ElementsCollection list = $$(By.xpath(".//div[@class = 'product-card v-loaded']")).filter(Condition.text("SM-N985FZNGSEK"))
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        list.first().$(By.xpath(".//button[contains(@class,'buy-button--animation')]")).click();
        $(By.xpath(".//div[@class='cart-popup__body']")).shouldBe(Condition.visible);
        String newCartValue = $(By.xpath(".//span[@class='shopping-cart__count']"))
                .shouldBe(Condition.visible).getText();
        Assert.assertNotEquals(oldCartValue,newCartValue);
    }
}
