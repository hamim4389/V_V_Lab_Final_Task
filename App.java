import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class App {
    WebDriver driver;

    public void launchBrowser() throws InterruptedException{
        System.setProperty("webdriver.gecko.driver",  "C:\\Users\\H A M I M\\Downloads\\Compressed\\chromedriver_win32\\chromedriver.exe");
           driver = new ChromeDriver();

          
        //1* Navigate to the following website https://www.saucedemo.com/
             driver.get("https://www.saucedemo.com/");

        //2* Login to the system as "standard_user".
          

            
            Thread.sleep(2000);
            
            String e =  driver.findElement(By.xpath("//div[@class='login_credentials']")).getText().toString();
            boolean isFound = e.indexOf("standard_user") !=-1? true: false;
            if(isFound){
                WebElement input_user_name = driver.findElement(By.id("user-name"));
                input_user_name.sendKeys("standard_user");
            }
            
            
            Thread.sleep(2000);
            e =  driver.findElement(By.xpath("//div[text()='secret_sauce']")).getText().toString();
            isFound = e.indexOf("secret_sauce") !=-1? true: false;
            if(isFound){
                WebElement input_pass = driver.findElement(By.id("password"));
                input_pass.sendKeys("secret_sauce");
            }
            
            Thread.sleep(2000);
             driver.findElement(By.id("login-button")).click();

        //3* Add the following product to the cart : Sauce Labs Backpack, Sauce Labs Fleece Jacket.
        Thread.sleep(2000);
        driver.findElement(By.name("add-to-cart-sauce-labs-backpack")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("add-to-cart-sauce-labs-fleece-jacket")).click();

       
      
        //4* Go to the "Your Cart" page by clicking on the cart icon on top right corner.
        Thread.sleep(2000);
        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(2000);

        //5* Checkout to the next page. (CHECKOUT: YOUR INFORMATION)
        driver.findElement(By.id("checkout")).click();
        Thread.sleep(2000);

          //6* Fill the form and then click to the Continue button. 
          driver.findElement(By.xpath("//div[@class='form_group']//input[@id='first-name']")).sendKeys("Hasibur");

          Thread.sleep(2000);
          driver.findElement(By.xpath("//div[@class='form_group']//input[@id='last-name']")).sendKeys("Rahman");
          Thread.sleep(2000);
          driver.findElement(By.xpath("//div[@class='form_group']//input[@id='postal-code']")).sendKeys("1032");
          Thread.sleep(2000);


          //7* Finish the order
          driver.findElement(By.id("continue")).click();
          Thread.sleep(2000);
          driver.findElement(By.id("finish")).click();
        
           
           
           
         
   
        
         
          }
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        App app = new App();
        app.launchBrowser();
    
    
    }
}
