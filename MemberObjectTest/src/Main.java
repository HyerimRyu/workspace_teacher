
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test t= new Test();
		System.out.println( t.a );
		System.out.println( t.p );//�������� �⺻�� null
		System.out.println();
		
		//������� �� ����
		t.a= 10;
		t.p= new Person(); //��ü �����Ͽ� ���������� ����
		
		System.out.println( t.a );
		System.out.println( t.p );//������ ���
		//��������� �����ϴ� �� �ٸ���ü�� ������� �� ���
		System.out.println( t.p.name );
		System.out.println( t.p.age );
		System.out.println();
		
		//�ᱹ ��������� �����ϴ� ��ü�� ������� ������ �־�� ��.
		t.p.name= "sam";
		t.p.age= 20;
		System.out.println( t.a );
		System.out.println( t.p.name );
		System.out.println( t.p.age );
		System.out.println();
		
		//Person�� ����� ����� ���� ������ ���� �� ¥��!
		//PersonŬ������ ����� ��±��
		System.out.println( t.a );
		t.p.show(); //�ڱⰪ�� �ڱⰡ ���!!
		System.out.println();
		
		
		//�׷� TestŬ������ ��±���� �ִٸ�..������..
		t.show();
		System.out.println();
		
		//���ο� Test��ü�� ���� ����� �ʰ�..����� ��°���!!
		Test t2= new Test();
		t2.a= 100;
		t2.p= new Person();
		//t2.p.name= "robin";
		//t2.p.age= 25;
		//�̷������� ��ü�� ���Ե� �޼ҵ带 �̿��ϸ� ���ϰ���.
		String s= new String("robin");
		t2.p.setMembers( s, 25);		
		t2.show();
		
		//�� ��Ȳ�� ���� TestŬ������ �Է±���� ������..
		//�� ���ϰ� �� ���� �����ϰ���!!
		Test t3= new Test();
		//Person��ü�� �־�� ������� ����
		Person p= new Person();
		p.setMembers("hong", 30);
				
		t3.setMembers(10, p);
		t3.show();
		
		//���� ���� �ᱹ TestŬ���� ��ü�� ������� �� ��
		//a���� ���Ҿ� name, age���� ��� �������־����.
		Test t4= new Test();
		t4.setMembers(10, "kim", 35);
		t4.show();
		
		
		//������� ���ϱ�... ��ü������ ����� ������ ����
		//�Ź�.. setMembers()�޼ҵ带 ȣ���ϴ� �ڵ带 �����.
		//��ü������ �� ������� �̸� �������� �� ������ ������!!
		//��ü ������ �ڵ����� 1�� ȣ��Ǵ� �޼ҵ� : ������ �޼ҵ�(Constructor)
		Test t5= new Test(10, new String("lee"), 40);
		t5.show();		
			
		Test t6= new Test(20, new Person("park", 45));
		t6.show();
		
		Test t7= new Test();
		t7.show();
		
		
		

	}

}









