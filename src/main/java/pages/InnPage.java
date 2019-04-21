package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InnPage extends BasePage {

    @FindBy(xpath = "//input[@id='fam']")
    public WebElement surnameField;

    @FindBy(xpath = "//input[@id='nam']")
    public WebElement nameField;

    @FindBy(xpath = "//input[@id='otch']")
    public WebElement patronymic;

    @FindBy(xpath = "//*[@id='unichk_0']")
    public WebElement checkBoxWithoutPatronymic;

    @FindBy(xpath = "//input[contains(@name, 'bdate')]")
    public WebElement birthDate;

    @FindBy(xpath = "//input[contains(@name, 'bplace')]")
    public WebElement placeOfBirth;

    @FindBy(xpath = "//input[contains(@class, 'inp-std')]")
    public WebElement certificateDocument;

    @FindBy(xpath = "//input[contains(@name, 'docno')]")
    public WebElement serialAndNumber;

    @FindBy(xpath = "//*[contains(text(), 'Отправить запрос')]")
    public WebElement buttonSendRequest;

    @FindBy(xpath = "//strong[contains(@id, 'resultInn')]")
    public WebElement INN;
}