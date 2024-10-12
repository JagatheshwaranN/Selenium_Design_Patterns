package revise;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class HandleMouseTest {

    protected static WebDriver driver;

    public static void main(String[] args) {
        mouseActions();
    }

    private static void browserLaunch() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    private static void mouseActions() {
        browserLaunch();
        driver.get("https://www.selenium.dev/selenium/web/mouse_interaction.html");
        Actions actions = new Actions(driver);
        actions.click(driver.findElement(By.id("clickable"))).perform();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        actions.dragAndDrop(driver.findElement(By.id("draggable")),driver.findElement(By.id("droppable"))).perform();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        actions.moveToElement(driver.findElement(By.id("hover")));
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        actions.click(driver.findElement(By.id("click"))).perform();
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        driver.close();
    }
}
