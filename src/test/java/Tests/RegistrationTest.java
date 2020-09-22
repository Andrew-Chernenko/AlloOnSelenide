package Tests;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationTest {

    @Test
    public void registerCheck(){
        open("https://allo.ua/");
        $(By.xpath(".//div[@class='user-block-authentication']//*[local-name()='svg']"))
                .shouldBe(Condition.visible).click();
        $(By.xpath(".//li[@class='login-tab']"))
                .shouldBe(Condition.visible).click();
        $(By.xpath(".//input[@id='v-register-name']"))
                .shouldBe(Condition.visible).sendKeys("Андрей");
        $(By.xpath(".//input[@id='v-register_telephone_number']"))
                .shouldBe(Condition.visible).sendKeys("956765444");
        $(By.xpath(".//input[@id='v-register-email']"))
                .shouldBe(Condition.visible).sendKeys("test12345612355@gmail.com");
        $(By.xpath(".//input[@id='vregister-password']"))
                .shouldBe(Condition.visible).sendKeys("qwerty12345");
        Assert.assertTrue($(By.xpath(".//button[@name='send']")).isEnabled());
    }
}
