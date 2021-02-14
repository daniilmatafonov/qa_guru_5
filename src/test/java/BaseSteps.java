import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    private static final String BASE_URL = "https://github.com/";
    private static final String SELENIDE = "selenide";

    @Step("Переходим в {repo}")
    public void openRepoPage(final String repo) {
        open(BASE_URL + repo);
    }

    @Step("Открываем страницу в {issues}")
    public void openIssuesPage(final String issues) {
        open(BASE_URL + SELENIDE + "/" + SELENIDE + "/" + issues);
    }

    @Step("Проверяем, что Issue {issueNumber} с именем {expectedIssueName} существует")
    public void checkThatIssueExists(final String issueNumber, final String expectedIssueName) {
        $("div[aria-label='Issues']")
                .should(visible).$("div#issue_" + issueNumber)
                .should(visible).$("div a#issue_" + issueNumber + "_link").should(Condition.exist).shouldHave(text(expectedIssueName));
    }
}
