import aaa.Person;

public class Main extends aaa.Second{

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
				
		//���� ��Ű���� Ŭ���� ��ü����
		First f= new First();
		//f.a=50; //private�� ���� �Ұ�!!
		
		//���� ��Ű�� �ȿ����� private�� ������ ��� ���������ڿ� ���ٰ���
		f.b= 10;
		f.c= 20;
		f.d= 30;
		
		f.aaa(); //���� ��Ű���� default�޼ҵ� ���� ����
		
		
		//�ٸ� ��Ű���� Ŭ���� ��ü ����
		aaa.Second s= new aaa.Second();
		//s.a=10; //private : error
		//s.b= 20;  //default : error
		//s.c= 30;  //protected : error
		
		//�ٸ� ��Ű�� Ŭ������ ��ü����� public�� ���� ����
		s.d= 40;
		//��, �ٸ� ��Ű�����ϴ��� ��ӹ����� protected���� ����
		
		//s.aaa(); //default - error
		s.bbb(); //public  - OK
		
		//aaa.Third t;
		
		
		//�⺻������ OOP������ ���������� �߿��� �����̾
		//�������(������:����)�� �ܺο� �������� �ʵ��� �ϴ°��� �̴�!!(������ class�� ����)
		//�������(Field)�� �⺻������ private���� ����!!
		//����޼ҵ�� �⺻������ public���� ����!!
		//��) �� ����� ���� ���� : ����� ���� : �̸�, ����, ����
		Person p= new Person();
		//p.name= "sam"; //�Ұ���!!
		//private������� ������ ���?? �޼ҵ带 �̿��ϴ� ��� ����!
		p.setMembers("sam", 20, "Ghana");		
		p.show(); 
		
		//����ϳ��� �� ����.. ���̺���, ��������
		//p.age= 21; //�Ұ�!!
		p.setAge(21);//���԰���
		
		//���̿� ���� ���ǽ�
		if( p.getAge() < 20 ) {
			System.out.println("�̼�����!!");
		}
		
		
		
		
		
	 }

}







