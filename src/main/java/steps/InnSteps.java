package steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.InnPage;
import org.openqa.selenium.Keys;
import static pages.BasePage.delay;

public class InnSteps {
    private InnPage innPage = new InnPage();

    @Step("Заполняем поле Фамилия - {0}")
    public void fillSurnameField(String surname){
        innPage.fillFieldByChar(innPage.surnameField, surname);
    }

    @Step("Заполняем поле имя - {0}")
    public void fillFirstName(String name){
        innPage.fillFieldByChar(innPage.nameField, name);
    }

    @Step("Заполняем поле отчество - {0}")
    public void fillPatronymicField(String patronymic){
        if (patronymic == null || patronymic.equals("")){
            innPage.clickElement(innPage.checkBoxWithoutPatronymic);
        } else {
            innPage.fillFieldByChar(innPage.patronymic, patronymic);
        }
    }

    @Step("Заполняем дату рождения - {0}")
    public void fillBirthDate(String date){
        innPage.fillFieldByChar(innPage.birthDate, date);
    }

    @Step("Место рождения - {0}")
    public void fillPlaceOfBirth(String place){
        innPage.fillField(innPage.placeOfBirth, place);
    }

    @Step("Вид документа удостоверяющий личность - {0}")
    public void fillCertificateDocument(String value){
        innPage.fillField(innPage.certificateDocument, value);
        innPage.certificateDocument.sendKeys(Keys.DOWN, Keys.RETURN);
    }

    @Step("Заполняем серию и номер документа - {0}")
    public void fillSerialAndNumber(String value){
        innPage.fillField(innPage.serialAndNumber, value);
        innPage.scrollPage(innPage.serialAndNumber);
    }

    @Step("Отправляем запрос на получение номера ИНН")
    public void sendRequest(){
        innPage.clickElement(innPage.buttonSendRequest);
    }

    @Step("Получаем номер ИНН")
    public void getInnNumber(){
        innPage.scrollPage(innPage.INN);
        delay(1);

        //todo сделать явное ожидание появление элемента

        WebElement el = BaseSteps.getDriver().findElement(By.xpath("//*[contains(text(), 'Информация об ИНН найдена.')]"));
        Assert.assertEquals("INN ne poluchen", "Информация об ИНН найдена.", el.getText());
    }

}