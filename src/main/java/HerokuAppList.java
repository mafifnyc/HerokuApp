import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.HashSet;
import java.util.Set;


public class HerokuAppList {
    public static void main(String[] args) throws InterruptedException {
        String os = "windows";
        WebDriver driver = null;
        driver = getChromeDriver(os, driver);
        String url = "https://the-internet.herokuapp.com/";
        driver.get(url);
        checkAndUncheckBoxes(driver);
        driver.get(url);
        contextMenu(driver);
        driver.get(url);
        dragAndDrop(driver);
        driver.get(url);
        dropDown(driver);
        driver.get(url);
        downloadFile(driver);
        driver.get(url);
        uploadFile(driver);
        driver.get(url);
        forgotPassword(driver);
        driver.get(url);
        frames(driver);
        driver.get(url);
        iFrames(driver);
        driver.get(url);
        slideHorizontally(driver);
        driver.get(url);
        scrollToInfinity(driver);
        cleanup(driver);
    }
    public static WebDriver getChromeDriver(String os, WebDriver driver) {
        String chromeDriverPath;
        if(os.equalsIgnoreCase("windows")) {
            chromeDriverPath = System.getProperty("user.dir") + "/drivers/windows/chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
        }
        else if(os.equalsIgnoreCase("mac")) {
            chromeDriverPath = System.getProperty(("user.dir") + "/drivers/mac/chromedriver");
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            driver = new ChromeDriver();
        }
        return driver;
    }
    public static void cleanup(WebDriver driver) throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
    public static void checkAndUncheckBoxes(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("Checkboxes")).click();
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]")).click();
        Thread.sleep(3000);
    }
    public static void contextMenu(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("Context Menu")).click();
        Actions actions = new Actions(driver);
        WebElement target = driver.findElement(By.id("hot-spot"));
        actions.contextClick(target).perform();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ESCAPE).build().perform();
        Thread.sleep(3000);
    }
    public static void dragAndDrop(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("Drag and Drop")).click();
        driver.manage().window().maximize();
        WebElement targetLocator = driver.findElement(By.xpath("//*[@id=\"column-a\"]"));
        WebElement targetDestination = driver.findElement(By.xpath("//*[@id=\"column-b\"]"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(targetLocator,targetDestination).build().perform();
        Thread.sleep(3000);
    }
    public static void dropDown(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("Dropdown")).click();
        WebElement element = driver.findElement(By.id("dropdown"));
        Select select = new Select(element);
        select.selectByVisibleText("Option 1");
        select.selectByValue("2");
        Thread.sleep(3000);
    }
    public static void downloadFile(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("File Download")).click();
        driver.findElement(By.linkText("lambda-file-processing.png")).click();
        Thread.sleep(3000);
    }
    public static void uploadFile(WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\QAAEB2201\\IdeaProjects\\HerokuApp\\data\\1438740029545.jpg");
        driver.findElement(By.id("file-submit")).click();
        Thread.sleep(3000);
    }
    public static void forgotPassword(WebDriver driver) {
        driver.findElement(By.linkText("Forgot Password")).click();
        driver.findElement(By.id("email")).sendKeys("johnsmith@gmail.com");
        driver.findElement(By.id("form_submit")).click();
    }
    public static void frames(WebDriver driver) {                                              //DID NOT UNDERSTAND THE ASSIGNMENT!!!!
        driver.findElement(By.linkText("Frames")).click();
        driver.findElement(By.linkText("Nested Frames")).click();
        System.out.println(driver.switchTo().frame(0).getWindowHandle());
    }
    public static void iFrames(WebDriver driver) {
        driver.findElement(By.linkText("Frames")).click();
        driver.findElement(By.linkText("iFrame")).click();
//        int countIFrames = driver.findElement(By.tagName("iframe")).size();                   // DOESN"T WORK
        WebElement iFrameElement = driver.findElement(By.tagName("iframe"));
        Dimension frameDimension = iFrameElement.getSize();
        System.out.println(frameDimension.getHeight());
        System.out.println(frameDimension.getWidth());
                                                                                                    //        Set<String> setOfWindow = driver.getWindowHandles();
                                                                                                    //        for(String s : setOfWindow) {
                                                                                                    //            System.out.println(s);
                                                                                                    //        }
                                                                                                    //        System.out.println(setOfWindow);
    }
    public static void slideHorizontally(WebDriver driver) {
        driver.findElement(By.linkText("Horizontal Slider")).click();
        WebElement slider = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/input"));
        Actions move = new Actions(driver);
        move.dragAndDropBy(slider, 50,0).build().perform();
    }
    public static void scrollToInfinity(WebDriver driver) {
        driver.findElement(By.linkText("Infinite Scroll")).click();
        JavascriptExecutor jsScroll = (JavascriptExecutor) driver;
        WebElement para = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div/div[2]"));

    }


}
