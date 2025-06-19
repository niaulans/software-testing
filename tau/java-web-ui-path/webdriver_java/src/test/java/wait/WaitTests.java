package wait;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTests;
import pages.DynamicLoadingPage;

public class WaitTests extends BaseTests{

    private DynamicLoadingPage loadingPage;

    @BeforeMethod
    public void goToDynamicLoadingPage() {
        loadingPage = homePage.clickDynamicLoading();
    }

    @Test
    public void testWaitUntilHidden() {
        var example1 = loadingPage.clickExample1();
        example1.clickStart();
        assertEquals(example1.getLoadedText(), "Hello World!", "Loaded text is incorrect");
    }

    @Test
    public void testWaitUntilVisible() {
        var example2 = loadingPage.clickExample2();
        example2.clickStart();
        assertEquals(example2.getLoadedText(), "Hello World!", "Loaded text is incorrect");
    }
}
