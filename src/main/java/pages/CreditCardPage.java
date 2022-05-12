package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtils;

public class CreditCardPage {
    public static PageUtils pageUtils;

    WebDriver driver;

    public CreditCardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        pageUtils = new PageUtils(driver);
    }

    @FindBy(how = How.XPATH, using = "(//a[@class='c24-cookie-consent-button'])[1]")
    WebElement cookie_accept_button;

    @FindBy(how = How.XPATH, using = "(//div[contains(@class,'product-panel product-panel--zero-element')]/" +
            "following-sibling::div)[2]//a")
    WebElement continue_button_of_first_product;

    @FindBy(how = How.XPATH, using = "//input[@id='cl_login']")
    WebElement email_input_box;

    @FindBy(how = How.XPATH, using = "//button[@id='c24-uli-login-btn']")
    WebElement continue_button_in_login;

    @FindBy(how = How.XPATH, using = "//div[text()='Ich möchte als Gast fortfahren']")
    WebElement continue_as_guest_check_box;

    @FindBy(how = How.XPATH, using = "//button[@id='c24-uli-register-btn']")
    WebElement continue_button_in_register;

    @FindBy(how = How.XPATH, using = "//a[text()='weiter']")
    WebElement continue_button_in_form;

    @FindBy(how = How.XPATH, using = "//input[@id='GENDER_FEMALE']/parent::div")
    WebElement female_radio_button;

    @FindBy(how = How.XPATH, using = "//input[@id='GENDER_MALE']/parent::div")
    WebElement male_radio_button;

    @FindBy(how = How.ID, using = "GIVEN_NAME")
    WebElement first_name_input_box;

    @FindBy(how = How.ID, using = "LAST_NAME")
    WebElement last_name_input_box;

    @FindBy(how = How.ID, using = "DATE_OF_BIRTH")
    WebElement date_of_birth_input_box;

    @FindBy(how = How.ID, using = "PHONENUMBER_MOBILE")
    WebElement mobile_number_input_box;

    @FindBy(how = How.XPATH, using = "//input[@id='GENDER_FEMALE']/ancestor::div[@class='styles_" +
            "_InputWrapper-sc-1p0oq45-7 jhxkXH']/following-sibling::div")
    WebElement gender_error_text;

    @FindBy(how = How.XPATH, using = "(//input[@id='GIVEN_NAME']/ancestor::div[@class='styles__InputWrapper-" +
            "sc-1p0oq45-7 jhxkXH']/following-sibling::div)[1]")
    WebElement first_name_error_text;

    @FindBy(how = How.XPATH, using = "(//input[@id='LAST_NAME']/ancestor::div[@class='styles_" +
            "_InputWrapper-sc-1p0oq45-7 jhxkXH']/following-sibling::div)[2]")
    WebElement last_name_error_text;

    @FindBy(how = How.XPATH, using = "//input[@id='DATE_OF_BIRTH']/ancestor::div[@class='styles_" +
            "_InputWrapper-sc-1p0oq45-7 jhxkXH']/following-sibling::div")
    WebElement date_of_birth_error_text;

    @FindBy(how = How.XPATH, using = "//input[@id='PHONENUMBER_MOBILE']/ancestor::div[@class='styles_" +
            "_InputWrapper-sc-1p0oq45-7 jhxkXH']/following-sibling::div")
    WebElement mobile_number_error_text;

    @FindBy(how = How.XPATH, using = "//h2[text()='Weitere persönliche Angaben']")
    WebElement other_personal_information_title;

    public void click_cookie_accept_button() {
        cookie_accept_button.click();
    }

    public void click_first_product_continue_button() {
        continue_button_of_first_product.click();
    }

    public void enter_email(String email) {
        email_input_box.sendKeys(email);
    }

    public void click_continue_button_in_login() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", continue_button_in_login);
    }

    public void select_continue_as_guest_check_box() {
        pageUtils.waitTillClickable(continue_as_guest_check_box);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", continue_as_guest_check_box);
    }

    public void click_continue_button_in_register() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", continue_button_in_register);
    }

    public void select_gender(String arg) {
        if (arg.equalsIgnoreCase("Male")) {
            male_radio_button.click();
        } else female_radio_button.click();
    }

    public String get_gender_error_message() {
        pageUtils.waitTillVisible(gender_error_text);
        return gender_error_text.getText();
    }

    public void enter_first_name(String firstName) {
        first_name_input_box.sendKeys(firstName);
    }

    public String get_first_name_error_message() {
        pageUtils.waitTillVisible(first_name_error_text);
        return first_name_error_text.getText();
    }

    public void enter_last_name(String lastName) {
        last_name_input_box.sendKeys(lastName);
    }

    public String get_last_name_error_message() {
        pageUtils.waitTillVisible(last_name_error_text);
        return last_name_error_text.getText();
    }

    public void enter_date_of_birth(String dob) {
        date_of_birth_input_box.sendKeys(dob);
    }

    public String get_date_of_birth_error_message() {
        pageUtils.waitTillVisible(date_of_birth_error_text);
        return date_of_birth_error_text.getText();
    }

    public void enter_mobile_number(String mob) {
        mobile_number_input_box.sendKeys(mob);
    }

    public String get_mobile_number_error_message() {
        pageUtils.waitTillVisible(mobile_number_error_text);
        return mobile_number_error_text.getText();
    }

    public void click_continue_button_in_form() {
        continue_button_in_form.click();
    }

    public Boolean verify_other_personal_information_title_is_displayed() {
        pageUtils.waitTillVisible(other_personal_information_title);
        return other_personal_information_title.isDisplayed();
    }

}
