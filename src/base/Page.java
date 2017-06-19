package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * Created by Home on 6/19/2017.
 */
public class Page {
    public WebDriver driver = null;
    public Properties CONFIG = null;

    public Page(){
        if(driver == null){
            CONFIG = new Properties();

            try{
                FileInputStream fs = new FileInputStream(System.getProperty("user.dir")+"C:\\Users\\Home\\IdeaProjects\\pomodel\\src\\config\\config.properties");
                CONFIG.load(fs);
            } catch (Exception e){
                return;
            }

            System.out.println(CONFIG.getProperty("browser"));
            if(CONFIG.getProperty("browser").equals("Mozilla")) {
                this.driver = new FirefoxDriver();
            } else if (CONFIG.getProperty("browser").equals("Chrome")){

                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver\\chromedriver.exe");
                this.driver = new ChromeDriver();
            }
        }
    }



}
