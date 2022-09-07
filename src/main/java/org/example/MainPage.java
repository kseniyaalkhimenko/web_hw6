package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    @FindBy(css = "a[title='Log in to your customer account']")
    private WebElement signInButton;

    @FindBy(css = "a[title='Log me out']")
    private WebElement signOutButton;

    @FindBy(id = "search_query_top")
    private WebElement searchQueryTop;

    @FindBy(name = "submit_search")
    private WebElement submitSearchButton;

    @FindBy(css = "a[title='Women']")
    private WebElement womenCategoryButton;

    @FindBy(css = "a[title='View my shopping cart']")
    private WebElement viewMyCartButton;

    @FindBy(xpath = ".//input[@id='newsletter-input']")
    private WebElement newsletterInput;

    @FindBy(xpath = ".//button[@name='submitNewsletter']")
    private WebElement submitNewsletterButton;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickSignInButton() {
        this.signInButton.click();
    }

    public void clickWomen() {
        this.womenCategoryButton.click();
    }

    public void viewMyCart() {
        this.viewMyCartButton.click();
    }

    public void signOut() {
        this.signOutButton.click();
    }

   /*public void newsletterInput(String email) {
        Actions enterEmail = new Actions(getDriver());
        enterEmail
                .click(newsletterInput)
                .sendKeys(newsletterInput, email)
                .click(submitNewsletterButton)
                .build()
                .perform();
    }*/

    public void newsletterInput() {
        Actions enterEmail = new Actions(getDriver());
        enterEmail
                .click(newsletterInput)
                .sendKeys(newsletterInput, (getSaltString()+"@gb.ru"))
                .click(submitNewsletterButton)
                .build()
                .perform();
    }

    public void search(String searchText) {

        Actions logIn = new Actions(getDriver());
        logIn
                .click(this.searchQueryTop)
                .sendKeys(this.searchQueryTop, searchText)
                .click(this.submitSearchButton)
                .build()
                .perform();
    }
}
