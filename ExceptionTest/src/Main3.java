
public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�ڵ带 ���� ���ܸ� ������ �ߵ�!!
		try {
			
			System.out.println("aaa");
			//������ ���� �߻�!!- ������ catch������ �̵���Ű�� ����
			throw new Exception("Hi~~~"); 
			
			//System.out.println("bbb");//throw�ϸ� �� �ڵ尡 ����� �� �����Ƿ� ����.
			
		}catch(ArithmeticException e) {
			System.out.println("���ܹ߻�!!");
		}catch(NullPointerException e) {
			System.out.println("null ����");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//[Ȱ�� ��]
		//�޼ҵ忡 ����� ��û���� �� ���� ������ ����� ������ �ʾ�����..
		//��, ���� ������ ������ ���ܻ�Ȳ�̴� ��� ���� ������ ��!
		//Java������ ��� ����� ������� �ؼ� ���ܶ�� �Ǵ��ϴ� �˰����� ����.
		int n;
		try {			
			n= aaa(10, 5);
			n= aaa(10, 15);
		}catch(Exception e) {
			System.out.println("������� �����Դϴ�.");
			System.out.println( e.getMessage() );
		}
		

	}
	
	static int aaa(int a, int b) throws Exception{
		
		//������ ������ ��Ȳ�϶�, ������ ���� �߻�!!
		if(a<b) {
			throw new MyException("aaa");//���� ���� ����Ŭ���� ��ü
		}
		
		//����, throw�� �Ǹ� �Ʒ� �ִ� ���� �۾��� �������� ����.
		return a-b;		
	}
	
	

}//


class MyException extends Exception{
	
	public MyException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
	
}




















