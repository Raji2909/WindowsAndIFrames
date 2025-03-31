package newWindowOpen;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NewWindowOpen {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/windows");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement ClickHere = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));ClickHere.click();
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        System.out.println("New Window is present on the page");
        System.out.println("New tab title: " + driver.getTitle());
        driver.close();
        Thread.sleep(3000);
        driver.switchTo().window(mainWindowHandle);
        Thread.sleep(3000);
        System.out.println("Original Window is active");
        driver.close();
    }
}