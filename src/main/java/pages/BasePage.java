package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseSteps;

import java.util.concurrent.TimeUnit;

public class BasePage {

    private WebDriver driver = BaseSteps.getDriver();
    private Wait<WebDriver> waiter = new WebDriverWait(driver, 30, 1000);

    public BasePage(){
        PageFactory.initElements(driver, this);
    }

    public void clickElement(WebElement element){
        waiter.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void scrollPage(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",  element);
    }

    public void fillFieldByChar(WebElement element, String value){
        clickElement(element);
        element.clear();
        for (int i = 0; i < value.length(); i++) {
            char symb = value.charAt(i);
            String strSymb = new StringBuilder().append(symb).toString();
            element.sendKeys(strSymb);
        }
    }

    public void fillField(WebElement element, String value){
        clickElement(element);
        element.clear();
        element.sendKeys(value);
    }

    public void waitForElement(String xpath){
        WebDriverWait wait = new WebDriverWait(BaseSteps.getDriver(), 30);
        wait.ignoring(NoSuchElementException.class).until((ExpectedCondition<Boolean>) driver ->
                !isPresent(By.xpath(xpath)));
    }

    private boolean isPresent(By locator){
        try {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            return BaseSteps.getDriver().findElement(locator).isDisplayed();
        } catch (NoSuchElementException e){
            return false;
        } finally {
            BaseSteps.getDriver().manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        }
    }

    public static void delay(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}