import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//��ü���� �� ������ ����� �����ϴ� �޼ҵ带 ȣ���ؾ� ��.
		Person p= new Person(); //��������� �⺻�� �ʱ�ȭ
		p.setMembers("sam", 20);
		p.show();
		
		//2��° ��ü������ ����.
		Person p2= new Person();
		p2.setMembers("robin", 25);
		p2.show();
		//�̷� ��������� ¥��! ��? ������ ��ü������
		//�� ������ ���� �Ǵٽ� .setMembers()�޼ҵ带
		//ȣ���ؾ߸� ��!!
		
		//��ü�� �����ϸ鼭 �޼ҵ带 �̿��ؼ� ���� �����ϰ�����.
		//��ü�� �����Ҷ� �ڵ����� ȣ��Ǵ� �޼ҵ尡 �ִٸ� ������!!
		//Constructor(������ �޼ҵ� : ��ü������ �ڵ����� ȣ��Ǵ� �޼ҵ�)
		
		//������ �޼ҵ� ������ ����....
		First f= new First();	
		
		//�����ڸ޼ҵ�� ��ü�� ������ �� ���� ȣ���.
		First f2= new First();
		
		//������ �޼ҵ忡 �Ķ���� ����!!		
		First f3= new First(10);
		//������ �����ε�...
		
		
		//Person��ü�� ������ �޼ҵ� ����
		new Person();
		
		
		//�ٸ� ��Ű���� (default)�����ڸ޼ҵ� ȣ��
		//aaa.Test t= new aaa.Test(); //error
		Person p3= new Person();
		p3.show();
		
		//��ü�� �����ϸ鼭 ��������� ����(�ʱ�ȭ)
		Person p4= new Person("hong", 30);
		p4.show();
		
		Person p5= new Person("kim", 35);
		p5.show();
		
		Person p6= new Person("lee");
		
		
		//this() �ٸ� �����ڸ޼ҵ带 ȣ���ϴ� ���
		
		new Second();
		new Second(50);
		new Second(40, 100);
		
		
		
		///InitialTest.java ��ü ����
		new InitialTest();
		new InitialTest();
		new InitialTest();
		
		
		

	}

}








