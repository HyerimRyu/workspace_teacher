
public class Test {
	
	public int a;        //�������           -- �ν��Ͻ��� ��ü���� �����Ƿ� -->�ٸ����� : �ν��Ͻ� ����
	public static int b; //����(static) �������  -- Ŭ������ �Ѱ� �����Ƿ� -->�ٸ����� : Ŭ���� ����
	public static final int c= 50;
	
	//�����ڸ޼ҵ�
	public Test() {
		// TODO Auto-generated constructor stub
		a=10;
		b=50;
	}
	
	public Test(int a, int b) {
		// TODO Auto-generated constructor stub
		this.a= a;
		this.b= b;
	}
	
	
	
	//static������ �ǵ���.
	//static�޼ҵ嵵 ������.
	static void show() {
		//static �޼ҵ� �ȿ�����..........
		//System.out.println("������� a : "+ a);//�ν��Ͻ� ���� ���Ұ�!!
		System.out.println("������� b : "+ b);//static ���� ��밡��
	}
	
	//instance �޼ҵ�(�Ϲݸ޼ҵ�)
	void aaaa() {
		System.out.println("������� a : "+ a);
		System.out.println("������� b : "+ b);
	}
	

}










