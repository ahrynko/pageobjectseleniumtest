import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

  private WebDriver driver;
  private LoginPage loginPage;

  @Before
  public void setUp(){
      System.setProperty("webdriver.chrome.driver", "D:\\My Java Projects\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("https://github.com/login");
    loginPage = new LoginPage(driver);
}
   @Test
   public void loginWithEmptyCredsTest(){
    LoginPage newloginPage = loginPage.loginWithInvalidCreds("","");
    String error = newloginPage.getErrorText();
     Assert.assertEquals("Incorrect username or password.",error);
   }
   @Test
   public void loginWithIncorrectCredsTest(){
    LoginPage newloginPage = loginPage.loginWithInvalidCreds("qwer","qrrewrwr");
    String error = newloginPage.getErrorText();
     Assert.assertEquals("Incorrect username or password.",error);
   }

  @After
  public void tearDown(){
    driver.quit();
  }
}
