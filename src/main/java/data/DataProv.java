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
    @DataProvider
    public Object[][] sendDataToForm() {
        return new Object[][]{
                {"Alex","alex412@email.com","985641123","vb","SMM Pro"},
                {"Jon","jon478@gmail.com","962253614","vb","Social Media Marketing"},
                {"Kate","kate25@gmail.com","961234578","vb","Social Media Marketing"},
                {"Mary","mary@email.com","961234578","vb","SMM Pro"},
                {"Nick","nick@gmail.com","967775621","tg","SMM Pro"},
        };
    }

}
