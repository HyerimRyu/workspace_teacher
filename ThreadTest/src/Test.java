
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Thread�� ����� ����� 2������ ����.
		
		
		//1. ThreadŬ������ �����(extends) Ŭ������ �����Ͽ� ����ϴ� ���
		TThread t= new TThread();
		t.start();//�ڵ�����  run()�� �����.
		
		TThread t2= new TThread();
		t2.start();//�ڵ�����  run()�� �����.
		
		//2. Runnable�������̽��� ������(implements) Ŭ������ �����Ͽ� ����ϴ� ���
		RThread r= new RThread();
		Thread k= new Thread(r);
		k.start();//��� start()���ֱ�!!
		
		

	}

}

class RThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<20; i++) {
			System.out.println( Thread.currentThread().getName() );
			
			try {
				Thread.sleep(500);//500ms, 0.5��
			}catch(Exception e) {}			
		}
	}
	
}

class TThread extends Thread{
	@Override
	public void run() {
		for(int i=0; i<20; i++) {
			System.out.println( Thread.currentThread().getName() );
			
			try {
				Thread.sleep(500);//500ms, 0.5��
			}catch(Exception e) {}			
		}
	}	
}











