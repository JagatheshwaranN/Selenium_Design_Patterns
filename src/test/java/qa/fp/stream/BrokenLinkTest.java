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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@SuppressWarnings("ALL")
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

    @Test
    public void brokenLinkCollectGroupByTest() {
        this.driver.get("https://the-internet.herokuapp.com/broken_images");
        Map<Integer, List<String>> groupByLinks = this.driver.findElements(By.xpath("//*[@src]"))
                .stream()
                .map(element -> element.getAttribute("src"))
                .collect(Collectors.groupingBy(src -> LinkUtil.getResponseCode(src)));
        System.out.println(groupByLinks);
    }

    @Test
    public void brokenLinkParallelCollectTest() {
        this.driver.get("https://www.google.com/");
        System.out.println("Start Time :: " + LocalDateTime.now());
        List<String> list = this.driver.findElements(By.xpath("//*[@href]"))
                .stream()
                .parallel()
                .map(element -> element.getAttribute("href"))
                .filter(src -> LinkUtil.getResponseCode(src) != 200)
                .toList();
        System.out.println("End Time :: " + LocalDateTime.now());
    }

    @AfterTest
    public void tearDown() {
        this.driver.quit();
    }

}
