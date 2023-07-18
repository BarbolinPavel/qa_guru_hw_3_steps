package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class ListenerTests {

    @Test
            void githubTestWithListener()
    {

        SelenideLogger.addListener("allure", new AllureSelenide());

        Selenide.open("https://github.com/");

        $("div.search-input-container").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        $("[data-testid='results-list']").find("[href='/selenide/selenide']").click();

        $("#issues-tab [data-content='Issues']").shouldHave(Condition.text("Issues"));
    }
}
