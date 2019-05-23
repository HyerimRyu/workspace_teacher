
public class Student extends Person{
	
	private String major;
	
	public Student() {
		// TODO Auto-generated constructor stub		
		super();
		major="";
	}
	
	public Student(String name, int age, String major) {
		// TODO Auto-generated constructor stub
		super(name, age);
		this.major= major;
	}
	
	public void show() {
		super.show();
		System.out.println("major : "+ major);
	}

}













