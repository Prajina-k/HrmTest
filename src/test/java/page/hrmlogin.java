package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hrmlogin
{
private WebDriver driver;
private WebDriverWait wait;
private By username=By.name("username");
private By Password=By.name("password");
private By Login=By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button");

public hrmlogin(WebDriver driver)
{
	this.driver=driver;
	this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}

public void username(String usrname)
{
	driver.findElement(username).clear();
	driver.findElement(username).sendKeys(usrname);
}
public void password(String pswd)
{
	driver.findElement(Password).clear();
	driver.findElement(Password).sendKeys(pswd);
}
public void clicklogin()
{
	driver.findElement(Login).click();
}

public void login(String usrname, String pswd) {
    WebElement userInput = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
    WebElement passInput = driver.findElement(Password);
    WebElement loginBtn = driver.findElement(Login);

    userInput.clear();
    passInput.clear();

    userInput.sendKeys(usrname);
    passInput.sendKeys(pswd);
    loginBtn.click();
}

}

