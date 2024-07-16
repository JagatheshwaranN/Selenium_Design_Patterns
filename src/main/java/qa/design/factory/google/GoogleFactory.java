package qa.design.factory.google;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GoogleFactory {

    // private static final Function<WebDriver, GooglePage> EN = driver -> new GoogleEnglish(driver);
    private static final Function<WebDriver, GooglePage> EN = GoogleEnglish::new;
    private static final Function<WebDriver, GooglePage> FR = GoogleFrench::new;
    private static final Function<WebDriver, GooglePage> SA = GoogleArabic::new;
    private static final Function<WebDriver, GooglePage> ES = GoogleSpanish::new;
    private static final Map<String, Function<WebDriver, GooglePage>> map = new HashMap<>();

    static {
        map.put("EN", EN);
        map.put("FR", FR);
        map.put("SA", SA);
        map.put("ES", ES);
    }

    public static GooglePage getInstance(String language, WebDriver driver){
        return map.get(language).apply(driver);
    }

}
