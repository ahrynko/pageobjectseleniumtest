import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
   private WebDriver driver;

    public LoginPage(WebDriver driver) {    //конструктор
        this.driver = driver;
    }   //  описание локаторов для елементов на странице LoginPage
   private By loginField = By.xpath("//input[@id='login_field']");
   private By passwordField = By.xpath("//input[@id='password']");
   private By signInButton = By.xpath("//input[@value='Sign in']");
   private By heading = By.xpath("//div[@class='auth-form-header p-0']");
   private By error = By.xpath("//div[@class='container']");
   private By createAccLink = By.xpath("//a[@data-ga-click='Sign in, switch to sign up']");

   public LoginPage typeUserName(String username){       //метод ввода логина
       driver.findElement(loginField).sendKeys(username);
       return this;
   }
    public LoginPage typePassword(String password){      //метод ввода пароля
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
        //  метод для нажатия кнопки Sign in
    public  LoginPage loginWithInvalidCreds(String username,String password){
       this.typeUserName(username);
       this.typePassword(password);
       driver.findElement(signInButton).click();
       return new LoginPage(driver);  // метод возврата объекта данной страницы и передачм драйвера
    }
    public String getHeadingText(){      //метод для получения заголовка текста
       return driver.findElement(heading).getText();
    }
    public String getErrorText(){       //метод для получения  текстовой ошибки
       return driver.findElement(error).getText();
    }
    public SignUpPage createAccount (){       //метод возврата страницы SignUp при нажатии на ссылку
        driver.findElement(createAccLink).click();
        return new SignUpPage(driver);
    }
}
