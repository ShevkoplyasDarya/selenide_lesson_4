package guthub;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class SelenideWikiTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920*1080";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void shouldFindSelenideWikiOnGithub() {
        //open selenide page
        open("https://github.com/selenide/selenide");
        //open Wiki
        $("#wiki-tab").click();
        // check if page Soft assertions is present
        $("#wiki-body").shouldHave(text("Soft assertions"));
        //open page SoftAssertions
        $("#wiki-body").$(byText("Soft assertions")).click();
        //find code for JUnit5
        $("#wiki-body").shouldHave(text("JUnit5"), text("@ExtendWith({SoftAssertsExtension.class})"));
    }

}