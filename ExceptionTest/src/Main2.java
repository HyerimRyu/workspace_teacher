import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main2 {	

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		try {
			int x= divide(10, 0);
			System.out.println( x );
		}catch(ArithmeticException e) {
			System.out.println("��� ���ܰ�ü �޾� ó��....");
		}
		
		
		try {
			aaa();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			ccc();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//�� �Լ��� �ټ� ������. ��? ������ ������ �ִ� �ڵ�..?
	//�̸� �����ϱ����� ����ó��..try
//	static int divide(int a, int b) {
//		try {
//			return a/b;
//		}catch(ArithmeticException e) {
//			return ???; //�̷��� ����� ��ߵ��� �𸣴� ��Ȳ�� �߻��� �� ����.
//		}		
//	}
	
	//�� �޼ҵ���� �ڵ忡�� ���� �߻��� ������ �����Ƿ� 
	//���ܹ߻��ϴ� ���� try�� ��������� �� ������ �ټ�  �ָ��ϸ�..
	//���� ��ü�� �޼ҵ带 ȣ���� �ʿ� ���ѱ�� ���(throws)���
	static int divide(int a, int b) throws ArithmeticException{
		return a/b;
	}
	
	//throws ���� ����� ExceptionŬ������ ������ ���� �������� ���� ������.	
	//Ȥ�� throws�� �� Exception�� Checked Exception�� �����̶��...
	//�� �޼ҵ带 ȣ���� �ʿ��� �ݵ�� try-catch�� ����߸� ��. 	
	
	//throws ���޿� ���޵� ������..(��ġ ��ź ���ѱ��ó��)
	static void aaa() throws MalformedURLException{			
		bbb();				
		System.out.println("aaa");		
	}
	
	static void bbb() throws MalformedURLException{
		URL url= new URL("http://www.daum.net");
	}
	
	//����, throws�� �ֻ��� ExceptionŬ������ ����ϸ�
	//���� �߻��� Exception��ü�� Checked����, UnChecked���� ������ ����� ���
	//�� �޼ҵ带 ȣ���ϴ� �ʿ����� ������ try-catch�� �ؾ��� ��!!	
	static void ccc() throws Exception{
		
	}
	
	
	//�̷� ������ Ư�� ����Ŭ������ throws���� ����ϴ� ���
	void ddd() throws NullPointerException{
		
	}	
	//���� �� ���޼ҵ忡�� Null���ܰ� �ƴ� ������ �߻��ϸ� �ٿ��!!!
	
	//�������ܸ� ��� ���ѱ�� �ʹٸ�?? : ��Ƽ ����!!
	void eee() throws NullPointerException, ArithmeticException, NumberFormatException{
		
	}
	
	//�ѹ濡 ���� �� ���� ����
	void fff() throws Exception{		
		
	}
}







