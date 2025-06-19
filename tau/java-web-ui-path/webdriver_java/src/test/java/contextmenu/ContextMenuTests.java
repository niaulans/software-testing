package contextmenu;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTests;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testRightClick() {
        var menuPage = homePage.clickContextMenu();
        menuPage.rightClickContextMenu();

        String message = menuPage.getPopUpText();
        menuPage.acceptPopUp();
        assertEquals(message, "You selected a context menu", "Popup message is incorrect");
    }
}
