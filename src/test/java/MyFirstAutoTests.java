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
                .setDateOfBirthInput("1911", "November", "11");
        $("#subjectsInput").setValue("Hindi").pressEnter();
        $(By.cssSelector("label[for='hobbies-checkbox-1']")).click();
        $(By.cssSelector("label[for='hobbies-checkbox-2']")).click();
        $(By.cssSelector("label[for='hobbies-checkbox-3']")).click();
        File fileUpFoto = new File("src\\pictures\\newfoto.jpg");
        $("#uploadPicture").uploadFile(fileUpFoto);
        $("#currentAddress").setValue("USA");
        $("#state").click();
        $("#react-select-3-option-3").click();
        $("#city").click();
        $("#react-select-4-option-1").click();
        $("#submit").click();

        registrationPage.checkResults();

    }
}