package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseSteps {

    public static final String ISSUE_NUMBER_SELECTOR = "a#issue_1420_link";

    @Step("Открываем репозиторий {repo}")
    public void openRepoPage(String repo) {
        open("/" + repo);
    }

    @Step("Переходим в issues")
    public void openIssuesPage() {
        $("span[data-content='Issues']").click();
    }

    @Step("Проверяем, что Issue с именем {expectedIssueName} существует")
    public void checkThatIssueExists(final String expectedIssueName) {
        $(ISSUE_NUMBER_SELECTOR).shouldBe(visible).shouldHave(text(expectedIssueName));
    }
}
