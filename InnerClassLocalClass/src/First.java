
public class First {
	
	int a=10;
	static int b=20;	
		
	//static �̳� Ŭ���� : �ƿ��Ͱ�ü�������� �ٸ� ���� ��ü���� ����
	//1. �̳�Ŭ���� �ƿ����� static ����� ������� �� �� ����.
	public static class Hello{
		
		void show() {
			System.out.println("Hello..show");
			//a= 20;//error; //�ƿ����� �ν��Ͻ������� ���Ұ�!
			b= 50;// static�� ����!
		}
		
	}

}
