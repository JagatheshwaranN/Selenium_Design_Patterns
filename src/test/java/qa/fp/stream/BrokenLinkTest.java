package qa.fp.stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qa.fp.supplier.DriverFactory;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

public class BrokenLinkTest {

    static class LinkUtil {

        public static int getResponseCode(String link) {
            URL url;
            HttpURLConnection httpURLConnection = null;
            int responseCode = 0;
            try {
                url = new URL(link);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                responseCode = httpURLConnection.getResponseCode();
            } catch (Exception ignored) {
            } finally {
                if (null != httpURLConnection)
                    httpURLConnection.disconnect();
            }
            return responseCode;
        }
    }

    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        this.driver = DriverFactory.getDriver("Chrome");
        this.driver.manage().window().maximize();
    }

    @Test
    public void brokenLinkTest() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(element -> element.getAttribute("src"))
                .forEach(src -> System.out.println(src + " :: " + LinkUtil.getResponseCode(src)));
    }

    @Test
    public void brokenLinkAnyMatchTest() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        boolean result = this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(element -> element.getAttribute("src"))
                .map(LinkUtil::getResponseCode)
                .anyMatch(resultCount -> resultCount!=200);
        Assert.assertFalse(result);
    }

    @Test
    public void brokenLinkCollectTest() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        List<String> list = this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(element -> element.getAttribute("src"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                        .toList();
        Assert.assertEquals(list.size(), 0, list.toString());
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
