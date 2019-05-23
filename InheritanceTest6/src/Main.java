
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//일반회원
		Person p= new Person("sam", 20);
		p.show();
		System.out.println();
		
		//학생
		Student stu= new Student("robin", 25, "android");
		stu.show();
		System.out.println();
		
		//교수
		Professor pro= new Professor("Park", 50, "Mobile Optimization");
		pro.show();
		System.out.println();
		
		//근로학생
		AlbaStudent alba= new AlbaStudent("hong", 25, "java", "PC Manager");
		alba.show();
		System.out.println();
		
		

	}

}






