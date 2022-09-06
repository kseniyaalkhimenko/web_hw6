package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage{

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(css = "button[id='SubmitLogin'] span")
    private WebElement submitLogInButton;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void signIn(String email, String password){

        Actions logIn = new Actions(getDriver());
        logIn
                .click(this.emailField)
                .sendKeys(this.emailField, email)
                .click(this.passwordField)
                .sendKeys(this.passwordField, password)
                .click(this.submitLogInButton)
                .build()
                .perform();
    }
}
