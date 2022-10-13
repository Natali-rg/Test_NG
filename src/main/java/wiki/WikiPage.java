package wiki;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiPage {
    @FindBy(id = "ca-view")
    WebElement tab1;

    @FindBy(id = "ca-viewsource")
    WebElement tab2;

    @FindBy(id = "ca-history")
    WebElement tab3;

    public WikiPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getTextTab1(){
        return tab1.getText();
    }

    public String getTextTab2(){
        return tab2.getText();
    }

    public String getTextTab3(){
        return tab3.getText();
    }



}
