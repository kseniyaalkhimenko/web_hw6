package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class WomenCategoryPage extends AbstractPage{

    @FindBy(css = "img[title='Faded Short Sleeve T-shirts']")
    private WebElement itemImg;

    @FindBy(xpath = ".//span[contains(text(),'More')][1]")
    private WebElement moreButton;

    public WomenCategoryPage(WebDriver driver) {
        super(driver);
    }

    public void goToItem(){
        Actions goTo = new Actions(getDriver());
        goTo
                .moveToElement(this.itemImg)
                .click(this.moreButton)
                .build()
                .perform();
    }
}
