
public class SynchronizedTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//계좌객체 생성
		Account acc= new Account();
		
		//acc계좌에 100원을 넣고 싶은 고객1
		TestThread t1= new TestThread(acc);
		
		//acc계좌에 100원을 넣고 싶은 고객2
		TestThread t2= new TestThread(acc);
		
		//비슷한 시점에 둘다 100원 입금 명령 실행!
		t1.start();
		t2.start();
		
	}

}

//은행계좌 클래스
class Account{
	int money= 0;
	
	//입금기능 : 동기화처리 되어 있지 않음. 계좌정보가 뒤죽박죽이 될 수 있음.
	//동기화처리함.
	//방법1. 메소드에 통채로 동기화 처리하기
//	synchronized void add(int m) {
//		System.out.println(Thread.currentThread().getName()+" : "+ "현재잔액:"+ money);
//		money += m;
//		System.out.println(Thread.currentThread().getName()+" : "+ "입금 후 잔액:"+ money);
//		System.out.println();
//	}
	
	//방법2. 동기화블럭 이용하는 방법
	void add(int m) {
		
		synchronized (this) {
			System.out.println(Thread.currentThread().getName()+" : "+ "현재잔액:"+ money);
			money += m;
			System.out.println(Thread.currentThread().getName()+" : "+ "입금 후 잔액:"+ money);
			System.out.println();
		}		
		
	}
	
}


class AA{
	
}


//은행계좌에 입금하는 기능을 가진 Thread클래스정의
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

















