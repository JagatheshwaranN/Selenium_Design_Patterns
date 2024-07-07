package qa.design.proxy;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentModeFactory {

    private static final Supplier<PaymentMode> CC = CreditCard::new;
    private static final Supplier<PaymentMode> NB = NetBanking::new;

    private static final Map<String, Supplier<PaymentMode>> map = new HashMap<>();

    static {
        map.put("CC", CC);
        map.put("NB", NB);
    }

    public static PaymentMode getInstance(String payMode){
        return map.get(payMode).get();
    }

}
