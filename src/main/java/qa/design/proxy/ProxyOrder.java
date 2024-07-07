package qa.design.proxy;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ProxyOrder implements OrderComponent {

    private static final List<String> EXCLUDED = Arrays.asList("PROD", "STAGE");

    private OrderComponent orderComponent;

    public ProxyOrder(WebDriver driver){
        String currentEnv = System.getProperty("env");
        if(!EXCLUDED.contains(currentEnv)){
            this.orderComponent = new RealOrder(driver);
        }
    }

    @Override
    public String placeOrder() {
        if(Objects.nonNull(this.orderComponent)){
            return this.orderComponent.placeOrder();
        }else{
            return "SKIPPED Placing Order";
        }
    }

}
