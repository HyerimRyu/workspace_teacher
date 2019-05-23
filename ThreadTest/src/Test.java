
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Thread를 만드는 방법은 2가지가 있음.
		
		
		//1. Thread클래스를 상속한(extends) 클래스를 선언하여 사용하는 방법
		TThread t= new TThread();
		t.start();//자동으로  run()이 실행됨.
		
		TThread t2= new TThread();
		t2.start();//자동으로  run()이 실행됨.
		
		//2. Runnable인터페이스를 구현한(implements) 클래스를 선언하여 사용하는 방법
		RThread r= new RThread();
		Thread k= new Thread(r);
		k.start();//대신 start()해주기!!
		
		

	}

}

class RThread implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<20; i++) {
			System.out.println( Thread.currentThread().getName() );
			
			try {
				Thread.sleep(500);//500ms, 0.5초
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
				Thread.sleep(500);//500ms, 0.5초
			}catch(Exception e) {}			
		}
	}	
}











