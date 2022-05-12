package testcases;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CreditCardPage;


@Listeners(listeners.Listeners.class)
public class CreditCardTest extends BaseTest {

    public static CreditCardPage creditCardPage;

    @BeforeTest
    public static void setup() {
        creditCardPage = new CreditCardPage(driver);
        creditCardPage.click_cookie_accept_button();
        creditCardPage.click_first_product_continue_button();
        creditCardPage.enter_email("randomtest@gmail.com");
        creditCardPage.click_continue_button_in_login();
        creditCardPage.select_continue_as_guest_check_box();
        creditCardPage.click_continue_button_in_register();

    }

    @Test
    public static void errors_verification_test() {
        creditCardPage.click_continue_button_in_form();
        Assert.assertEquals(creditCardPage.get_gender_error_message(), "Bitte wählen Sie Ihre Anrede aus.",
                "Gender Error message is wrong");

        Assert.assertEquals(creditCardPage.get_first_name_error_message(), "Bitte geben Sie " +
                "Ihren Vornamen an.", "First Name Error message is wrong");

        Assert.assertEquals(creditCardPage.get_last_name_error_message(), "Bitte geben Sie Ihren Nachnamen an.",
                "Last Name Error message is wrong");

        Assert.assertEquals(creditCardPage.get_date_of_birth_error_message(), "Bitte geben Sie Ihr " +
                "Geburtsdatum an.", "DOB Error message is wrong");

        Assert.assertEquals(creditCardPage.get_mobile_number_error_message(), "Für eventuelle Rückfragen benötigen " +
                "wir Ihre deutsche Mobilnummer.", "Mobile Number Error message is wrong");

    }


    @Test
    public static void valid_values_verification_test() {
        creditCardPage.select_gender("Male");
        creditCardPage.enter_first_name("test");
        creditCardPage.enter_last_name("test");
        creditCardPage.enter_date_of_birth("29.01.1994");
        creditCardPage.enter_mobile_number("+49 171 1234567");
        creditCardPage.click_continue_button_in_form();
        Assert.assertTrue(creditCardPage.verify_other_personal_information_title_is_displayed(), "Other " +
                "Person information form is not loaded");

    }

}
