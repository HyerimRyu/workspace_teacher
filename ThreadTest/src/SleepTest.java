
public class SleepTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SThread t= new SThread();
		t.start();
		
		//5���Ŀ� �����...
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {}
		
		t.interrupt();//sleep()�޼ҵ忡 ���� ���ܹ߻�!

	}

}

class SThread extends Thread{
	@Override
	public void run() {
		//10�� ����� "Hello"�۾� ���
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			System.out.println("�� �ڴµ� ����!!!");
//		}
		
//		while(true) {
//			System.out.println("kkk");	
//			
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				System.out.println("���ͷ�Ʈ ���ܹ߻�");
//				break;//while�� ����������!!
//			}
//		}
		//������ �� ����� ����Ǿ��� ��õ���(1ms) ���ߴ� ����̹Ƿ�..
		//���α׷��� ���� ������ �� �� ����.
		
		//�׷��� �Ⱦ��� �;���..
		while(true) {
			System.out.println("kkk");
			//Ȥ�� ���ͷ�Ʈ( .interrupt()�޼ҵ尡 ȣ��Ǿ�����?)
			if( this.isInterrupted() ) {
				break;
			}
		}
		
//		System.out.println("Hello");
	}
}
























