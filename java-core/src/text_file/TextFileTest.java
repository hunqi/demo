package text_file;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

import pojo.Employee;
import volume2.c01.Constant;

public class TextFileTest {
	public static void main(String[] args) throws IOException {
		
		Employee[] staff =new Employee[3];
		
		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);
		
		
		String utf8 = "UTF-8";
		String destinationFilePath = Constant.BASE_DIR + "employee.dat";
		//save all records to the file employee.dat
		try(PrintWriter out = new PrintWriter(destinationFilePath, utf8)){
			writeData(out, staff);
		}
		
		//retrieve all records into an array
		try(Scanner in = new Scanner(new FileInputStream(destinationFilePath), utf8)){
			Employee[] newStaff = readData(in);
			//print the newly read employee records
			for(Employee e : newStaff)
				System.out.println(e);
		}
		
	}

	/**
	 * Reads an array of employees from a scanner
	 * @param in
	 * @return
	 */
	private static Employee[] readData(Scanner in) {
		
		//retrieve the array size
		int n = in.nextInt();
		in.nextLine(); //consume the new line
		
		Employee[] employees = new Employee[n];
		for(int i=0; i<n; i++)
			employees[i] = readEmployee(in);
		
		return employees;
	}

	private static Employee readEmployee(Scanner in) {
		String line = in.nextLine();
		String[] token = line.split("\\|");
		String name = token[0];
		double salary = Double.parseDouble(token[1]);
		int year = Integer.parseInt(token[2]);
		int month = Integer.parseInt(token[3]);
		int day = Integer.parseInt(token[4]);
		
		return new Employee(name, salary, year, month, day);
	}

	/**
	 * Writes all employees in an array to a print writer
	 * @param out
	 * @param staff
	 */
	private static void writeData(PrintWriter out, Employee[] staff) {
		//number of employees
		out.println(staff.length);
		
		for(Employee e : staff)
			writeEmployee(out, e);
	}

	/**
	 * Writes employee data to a print writer
	 * @param out
	 * @param e
	 */
	private static void writeEmployee(PrintWriter out, Employee e) {
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(e.getHireDay());
		
		out.println(String.format("%s|%s|%s|%s|%s", 
				e.getName(), 
				e.getSalary(),
				calendar.get(Calendar.YEAR),
				calendar.get(Calendar.MONTH) + 1,
				calendar.get(Calendar.DAY_OF_MONTH)));
		
	}
}
