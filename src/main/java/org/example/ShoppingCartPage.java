package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = ".//i[@class='icon-trash']")
    private WebElement trashIconButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void trashButton(){
        this.trashIconButton.click();
    }
}
