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
import java.util.Random;

public class Registration_TC extends DriverFactory {


    static WebDriver driver = null;
    static HomePage hp;

    @BeforeTest
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
        hp = new HomePage(driver);
    }


    @Test()
    public static void register_with_empty_fields() {
        signup_stps("", "");
        Assert.assertEquals("Please fill out Username and Password.", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test
    public static void register_without_password() {
        signup_stps("User1", "");
        Assert.assertEquals("Please fill out Username and Password.", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }

    @Test
    public static void register_successfully() throws InterruptedException, IOException {
        Random randomizer = new Random();
        int rndm = randomizer.nextInt(1000)+1;
        signup_stps("emad_r_"+rndm, "1234");
        Thread.sleep(3000);
        Assert.assertEquals("Sign up successful.", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    @Test(dependsOnMethods = {"register_successfully"})
    public static void register_with_already_registered() throws InterruptedException {
        signup_stps("User1", "1234");
        Thread.sleep(3000);
        Assert.assertEquals("This user already exist.", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }


    @AfterTest
    public void terminate() {
        System.out.println("Testing Completed");
        driver.quit();
    }


    private static void signup_stps(String un, String pwd) {
        driver.get("https://www.demoblaze.com/");
        hp.click_on_sigup_button();
        hp.fill_username(un);
        hp.fill_password(pwd);
        hp.click_on_sigup_popup_button();
    }


}
