package test.mybatis;

public class User {
	
	private int id;
	private  String  name;
	private int age;
	
	public int getId() {
		return id;
	}
	
	public  String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
}
