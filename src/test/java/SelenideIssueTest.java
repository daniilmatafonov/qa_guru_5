import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class SelenideIssueTest {

    String expectedIssueName = "Integrate Selenide with CDP";
    private static final String ISSUE_NUMBER = "1157";
    private static final String ISSUES = "Issues";
    private static final String SELENIDE_REPO = "selenide";

    @Test
    void shouldSeeSelenideIssue() {
        open("https://github.com/selenide/selenide/issues");
        $("div[aria-label='" + ISSUES + "']")
                .should(visible).$("div#issue_" + ISSUE_NUMBER)
                .should(visible).$("div a#issue_" + ISSUE_NUMBER + "_link")
                .shouldHave(text(expectedIssueName));
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
                .shouldHave(text(expectedIssueName));
    }
}
