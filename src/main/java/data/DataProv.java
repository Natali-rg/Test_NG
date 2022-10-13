package data;

import org.testng.annotations.DataProvider;

public class DataProv {
    @DataProvider
    public Object[][] createData() {
        return new Object[][] {
                { "Cedric", 36 },
                { "Anne", 37 },
        };
    }

    @DataProvider
    public Object[][] createData1() {
        return new Object[][]{
                {"en"},
                {"de"},
                {"es"},
        };
    }


}
