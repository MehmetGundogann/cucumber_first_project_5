package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TechGlobalBasePage {
    public TechGlobalBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "dropdown-button")
    public WebElement headerDropdown;

    @FindBy(css = "div[id=dropdown-menu] a")
    public List<WebElement> dropdownItems;

    public void selectByVisibleText(String option) {
        for(WebElement dropdownItem : dropdownItems) {
            if(dropdownItem.getText().equals(option)) {
                dropdownItem.click();
                break;
            }
        }
    }

}
