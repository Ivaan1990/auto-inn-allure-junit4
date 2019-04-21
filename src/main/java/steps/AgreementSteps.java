package steps;

import io.qameta.allure.Step;
import pages.AgreementPage;

public class AgreementSteps {

    private AgreementPage agreementPage = new AgreementPage();

    @Step("Ставим чекбокс на согласие обработки данных")
    public void aggrement(){
        agreementPage.clickElement(agreementPage.agreementCheckBox);
        agreementPage.scrollPage(agreementPage.agreementCheckBox);
    }

    @Step("Нажатие на кнопку 'Продолжить'")
    public void continueButton(){
        agreementPage.clickElement(agreementPage.buttonContinue);
    }
}