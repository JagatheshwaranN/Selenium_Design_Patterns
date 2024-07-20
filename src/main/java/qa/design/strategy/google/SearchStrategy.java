package qa.design.strategy.google;

import org.openqa.selenium.WebDriver;

public interface SearchStrategy {

    void setDriver(WebDriver driver);

    void search(String searchKeyword);
}
