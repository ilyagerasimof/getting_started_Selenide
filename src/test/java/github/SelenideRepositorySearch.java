package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @Test
    void shouldFindSelenideRepositoryFirst(){

        Configuration.holdBrowserOpen = true;

        open("https://github.com/");
        $(".search-input").click();
        $("[id=query-builder-test]").setValue("selenide").pressEnter();
        //$(".search-input").setValue("selenide").pressEnter();
        $$("[data-testid=results-list]").first().$("a").click();
        $("#repository-container-header").shouldHave(Condition.text("selenide / selenide"));

    };

    @Test
    void checkJUnitExists(){
        Configuration.holdBrowserOpen = true;
        //- Откройте страницу Selenide в Github
        open("https://github.com/selenide/selenide");
        //- Перейдите в раздел Wiki проекта
        $("[id=wiki-tab]").click();
        //- Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        //$("h2").$(Selectors.byText("Chapters")).click();
        $(".markdown-body ul").shouldHave(Condition.text("Soft assertions"));
        //- Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
        $(".markdown-body").$(Selectors.byText("Soft assertions")).click();



    };
}
