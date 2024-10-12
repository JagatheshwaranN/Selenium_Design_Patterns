package qa.solid.single_responsibility_principle.srp;


@SuppressWarnings("All")
public class TaxCalculator {

    /**
     * Reason for Change
     * =================
     * 1. Change in Tax Calculation
     */
    public void calculateTax(Employee employee) {
        if(employee.getEmpType().equals("fullTime")) {
            // Tax calculation for Full Time Employees
        }
        if(employee.getEmpType().equals("contract")) {
            // Tax calculation for Contract Employees
        }
    }

}
