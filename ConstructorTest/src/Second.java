
public class Second {
	
	int a;
	int b;
	
	//������ �޼ҵ�
	public Second() {
		//�ٸ� ������ ȣ�� ������!!
		//Second(10, 20); <--�̰� ���������� �ȵ�.
		this(10, 20);
	}
	
	public Second(int a) {
		//System.out.println("aaa");//error		
		this(a, a);	//ù��° ���๮���θ� ������.
		System.out.println("aaa");//OK
	}
	
	public Second(int a, int b) {
		this.a= a;
		this.b= b;
	}
	
	
	//�Ϲ� �޼ҵ�
	void aaa() {
		bbb();//�ٸ� �޼ҵ� ȣ�� ����!!
	}
	
	void bbb() {
		
	}

}












