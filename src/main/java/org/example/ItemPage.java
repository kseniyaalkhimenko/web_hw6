package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ItemPage extends AbstractPage {

    @FindBy(id = "group_1")
    private WebElement radioChooseSize;

    @FindBy(css = "button[name='Submit'] span")
    private WebElement submitItemButton;

    public ItemPage(WebDriver driver) {
        super(driver);
    }

    public void setSize(String size) {
        Actions setSize = new Actions(getDriver());
        setSize.click(this.radioChooseSize).sendKeys(this.radioChooseSize, size).click(this.submitItemButton).build().perform();
    }
}
