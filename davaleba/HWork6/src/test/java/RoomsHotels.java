import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class RoomsHotels extends ChromeRunner {
    @Test
    public void test2()    {
        $(".module-intro__headline").shouldHave(Condition.text("Old City. New City. "));
        $(".module-intro__text-container").$(By.tagName("h3")).shouldHave(Condition.text("#Tbilisi"));

        $(byText("Kazbegi")).click();
        $(".module-intro__headline").shouldHave(Condition.text("I WOKE UP LIKE THIS"));
        $(".module-intro__text-container").$(By.tagName("h3")).shouldHave(Condition.text("#Kazbegi"));
        String kazbegi = $(".module-intro__text-container").$(By.tagName("h3")).getText();
        Assert.assertEquals("Not Same In Kazbegi", "#Kazbegi", kazbegi);

        $(byText("Kokhta")).click();
        $(".module-intro__headline").shouldHave(Condition.text("THIS IS ROOMS HOTELS"));
        $(".module-intro__text-container").$(By.tagName("h3")).shouldHave(Condition.text("#Kokhta"));
        String kokhta = $(".module-intro__text-container").$(By.tagName("h3")).getText();
        Assert.assertEquals("Not Same In Kokhta", "#Kokhta", kokhta);

        $(byText("Kokhta")).hover();
        $(".header__top__submenu", 2).shouldHave(Condition.text("Rooms Overview"));

        $(".menu-toggler").click();
        $(".accordion").shouldHave(Condition.text("DESTINATIONS"));
        $(byLinkText("Special Offers")).shouldBe(Condition.visible);
        $(byLinkText("About")).shouldBe(Condition.visible);
        $(byLinkText("Travel Experiences")).shouldBe(Condition.visible);
        $(byLinkText("Events Calendar")).shouldBe(Condition.visible);
        $(byLinkText("EDITORIAL")).shouldBe(Condition.visible);
        $(byLinkText("CONTACT")).shouldBe(Condition.visible);

        $(".accordion").click();
        $(byLinkText("Tbilisi")).shouldBe(Condition.visible);
        $(byLinkText("Kazbegi")).shouldBe(Condition.visible);
        $(byLinkText("Kokhta")).shouldBe(Condition.visible);


    }
}
