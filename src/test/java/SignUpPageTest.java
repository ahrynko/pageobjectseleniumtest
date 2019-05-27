import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SignUpPageTest {

  WebDriver driver;
  SignUpPage signUpPage;

  @Before
  public void setUp(){
    System.setProperty("webdriver.chrome.driver", "D:\\My Java Projects\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    driver.get("http://github.com/join");
    signUpPage = new SignUpPage(driver);
  }

  @Test
  public void signUpWithShortPass(){
    SignUpPage sp = signUpPage.typePassword("qwe");
    String error = sp.getPasswordErrorText();
    Assert.assertEquals("Make sure it's at least 15 characters OR at least 8 characters including a number and a lowercase letter. Learn more.",error);
  }

  @Test
public void signUpWithUnavaibleUserNameTest(){
    SignUpPage sp = signUpPage.typeUserName("Username");
    String error = sp.getUserNameErrorText();
    Assert.assertEquals("Username 'Username' is unavailable",error);
  }

  @Test
  public void signUpTakenUserName(){
    SignUpPage sp = signUpPage.typeUserName("User");
    String error = sp.getUserNameErrorText();
    Assert.assertEquals("Username is already taken",error);
  }

  @Test
  public void getHeadingTest(){
    String hesding = signUpPage.getHeadingText();
    Assert.assertEquals("Join GitHub",hesding);
  }

  @After
  public void tearDown(){
    driver.quit();
  }
}
