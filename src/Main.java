import java.util.Random;

public class Main {

    private static Employee[] employeesArr = new Employee[10];

    public static void main(String[] args) {


        employeesArr[0] = new Employee("Доминов Кирилл Ринатович", 1, 40000);
        employeesArr[1] = new Employee("Иванов Иван Иванович", 1, 45000);
        employeesArr[2] = new Employee("Петров Петр Петрович", 2, 50000);
        employeesArr[3] = new Employee("Сергеев Сергей Сергеевич", 2, 55000);
        employeesArr[4] = new Employee("Елькин Дмитрий Владимирович", 3, 60000);
        employeesArr[5] = new Employee("Федоров Федор Федорович", 3, 70000);
        employeesArr[6] = new Employee("Механошин Евгений Владимирович", 4, 75000);
        employeesArr[7] = new Employee("Сокол Александр Александрович", 4, 80000);
        employeesArr[8] = new Employee("Баланчук Светлана Ринатовна", 5, 85000);
        employeesArr[9] = new Employee("Попова Александра Сергеевна", 5, 90000);
        indexingTheSalary(employeesArr, 10);
        Random random = new Random();
        int departamentNumber = 1 + random.nextInt(5);

        int compareSalary = 55000 + random.nextInt(30001);
        int minDepartmentSalary = findEmployeeDepartmentMinSalary(employeesArr, departamentNumber);
        int maxDepartmentSalary = findEmployeeDepartmentMaxSalary(employeesArr, departamentNumber);
        int totalDepartmentSalary = paidTotalSalaryDeparments(employeesArr, departamentNumber);

        float averageDepartmentSalary = calculateAverageSalaryDepartment(employeesArr, departamentNumber);
        indexingTheSalaryDepartment(employeesArr, departamentNumber, 2);
        printListEmployeeDepartment(employeesArr, departamentNumber);
        System.out.println();
        printSalaryLessNumber(employeesArr, compareSalary);
        System.out.println();
        printSalaryGreaterNumber(employeesArr, compareSalary);

    }

    private static void indexingTheSalary(Employee[] employeesArr, int percent) {
        for (Employee employee : employeesArr) {
            int salary = employee.getSalaryMonth();
            int newSalary = salary + (salary * percent / 100);
            employee.setSalaryMonth(newSalary);
        }

    }

    private static int findEmployeeDepartmentMinSalary(Employee[] employeesArr, int number) {
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : employeesArr) {
            if (employee.getDepartment() == number && minSalary > employee.getSalaryMonth()) {
                minSalary = employee.getSalaryMonth();
            }
        }
        return minSalary;
    }

    private static int findEmployeeDepartmentMaxSalary(Employee[] employeesArr, int number) {
        int maxSalary = Integer.MIN_VALUE;
        for (Employee employee : employeesArr) {
            if (employee.getDepartment() == number && maxSalary < employee.getSalaryMonth()) {
                maxSalary = employee.getSalaryMonth();
            }
        }
        return maxSalary;
    }

    private static int paidTotalSalaryDeparments(Employee[] employeesArr, int number) {
        int totalSalari = 0;
        for (Employee employee : employeesArr) {
            if (employee.getDepartment() == number) {
                totalSalari += employee.getSalaryMonth();
            }
        }
        return totalSalari;
    }

    private static float calculateAverageSalaryDepartment(Employee[] employeesArr, int number) {
        int sumSalary = 0;
        int count = 0;
        for (Employee employee : employeesArr) {
            if (employee.getDepartment() == number) {
                sumSalary += employee.getSalaryMonth();
                count++;
            }
        }
        return count > 0 ? (float) sumSalary / count : 0;
    }

    private static void indexingTheSalaryDepartment(Employee[] employeesArr, int number, int percent) {
        for (Employee employee : employeesArr) {
            if (employee.getDepartment() == number) {
                int salaryDepartment = employee.getSalaryMonth();
                int newSalaryDepartment = salaryDepartment + (salaryDepartment * percent / 100);
                employee.setSalaryMonth(newSalaryDepartment);
            }

        }

    }

    private static void printListEmployeeDepartment(Employee[] employeeArr, int number) {
        for (Employee employee : employeeArr) {
            if (employee.getDepartment() == number) {
                System.out.println(employee);
            }
        }
    }

    private static void printSalaryLessNumber(Employee[] employeesArr, int num) {
        System.out.printf("Сотрудники у которых зп меньше %d:\n", num);
        for (Employee employee : employeesArr) {
            if (employee.getSalaryMonth() < num) {
                System.out.println(employee);
            }
        }

    }

    private static void printSalaryGreaterNumber(Employee[] employeesArr, int num) {
        System.out.printf("Сотрудники у которых зп больше (или равно) %d:\n", num);
        for (Employee employee : employeesArr) {
            if (employee.getSalaryMonth() >= num) {
                System.out.println(employee);
            }
        }

    }


}