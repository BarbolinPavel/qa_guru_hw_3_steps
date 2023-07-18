package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        Selenide.open("https://github.com/");
    }

    @Step("Ищем репозиторий по имени {repository}")
    public void searchForRepository(String repository) {
        $("div.search-input-container").click();
        $("#query-builder-test").setValue(repository).pressEnter();
    }


    @Step("В результатах поиска переходим по ссылке репозитория")
    public void openRepositoryLink() {

        $("[data-testid='results-list']").find("[href='/selenide/selenide']").click();
    }

    @Step("Проверяем что существует Issue")
    public void shouldIssue() {

        $("#issues-tab [data-content='Issues']").shouldHave(Condition.text("Issues"));
    }
}
