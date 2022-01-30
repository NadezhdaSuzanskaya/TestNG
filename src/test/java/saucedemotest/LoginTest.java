package saucedemotest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import web.pages.LoginPage;

public class LoginTest extends BaseTest {

    public static final String invalidCredential = "Epic sadface: Username and password do not match any user in this service";
    public static final String requiredUserName = "Epic sadface: Username is required";
    public static final String requiredUserPassword = "Epic sadface: Password is required";

    @BeforeMethod (groups = "smoke")
    public void openLoginPage() {
        Assert.assertNotNull(
                loginPage
                        .open()
                        .isPageLoaded()
                , "Login page is not loaded");
    }

    @DataProvider(name = "Input data for auth")
    public Object[][] inputForAuthTask() {
        return new Object[][]{
                {"user1", "qwerty1", invalidCredential, "The text message when credentials are wrong is not correct"},
                {"", "qwerty1", requiredUserName, "The text message when username is absent  is not correct"},
                {"user1", "", requiredUserPassword, "The text message when password is absent  is not correct"}
        };
    }

    @Test(dataProvider = "Input data for auth", groups = "smoke", priority = 2)
    public void LoginTest(String username, String password, String exp_message, String act_message) {
        Assert.assertEquals(
                loginPage
                        .returnLoginErrorMessage(username, password)
                , exp_message
                , act_message);
    }

    @Test(groups = "smoke")
    public void validCredentialsLoginTest() {
        Assert.assertNotNull(
                loginPage
                        .open()
                        .isPageLoaded()
                        .login(USERNAME, PASSWORD)
                        .open()
                        .isPageLoaded()
                , "Catalog page is not loaded");
    }

    @Test(priority = 3, enabled = false)
    public void USERNAME_PLACEHOLDER_TEST() {
        Assert.assertEquals(
                loginPage.
                        getUsernamePlaceholder()
                , LoginPage.USERNAME_TEXT_FIELD_PLACEHOLDER
                , "Username placeholder is not valid"
        );
    }

    @Test(priority = 4, enabled = false)
    public void PASSWORD_PLACEHOLDER_TEST() {
        Assert.assertEquals(
                loginPage.
                        getPasswordPlaceholder()
                , LoginPage.PASSWORD_TEXT_FIELD_PLACEHOLDER
                , "Password placeholder is not valid"
        );
    }

}
