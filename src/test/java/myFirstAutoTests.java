import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class myFirstAutoTests {
   @Test

    void myFirstAT() {
       open("https://demoqa.com/automation-practice-form");
       $("#firstName").setValue("Grena");
       $("[id=lastName]").setValue("Ukropovi4");
       $("[id=userEmail]").setValue("Ukropov.Grena@ml.com");
   }
}
