
public class Second extends First{
	
	private int b; 
	
	//������ �޼ҵ� 
	public Second() {
		//super();�θ�Ŭ����(First) �����ڸ� ȣ���ߴ�!!!
		System.out.println("Second��ü ����!!");
	}	
	
	//������ �����ε�
	public Second(int a, int b) {
		super(a); //First(�θ�Ŭ����)������ ����� ȣ��
		//super() ������ ȣ���� �ݵ�� ù��° �������� �־����.!!		
		this.b= b;	
		System.out.println("Second��ü int, int ����!!");
	}
	
	
	public void showSecond() {
		System.out.println("b : "+ b);		
	}
	
	public void show() {
		showFirst();
		System.out.println("b : "+ b);		
		System.out.println();
	}

}
