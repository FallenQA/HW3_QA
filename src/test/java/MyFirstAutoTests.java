import PageObjects.Components;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

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
                .setDateOfBirthInput("1911", "November", "11")
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