package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AgreementPage extends BasePage{

    @FindBy(xpath = "//*[contains(@class, 'checkbox checkbox')]")
    public WebElement agreementCheckBox;

    @FindBy(xpath = "//*[contains(@id, 'btnContinue')]")
    public WebElement buttonContinue;

}