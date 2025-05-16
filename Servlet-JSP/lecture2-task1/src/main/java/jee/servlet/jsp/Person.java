package jee.servlet.jsp;

public class Person {


	private String fullNamel;
	private int age;
	
	public Person(String fullNamel, int age) {
		super();
		this.fullNamel = fullNamel;
		this.age = age;
	}
	
	public String getFullNamel() {
		return fullNamel;
	}
	public void setFullNamel(String fullNamel) {
		this.fullNamel = fullNamel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

}
