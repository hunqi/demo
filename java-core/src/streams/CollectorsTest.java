package streams;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsTest {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.addAll(Arrays.asList(
                new Employee("Tom", 22, 6000, Department.HR),
                new Employee("Jerry", 23, 6000, Department.HR),
                new Employee("Jim", 25, 7000, Department.SECURITY),
                new Employee("Steve", 28, 8000, Department.SECURITY)));

        List<String> list = employees.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println("list:");
        list.forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println("set:");
        Set<String> set = employees.stream().map(Employee::getName).collect(Collectors.toCollection(TreeSet::new));
        set.forEach(n -> System.out.print(n + " "));
        System.out.println();

        // sum salaries
        int totalSalaries = employees.stream().collect(Collectors.summingInt(Employee::getSalary));
        System.out.println("totalSalaries=" + totalSalaries);

        // group employee by department
        Map<Department, List<Employee>> byDept =
                employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        byDept.entrySet().forEach(i -> {
            String names = i.getValue().stream().map(Employee::getName).collect(Collectors.joining(","));
            System.out.println(i.getKey() + ": " + names);
        });

        String str = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
        System.out.println("str=" + str);

        // partition by salary > 6000
        Map<Boolean, List<Employee>> partition =
                employees.stream().collect(Collectors.partitioningBy(e -> e.getSalary() > 6000));
        // print greater than 6000
        partition.entrySet().forEach(p -> {
            if (p.getKey()) {
                System.out.println("employees of salary > 6000: "
                        + p.getValue().stream().map(Employee::getName).collect(Collectors.joining(",")));
            }
        });
    }
}

class Employee {
    private String name;
    private int age;
    private int salary;
    private Department department;

    public Employee(String name, int age, int salary, Department department) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }
}

enum Department {
    HR, SECURITY;
}
