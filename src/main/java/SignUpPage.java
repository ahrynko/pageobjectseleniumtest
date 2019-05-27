import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUpPage {
    private WebDriver driver;

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }
    private By heading = By.xpath("//h1[contains(text(),'Join GitHub')]");
    private By userNameField = By.xpath("//input[@id='user_login']");
    private By emailField = By.xpath("//input[@id='user_email']");
    private By passwordField = By.xpath("//input[@id='user_password']");
    private By signUpButton = By.xpath("//button[@id='signup_button']");
    private By mainError = By.xpath("//div[@class='flash flash-error my-3']");
    private By userNameError = By.xpath("//input[@id='user_login']/following::p[@class='note'][1]");  //input[@id='user_login']/ancestor::dd/following-sibling::dd  //p[@class='note']
    private By emailError = By.xpath("//input[@id='user_email']/ancestor::dd/following-sibling::dd");   //dd[contains(text(),'Email is invalid or already taken')]
    private By passwordError = By.xpath("//password-strength//p[1]");

    public SignUpPage typeUserName(String username){   // метод заполнения полей username  и возврат page SignUpPage
        driver.findElement(userNameField).sendKeys(username);
        return this;
    }
    public SignUpPage typePassword(String password){   // метод заполнения полей password
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public SignUpPage typeEmail(String email){         // метод заполнения полей email
        driver.findElement(emailField).sendKeys(email);
        return this;
    }

    public SignUpPage registerWithInvalidCreds(String username, String email, String password){
        this.typeUserName(username);
        this.typeEmail(email);
        this.typePassword(password);
        driver.findElement(signUpButton).click();
        return new SignUpPage(driver);
    }
    public String getHeadingText(){   // метод получения текстовой ошибок заголовка
        return driver.findElement(heading).getText();
    }
    public String getMainErrorText(){   // метод получения главной ошибки
        return driver.findElement(mainError).getText();
    }
    public String getUserNameErrorText(){   // метод получения ошибки UserName
        return driver.findElement(userNameError).getText();
    }
    public String getPasswordErrorText(){   // метод получения ошибки Email
        return driver.findElement(passwordError).getText();
    }
    public String getEmailErrorText(){   // метод получения ошибки Email
        return driver.findElement(emailError).getText();
    }

}
