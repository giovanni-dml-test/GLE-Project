package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;



public class RegistrationPage {


    // Locators
    @FindBy(name = "firstName")
    public WebElement firstNameInput;

    @FindBy(name = "lastName")
    public WebElement lastNameInput;

    @FindBy(name = "phone")
    public WebElement phoneInput;

    @FindBy(name = "email")
    public WebElement emailInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(name = "confirmPassword")
    public WebElement confirmPasswordInput;

    @FindBy(id = "terms")
    public WebElement termsCheckbox;

    @FindBy(xpath = "//button[text()='REGISTER']")
    public WebElement registerButton;

    @FindBy(xpath = "//div[@class='p-toast-detail' and text()='E-mail already exists.']")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@class='p-toast-detail' and text()='Your registration has been completed successfully. Please to activate your account, click on the activation link sent to your e-mail.']")
    public WebElement successMessage;

    @FindBy(xpath = "//div[text()='First name is required']")
    public WebElement firstNameError;

    @FindBy(xpath = "//div[text()='Last name is required']")
    public WebElement lastNameError;

    @FindBy(xpath = "//div[text()='Phone is required']")
    public WebElement phoneError;

    @FindBy(xpath = "//div[text()='Email is required']")
    public WebElement emailError;

    @FindBy(xpath = "//div[text()='Invalid email']")
    public WebElement invalidEmailError;

    @FindBy(xpath = "//div[text()='Password is required']")
    public WebElement passwordError;

    @FindBy(xpath = "//div[text()='Confirm password is required']")
    public WebElement confirmPasswordError;

    @FindBy(xpath = "//div[text()='At least 8 characters']")
    public WebElement passwordLengthError;

    @FindBy(xpath = "//div[text()='One uppercase char']")
    public WebElement passwordUppercaseError;

    @FindBy(xpath = "//div[text()='One special character']")
    public WebElement passwordSpecialCharError;

    @FindBy(xpath = "//div[text()='One lowercase char']")
    public WebElement passwordLowercaseError;

    @FindBy(xpath = "//div[text()='One number']")
    public WebElement passwordNumberError;

    @FindBy(xpath = "//div[text()='Passwords must match']")
    public WebElement passwordsMustMatchError;




    // Constructor
    public RegistrationPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }



}
