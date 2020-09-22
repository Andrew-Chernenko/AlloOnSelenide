package Tests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.*;

public class SwitchCategoryTest {

    @Test
    public void checkCategoryFirst(){
        Configuration.startMaximized = true;
        String url = "https://allo.ua/";
        open(url);
        $(By.xpath(".//p[contains(text(),'Смартфоны и телефоны') or contains( text(), 'Смартфони та телефони')]"))
                .shouldBe(Condition.visible).click();
        Assert.assertNotEquals(WebDriverRunner.url(),url);
    }

    @Test
    public void checkCategorySecond(){
        Configuration.startMaximized = true;
        String url = "https://allo.ua/";
        open(url);
        $(By.xpath(".//p[contains(text(),'Бытовая техника') or contains( text(), 'Побутова техніка')]"))
                .shouldBe(Condition.visible).click();
        Assert.assertNotEquals(WebDriverRunner.url(),url);
    }
}
