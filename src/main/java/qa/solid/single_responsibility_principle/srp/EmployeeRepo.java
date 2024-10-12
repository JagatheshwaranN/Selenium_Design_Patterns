package qa.solid.single_responsibility_principle.srp;

import java.util.ArrayList;

@SuppressWarnings("All")
public class EmployeeRepo {

    /**
     * Reason for Change
     * =================
     * 1. Change in Employee Database
     */
    public void save(Employee employee) {
        // Logic to save the Employee details to DB. For eg., MySQL
        // For demo, we can have a list and store the details.
        ArrayList<Employee> employeesDetails = new ArrayList<>();
        employeesDetails.add(employee);
    }

}
