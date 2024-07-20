package qa.fp.predicate;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class RuleEngine {

    private static final Predicate<WebElement> elementIsBlank = ele -> ele.getText().trim().isEmpty();
    private static final Predicate<WebElement> elementContainS = ele -> ele.getText().toLowerCase().contains("s");

    public static List<Predicate<WebElement>> get() {
        List<Predicate<WebElement>> rule = new ArrayList<>();
        rule.add(elementIsBlank);
        rule.add(elementContainS);
        return rule;
    }
}
