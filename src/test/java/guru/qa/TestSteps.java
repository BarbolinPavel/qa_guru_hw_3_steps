package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

public class TestSteps {
    private static final String REPOSITORY = "Selenide";
    @Test
    public void githubTests(){
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу",()->{
            Selenide.open("https://github.com/");
        });
        step("Ищем репозиторий по имени" + REPOSITORY,()->{
            $("div.search-input-container").click();
            $("#query-builder-test").setValue(REPOSITORY).pressEnter();
        });
        step("В результатах поиска переходим по ссылке репозитория",()->{
            $("[data-testid='results-list']").find("[href='/selenide/selenide']").click();
        });
        step("Проверяем что существует Issue",()->{
            $("#issues-tab [data-content='Issues']").shouldHave(Condition.text("Issues"));
        });
    }
}
