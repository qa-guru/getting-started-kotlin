import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.open
import org.junit.jupiter.api.Test

class SearchTests {
    @Test
    fun successfulSearchTest() {
        open("https://github.com/search")
        `$`("[aria-label='Search GitHub']").setValue("qa.guru").pressEnter()
        `$`("[data-testid='results-list']").shouldHave(text("QA.GURU"))
    }
}
