
public class Second extends First{
	//�׳ɺ��� �ϳ��� ���� ��ó�� �������� ��ӹ��� FirstŬ������ 
	//����� �����ϰԵ�.
	
	//������� �߰�.
	int b;
	
	//����� �����ϴ� ���
	void setMembers(int a, int b) {
		//super.a= a; //�θ�ü�� ���� �θ�ü�� �˾Ƽ�!!!
		setA( a );//�θ�Ŭ������ �����ϴ� ���!!
		this.b= b;
	}
	
	
	//���� ��������� ����ϴ� ���!
	void showSecond() {
		System.out.println("b : "+ b);		
	}
	
	//��ӹ��� Ŭ������ ������� ����ϴ� ���!
	void show() {
		//System.out.println("a : "+ a);//��ü�������� �� ��ü�� ����!!
		showFirst();
		System.out.println("b : "+ b);
		System.out.println();
	}
	

}








