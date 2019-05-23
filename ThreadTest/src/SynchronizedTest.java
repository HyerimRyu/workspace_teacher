
public class SynchronizedTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MP3 mp3= new MP3();
		
		//별도의 Thread객체 생성 : MainThread와 동시에 작업가능!!
		MyThread t= new MyThread(mp3);
		t.start();//run()메소드 발동!-5초 소요되는 작업
			
		mp3.play();// Main Thread가 실행.
		
		//이렇게 되면 동시에 1개의 Mp3를 건드리게되어
		//그 사용이 뒤죽박죽이 됨.
		//이를 해결하기 위해 하나의 스레드가 play()하고 있다면...
		//다른 스레드가 설사 play()를 또 호출해도 잠시 대기시키는 기법이 필요!!
		//동시에 실행되면 안되는 메소드( play()메소드)에 동기화(synchronized)처리를 함.
		
		
		
		
		

	}

}

//음악플레이어 클래스
class MP3{
	int musicNum=0;
	
	//동기화 처리..
	//방법1. 메소드를 통채로 동기화 처리..
//	synchronized void play() {		
//		System.out.println(Thread.currentThread().getName()+"로부터 플레이 명령이 내려졌습니다.");
//		
//		//5초당안 musicNum에 해당하는 음악파일 재생..
//		musicNum++;
//		for(int i=0; i<5; i++) {
//			System.out.println(musicNum+"번 음악 재생중~~"+ Thread.currentThread().getName());
//			
//			//1초 대기..
//			try {
//				Thread.sleep(1000);//1000ms : 1초
//			}catch(Exception e) {}			
//		}
//	}
	
	//방법2. 특정 코드 영역만 동기화(synchronized) 블럭 처리
	void play() {		
		//이 코드는 동기화 처리가 되어 있지 않음. 그러므로 기다리지 않음.
		System.out.println(Thread.currentThread().getName()+"로부터 플레이 명령이 내려졌습니다.");
		
		//이 영역만 동기화 블럭처리
		synchronized(this) {
			//5초당안 musicNum에 해당하는 음악파일 재생..
			musicNum++;
			for(int i=0; i<5; i++) {
				System.out.println(musicNum+"번 음악 재생중~~"+ Thread.currentThread().getName());
				
				//1초 대기..
				try {
					Thread.sleep(1000);//1000ms : 1초
				}catch(Exception e) {}			
			}
		}
		
		
	}
}


//Mp3플레이어를 실행시키는 기능을 가진 Thread클래스 선언
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












