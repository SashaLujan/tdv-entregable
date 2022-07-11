import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoqaSearch {
	
	WebDriver driver;

	public DemoqaSearch(WebDriver driver) {
		this.driver = driver;
	}

	public void search(String busqueda) {
		WebDriverWait wait = new WebDriverWait(driver, 6000);
		WebElement searchbar = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("searchBox")));
		searchbar.sendKeys(busqueda);
		
		WebElement book = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("see-book-Eloquent JavaScript, Second Edition")));
		
		Actions action = new Actions(driver);
		action.doubleClick(book).perform();
	}
	
}
