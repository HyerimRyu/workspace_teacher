
public class Test {
	
	int a;
	Person p;
	
	//������ �޼ҵ�
	public Test() {
		a=0;
		p= new Person(); //"�͸�", 0
	}
	
	public Test(int a, Person p) {
		this.a= a;
		this.p= p;
	}
	
	public Test(int a, String name, int age) {
		this.a= a;
		this.p= new Person(name, age);
	}
	
	
	//��±��
	void show() {
		System.out.println("a : "+ a);
		//System.out.println("p : "+ p);//�̰� ����??
		//System.out.println("name : "+ p.name);
		//System.out.println("age : "+ p.age);
		
		//��� ��ü�� ��������� ���� ������� �ʿ� ����!!
		//�� �����ü�� ��±���� �����״�....
		p.show();
	}
	
	//�Է±��
	void setMembers(int a, Person p) {
		this.a= a;
		this.p= p;		
	}
	
	//�Է±�� : Overloading
	void setMembers(int a, String name, int age) {
		this.a= a;
		//this.p.name= name;
		//this.p.age= age;
		
		//������� p�� ���� �����ϰ� �ִ� ��ü�� �����Ƿ�..
		//����������� �����ϴ� ���� �ڵ�� ����!!
		
		//���� Person��ü�� �����ϰ�..
		this.p= new Person();		
		//�� ����
		//this.p.name= name;
		//this.p.age= age;
		this.p.setMembers(name, age);
	}

}







