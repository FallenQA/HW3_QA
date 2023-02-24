import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

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
       $("#firstName").setValue("Grena");
       $("[id=lastName]").setValue("Ukropovi4");
       $("[id=userEmail]").setValue("Ukropov.Grena@ml.com");
       $("#genterWrapper > div.col-md-9.col-sm-12 > div:nth-child(1) > label").click();
       $("[id=userNumber]").setValue("+79169111020");
       $(By.cssSelector("label[for='gender-radio-1']")).click();
       $("#dateOfBirthInput").click();
       $(".react-datepicker__month-select").selectOptionByValue("10");
       $(".react-datepicker__year-select").selectOptionByValue("1941");
      }
}



