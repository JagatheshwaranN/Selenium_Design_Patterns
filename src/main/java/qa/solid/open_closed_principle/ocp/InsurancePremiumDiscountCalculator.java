package qa.solid.open_closed_principle.ocp;

@SuppressWarnings("All")
public class InsurancePremiumDiscountCalculator {

    public int calculatePremiumDiscountPercent(CustomerProfile customerProfile) {
        if (customerProfile.isLoyalCustomer()) {
            return 20;
        }
        return 0;
    }

}
