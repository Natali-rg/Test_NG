import data.DataProv;
import driverConfig.BROWSER;
import driverConfig.Base;
import driverConfig.DriverFactory;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import watchers.MyRetry;
import wiki.Language;
import wiki.WikiPage;

import java.util.ResourceBundle;

@Slf4j
public class TestTestNG extends Base{
    static WikiPage language;
    int iterator=0;

    @BeforeClass(groups = {"smoke"})
    public void initChroMe() {
        log.info("initial chrome driver");
        System.out.println(iterator++);
        System.out.println("before");
        System.out.println("_____________________");
        if (driver == null) {
            driver = DriverFactory.getDriver(BROWSER.CHROME);
        }
        if(language==null){
            language=new WikiPage(driver);
        }
    }



    @Test(description = "open parent page", groups = {"smoke"},retryAnalyzer = MyRetry.class)//retryAnalyzer = MyRetry.class перезапускает тест
    public void OpenPage(){

        System.out.println(iterator++);
        System.out.println("OpenPage");
        System.out.println("_____________________");
        driver.get("https://en.wikipedia.org/");
        Assert.assertEquals(3,iterator);
    }
    @Test(description = "test Tab1", groups = {"smoke","regression"},dependsOnMethods = "OpenPage",alwaysRun = true,priority = 1)
    public void TestTab1(){
        System.out.println(iterator++);
        System.out.println("TestTab1");
        System.out.println("_____________________");
        language.getTextTab1().equals("Read");
    }
    @Test(priority = 0)
    public void test1(){
        System.out.println(iterator++);
        System.out.println("test1");
        System.out.println("_____________________");
        ResourceBundle bundle=ResourceBundle.getBundle(Language.EN.getCode());
        language.getTextTab2().equals(bundle.getString("menutab1"));
    }

    @Test(dataProvider = "createData", dataProviderClass = DataProv.class)
    public void test3(String name, int t){
        System.out.println(name);
    }
    @Test(dataProvider = "createData1", dataProviderClass = DataProv.class)
    public void test4(String lan){
        ResourceBundle bundle=ResourceBundle.getBundle(lan);
        driver.get("https://"+bundle.getString("lang")+".wikipedia.org/");

    }

    @AfterClass
    public void afteR(){
        if(driver!=null){
            driver.close();
        }
    }

}
