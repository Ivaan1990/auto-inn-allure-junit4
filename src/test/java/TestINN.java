import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pages.BasePage;
import steps.AgreementSteps;
import steps.BaseSteps;
import steps.InnSteps;
import util.TestProperties;

import java.util.Properties;

public class TestINN extends BaseSteps {

    private Properties properties = TestProperties.getInstance().getProperties();

    @Test
    @DisplayName("Получение ИНН")
    public void Inn(){

        AgreementSteps agreementSteps = new AgreementSteps();
        InnSteps innSteps = new InnSteps();

        agreementSteps.aggrement();
        agreementSteps.continueButton();
        innSteps.fillSurnameField(properties.getProperty("surname"));
        innSteps.fillFirstName(properties.getProperty("name"));
        innSteps.fillPatronymicField(properties.getProperty("patronymic"));
        innSteps.fillBirthDate(properties.getProperty("birthDate"));
        innSteps.fillPlaceOfBirth(properties.getProperty("placeOfBirth"));
        innSteps.fillCertificateDocument(properties.getProperty("document"));
        innSteps.fillSerialAndNumber("4511299805"); // заменить на актуальные паспортные данные
        innSteps.sendRequest();
        innSteps.getInnNumber();
    }

}