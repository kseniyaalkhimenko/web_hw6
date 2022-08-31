import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class MyTests extends AbstractTest {

    @Test
    @DisplayName("Authorization")
    @Order(1)
    void signInTest() {
        Actions action = new Actions(getDriver());

        WebElement webElement1 = getDriver().findElement(By.cssSelector("a[title='Log in to your customer account']"));
        webElement1.click();

        Assertions.assertEquals("Login - My Store", getDriver().getTitle(), "Unexpected page");

        action
                .click(getDriver().findElement(By.id("email")))
                .sendKeys(getDriver().findElement(By.id("email")), "aka_lub@mail.ru")
                .click(getDriver().findElement(By.id("passwd")))
                .sendKeys(getDriver().findElement(By.id("passwd")), "12345")
                .click(getDriver().findElement(By.cssSelector("button[id='SubmitLogin'] span")))
                .build()
                .perform();

        Assertions.assertEquals("My account - My Store", getDriver().getTitle(), "Unexpected page");
    }

    @Test
    @DisplayName("Search dresses")
    @Order(2)
    void searchDresses() {
        Actions action = new Actions(getDriver());

        action
                .click(getDriver().findElement(By.id("search_query_top")))
                .sendKeys(getDriver().findElement(By.id("search_query_top")), "dress")
                .click(getDriver().findElement(By.name("submit_search")))
                .build()
                .perform();

        Assertions.assertEquals("Search - My Store", getDriver().getTitle(), "Unexpected page");

        WebElement webElement1 = getDriver().findElement(By.xpath(".//span[@class='heading-counter']"));
        Assertions.assertTrue(webElement1.isEnabled(), "Error");
    }

    @Test
    @DisplayName("Add M-size product to the cart")
    @Order(3)
    void addToCart() throws InterruptedException {
        Actions action1 = new Actions(getDriver());
        Actions action2 = new Actions(getDriver());

        WebElement webElement1 = getDriver().findElement(By.cssSelector("a[title='Women']"));
        webElement1.click();

        Assertions.assertEquals("Women - My Store", getDriver().getTitle(), "Unexpected page");

        action1
                .moveToElement(getDriver().findElement(By.cssSelector("img[title='Faded Short Sleeve T-shirts']")))
                .click(getDriver().findElement(By.xpath(".//span[contains(text(),'More')][1]")))
                .build()
                .perform();

        Assertions.assertEquals("Faded Short Sleeve T-shirts - My Store", getDriver().getTitle(), "Unexpected page");

        action2
                .click(getDriver().findElement(By.id("group_1")))
                .sendKeys(getDriver().findElement(By.id("group_1")), "M")
                .click(getDriver().findElement(By.cssSelector("button[name='Submit'] span")))
                .build()
                .perform();

        WebElement webElement2 = getDriver().findElement(By.xpath(".//div[@id='layer_cart']//div[@class='clearfix']"));
        Assertions.assertTrue(webElement2.isEnabled(), "Error");

        WebElement webElement3 = getDriver().findElement(By.xpath(".//h2[normalize-space()='Product successfully added to your shopping cart']"));
        Assertions.assertTrue(webElement3.isEnabled(), "Error");

        Thread.sleep(10000);
        WebElement webElement4 = getDriver().findElement(By.cssSelector("span[title='Close window']"));
        webElement4.click();
    }

    @Test
    @DisplayName("Delete product from cart")
    @Order(4)
    void deleteFromCart() {
        WebElement webElement1 = getDriver().findElement(By.cssSelector("a[title='View my shopping cart']"));
        webElement1.click();

        WebElement webElement2 = getDriver().findElement(By.xpath(".//i[@class='icon-trash']"));
        webElement2.click();

        WebElement webElement3 = getDriver().findElement(By.xpath(".//p[@class='alert alert-warning']"));
        Assertions.assertTrue(webElement3.isEnabled(), "Error");
    }

    @Test
    @DisplayName("Newsletter subscribe")
    @Order(5)
    void newsletterSubscribe() {
        WebElement webElement1 = getDriver().findElement(By.xpath(".//input[@id='newsletter-input']"));

        Assertions.assertTrue(webElement1.isEnabled(), "Error");

        webElement1.click();
        webElement1.sendKeys("geekbrains@testgb.ru");

        WebElement webElement2 = getDriver().findElement(By.xpath(".//button[@name='submitNewsletter']"));
        webElement2.click();

        WebElement webElement3 = getDriver().findElement(By.xpath(".//p[@class='alert alert-success']"));
        Assertions.assertTrue(webElement3.isEnabled(), "Error");
    }

    @Test
    @DisplayName("Sign out")
    @Order(6)
    void signOut() {
        WebElement webElement1 = getDriver().findElement(By.cssSelector("a[title='Log me out']"));
        webElement1.click();

        WebElement webElement2 = getDriver().findElement(By.xpath(".//a[normalize-space()='Sign in']"));
        Assertions.assertTrue(webElement2.isEnabled(), "Error");
    }
}
