package application;

import entities.Employee;

import java.util.*;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> employeeList = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Employee #" + i + ":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            employeeList.add(new Employee(id, name, salary));
        }

        System.out.print("Enter the employee id that will have salary increase: ");
        Integer id = sc.nextInt();
        Optional<Employee> emp = employeeList.stream().filter(x -> Objects.equals(x.getId(), id)).findFirst();

        if (emp.isPresent()) {
            System.out.print("Enter the percentage: ");
            Double percentage = sc.nextDouble();
            emp.get().increaseSalary(percentage);
        } else {
            System.out.println("This id does not exist!");
        }

        System.out.println();
        System.out.println("List of employees:");
        for (Employee obj : employeeList) {
            System.out.println(obj);
        }

        sc.close();
    }
}
