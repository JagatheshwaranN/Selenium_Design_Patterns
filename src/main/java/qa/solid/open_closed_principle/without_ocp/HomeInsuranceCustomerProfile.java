package qa.solid.open_closed_principle.without_ocp;

import java.util.Random;

public class HomeInsuranceCustomerProfile {

    public boolean isLoyalCustomer() {
        return new Random().nextBoolean();
    }
}
