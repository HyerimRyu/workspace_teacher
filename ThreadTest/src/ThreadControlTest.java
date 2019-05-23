
public class ThreadControlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CThread t= new CThread();
		t.start();
		
		//3���Ŀ� �Ͻ�����(pause) - wait()�޼ҵ� �̿�!
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		//t.wait();//�̷��� �ٷ� ȣ���ϴ� ���� �ٶ������� ����
		t.pauseThread();
		
		
		//3���Ŀ� �̾��ϱ�(resume)  - notify()�޼ҵ� �̿�!
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		//t.resumeThread();	
		
		
		//3���Ŀ� ���(Thread����)
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		//run()�� �����Ű�� ��� ����.
		//t.stop();//deprecate �� �޼ҵ�, ���������̹Ƿ� �۾��� �������� �ȵȻ��¿��� ���ڱ� ���⿩���� �־..
		//t.isRun= false;
		//��ü�� ������� �� ��ü�� �����ϵ��� �ϴ� ���� OOP�� �⺻ ��Ģ!!
		t.stopThread();
		
		
		System.out.println("main���� : ���!!");
	}

}

class CThread extends Thread{
	
	private boolean isRun= true;
	private boolean isWait= false;
	
	@Override
	public void run() {
		//Ÿ�̾� 4�� �����ϴ� �۾�..
		while(isRun) {
			System.out.println("1�� Ÿ�̾� ����");
			System.out.println("2�� Ÿ�̾� ����");
			System.out.println("3�� Ÿ�̾� ����");
			System.out.println("4�� Ÿ�̾� ����");
			System.out.println();
			
			if(isWait) {
				try {
					synchronized (this) {
						wait();
					}					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}			
			
						
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}//while��..
		
		System.out.println("���� ���!!!");
		
	}//run method...
	
	//isRun������ ���� �����ϴ� �޼ҵ�
	public void stopThread() {		
		isRun= false;
		synchronized (this) {
			this.notify();
		}
	}
	
	//isWait�� true�� �����ϴ� �޼ҵ�
	//�Ͻ������ϴ� �޼ҵ�
	public void pauseThread() {
		isWait= true;
	}
	
	//�̾��ϱ� �޼ҵ�
	public void resumeThread() {
		isWait= false;//�̰� �ٲ㳪�� �ٽ� wait���� ����.
		synchronized (this) {
			this.notify();
		}		
	}
	
}//CThread class..













