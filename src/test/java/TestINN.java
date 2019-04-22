import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.BasePage;
import steps.AgreementSteps;
import steps.BaseSteps;
import steps.InnSteps;

public class TestINN extends BaseSteps {

    // заменить на актуальные данные
    private String
            surname = "Юшин",
            name = "Иван",
            patronymic = "Евгеньевич",
            birthDate = "01111990",
            placeOfBirth = "город Москва",
            document = "21"; // код документа на сайте

    @Test
    @DisplayName("Получение ИНН")
    public void Inn(){
        AgreementSteps agreementSteps = new AgreementSteps();
        InnSteps innSteps = new InnSteps();

        agreementSteps.aggrement();
        agreementSteps.continueButton();
        innSteps.fillSurnameField(surname);
        innSteps.fillFirstName(name);
        innSteps.fillPatronymicField(patronymic);
        innSteps.fillBirthDate(birthDate);
        innSteps.fillPlaceOfBirth(placeOfBirth);
        innSteps.fillCertificateDocument(document);
        innSteps.fillSerialAndNumber(""); // заменить на актуальные паспортные данные
        innSteps.sendRequest();
        innSteps.getInnNumber();

    }
}