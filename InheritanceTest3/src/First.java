
public class First {
	
	private int a;
	
	//��ü������ 1�� �ڵ����� ����Ǵ� �޼ҵ� : ������ �޼ҵ�
	public First() {		
		System.out.println("First��ü ����!!");		
	}
	
	//������ �޼ҵ� �����ε�
	public First(int a) {
		System.out.println("First��ü int ����!!");
		this.a= a;
	}
	
	
	
	public void showFirst() {
		System.out.println("a : "+ a);
	}

}
