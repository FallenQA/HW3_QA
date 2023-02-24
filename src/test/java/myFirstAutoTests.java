import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class myFirstAutoTests {
   @Test

    void myFirstAT() {
       open("https://demoqa.com/automation-practice-form");
       $("#firstName").setValue("Grena");
    }
}
