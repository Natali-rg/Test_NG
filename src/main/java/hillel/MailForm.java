package hillel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MailForm {
    @FindBy(xpath = "//input[@id='input-name-consultation']")
    WebElement name;
    @FindBy(xpath = "//input[@id='input-email-consultation']")
    WebElement mail;
    @FindBy(xpath = "//input[@id='input-tel-consultation']")
    WebElement tel;
    @FindBy(xpath = "//button[contains(@class,'socials-input-triggers_btn') and contains(@class, 'btn-icon-only')]")
    List<WebElement> message;
    @FindBy(xpath = "//button[@id='listbox-btn-input-course-consultation']")
    WebElement course;
    @FindBy(xpath = "//li[@class='listbox_option']")
    List<WebElement> listcourse;
    @FindBy(xpath = "//textarea[@id='input-comment-consultation']")
    WebElement comment;
    @FindBy(xpath = "//span[@class='checkbox_checkmark']")
    WebElement agree;
    @FindBy(xpath = "")
    WebElement submit;

    public MailForm(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickMass(String mass){
        for (WebElement l:message){
                    if (l.getAttribute("data-name").equals("tg")){
                        l.click();
                    }
                }
        }

    public void setCourse(String s){
        course.click();
        for(WebElement l:listcourse){
            if(l.getText().equals(s)){
                l.click();
            }
        }
    }

    public void create(String name, String mail, String tel, String mass, String courseName, String text) {
        this.name.sendKeys(name);
        this.mail.sendKeys(mail);
        this.tel.sendKeys(tel);
        clickMass(mass);
        setCourse(courseName);
        comment.sendKeys(text);
        agree.click();

    }


}
