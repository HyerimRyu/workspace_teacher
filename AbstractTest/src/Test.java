
//�߻� Ŭ���� : �׳� ����ϴ� ���� �ƴ϶� �ݵ�� ����ؼ� ����ؾ� ��!!
public abstract class Test {
	
	int a;//�ν��Ͻ� ����
	static int b=10; //static ����
	
	//�����ڸ޼ҵ�
	public Test() {
		System.out.println("Test ������!!");
	}
	
	//�ν��ͽ� �޼ҵ�
	void show() {
		System.out.println("show..");
	}
	
	//�߻� �޼ҵ�
	abstract void aaa();
	abstract void ccc();
	//abstract static void ddd(); //����: abstract�� static�� ���ÿ� ���Ұ�
	
	//static�޼ҵ�
	static void bbb() {
		System.out.println("static..."+ b);
	}

}







