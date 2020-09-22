package Tests;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class SearchProductTest {

    @Test
    public void searchProductEngLanguage(){
        Configuration.timeout = 8000;
        open("https://allo.ua/");
        $(By.xpath(".//input[@id='search-form__input']"))
                .shouldBe(Condition.visible).sendKeys("Vacuum cleaner" + Keys.ENTER);
        $$(By.xpath(".//div[contains(@class,'product-card v-loaded')]"))
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        Assert.assertEquals(WebDriverRunner.url(),"https://allo.ua/ua/catalogsearch/result/?q=Vacuum%20cleaner");
    }

    @Test
    public void searchProductRusLanguage(){
        Configuration.timeout = 8000;
        open("https://allo.ua/");
        $(By.xpath(".//input[@id='search-form__input']"))
                .shouldBe(Condition.visible).sendKeys("Айфон" + Keys.ENTER);
        $$(By.xpath(".//div[contains(@class,'product-card v-loaded')]"))
                .shouldBe(CollectionCondition.sizeGreaterThan(0));
        Assert.assertEquals(WebDriverRunner.url(),"https://allo.ua/ua/catalogsearch/result/?q=iphone");
    }
}
