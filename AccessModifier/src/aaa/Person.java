package aaa;

public class Person {
	
	//�̸�, ����, ����(���� ����)
	private String name;    //�̸�
	private int age;        //����
	private String nation;  //����
	
	//��� �޼ҵ� 
	public void setMembers(String name, int age, String nation) {
		//���޹��� ������ ��������� ����!!
		this.name= name;
		this.age= age;
		this.nation= nation;			
	}
	
	public void show() {
		System.out.println(name+" , " + age + " , " + nation);
	}

	//����� �ϳ��� �����ϴ� �޼ҵ� : Setter
		public void setName(String name) {
			this.name = name;
		}
		
		public void setAge(int age) {
			this.age= age;		
		}
		
		public void setNation(String nation) {
			this.nation = nation;
		}
		
		// ����� �ϳ��� ���Ͻ����ִ� �޼ҵ� : Getter
		public String getName() {
			return name;
		}
		
		public int getAge() {
			return age;
		}
		
		public String getNation() {
			return nation;
		}
	
	

}









