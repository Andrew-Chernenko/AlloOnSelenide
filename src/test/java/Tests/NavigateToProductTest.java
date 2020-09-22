package Tests;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class NavigateToProductTest {

    @Test
    public void moveToRefrigerator(){
        open("https://allo.ua/");
        $(By.xpath(".//input[@id='search-form__input']"))
                .shouldBe(Condition.visible).sendKeys("Холодильник" + Keys.ENTER);
        ElementsCollection list = $$(By.xpath(".//div[@class = 'product-card v-loaded']")).filter(Condition.text("BCD-160MDMJ01"))
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        list.first().click();
        Assert.assertEquals(true,$(By.xpath(".//h1[@class='product-header__title']")).getText().contains("BCD-160MDMJ01"));
    }
}
