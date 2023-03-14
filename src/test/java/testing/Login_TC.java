package testing;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Login_TC extends DriverFactory {


    static WebDriver driver = null;
    static HomePage hp;

    @BeforeTest
    @BeforeSuite
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
        hp = new HomePage(driver);
    }


    @Test()
    public static void login_with_empty_fields() {
        login_steps("", "");
        Assert.assertEquals("Please fill out Username and Password.", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public static void login_without_password() {
        login_steps("emadr", "");
        Assert.assertEquals("Please fill out Username and Password.", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public static void login_with_incorrect_password() throws InterruptedException {
        login_steps("emadr", "9876");
        Thread.sleep(3000);
        Assert.assertEquals("Wrong password.", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public static void login_successfully() throws InterruptedException {
        login_steps("emadr", "1234");
        Thread.sleep(5000);
        Assert.assertEquals(hp.welcome_label_text(), "Welcome emadr");
    }

    @AfterTest
    public void terminate() {
        System.out.println("Testing Completed");
        driver.quit();
    }


    private static void login_steps(String un, String pwd) {
        driver.get("https://www.demoblaze.com/");
        hp.click_on_login_button();
        hp.fill_login_username(un);
        hp.fill_login_password(pwd);
        hp.click_on_login_popup_button();
    }


}
