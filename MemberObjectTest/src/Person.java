
public class Person {
	
	String name;
	int age;
	
	//��� �޼ҵ�
	public Person() {
		name= "�͸�";
		age= 0;
	}
	
	public Person(String name, int age) {
		this.name= name;
		this.age= age;		
	}
	
	
	//����� ��±��
	void show() {
		System.out.println("name : " + name);
		System.out.println("age : " + age);
	}
	
	//����� �Է±��
	void setMembers(String name, int age) {
		this.name= name;
		this.age= age;		
	}

}








