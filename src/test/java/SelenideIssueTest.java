import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideIssueTest {

    String expectedIssueName = "Integrate Selenide with CDP";
    private static final String ISSUE_NUMBER = "1157";
    private static final String ISSUES = "Issues";

    @Test
    void shouldSeeSelenideIssue() {
        open("https://github.com/selenide/selenide/issues");
        $("div[aria-label='" + ISSUES + "']")
                .should(visible).$("div#issue_" + ISSUE_NUMBER)
                .should(visible).$("div a#issue_"+ ISSUE_NUMBER + "_link")
                .shouldHave(text(expectedIssueName));
    }
}
