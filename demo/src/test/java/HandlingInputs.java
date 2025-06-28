public class InputTests {

    private static ChromeDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver.setup();
        driver = new ChromeDriver();
        driver.get("https://letcode.in/edit");

        // Enter your full name
        driver.findElementById("fullName").sendKeys("Nia Ulan Sari");

        // Append a text and press keyboard tab
        driver.findElementById("join").sendKeys(" person", Keys.TAB);

        // What is inside the text box
        String text = driver.findElementById("getMe").getAttribute("value");
        System.out.println(text);

        // Clear the text
        driver.findElementById("clearMe").clear();

        // Confirm edit field is disabled
        boolean isEdit = driver.findElementById("noEdit").isEnabled();
        System.out.println(isEdit);

        // Confirm text is readonly
        String isReadOnly = driver.findElementById("dontwrite").getAttribute("readonly");
        System.out.println(isReadOnly);
    }
}
