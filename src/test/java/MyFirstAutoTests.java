import PageObjects.Components;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MyFirstAutoTests {
    Components registrationPage = new Components();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void myFirstAT() {
        String userName = "Grena";
        registrationPage.openPage()
                .setFirstName(userName)
                .lastName()
                .eMail("Ukropov.Grena@ml.com")
                .setGender("Male")
                .setPhoneNumber("7916911102")
                .setDate("1911", "November", "11")
                .setSubjectsInput("Hindi")
                .setAllCheckboxes()
                .setUploadFile()
                .setCurrentAddress("USA")
                .setState()
                .setCity()
                .clickSubmit()
                .checkResults();

    }
}