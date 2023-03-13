package PageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.remote.tracing.EventAttribute.setValue;

public class Components {
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("[id=lastName]"),
            userEmailInput = $("[id=userEmail]"),

    gender = $("#genterWrapper"),

    phoneNumber = $("[id=userNumber]"),
    subjects =  $("#subjectsInput");

    public Components openPage() {
        open("https://demoqa.com/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public Components setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public Components lastName() {
        lastNameInput.setValue("Ukropovi4");
        return this;
    }

    public Components eMail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public Components setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public Components setPhoneNumber(String value) {
        phoneNumber.setValue(value);
        return this;
    }
    public Components setDateOfBirthInput (String year, String month, String day) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day +
                ":not(.react-datepicker__day--outside-month)").click();
        return this;
    }

    public Components checkResults() {
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $("tbody tr:nth-child(1) td:nth-child(2)").shouldHave(text("Grena Ukropovi4"));
        $("tbody tr:nth-child(2) td:nth-child(2)").shouldHave(text("Ukropov.Grena@ml.com"));
        $("tbody tr:nth-child(3) td:nth-child(2)").shouldHave(text("Male"));
        $("tbody tr:nth-child(4) td:nth-child(2)").shouldHave(text("7916911102"));
        $("tbody tr:nth-child(5) td:nth-child(2)").shouldHave(text("11 November,1911"));
        $("tbody tr:nth-child(6) td:nth-child(2)").shouldHave(text("Hindi"));
        $("tbody tr:nth-child(7) td:nth-child(2)").shouldHave(text("Sports, Reading, Music"));
        $("tbody tr:nth-child(8) td:nth-child(2)").shouldHave(text("newfoto.jpg"));
        $("tbody tr:nth-child(9) td:nth-child(2)").shouldHave(text("USA"));
        $("tbody tr:nth-child(10) td:nth-child(2)").shouldHave(text("Rajasthan Jaiselmer"));
        return this;
    }
    public Components setSubjectsInput(String value) {
       subjects.setValue(value).pressEnter();
        return this;
    }
}