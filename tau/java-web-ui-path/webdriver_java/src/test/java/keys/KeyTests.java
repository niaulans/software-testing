package keys;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTests;
import pages.KeyPressesPage;

public class KeyTests extends BaseTests{

    private KeyPressesPage keyPage;

    @BeforeMethod
    public void gotoKeyPressesPage() {
        keyPage = homePage.clickKeyPresses();
    }

    @Test
    public void testBackSpace() {
        keyPage.enterText("A" + Keys.BACK_SPACE);
        assertEquals(keyPage.getResult(), "You entered: BACK_SPACE!");
    }

    @Test
    public void testPi() {
        keyPage.enterPi();
    }
}
