
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���ÿ� ������ �ϴ� �۾� 2�� ����
		//��) �ٿ�ε� �ϸ鼭 ���ǵ�� or ä���ϱ� etc...
		
		//���� ��Ʈ��ũ�� ����� �ʾ����ϱ�..�׳�..������...�ִ� �ڵ�
		
		//20���� ������ �ٿ�ε��ϴ� �۾�..
//		for(int i=0; i<20; i++) {
//			System.out.println(i + "�� ���� �ٿ�ε���....");
//			
//			//������ ��� ���...
//			for(long k=0; k<1000000000L; k++) {				
//			}			
//		}
//		System.out.println("���ϴٿ�ε� �Ϸ�!!!");
		
		
		//20���� ������ ����ϴ� �۾�..������..
//		for(int i=0; i<20; i++) {
//			System.out.println(i+"�� ���� ���~~");
//			
//			//������ ��� ���...
//			for(long k=0; k<1000000000L; k++) {				
//			}
//		}
//		System.out.println("������� �Ϸ�!!!");
		
		
		//�� 2���� �۾��� ���ÿ� �Ǹ� �� ������ �۾�ó���� �ϰ���?
		//���?? ������ �� ä���ϸ� �����ϰ���..
		//���⼭ ���� �Ϲݰ�ü�� Thread�� ȥ����...
		//��ü�� ���� ����ٰ� �ؼ� ���ο� ������ ����� ���� �ƴ�!!
		//���� �ٸ� ��ü�� ����� ����Ŵ.
//		WorkerA workerA= new WorkerA();
//		workerA.work();
//		
//		WorkerB workerB= new WorkerB();
//		workerB.work();
		//�� �۾��� ��ü�� 2�����ϻ� �����δ� MainThread(����)�� ȥ�ڼ� �۾��� ����.
		//�׷��� ���� �۾� �ȵ�!!
		
		
		//�׷� ��¥ ����(MainThread)����.. ����(Thread)��ü�� ������ 
		//�����۾��� ������. how?? Thread�ɷ��ϻ�ޱ�-->ThreadŬ���� ���!!
		//��, �Ϲ� Ŭ������ �ƴ϶� Thread�� ����� Ŭ������ ��ü�� ���� ���!
		
		//�ٿ�ε� �۾� <-������ Thread��ü���� �۾� �ñ��..
		ThreadA a= new ThreadA(); //����ä��
		a.start();//�۾� ���� ��û(Thread��ü�� run()�޼ҵ尡 �ڵ����� ����)
		
		//������� �۾� <-������ Thread��ü���� �۾� �ñ��..
		ThreadB b= new ThreadB();
		b.start();
		
		//Thread�� �켱��(cpu�����ð�) ���� �ο� ����(0~10)(����~����)
		a.setPriority(1);//����
		b.setPriority(10);//����
		
		//Thread.sleep()�� �ϸ� �켱������ ���ǹ�����.
		//�ݺ�Ƚ���� �ʹ� ������ �켱������ �� �ǹ̰� ����.
		//��, �۾��� �ҿ�Ǵ� �ð��� ª���� �켱���� �ǹ� ����.
		//�ݺ�Ƚ���� �� ���.. 20-->2000
		//Main Thread�� �⺻ �켱����(5)�� �����Ǿ� ����.
		
		//MainThread�� Thread�̹Ƿ� �� a, b �۾���(Thread)�� ���ÿ� ������ �۾� ����.
		for(int k=100; k<120; k++) {
			//���� �� �ڵ带 ����Ű�� �����尡 ��������?
			Thread t=Thread.currentThread();
			String name= t.getName();
			System.out.println(name + " : " + k );
			
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		System.out.println("Main Thread����!!!");		

	}

}

//���� �ٿ�ε带 �ϴ� Ŭ����(Thread�� ��ӹ���)
class ThreadA extends Thread{
	//��� ThreadŬ������ �۾��� �� �޼ҵ� �ȿ��� �ۼ��ؾ߸� ��.
	//ThreadŬ������ �ִ� run()�޼ҵ带 �������̵��ؼ� ����ؾ���.
	@Override
	public void run() {
		for(int i=0; i<20; i++) {
			String name= Thread.currentThread().getName();
			System.out.println(name+" : " + i + "�� ���� �ٿ�ε���....");
					
			//������ ��� ���...(0.5�� : 500ms ���)
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}			
		}
		System.out.println("���ϴٿ�ε� �Ϸ�!!!");
	}
}


//������ ����ϴ� Ŭ����(Thread��ӹ���)
class ThreadB extends Thread{
	@Override
	public void run() {
		for(int i=0; i<20; i++) {
			String name= Thread.currentThread().getName();
			System.out.println(name+" : " + i + "�� ���� ���~~");
					
			//������ ��� ���...
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		System.out.println("������� �Ϸ�!!!");
	}	
}





//������ �ٿ�ε��ϴ� Ŭ����
class WorkerA{
	//20���� ������ �ٿ�ε��ϴ� �۾�..�޼ҵ�
	void work() {		
		for(int i=0; i<20; i++) {
			System.out.println(i + "�� ���� �ٿ�ε���....");
					
			//������ ��� ���...
			for(long k=0; k<1000000000L; k++) {				
			}			
		}
		System.out.println("���ϴٿ�ε� �Ϸ�!!!");		
	}
}


//������ ����ϴ� Ŭ����
class WorkerB{
	//20���� ������ ����ϴ� �۾�..�޼ҵ�
	void work() {		
		for(int i=0; i<20; i++) {
			System.out.println(i+"�� ���� ���~~");
					
			//������ ��� ���...
			for(long k=0; k<1000000000L; k++) {				
			}
		}
		System.out.println("������� �Ϸ�!!!");
	}
}

























