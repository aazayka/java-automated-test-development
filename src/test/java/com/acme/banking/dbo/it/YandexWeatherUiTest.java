package com.acme.banking.dbo.it;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.linkText;

public class YandexWeatherUiTest {
    private static ChromeDriver driver;

    @BeforeClass
    public static void setupBrowser() {
        //region Driver setup
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions()
                .addArguments("--headless")
                .addArguments("--disable-gpu")
                .addArguments("--disable-dev-shm-usage")
                .addArguments("--disable-extensions")
                .addArguments("--no-sandbox")
                .addArguments("--start-maximized")
                .addArguments("--window-size=800,2000")
                .addArguments("--ignore-certificate-errors")
        );
        //endregion

        //region Selenide Runner setup
        WebDriverRunner.setWebDriver(driver);
        Configuration.timeout = 5_000;
        Configuration.reportsFolder = "target/surefire-reports";
        //endregion

        //region Performance hack setup
        //always keep open tab to prevent closing driver at <code>driver.close()</code>
        //note that <code>driver.quit()</code> closes driver anyway
        driver.manage().window().maximize();

        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        //endregion
    }

    @After
    public void closeBrowser() {
        driver.close(); //not quit()
    }

    @AfterClass
    public static void quitBrowser() {
        driver.quit();
    }

    @Test
    public void shouldGetWeather() throws InterruptedException {
        com.codeborne.selenide.Selenide.open("https://стопкоронавирус.рф");
        $(linkText("Подробные данные"))
            .shouldBe(visible)
                .click();

        $(By.tagName("body")).screenshot();
//        Thread.sleep(10_000);
    }
}
