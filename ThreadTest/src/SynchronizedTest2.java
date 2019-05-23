
public class SynchronizedTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���°�ü ����
		Account acc= new Account();
		
		//acc���¿� 100���� �ְ� ���� ��1
		TestThread t1= new TestThread(acc);
		
		//acc���¿� 100���� �ְ� ���� ��2
		TestThread t2= new TestThread(acc);
		
		//����� ������ �Ѵ� 100�� �Ա� ��� ����!
		t1.start();
		t2.start();
		
	}

}

//������� Ŭ����
class Account{
	int money= 0;
	
	//�Աݱ�� : ����ȭó�� �Ǿ� ���� ����. ���������� ���׹����� �� �� ����.
	//����ȭó����.
	//���1. �޼ҵ忡 ��ä�� ����ȭ ó���ϱ�
//	synchronized void add(int m) {
//		System.out.println(Thread.currentThread().getName()+" : "+ "�����ܾ�:"+ money);
//		money += m;
//		System.out.println(Thread.currentThread().getName()+" : "+ "�Ա� �� �ܾ�:"+ money);
//		System.out.println();
//	}
	
	//���2. ����ȭ�� �̿��ϴ� ���
	void add(int m) {
		
		synchronized (this) {
			System.out.println(Thread.currentThread().getName()+" : "+ "�����ܾ�:"+ money);
			money += m;
			System.out.println(Thread.currentThread().getName()+" : "+ "�Ա� �� �ܾ�:"+ money);
			System.out.println();
		}		
		
	}
	
}


class AA{
	
}


//������¿� �Ա��ϴ� ����� ���� ThreadŬ��������
class TestThread extends Thread{
	Account acc;
	public TestThread(Account acc) {
		// TODO Auto-generated constructor stub
		this.acc= acc;
	}
	
	@Override
	public void run() {
		acc.add(100);
	}
	
}

















