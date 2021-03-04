import org.junit.jupiter.api.Test;
import steps.BaseSteps;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideIssueTest extends BaseTest {

    private BaseSteps baseSteps = new BaseSteps();
    private static final String REPOSITORY_NAME = "selenide";
    private static final String EXPECTED_ISSUE_NAME = "Caused by: TimeoutException: Expected condition failed after 5.14.0 update";

    @Test
    public void shouldSeeSelenideIssue() {
        open("/" + REPOSITORY_NAME);
        $("span[data-content='Issues']").click();
        $(BaseSteps.ISSUE_NUMBER_SELECTOR).shouldBe(visible).shouldHave(text(EXPECTED_ISSUE_NAME));
    }

    @Test
    public void shouldSeeSelenideIssueSteps() {
        step("Открываем репозиторий " + REPOSITORY_NAME, () -> {
            open("/" + REPOSITORY_NAME);
        });
        step("Переходим в issues ", () -> {
            $("span[data-content='Issues']").click();
        });
        step("Проверяем, что Issue с именем " + EXPECTED_ISSUE_NAME + " существует", () -> {
            $(BaseSteps.ISSUE_NUMBER_SELECTOR).shouldBe(visible).shouldHave(text(EXPECTED_ISSUE_NAME));
        });
    }

    @Test
    public void shouldSeeSelenideIssueAnnotationSteps() {
        baseSteps.openRepoPage(REPOSITORY_NAME);
        baseSteps.openIssuesPage();
        baseSteps.checkThatIssueExists(EXPECTED_ISSUE_NAME);
    }
}
