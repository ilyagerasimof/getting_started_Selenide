import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginTests {
    /*
    Открыть форму авторизации
    Ввести почту
    Ввести пароль
    Нажать Войти
    Нажать Личный кабинет
    Проверить авторизацию
     */


    @Test
    void successfullLoginTest( ){
        //Configuration.holdBrowserOpen = true;
        //Configuration.browser = "safari";

        open("https://school.qa.guru/cms/system/login");
        $(".login-form").shouldHave(Condition.text("Войти"));
        $("[name=email]").setValue("ilya.grsmv@gmail.com");
        $("[name=password]").setValue("dCan0Z+A").pressEnter();
        $(".logined-form").shouldHave(Condition.text("Здравствуйте, Илья"));
        $(".menu-item-icon").click();
        $(".menu-item-profile").click();
    }

    @Test
    void unsuccessfullLoginTest( ){

    }
}
