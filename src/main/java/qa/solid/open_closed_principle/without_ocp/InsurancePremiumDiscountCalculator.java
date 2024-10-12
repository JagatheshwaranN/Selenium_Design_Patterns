package qa.solid.open_closed_principle.without_ocp;

@SuppressWarnings("All")
public class InsurancePremiumDiscountCalculator {

    public int calculatePremiumDiscountPercent(HealthInsuranceCustomerProfile customerProfile) {
        if (customerProfile.isLoyalCustomer()) {
            return 20;
        }
        return 0;
    }

    public int calculatePremiumDiscountPercent(VehicleInsuranceCustomerProfile customerProfile) {
        if (customerProfile.isLoyalCustomer()) {
            return 20;
        }
        return 0;
    }

    public int calculatePremiumDiscountPercent(HomeInsuranceCustomerProfile customerProfile) {
        if (customerProfile.isLoyalCustomer()) {
            return 20;
        }
        return 0;
    }
}
