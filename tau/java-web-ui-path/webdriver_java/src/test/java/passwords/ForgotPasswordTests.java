package passwords;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import base.BaseTests;

public class ForgotPasswordTests extends BaseTests{

    @Test
    public void testRetrievePassword() {
        var forgotPasswordPage = homePage.clickForgotPassword();
        var emailSentPage = forgotPasswordPage.retrievePassword("tau@example.com");

        String pageSource = driver.getPageSource();
        assertEquals(emailSentPage.getMessage(), "Your email's been sent!", "Message is incorrect");
        
    }

    @Test
    public void testRetrievePassword_shouldShowError_InternalServerError() {
        var forgotPasswordPage = homePage.clickForgotPassword();
        var emailSentPage = forgotPasswordPage.retrievePassword("tau@example.com");

        String pageSource = driver.getPageSource();
        assertTrue(pageSource.contains("Internal Server Error"), "Error page: 'Internal Server Error' not encountered!'");
    }
}