package alerts;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTests2;
import pages.AlertsPage;

public class AlertTests extends BaseTests2{

    private AlertsPage alertsPage;

    @BeforeMethod
    public void goToAlertsPage() {
        alertsPage = homePage.clickJavaScriptAlerts();
    }

    @Test
    public void testAcceptAlert() {
        alertsPage.triggerAlert();
        alertsPage.alert_clickToAccept();
        alertsPage.getResult();
        assertEquals(alertsPage.getResult(), "You successfully clicked an alert", "Result text is incorrect");
    }

    @Test 
    public void testGetTextFromAlert() {
        alertsPage.triggerConfirm();
        String text = alertsPage.alert_getText();
        alertsPage.alert_clickToDismiss();
        assertEquals(text, "I am a JS Confirm", "Alert text is incorrect");
    }

    @Test
    public void testSetInputInAlert() {
        alertsPage.triggerPrompt();

        String text = "TAU rocks!";
        alertsPage.alert_setInput(text);
        alertsPage.alert_clickToAccept();
        assertEquals(alertsPage.getResult(), "You entered: " + text, "Result text is incorrect");
    }
}
