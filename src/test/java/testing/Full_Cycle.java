package testing;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;

import java.io.IOException;
import java.util.Random;

public class Full_Cycle extends DriverFactory {


    static WebDriver driver = null;
    static HomePage hp;

    @BeforeTest
    public void setup() throws IOException {
        driver = DriverFactory.getDriver();
        hp = new HomePage(driver);
    }


    @Test
    public static void Check_the_listed_Categories_has_Items() throws InterruptedException {
        login_steps("emadr", "1234");
        Thread.sleep(5000);
        Assert.assertEquals(hp.item_one_exist() ,true );
    }

    @Test (dependsOnMethods = {"Check_the_listed_Categories_has_Items"})
    public static void Add_random_item_to_the_cart() throws InterruptedException {
        Random randomizer = new Random();
        int random_item_id = randomizer.nextInt(9)+1;
        int random_item_id2 = randomizer.nextInt(9)+1;
        //add the first item
        add_item_to_cart(random_item_id);
        //add the second item
        hp.go_home();
        Thread.sleep(3000);
        add_item_to_cart(random_item_id2);
    }

    @Test (dependsOnMethods = {"Add_random_item_to_the_cart"})
    public static void Remove_item_from_cart() throws InterruptedException {
        hp.click_open_cart();
        Thread.sleep(3000);
        hp.remove_from_cart_1st_item();
        Thread.sleep(3000);
    }

    @Test (dependsOnMethods = {"Remove_item_from_cart"})
    public static void Complete_successful_checkout_with_random_item()
    {
        hp.place_order_click();
        fill_the_card_info();
        hp.purchase_click();
        Assert.assertEquals(hp.success_order_message_exist(),true);
    }

    @AfterTest
    public void terminate() {
        System.out.println("Testing Completed");
     //   driver.quit();
    }



    private static void login_steps(String un, String pwd) {
        driver.get("https://www.demoblaze.com/");
        hp.click_on_login_button();
        hp.fill_login_username(un);
        hp.fill_login_password(pwd);
        hp.click_on_login_popup_button();
    }

    private static void add_item_to_cart(int random_item_id) throws InterruptedException {
        hp.click_on_random_item(random_item_id);
        Thread.sleep(5000);
        Assert.assertEquals(driver.getCurrentUrl(),String.format("https://www.demoblaze.com/prod.html?idp_=%d",random_item_id));
        hp.click_on_add_to_cart();
        Thread.sleep(3000);
        Assert.assertEquals("Product added.", driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }

    private static void fill_the_card_info()
    {
        hp.fill_name("emad");
        hp.fill_country("Jordan");
        hp.fill_city("Amman");
        hp.fill_card("1234-5678-9012-3456");
        hp.fill_month("03");
        hp.fill_year("2024");
    }


}
