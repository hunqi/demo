package v2.chapter02.objectStream;

import java.io.*;

public class ObjectStreamTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        carl.setSecretary(harry);
        Manager tony = new Manager("Tony Tester", 40000, 1990, 3, 15);
        tony.setSecretary(harry);

        Employee[] staff = new Employee[3];

        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;

        // save all employee records to the file employee.dat
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
            out.writeObject(staff);
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"))) {
            Employee[] newStaff = (Employee[]) in.readObject();

            newStaff[0].raiseSalary(10);

            for(Employee e : newStaff)
                System.out.println(e);

        }

    }

}
