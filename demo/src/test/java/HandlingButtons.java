public class HandlingButtons {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver.setup();
        driver = new ChromeDriver();
        driver.get("https://letcode.in/button");

        // Get the X and Y coordinates
        WebElement findLocationButton = driver.findElementById("position");
        Point pointLocationButton = findLocationButton.getLocation();
        int x = point.geX();
        int y = point.getY();

        System.out.println("x => " + x + ", y => " + y);

        // Find the color of the button
        WebElement btnColor = driver.findElementById("color");
        String color = btnColor.getCssValue("background-color");
        System.out.println(color);

        // Find the height & weight of the button
        Rectangle rect = driver.findElementById("property").getRect();
        Dimension dimension = rect.getDimension();
        dimension.getHeight();
        dimension.getWidth();

        // Confirm the button is disabled
        boolean isDisabled = driver.findElementById("isDisabled").isEnabled();
        System.out.println(isDisabled);
    }
}
