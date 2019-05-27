import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage {
    private WebDriver driver;        // переменная класса

    public MainPage(WebDriver driver) {    //конструктор (alt+insert)
        this.driver = driver;
    }
  //  описание локаторов для елементов на странице

//  @FindBy(xpath = "//a[@class='HeaderMenu-link no-underline mr-3']")      //Page Factory
//  private WebElement singInButton;
//  @FindBy(xpath = "//a[@class='HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1']")
//  private WebElement singUpButton;
//  @FindBy(xpath = "//input[@id='user[login]']")
//  private WebElement userNameField;
//  @FindBy(xpath = "//input[@id='user[email]']")
//  private WebElement emailField;
//  @FindBy(xpath = "//input[@id='user[password]']")
//  private WebElement passwordField;
//  @FindBy(xpath = "//button[@type='submit'][contains(text(),'Sign up for GitHub')]")
//  private WebElement singUpFormButton;

   private By singInButton = By.xpath("//a[@class='HeaderMenu-link no-underline mr-3']");
   private By singUpButton = By.xpath("//a[@class='HeaderMenu-link d-inline-block no-underline border border-gray-dark rounded-1 px-2 py-1']");
   private By userNameField = By.xpath("//input[@id='user[login]']");
   private By emailField = By.xpath("//input[@id='user[email]']");
   private By passwordField = By.xpath("//input[@id='user[password]']");
   private By singUpFormButton = By.xpath("//button[@type='submit'][contains(text(),'Sign up for GitHub')]");

   public LoginPage clickSignIn(){      //  метод для нажатия кнопки SignIn в хедере
       driver.findElement(singInButton).click();
       return new LoginPage(driver);  //  возврат объекта LoginPage и переход на страницу логина
   }
    public SignUpPage clickSingUpButton(){  //  метод для нажатия кнопки SignUp в хедере
        driver.findElement(singUpButton).click();
        return new SignUpPage(driver);
    }
    public SignUpPage clickSingUpFormButton(){   //  метод для нажатия кнопки “Sign up for GitHub”
        driver.findElement(singUpFormButton).click();
        return new SignUpPage(driver);
    }

    public MainPage typeUserName(String username){   // метод заполнения полей username и возврат MainPage
       driver.findElement(userNameField).sendKeys(username);
       return this;
    }
    public MainPage typePassword(String password){   // метод заполнения полей password  и возврат MainPage
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public MainPage typeEmail(String email){         // метод заполнения полей email  и возврат MainPage
        driver.findElement(emailField).sendKeys(email);
//        emailField.sendKeys(email);           //Page Factory
        return this;
    }
         //название метода register, возвращает страницу SignUpPage и прин...3 param
    public SignUpPage register(String username, String email, String password) {
       this.typeUserName(username);
       this.typeEmail(email);
       this.typePassword(password);
       this.clickSingUpFormButton();
       return new SignUpPage(driver);
    }
}
