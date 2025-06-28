package login;

import base.BaseTests;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    private LoginPage loginPage;

    @DataProvider(name = "invalidCredentials")
    public Object[][] credentials() {
        return new Object[][] {
            {"user1", "12345"},
            {"", "SuperSecretPassword!"},
            {"tomsmith", ""},
            {"", ""}
        };
    }

    private void performLogin(String username, String password) {
        loginPage = homePage.clickFormAutentication();

        System.out.printf("[LoginTests] [Browser: %s] Running test with username: '%s', password: '%s'%n", browser, username, password);
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @Test(groups = {"sanity"})
    public void testSuccessfulLogin_shouldRedirectToSecurePage_whenCredentialsIsValid() {
        performLogin("tomsmith", "SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        String alertText = secureAreaPage.getAlertText();
        assertTrue(alertText.contains("You logged into a secure area!"), 
                   "Alert text is incorrect: " + alertText);
    }

    @Test(dataProvider = "invalidCredentials", groups = {"regression"})
    public void testUnsuccessfulLogin_shouldShowError_whenCredentialsAreInvalid(String username, String password) {
        performLogin(username, password);
        loginPage.clickLogginButtonOnly();
        String alertText = loginPage.getAlertText().toLowerCase();
        assertTrue(alertText.contains("invalid"), 
                   "Alert text for invalid login is incorrect: " + alertText);
    }
}
