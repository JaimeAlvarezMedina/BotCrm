import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumPrueba {

	public static void main(String[] args) {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--enable-javascript");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:3000");
		
		driver.findElement(By.id("user")).sendKeys("admin");
		driver.findElement(By.id("contra")).sendKeys("admin");
		driver.findElement(By.id("boton")).click();
		
		driver.findElement(By.cssSelector("a[href='/anadir']")).click();
		driver.findElement(By.id("campo_nombre")).sendKeys("Jaime");
		driver.findElement(By.id("campo_correo")).sendKeys("jaime@solera.com");
		driver.findElement(By.id("campo_tel")).sendKeys("678953240");
		driver.findElement(By.id("boton")).click();
		
		try {
			Thread.sleep(1500);
			driver.findElement(By.cssSelector("a[href='/oportunidad']")).click();
			driver.findElement(By.id("boton")).click();
			driver.findElement(By.cssSelector("a[href='/cliente']")).click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}