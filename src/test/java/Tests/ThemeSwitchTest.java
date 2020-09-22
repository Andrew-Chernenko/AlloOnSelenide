package Tests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;

public class ThemeSwitchTest {

    @Test
    public void checkThemeColor(){
        Configuration.startMaximized = true;
        open("https://allo.ua/");
        String headerColor;
        String headerColorAfterSwitch;
        headerColor = $(By.xpath(".//div[@class='main-header-second-line-wrapper']"))
                .getCssValue("background-color");
        headerColor = Color.fromString(headerColor).asHex();
        $(By.xpath(".//div[@class='header-theme']//div[@class='switcher-toggle']"))
                .shouldBe(Condition.visible).click();
        headerColorAfterSwitch = $(By.xpath(".//div[@class='main-header-second-line-wrapper']"))
                .getCssValue("background-color");
        headerColorAfterSwitch = Color.fromString(headerColorAfterSwitch).asHex();
        Assert.assertNotEquals(headerColor,headerColorAfterSwitch);
    }
}
