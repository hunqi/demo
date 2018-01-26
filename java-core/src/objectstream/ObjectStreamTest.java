package objectstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pojo.Employee;
import pojo.Manager;
import volume2.c01.Constant;

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
		
		System.out.println("write out employees:");
		//save all employee records to the file employee.dat
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Constant.BASE_DIR + "employee.dat"))){
			out.writeObject(staff);		
		}
		
		System.out.println("read in employees:");
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(Constant.BASE_DIR + "employee.dat"))){
			
			//retrieve all records into a new arry
			Employee[] newStaff = (Employee[]) in.readObject();
			
			//raise secretary's salary
			newStaff[1].raiseSalary(10);
			
			for(Employee e : newStaff)
				System.out.println(e);
			
		}
		
		
	}
	
}
