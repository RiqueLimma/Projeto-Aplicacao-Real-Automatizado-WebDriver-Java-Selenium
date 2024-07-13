package core.propriedadeSetup;


import org.junit.AfterClass;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static WebDriver driver;


    private static DriverFactory driverChrome() {
        //Caminho ate a pasta da propriedade driver
        System.setProperty("webdriver.chrome.driver", "src/main/java/core/driver/chromedriver.exe");
    return new DriverFactory();
    }
    public static WebDriver getDriver(){
        if(driver == null) {
            driverChrome();
            switch (Propriedades.browser) {
                case CHROME: driver = new ChromeDriver(); break;
            }
            driver.manage().window().setSize(new Dimension(1200, 765));
        }
        return driver;
    }


    public static void killDriver(){
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
