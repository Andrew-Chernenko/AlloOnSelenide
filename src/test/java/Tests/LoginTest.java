package Tests;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTest {

    @Test
    public void checkLogin(){
        open("https://allo.ua/");
        $(By.xpath(".//div[@class='user-block-authentication']//*[local-name()='svg']"))
                .shouldBe(Condition.visible).click();
        $(By.xpath(".//input[@id='auth']")).shouldBe(Condition.visible).sendKeys("test123@gmail.com");
        $(By.xpath(".//input[@id='v-login-password']")).sendKeys("qwerty12345");
        Assert.assertTrue($(By.xpath(".//button[@class='modal-submit-button']")).isEnabled());
    }
}
