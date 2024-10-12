package qa.solid.open_closed_principle.ocp;

import java.util.Random;

@SuppressWarnings("All")
public class HomeInsuranceCustomerProfile implements CustomerProfile {

    @Override
    public boolean isLoyalCustomer() {
        return new Random().nextBoolean();
    }
}
