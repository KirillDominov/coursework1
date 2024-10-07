import java.util.Objects;

public class Employee {
    private String fullName;
    private int department;
    private int salaryMonth;
    private static int nextId = 1;
    private int id;

    public Employee(String name, int department, int monthSalary) {
        this.fullName = name;
        this.department = department;
        this.salaryMonth = monthSalary;
        this.id = nextId++;
    }

    public String getName() {
        return fullName;
    }

    public int getSalaryMonth() {
        return salaryMonth;
    }

    public int getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalaryMonth(int salaryMonth) {
        this.salaryMonth = salaryMonth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && salaryMonth == employee.salaryMonth && id == employee.id && Objects.equals(fullName, employee.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, salaryMonth, id);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s,  salary: %d", id, fullName, salaryMonth);
    }
}