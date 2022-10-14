import data.DataProv;
import driverConfig.BROWSER;
import driverConfig.Base;
import driverConfig.DriverFactory;
import hillel.MailForm;
import hillel.MainPage;
import hillel.Users;
import org.junit.After;
import org.junit.Before;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.ResourceBundle;


public class MailFormTest extends Base {
    WebDriver driver;
    MailForm form;
    MainPage mainPage;


    @BeforeClass
    public void create(){
        if (driver == null) {
            driver = DriverFactory.getDriver(BROWSER.CHROME);
        }
        if(form==null){
            form=new MailForm(driver);
        }
        if(mainPage==null){
            mainPage=new MainPage(driver);
        }
    }

    @After
    public void waitT() throws InterruptedException {
        Thread.sleep(3000);
    }

    @AfterClass
    public void ass() {
        driver.close();
    }



    @Test(description = "open page", priority = 0)
    public void openPage(){
        driver.get("https://ithillel.ua/");
        Assert.assertEquals(driver.getTitle(),"Комп'ютерна школа Hillel у Києві: Курси IT-технологій");

    }
    @Test(description = "click button consultation",dependsOnMethods = "openPage",priority = 1)
    public void clickFormButton(){
        if(MainPage.element.isEnabled()) {
            mainPage.clickConsultButton();
        }else {
            System.out.println("The button not found");
        }
    }

    @Test( dataProvider = "sendDataToForm", dataProviderClass = DataProv.class, priority = 2)
    public void testForm(String name, String mail, String tel, String mass, String course) {
        driver.get("https://ithillel.ua/");
        mainPage.clickConsultButton();
        form.create(name,mail,tel,mass,course, "ldklkkvjdl");
    }

}
