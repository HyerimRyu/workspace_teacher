
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���������� final�� ���̸� ���ȭ�� ����!
		final int a= 10;
		//a= 20; //error : a�� ����Ұ�!
		
		//����������� final�����ϰ���.
		//TestŬ���� ����...
		
		final int b;
		b=50;//ó������ ������ �ִ°��� �ʱ�ȭ�� �������� ó����.
		//b=30; //error
		
		
		//�޼ҵ忡�� finalŰ���� ���� ����!
		//TestŬ������ show()�޼ҵ� ����� final����!
		Test t= new Test();
		t.show();
		
		
		//class�� final���� : ��� �Ұ�!!!
		//final Ŭ������ ����ϴ� ���� Ư���� ���� ����.
		//��, �� Ŭ������ ������� �� ����.
		//First��ӹ޴� SecondŬ������ ����� ����!!!
		First f= new First();
		f.show();
		
		
		

	}

}










