package iFramesOpen;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;
public class IFramesOpen {
	public static void main(String[] args) throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://the-internet.herokuapp.com/nested_frames");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.cssSelector("[name = 'frame-top']")));
		System.out.println("There are three frames on the Page");
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.xpath("/html/frameset/frame[1]")));
		System.out.println("The left frame has a text LEFT");
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.cssSelector("[name = 'frame-middle']")));
		System.out.println("The middle frame has a text MIDDLE");
		driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.cssSelector("[name = 'frame-right']")));
		System.out.println("The right frame has a text RIGHT");
	    driver.switchTo().parentFrame();
		driver.switchTo().frame(driver.findElement(By.cssSelector("[name = 'frame-bottom']")));
		System.out.println("The bottom frame has a text BOTTOM");
		driver.getTitle();
        
}
}
