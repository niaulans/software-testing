package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {

    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseIndentButton = By.cssSelector("button[title='Increase indent']");
    
    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToEditArea() {
        driver.switchTo().frame(editorIframeId);
    }

    private void swithToMainArea() {
        driver.switchTo().parentFrame();
    }

    public void clearTextArea() {
        switchToEditArea();
        driver.findElement(textArea).clear();
        swithToMainArea();
    }

    public void setTextArea(String text) {
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        swithToMainArea();
    }

    public String getTextFromEditor() {
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        swithToMainArea();
        return text;
    }

    public void increaseIndentation() {
        driver.findElement(increaseIndentButton).click();
    }
   
}
