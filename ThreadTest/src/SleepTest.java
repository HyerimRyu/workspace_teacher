
public class SleepTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SThread t= new SThread();
		t.start();
		
		//5초후에 깨우기...
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {}
		
		t.interrupt();//sleep()메소드에 강제 예외발생!

	}

}

class SThread extends Thread{
	@Override
	public void run() {
		//10초 대기후 "Hello"글씨 출력
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			System.out.println("왜 자는데 깨워!!!");
//		}
		
//		while(true) {
//			System.out.println("kkk");	
//			
//			try {
//				Thread.sleep(1);
//			} catch (InterruptedException e) {
//				System.out.println("인터럽트 예외발생");
//				break;//while문 빠져나가기!!
//			}
//		}
		//하지만 위 방법은 어찌되었든 잠시동안(1ms) 멈추는 명령이므로..
		//프로그래밍 성능 영향을 줄 수 있음.
		
		//그래서 안쓰고 싶어해..
		while(true) {
			System.out.println("kkk");
			//혹시 인터럽트( .interrupt()메소드가 호출되었는지?)
			if( this.isInterrupted() ) {
				break;
			}
		}
		
//		System.out.println("Hello");
	}
}
























