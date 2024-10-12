package qa.solid.single_responsibility_principle.srp;

@SuppressWarnings("All")
public class Employee {

    /**
     * Reason for Change
     * =================
     * 1. Change in Employee Profile
     */

    private String empId;
    private String empName;
    private String empPhone;
    private String empAddress;
    private String empType;

    public void save() {
       new EmployeeRepo().save(this);
    }

    public void calculateTax() {
        new TaxCalculator().calculateTax(this);
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
