package pojo;

import java.io.Serializable;

public class Manager extends Employee implements Serializable {
	private static final long serialVersionUID = 4625546784243301393L;
	
	private Employee secretary;
	
	public Manager() {
		super();
	}

	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
	}

	public Employee getSecretary() {
		return secretary;
	}

	public void setSecretary(Employee secretary) {
		this.secretary = secretary;
	}
	
	
	
}
