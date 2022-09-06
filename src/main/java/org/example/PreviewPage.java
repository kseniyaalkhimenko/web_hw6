package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PreviewPage extends AbstractPage {

    @FindBy(css = "span[title='Close window']")
    private WebElement closePopUpButton;

    public PreviewPage(WebDriver driver) {
        super(driver);
    }

    public void closePopUp() {
        this.closePopUpButton.click();
    }
}
