package views;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import base.BaseTests;
import pages.ActivityMenu;
import pages.AppMenu;
import pages.HelloWorldMenu;

public class HelloWorldTest extends BaseTests {

    @Test
    public void getHelloWorld() {
        assertTrue(homePage.isAt(), "Not on HomePage!");
        AppMenu appMenu = homePage.goToAppMenu();

        assertTrue(appMenu.isAt(), "Not on AppMenu!");
        ActivityMenu activityMenu = appMenu.goToActivityMenu();

        assertTrue(activityMenu.isAt(), "Not on ActivityMenu!");
        HelloWorldMenu helloWorldMenu = activityMenu.goToHelloWorldMenu();

        String text = helloWorldMenu.getText();
        assertEquals(text, "Hello, World!", "The text is incorrect!");
    }
}
