//�������̽��� ���� ��� : Ŭ���� ���� ��� ������.
//�������̽��� ��ü �����Ұ�!!(Like. �߻�Ŭ����)
public interface Test {
	
	//interface�� Ư¡��
	//1. �������̽� �ȿ����� �ν��Ͻ�, static ����, �ν��Ͻ��޼ҵ带 ���� �� ����.
	//2. �������̽� �ȿ����� �߻�޼ҵ�, static�޼ҵ�, ����ʵ�� public static final�� ������.
	//3. �������̽� �ȿ��ִ� ����� ���� �ڵ� public��!!
	//4. �������̽��� ���(�޼ҵ�)������ �ϼ��� ���� �ƴϱ⿡ �׳� ����� ���� ���� �ݵ�� ����� �����ؾ߸� ��� ������.
	//5. �������̽��� ����Ϸ��� ���ο� Ŭ������ �����ϸ鼭 implements Ű����� �����ؾ� �� ��.
	//6. �������̽��� ������ ��Ӱ����̹Ƿ� UP Casting�� ������.
	//7. �������̽��� ���߱���(���߻��)�� ������. //AAA,BBB �������̽�, SampleŬ����
	//8. �������̽��� �ٸ� �������̽��� ��ӹ��� �� ����.!! //KKK, SSS�������̽�
	//9. �������̽� �ȿ� �̳�Ŭ����(Inner class)�� �����ϸ� �ڵ� public static�� ��.
	
	
	//������� ���Ұ�!
	//int a;
	//static int b;
	
	//final����ʵ� ��밡��
	public static final int a=10; 
	int b=20; //�ڵ� public static final�� �Ǿ���! : ������ʱ�ȭ�� �Ǿ� ��������!!
	
//	private static final int c=50;
//	protected static final int d=50;
	
	//�ν��Ͻ� �޼ҵ� ����!!
//	void show() {
//		//����
//	}
	
	
	//���������ڴ� ������ public: �Ƚᵵ �ڵ� public
	public abstract void aaa(); //�̸��� �ִ� �޼ҵ� : �߻� �޼ҵ�!!
	void ddd();//�ڵ� public abstract
	
//	protected abstract void ccc();
	
	//static�޼ҵ� : (JDK 1.8���� ���� ������) : �ڵ� public
	static void bbb() {
		System.out.println("bbb");
	}
	
	
	
	//�̳� Ŭ���� ���� : �ڵ� public static
	class Hello{
		void show() {
			System.out.println("Hello show...");
		}
	}
	
	

}//Test interface











