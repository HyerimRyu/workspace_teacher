
public class Test {
	
	int a;
	Person p;
	
	//생성자 메소드
	public Test() {
		a=0;
		p= new Person(); //"익명", 0
	}
	
	public Test(int a, Person p) {
		this.a= a;
		this.p= p;
	}
	
	public Test(int a, String name, int age) {
		this.a= a;
		this.p= new Person(name, age);
	}
	
	
	//출력기능
	void show() {
		System.out.println("a : "+ a);
		//System.out.println("p : "+ p);//이거 문제??
		//System.out.println("name : "+ p.name);
		//System.out.println("age : "+ p.age);
		
		//멤버 객체의 멤버값까지 직접 출력해줄 필요 없음!!
		//그 멤버객체가 출력기능이 있을테니....
		p.show();
	}
	
	//입력기능
	void setMembers(int a, Person p) {
		this.a= a;
		this.p= p;		
	}
	
	//입력기능 : Overloading
	void setMembers(int a, String name, int age) {
		this.a= a;
		//this.p.name= name;
		//this.p.age= age;
		
		//멤버변수 p는 현재 참조하고 있는 객체가 없으므로..
		//멤버변수값을 대입하는 위의 코드는 에러!!
		
		//먼저 Person객체를 생성하고..
		this.p= new Person();		
		//값 대입
		//this.p.name= name;
		//this.p.age= age;
		this.p.setMembers(name, age);
	}

}







