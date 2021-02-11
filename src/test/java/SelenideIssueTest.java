import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SelenideIssueTest {

    String expectedIssueName = "Integrate Selenide with CDP";

    @Test
    void shouldSeeSelenideIssue() {
        open("https://github.com/selenide/selenide/issues");
        $("div[aria-label='Issues']")
                .should(visible).$("div#issue_1157")
                .should(visible).$("div#issue_1157 div a#issue_1157_link")
                .shouldHave(text(expectedIssueName));
    }
}
