import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class MyTests extends AbstractTest {

    @Test
    @DisplayName("Authorization")
    @Description("Website authorization with login and password")
    @Severity(SeverityLevel.CRITICAL)
    @Order(1)
    void signInTest() {
        new MainPage(getWebDriver()).clickSignInButton();
        Assertions.assertEquals("Login - My Store", getWebDriver().getTitle(), "Unexpected page");
        new LogInPage(getWebDriver()).signIn("aka_lub@mail.ru", "12345");
        Assertions.assertEquals("My account - My Store", getWebDriver().getTitle(), "Unexpected page");
    }

    @Test
    @DisplayName("Search dresses")
    @Description("Searching dresses by query")
    @Severity(SeverityLevel.MINOR)
    @Order(2)
    void searchDresses() {
        new MainPage(getWebDriver()).search("dress");
        Assertions.assertEquals("Search - My Store", getWebDriver().getTitle(), "Unexpected page");
    }

    @Test
    @DisplayName("Add M-size product to the cart")
    @Description("Adding M-size product to the shopping cart")
    @Severity(SeverityLevel.NORMAL)
    @Order(3)
    void addToCart() throws InterruptedException {
        new MainPage(getWebDriver()).clickWomen();
        Assertions.assertEquals("Women - My Store", getWebDriver().getTitle(), "Unexpected page");
        new WomenCategoryPage(getWebDriver()).goToItem();
        Assertions.assertEquals("Faded Short Sleeve T-shirts - My Store", getWebDriver().getTitle(), "Unexpected page");
        new ItemPage(getWebDriver()).setSize("M");
        Thread.sleep(10000);
        Assertions.assertEquals("Product successfully added to your shopping cart", getWebDriver().findElement(By.xpath(".//h2[normalize-space()='Product successfully added to your shopping cart']")).getText());
        new PreviewPage(getWebDriver()).closePopUp();
    }

    @Test
    @DisplayName("Delete product from cart")
    @Description("Deleting product from shopping cart")
    @Severity(SeverityLevel.NORMAL)
    @Order(4)
    void deleteFromCart() throws InterruptedException {
        new MainPage(getWebDriver()).viewMyCart();
        new ShoppingCartPage(getWebDriver()).trashButton();
        Thread.sleep(10000);
        Assertions.assertEquals("Your shopping cart is empty.", getWebDriver().findElement(By.cssSelector(".alert.alert-warning")).getText());
    }

    @Test
    @DisplayName("Newsletter subscribe")
    @Description("Newsletter subscription by email")
    @Severity(SeverityLevel.TRIVIAL)
    @Order(5)
    void newsletterSubscribe() {
        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//input[@id='newsletter-input']")).isEnabled(), "Error");
        new MainPage(getWebDriver()).newsletterInput();
        Assertions.assertEquals("Newsletter : You have successfully subscribed to this newsletter.", getWebDriver().findElement(By.xpath(".//p[@class='alert alert-success']")).getText());
    }

    @Test
    @DisplayName("Sign out")
    @Description("Logging out")
    @Severity(SeverityLevel.NORMAL)
    @Order(6)
    void signOut() {
        new MainPage(getWebDriver()).signOut();
        Assertions.assertTrue(getWebDriver().findElement(By.xpath(".//a[normalize-space()='Sign in']")).isEnabled(), "Error");
    }
}
