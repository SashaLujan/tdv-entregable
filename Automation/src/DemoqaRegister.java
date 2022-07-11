
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoqaRegister {
	
	WebDriver driver;

	public DemoqaRegister(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchRegister() {
		WebDriverWait wait = new WebDriverWait(driver, 6000);
		WebElement buttonLogin = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
		buttonLogin.click();
		
		WebElement buttonNewUser = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("newUser")));
		buttonNewUser.click();
	}

	public void register(String name, String lastName, String userName, String password) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 6000);
		WebElement inputName = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
		WebElement inputLastName = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname")));
		WebElement inputUserName = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("userName")));
		WebElement inputPassword = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
		WebElement recaptcha = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("g-recaptcha")));
		WebElement btnRegister = (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register")));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,350)", "");
		inputName.sendKeys(name);
		inputLastName.sendKeys(lastName);
		inputUserName.sendKeys(userName);
		inputPassword.sendKeys(password);
		recaptcha.click();
		btnRegister.click();
		Thread.sleep(2000);
	}
	
}
