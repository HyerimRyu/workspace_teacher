
public class SynchronizedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MP3 mp3= new MP3();
		
		//������ Thread��ü ���� : MainThread�� ���ÿ� �۾�����!!
		MyThread t= new MyThread(mp3);
		t.start();//run()�޼ҵ� �ߵ�!-5�� �ҿ�Ǵ� �۾�
			
		mp3.play();// Main Thread�� ����.
		
		//�̷��� �Ǹ� ���ÿ� 1���� Mp3�� �ǵ帮�ԵǾ�
		//�� ����� ���׹����� ��.
		//�̸� �ذ��ϱ� ���� �ϳ��� �����尡 play()�ϰ� �ִٸ�...
		//�ٸ� �����尡 ���� play()�� �� ȣ���ص� ��� ����Ű�� ����� �ʿ�!!
		//���ÿ� ����Ǹ� �ȵǴ� �޼ҵ�( play()�޼ҵ�)�� ����ȭ(synchronized)ó���� ��.
		
		
		
		
		

	}

}

//�����÷��̾� Ŭ����
class MP3{
	int musicNum=0;
	
	//����ȭ ó��..
	//���1. �޼ҵ带 ��ä�� ����ȭ ó��..
//	synchronized void play() {		
//		System.out.println(Thread.currentThread().getName()+"�κ��� �÷��� ����� ���������ϴ�.");
//		
//		//5�ʴ�� musicNum�� �ش��ϴ� �������� ���..
//		musicNum++;
//		for(int i=0; i<5; i++) {
//			System.out.println(musicNum+"�� ���� �����~~"+ Thread.currentThread().getName());
//			
//			//1�� ���..
//			try {
//				Thread.sleep(1000);//1000ms : 1��
//			}catch(Exception e) {}			
//		}
//	}
	
	//���2. Ư�� �ڵ� ������ ����ȭ(synchronized) �� ó��
	void play() {		
		//�� �ڵ�� ����ȭ ó���� �Ǿ� ���� ����. �׷��Ƿ� ��ٸ��� ����.
		System.out.println(Thread.currentThread().getName()+"�κ��� �÷��� ����� ���������ϴ�.");
		
		//�� ������ ����ȭ ��ó��
		synchronized(this) {
			//5�ʴ�� musicNum�� �ش��ϴ� �������� ���..
			musicNum++;
			for(int i=0; i<5; i++) {
				System.out.println(musicNum+"�� ���� �����~~"+ Thread.currentThread().getName());
				
				//1�� ���..
				try {
					Thread.sleep(1000);//1000ms : 1��
				}catch(Exception e) {}			
			}
		}
		
		
	}
}


//Mp3�÷��̾ �����Ű�� ����� ���� ThreadŬ���� ����
class MyThread extends Thread{
	MP3 mp3;
	
	public MyThread(MP3 mp3) {
		// TODO Auto-generated constructor stub
		this.mp3= mp3;
	}
	
	@Override
	public void run() {
		if(mp3!=null) {
			mp3.play();
		}		
	}
}












