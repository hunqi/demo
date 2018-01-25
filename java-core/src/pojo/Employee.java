package pojo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Serializable {
	private static final long serialVersionUID = -6369500384819380692L;	
	public static final int RECORD_SIZE = 100;
	public static final int NAME_SIZE = 40;
	private static SimpleDateFormat dateFormater = new SimpleDateFormat("yyyyMMdd");
	
	private String name;
	private double salary;
	private Date hireDay;
	
	public Employee() {
	}

	public Employee(String name, double salary, int year, int month, int day) {
		this.name = name;
		this.salary = salary;
		this.hireDay = setDate(year, month, day);
	}
	
	private Date setDate(int year, int month, int day){
		GregorianCalendar c = new GregorianCalendar();
		c.set(year, month - 1, day);
		
		return c.getTime();
	}

	public String getName() {
		return name;
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
	
	public void raiseSalary(double byPercent){
		double raise = salary * byPercent / 100;
		salary += raise;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name 
				+ ", salary=" + salary 
				+ ", hireDay=" + dateFormater.format(hireDay) + "]";
	}

}
