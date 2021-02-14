import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideIssueTest {

    final BaseSteps baseSteps = new BaseSteps();
    private static final String ISSUE_NUMBER = "1157";
    private static final String ISSUES = "Issues";
    private static final String SELENIDE_REPO = "selenide";
    String EXPECTED_ISSUE_NAME = "Integrate Selenide with CDP";

    @Test
    void shouldSeeSelenideIssue() {
        open("https://github.com/selenide/selenide/issues");
        $("div[aria-label='" + ISSUES + "']")
                .should(visible).$("div#issue_" + ISSUE_NUMBER)
                .should(visible).$("div a#issue_" + ISSUE_NUMBER + "_link")
                .shouldHave(text(EXPECTED_ISSUE_NAME));
    }

    @Test
    void shouldSeeSelenideIssueSteps() {
        step("Открываем репозиторий " + SELENIDE_REPO, () -> {
            open("https://github.com/selenide");
        });
        step("Открываем " + ISSUES, () -> {
            open("https://github.com/selenide/selenide/issues");
        });

        step("Проверяем, что Issue " + ISSUE_NUMBER + " существует", () -> {
            $("div[aria-label='" + ISSUES + "']")
                    .should(visible).$("div#issue_" + ISSUE_NUMBER)
                    .should(visible).$("div a#issue_" + ISSUE_NUMBER + "_link").should(Condition.exist);
        });

        $("div[aria-label='" + ISSUES + "']")
                .should(visible).$("div#issue_" + ISSUE_NUMBER)
                .should(visible).$("div a#issue_" + ISSUE_NUMBER + "_link")
                .shouldHave(text(EXPECTED_ISSUE_NAME));
    }

    @Test
    void shouldSeeSelenideIssueAnnotationSteps(){
        baseSteps.openRepoPage(SELENIDE_REPO);
        baseSteps.openIssuesPage("issues");
        baseSteps.checkThatIssueExists(ISSUE_NUMBER, EXPECTED_ISSUE_NAME);
    }
}
