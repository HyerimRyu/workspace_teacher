
public class Second extends First{
	
	private int b;
	//int a=50;//������ override�� ������ ������ ������� ����.
	
	public Second(){
		super();
	}
	
	public void show() {		
		//First�� a�� ��� ����������...
		super.show();//FirstŬ������ show()ȣ��
		System.out.println("b : "+ b);
		
	}
	

}
