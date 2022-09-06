import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class AbstractTest {

    private static WebDriver webDriver;

    @BeforeAll
    static void setDriver (){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        webDriver = new ChromeDriver(options);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @BeforeEach
    void initMainPage (){
        Assertions.assertDoesNotThrow( ()-> webDriver.navigate().to("http://automationpractice.com"),
                "Page not found");
    }

    @AfterAll
    static void close(){
        //driver.quit();
    }

    public WebDriver getWebDriver(){
        return this.webDriver;
    }
}
