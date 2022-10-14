package hillel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(xpath = "//button[@id='btn-consultation-hero']")
    WebElement element;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickConsultButton() {
        element.click();
    }
}
