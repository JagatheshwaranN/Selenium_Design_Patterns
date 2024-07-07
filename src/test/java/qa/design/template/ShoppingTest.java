package qa.design.template;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import qa.design.test.BaseTest;

public class ShoppingTest extends BaseTest {

    @Test(dataProvider = "fetchData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate){
        shoppingTemplate.purchase();
    }

    @DataProvider
    public Object[]fetchData() {
        return new Object[]{
          new Amazon(driver, "iphone"),
          new Ebay(driver, "iphone")
        };
    }

}
