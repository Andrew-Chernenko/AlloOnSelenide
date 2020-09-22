package Tests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LanguageSwitchTest {

    @Test
    public void checkSwapLanguage(){
        String url = "https://allo.ua/";
        open(url);
        $(By.xpath(".//div[@class='language']//div[@class='switcher-toggle']"))
                .shouldBe(Condition.visible).click();
        $(By.xpath(".//span[@class='language__ru active']"))
                .shouldBe(Condition.visible);
        Assert.assertNotEquals(WebDriverRunner.url(),url);
    }
}
