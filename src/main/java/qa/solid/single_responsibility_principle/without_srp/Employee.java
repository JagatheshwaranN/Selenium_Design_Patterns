package qa.solid.single_responsibility_principle.without_srp;

import java.util.ArrayList;

@SuppressWarnings("All")
public class Employee {

    /**
     * Reason for Change
     * =================
     * 1. Change in Employee Profile
     * 2. Change in Employee Database
     * 3. Change in Tax Calculation
     */

    private String empId;
    private String empName;
    private String empPhone;
    private String empAddress;
    private String empType;

    public void save() {
        // Logic to save the Employee details to DB. For eg., MySQL
        // For demo, we can have a list and store the details.
        ArrayList<Employee> employeesDetails = new ArrayList<>();
        employeesDetails.add(this);
    }

    public void calculateTax() {
        if (this.getEmpType().equals("fullTime")) {
            // Tax calculation for Full Time Employees
        }
        if (this.getEmpType().equals("contract")) {
            // Tax calculation for Contract Employees
        }
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public String getEmpType() {
        return empType;
    }

    public void setEmpType(String empType) {
        this.empType = empType;
    }
}
