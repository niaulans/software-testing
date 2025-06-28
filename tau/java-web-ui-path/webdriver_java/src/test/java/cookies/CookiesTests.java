package cookies;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

import base.BaseTests;

public class CookiesTests extends BaseTests {

    @Test
    public void testDeleteCookie() {
        var cookieManager = getCookieManager();
        Cookie cookie = cookieManager.buildCookie("optimizelyBuckets", "%7B%7D");
        cookieManager.deleteCookie(cookie);
        assertFalse(cookieManager.isCookiePresent(cookie), "Cookie was not deleted");
    }
}
