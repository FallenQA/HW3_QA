import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;

public class myFirstAutoTests {
   @BeforeAll
   static void beforeAll(){
      Configuration.browserSize = "1920x1080";
      Configuration.baseUrl = "https://demoqa.com/";
   }
   @Test

    void myFirstAT() {
       open("automation-practice-form");
       executeJavaScript("$('#fixedban').remove()");
       executeJavaScript("$('footer').remove()");
       $("#firstName").setValue("Grena");
       $("[id=lastName]").setValue("Ukropovi4");
       $("[id=userEmail]").setValue("Ukropov.Grena@ml.com");
      $("#gender-radio-1").sendKeys(" ");
       $("[id=userNumber]").setValue("7916911102");
      $("#dateOfBirthInput").click();
      $(by("class", "react-datepicker__year-select")).$(byText("1911")).click();
      $(by("class", "react-datepicker__month-select")).$(byText("November")).click();
      $(by("class", "react-datepicker__month-container")).$(byText("11")).click();
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
    }
}