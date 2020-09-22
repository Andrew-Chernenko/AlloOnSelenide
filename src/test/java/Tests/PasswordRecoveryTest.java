package Tests;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PasswordRecoveryTest {

    @Test
    public void passwordRecovery(){
        open("https://allo.ua/");
        $(By.xpath(".//div[@class='user-block-authentication']//*[local-name()='svg']"))
                .shouldBe(Condition.visible).click();
        $(By.xpath(".//a[@class='forgot-password']"))
                .shouldBe(Condition.visible).click();
        $(By.xpath(".//input[@id='auth']")).shouldBe(Condition.visible).sendKeys("test@gmail.com");
        Assert.assertTrue($(By.xpath(".//button[@class='modal-submit-button']")).isEnabled());
    }
}
