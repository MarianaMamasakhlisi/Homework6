import com.codeborne.selenide.Condition;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;


public class Hotels extends ChromeRunner {
    @Test
    public void test1(){
    $(".menu-toggler").click();
    $(byText("Events Calendar")).click();
    $("#from").click();
    $("#ui-datepicker-div").shouldBe(Condition.visible);
    $(".ui-datepicker-next").click();
    $(byLinkText("10")).click();
    $(".ui-datepicker-div").shouldNotBe(Condition.visible);
    String date =  $("#from").getValue();
        Assert.assertEquals("Date Error","10/02/21", date );
}

}