
public class InitialTest {
	//1. �⺻�� �ʱ�ȭ - 0
	int a=10; //2.����� �ʱ�ȭ
	static int b;
	
	//3.0 static �ʱ�ȭ �� : ��ü�� ó�� ��������� 1�� ����(��ü �����������)
	static
	{
		//a=10;//�Ϲ� ��������� �ʱ�ȭ ����. error
		b= 40;//static ��������� �ʱ�ȭ �� �� ����.
		System.out.println("static �ʱ�ȭ ��!!");
	}
		
	//3.1 �ʱ�ȭ ��(Region) : �ν��Ͻ� �ʱ�ȭ�� :��ü ���������� ����
	{
		//������ �޼ҵ� ���� ����Ǵ� ����
		a= 20;
		a++;
		System.out.println( a );
		//�̷� ���๮���� ������ ����!!
		if(a<25) {
			a--;
		}
	}
	
	//4. ������ �޼ҵ�
	public InitialTest() {
		// TODO Auto-generated constructor stub
		a=50;
	}

}







