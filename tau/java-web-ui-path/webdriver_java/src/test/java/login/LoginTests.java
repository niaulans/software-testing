package login;

import base.BaseTests;
import pages.LoginPage;
import pages.SecureAreaPage;

import static org.testng.Assert.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests{

    private LoginPage loginPage;

    @BeforeMethod
    public void goToLoginPage() {
        loginPage = homePage.clickFormAutentication();
    }

    @DataProvider(name = "invalidCredentials")
    public Object[][] credentials() {
        return new Object[][] {
            {"user1", "12345"},
            {"", "SuperSecretPassword!"},
            {"tomsmith", ""},
            {"", ""},
            

        };
    }

    private void performLogin(String username, String password) {
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }

    @Test
    public void testSuccessfulLogin_shouldRedirectToSecurePage_whenCredentialsIsValid() {
        performLogin("tomsmith", "SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickLoginButton();
        secureAreaPage.getAlertText();
        assertTrue(secureAreaPage.getAlertText() 
                    .contains("You logged into a secure area!"), 
                    "Alert text is incorrect");
    }

    @Test(dataProvider = "invalidCredentials")
    public void testUnsuccessfulLogin_shouldShowError_whenCredentialsAreInvalid(String username, String password) {
        performLogin(username, password);
        loginPage.clickLogginButtonOnly();
        assertTrue(loginPage.getAlertText().toLowerCase().contains("invalid"),
                    "Alert text for invalid login is incorrect");

    }
}
