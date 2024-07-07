package qa.design.strategy;

import java.util.Map;

public interface PaymentMode {

    void enterPaymentDetail(Map<String, String> paymentDetail);

}
