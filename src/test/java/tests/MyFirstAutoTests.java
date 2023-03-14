package tests;

import pages.RegistrationPage;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MyFirstAutoTests {
    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void myFirstAT() {
        String userName = "Grena";
        String lastName = "Ukropovi4";
        String eMail = "Ukropov.Grena@ml.com";
        String setFile = "src/pictures/newfoto.jpg";
        String genders = "Male";
        String phoneNumber = "7916911102";
        String birthYear = "1911";
        String birthMonth = "November";
        String birthDate = "11";
        String subjects = "Hindi";
        String hibbies = "Sports";
        String address = "USA";
        String state = "Uttar Pradesh";
        String city = "Agra";
        registrationPage.openPage();
        registrationPage.fixBanner();
        registrationPage.setFirstName(userName);
        registrationPage.lastName(lastName);
        registrationPage.eMail(eMail);
        registrationPage.setGender(genders);
        registrationPage.setPhoneNumber(phoneNumber);
        registrationPage.setBirthDay(birthYear,birthMonth,birthDate);
        registrationPage.setSubjectsInput(subjects);
        registrationPage.clickHobbies(hibbies);
        registrationPage.setCurrentAddress(address);
        registrationPage.setState(state);
        registrationPage.setCity(city);
        registrationPage.setPictures(setFile);

        registrationPage.clickSubmit();

        registrationPage.submitForm();
        registrationPage.verifyResults("Student Name", userName + " " + lastName);
        registrationPage.verifyResults("Student Email", eMail);
        registrationPage.verifyResults("Gender", genders);
        registrationPage.verifyResults("Mobile", phoneNumber);
        registrationPage.verifyResults("Date of Birth", birthDate + " " + birthMonth + "," + birthYear);
        registrationPage.verifyResults("Subjects", subjects);
        registrationPage.verifyResults("Hobbies", hibbies);
        registrationPage.verifyResults("Address", address);
        registrationPage.verifyResults("State and City", state + " " + city);

    }
}