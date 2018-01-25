package serialclone;

/**
	@version 24 Jan 2018
	@author ray.sun
*/

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class SerialCloneTest {
	public static void main(String[] args) throws CloneNotSupportedException {
		Employee harry = new Employee("Harry Hacker", 35000, 1989, 10, 1);
		//clone harry
		Employee harry2 = (Employee) harry.clone();
		
		//mutate harry
		harry.raiseSalary(10);
		
		//now harry and the clone are different
		System.out.println(harry);
		System.out.println(harry2);
	}
}

/**
	a class whose clone method uses serialization
 */
class SerialClone implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	@Override
	protected Object clone() throws CloneNotSupportedException {

		try {
			//save the object to a byte array
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			ObjectOutputStream out = new ObjectOutputStream(bout);
			out.writeObject(this);
			out.close();
			
			//read a clone of the object from the byte array
			ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
			ObjectInputStream in = new ObjectInputStream(bin);
			Object ret = in.readObject();
			in.close();
			
			return ret;
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

/**
 	The familiar Employee class, refined to extend the 
 	SerialClone class
 */
/**
 * @author ray.sun
 *
 */
class Employee extends SerialClone {
	private static final long serialVersionUID = 1L;
	private String name;
	private double salary;
	private Date hireDay;
	public String getName() {
		return name;
	}
	
	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
		this.hireDay = calendar.getTime();
	}

	public void raiseSalary(double byPercent){
		double raise = salary * byPercent/100;
		salary += raise;
	}

	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Date getHireDay() {
		return hireDay;
	}
	public void setHireDay(Date hireDay) {
		this.hireDay = hireDay;
	}

	@Override
	public String toString() {
		return getClass().getName() 
				+ "[name=" + name 
				+ ", salary=" + salary 
				+ ", hireDay=" + hireDay + "]";
	}
	
}
