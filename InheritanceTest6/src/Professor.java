
public class Professor extends Person {
	
	private String subject="";
	
	public Professor() {
		// TODO Auto-generated constructor stub		
	}
	
	public Professor(String name, int age, String subject) {
		// TODO Auto-generated constructor stub		
		super(name, age);
		this.subject= subject;
	}
	
	public void show() {
		super.show();
		System.out.println("subject : "+ subject);
	}
	
	

}






