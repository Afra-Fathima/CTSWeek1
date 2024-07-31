// Employee Class
class Employee {
    private String employeeId;
    private String name;
    private String position;
    private double salary;

    public Employee(String employeeId, String name, String position, double salary) {
        this.employeeId = employeeId;
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary;
    }
}

// Employee Management System
class EmployeeManagementSystem {
    private Employee[] employees;
    private int size;

    public EmployeeManagementSystem(int capacity) {
        employees = new Employee[capacity];
        size = 0;
    }

    public void addEmployee(Employee employee) {
        if (size < employees.length) {
            employees[size++] = employee;
        } else {
            System.out.println("Employee array is full. Cannot add more employees.");
        }
    }

    public Employee searchEmployeeById(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    public void traverseEmployees() {
        for (int i = 0; i < size; i++) {
            System.out.println(employees[i]);
        }
    }

    public void deleteEmployeeById(String employeeId) {
        for (int i = 0; i < size; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                employees[i] = employees[size - 1];
                employees[size - 1] = null;
                size--;
                return;
            }
        }
        System.out.println("Employee with ID " + employeeId + " not found.");
    }
}

// Main Class
public class EmployeeManagementSystemDemo {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem(10);

        ems.addEmployee(new Employee("E001", "Alice", "Developer", 60000));
        ems.addEmployee(new Employee("E002", "Bob", "Manager", 80000));
        ems.addEmployee(new Employee("E003", "Charlie", "Analyst", 50000));

        System.out.println("All Employees:");
        ems.traverseEmployees();

        System.out.println("\nSearch Employee by ID (E002):");
        Employee employee = ems.searchEmployeeById("E002");
        if (employee != null) {
            System.out.println(employee);
        } else {
            System.out.println("Employee not found.");
        }

        System.out.println("\nDeleting Employee with ID (E002):");
        ems.deleteEmployeeById("E002");

        System.out.println("\nAll Employees after deletion:");
        ems.traverseEmployees();
    }
}
