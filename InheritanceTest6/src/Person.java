
public class Person {
	
	private String name;
	private int age;
	
	public Person() {
		name="no name";
		age= 0;
	}
	
	public Person(String name, int age) {
		this.name= name;
		this.age= age;
	}
	
	public void show() {
		System.out.println("name : "+ name);
		System.out.println("age : "+ age);
	}

}










