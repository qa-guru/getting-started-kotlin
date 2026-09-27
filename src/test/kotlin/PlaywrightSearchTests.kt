import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Playwright
import com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat
import org.junit.jupiter.api.Test

class PlaywrightSearchTests {
    @Test
    fun successfulSearchTest() {
        Playwright.create().use { playwright ->
            val browser = playwright.chromium().launch(
                BrowserType.LaunchOptions().setHeadless(false)
            )
            val page = browser.newPage()

            page.navigate("https://github.com/search")
            val search = page.locator("[aria-label='Search GitHub']")
            search.fill("qa.guru")
            search.press("Enter")

            assertThat(page.locator("[data-testid='results-list']")).containsText("QA.GURU")
            browser.close()
        }
    }
}
