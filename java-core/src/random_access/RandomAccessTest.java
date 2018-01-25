package random_access;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.GregorianCalendar;

import pojo.Employee;
import util.DataIO;
import volume2.c01.Constant;

public class RandomAccessTest {

	public static void main(String[] args) throws IOException {

		Employee[] staff = new Employee[3];

		staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
		staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
		staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

		String destinationFilePath = Constant.BASE_DIR + "employee.dat";
		// save all records to the file employee.dat
		try (DataOutputStream out = new DataOutputStream(new FileOutputStream(destinationFilePath))) {
			for(Employee e : staff)
				writeData(out, e);
		}
		
		try(RandomAccessFile in = new RandomAccessFile(destinationFilePath, "r")){
			//retrieve all records into a new array
			//compute the array size
			int n = (int) (in.length()/Employee.RECORD_SIZE);
			Employee[] newStaff = new Employee[n];
			
			//read employee in reserved order
			for(int i=n-1;i>=0; i--){
				newStaff[n-i-1] = new Employee();
				in.seek(i*Employee.RECORD_SIZE);
				newStaff[n-i-1] = readData(in);
			}
			
			//print the newly read employee records
			for(Employee e : newStaff)
				System.out.println(e);
		}

	}
	
	private static Employee readData(DataInput in) throws IOException {
		String name = DataIO.readFixedString(Employee.NAME_SIZE, in);
		double salary = in.readDouble();
		int year = in.readInt();
		int month = in.readInt();
		int day = in.readInt();
		
		return new Employee(name, salary, year, month + 1, day);
	}

	/**
	 * Writes all employees in an array to a print writer
	 * @param out
	 * @param staff
	 * @throws IOException 
	 */
	private static void writeData(DataOutput out, Employee e) throws IOException {
		DataIO.writeFixedString(e.getName(), Employee.NAME_SIZE, out);
		out.writeDouble(e.getSalary());
		
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(e.getHireDay());
		out.writeInt(calendar.get(Calendar.YEAR));
		out.writeInt(calendar.get(Calendar.MONTH));
		out.writeInt(calendar.get(Calendar.DAY_OF_MONTH));
	}

}
