package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.RegistrationResultsModal;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();
    private final SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("[id=lastName]"),
            userEmailInput = $("[id=userEmail]"),
            gender = $("#genterWrapper"),
            phoneNumber = $("[id=userNumber]"),
            subjects = $("#subjectsInput"),
            submit = $("#submit"),
            checkboxSport = $("#hobbiesWrapper"),
            uploadPicture = $("#uploadPicture"),
            userState = $("#state"),
            userStateCityWrapper = $("#stateCity-wrapper"),
            userCity = $("#city");


    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void lastName(String value) {
        lastNameInput.setValue(value);
    }

    public void eMail(String value) {
        userEmailInput.setValue(value);
    }

    public void setGender(String value) {
        gender.$(byText(value)).click();
    }

    public void setPhoneNumber(String value) {
        phoneNumber.setValue(value);
    }

    public void setBirthDay(String year, String month, String day) {
        CalendarComponent.setDate(year, month, day);
    }

    public void setSubjectsInput(String value) {
        subjects.setValue(value).pressEnter();
    }

    public void clickHobbies(String hobbies) {
        checkboxSport.$(byText(hobbies)).click();
    }

    public void setPictures(String value) {
        File fileToUpload = new File(value);
        uploadPicture.uploadFile(fileToUpload);
    }

    public void setCurrentAddress(String value) {
        $("#currentAddress").setValue(value);
    }

    public void setState(String value) {
        userState.click();
        userStateCityWrapper.$(byText(value)).click();
    }

    public void setCity(String value) {
        userCity.click();
        userStateCityWrapper.$(byText(value)).click();
    }

    public void clickSubmit() {
        submit.click();
    }

    public void verifyResults(String key, String value) {
        registrationResultsModal.formResults(key, value);
    }

    public void submitForm() {
        registrationResultsModal.submittingForm();
    }

    public void fixBanner() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }
}