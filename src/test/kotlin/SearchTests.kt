import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.openqa.selenium.By
import org.openqa.selenium.Keys
import org.openqa.selenium.chrome.ChromeDriver
import java.time.Duration

class SearchTests {
    @Test
    fun successfulSearchTest() {
        val driver = ChromeDriver()
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))

        driver.get("https://github.com/search")
        driver.findElement(By.cssSelector("[aria-label='Search GitHub']"))
            .sendKeys("qa.guru", Keys.RETURN)

        val results = driver.findElement(By.cssSelector("[data-testid='results-list']"))
        assertTrue(results.text.contains("QA.GURU"))

        driver.quit()
    }
}
