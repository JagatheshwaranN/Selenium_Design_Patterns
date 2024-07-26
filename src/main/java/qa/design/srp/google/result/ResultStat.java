package qa.design.srp.google.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import qa.design.srp.google.base.DisplayComponent;

public class ResultStat extends DisplayComponent {

    @FindBy(id="hdtb-tls")
    private WebElement tools;

    @FindBy(id="result-stats")
    private WebElement resultStat;

    public ResultStat(WebDriver driver) {
        super(driver);
    }

    public String getResultStatistics(){
        displayStat();
        return this.resultStat.getText();
    }

    private void displayStat(){
        this.tools.click();
    }

    @Override
    public boolean isDisplayed() {
        displayStat();
        return this.wdWait.until(driver -> this.resultStat.isDisplayed());
    }

}
