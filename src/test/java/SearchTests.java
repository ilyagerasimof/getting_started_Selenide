import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.href;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    @Test
    void successfulSearchTest() {

        Configuration.holdBrowserOpen = true;

        open("https://www.ya.ru/");
        $(".mini-suggest__input").setValue("selenide").pressEnter();
        $(".link").shouldHave(href("https://ru.selenide.org"));
    }
}
