package Tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.hrmlogin;

public class logintest
{
	WebDriver driver;
	hrmlogin HrmLogin;
	@BeforeMethod
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		HrmLogin=new hrmlogin(driver);
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	@Test
	public void Validlogin()
	{
		HrmLogin.login("Admin","admin123");
        Assert.assertTrue(driver.getPageSource().contains("dashboard"));
	}
@Test
public void invalidlogin()
{
	HrmLogin.login("user","admin");
	Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"));
}

@Test
public void invaliduser()
{
	HrmLogin.login("user","admin123");
	Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"));
	}

@Test
public void invalidpassword()
{
	HrmLogin.login("Admin","admin");
	Assert.assertTrue(driver.getPageSource().contains("Invalid credentials"));
}
@Test
public void blankfield()
{
	HrmLogin.login("","");
	Assert.assertTrue(driver.getPageSource().contains("Required"));
}
@Test
public void blankusr() 
{
	HrmLogin.login("","admin123");
	Assert.assertTrue(driver.getPageSource().contains("Required"));
}

@Test
public void blankpsw()
{
	HrmLogin.login("Admin","");
	Assert.assertTrue(driver.getPageSource().contains("Required"));
}

@Test
public void usrcasesensitive()
{
	HrmLogin.login("admin","admin123");
	Assert.assertTrue(driver.getPageSource().contains("Dashboard"));
}

@Test

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
	
}
