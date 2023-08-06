package guthub;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;
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

    @AfterAll
    static void afterAll() {
        Selenide.closeWebDriver();
    }


    @Test
    void shouldFindSoftAssertions() {
        //open selenide page
        open("https://github.com/selenide/selenide");
        //open Wiki
        $("#wiki-tab").click();
        //search for SoftAssertions
        $("#wiki-pages-filter").setValue("SoftAssertions");
        //go to SoftAssertions page
        $("#wiki-pages-box").$(byText("SoftAssertions")).click();
        //find code for JUnit5
        $(".markdown-body").shouldHave(text(
                "3. Using JUnit5 extend test class:\n" +
                        "@ExtendWith({SoftAssertsExtension.class})\n" +
                        "class Tests {\n" +
                        "  @Test\n" +
                        "  void test() {\n" +
                        "    Configuration.assertionMode = SOFT;\n" +
                        "    open(\"page.html\");\n" +
                        "\n" +
                        "    $(\"#first\").should(visible).click();\n" +
                        "    $(\"#second\").should(visible).click();\n" +
                        "  }\n" +
                        "}"));
    }

}