package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver = null;


    By signup_home = By.id("signin2");
    By signup_popup = By.xpath("//BUTTON[@type='button'][text()='Sign up']");
    By signusername = By.id("sign-username");
    By signpassword = By.id("sign-password");
    By login = By.id("login2");
    By login_popup = By.xpath("//BUTTON[@type='button'][text()='Log in']");
    By login_username = By.xpath("//INPUT[@id='loginusername']");
    By login_password = By.xpath("//INPUT[@id='loginpassword']");
    By item1 = By.xpath("(//IMG[@class='card-img-top img-fluid'])[1]");
    By item2 = By.xpath("(//IMG[@class='card-img-top img-fluid'])[2]");
    By item3 = By.xpath("(//IMG[@class='card-img-top img-fluid'])[3]");
    By item4 = By.xpath("(//IMG[@class='card-img-top img-fluid'])[4]");
    By item5 = By.xpath("(//IMG[@class='card-img-top img-fluid'])[5]");
    By item6 = By.xpath("(//IMG[@class='card-img-top img-fluid'])[6]");
    By item7 = By.xpath("(//IMG[@class='card-img-top img-fluid'])[7]");
    By item8 = By.xpath("(//IMG[@class='card-img-top img-fluid'])[8]");
    By item9 = By.xpath("(//IMG[@class='card-img-top img-fluid'])[9]");
    By add_to_cart_btn = By.xpath("//A[@href='#'][text()='Add to cart']");
    By open_cart = By.xpath("//A[@id='cartur']");
    By delete_from_cart_1st_item = By.xpath("(//A[@href='#'][text()='Delete'])[1]");
    By delete_from_cart_2nd_item = By.xpath("(//A[@href='#'][text()='Delete'])[2]");
    By open_home_page = By.xpath("(//A[@class='nav-link'])[1]");
    By welcome_label = By.xpath("//A[@id='nameofuser']");
    By Place_order = By.xpath("//BUTTON[@type='button'][text()='Place Order']");
    By name = By.xpath("//INPUT[@id='name']");
    By country = By.xpath("//INPUT[@id='country']");
    By month = By.xpath("//INPUT[@id='month']");
    By card = By.xpath("//INPUT[@id='card']");
    By city = By.xpath("//INPUT[@id='city']");

    By year = By.xpath("//INPUT[@id='year']");
    By Purchase = By.xpath("//BUTTON[@type='button'][text()='Purchase']");
    By success_order_message = By.xpath("//H2[text()='Thank you for your purchase!']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void click_on_sigup_button() {
        driver.findElement(signup_home).click();
    }
    public void click_on_sigup_popup_button() {
        driver.findElement(signup_popup).click();
    }
    public void fill_username(String un) {
        driver.findElement(signusername).sendKeys(un);
    }
    public void fill_password(String pwd) {
        driver.findElement(signpassword).sendKeys(pwd);
    }
    public void click_on_login_button() {
        driver.findElement(login).click();
    }
    public void click_on_login_popup_button() {
        driver.findElement(login_popup).click();
    }
    public void fill_login_username(String un) {
        driver.findElement(login_username).sendKeys(un);
    }
    public void fill_login_password(String pwd) {
        driver.findElement(login_password).sendKeys(pwd);
    }
    public String welcome_label_text() {
        return driver.findElement(welcome_label).getText();
    }
    public boolean item_one_exist() {
        return driver.findElement(item1).isDisplayed();
    }
    public void click_on_random_item(int random_id) {
        String locator = String.format("(//IMG[@class='card-img-top img-fluid'])[%d]", random_id);
        if (driver.findElement(By.xpath(locator)).isDisplayed()) {
            driver.findElement(By.xpath(locator)).click();
        } else {
            System.out.println("COULDNT FIND THE ELEMENT");
        }
    }
    public void click_on_add_to_cart() {
        driver.findElement(add_to_cart_btn).click();
    }
    public void click_open_cart() {
        driver.findElement(open_cart).click();
    }
    public void remove_from_cart_1st_item() {
        driver.findElement(delete_from_cart_1st_item).click();
    }
    public void remove_from_cart_2nd_item() {
        driver.findElement(delete_from_cart_2nd_item).click();
    }
    public void go_home() {
        driver.findElement(open_home_page).click();
    }
    public void place_order_click() {
        driver.findElement(Place_order).click();
    }
    public void fill_name(String text) {
        driver.findElement(name).sendKeys(text);
    }
    public void fill_country(String text) {
        driver.findElement(country).sendKeys(text);
    }
    public void fill_city(String text) {
        driver.findElement(city).sendKeys(text);
    }
    public void fill_card(String text) {
        driver.findElement(card).sendKeys(text);
    }
    public void fill_month(String text) {
        driver.findElement(month).sendKeys(text);
    }
    public void fill_year(String text) {
        driver.findElement(year).sendKeys(text);
    }
    public void purchase_click() {
        driver.findElement(Purchase).click();
    }
    public boolean success_order_message_exist() {
        return driver.findElement(success_order_message).isDisplayed();
    }
}
