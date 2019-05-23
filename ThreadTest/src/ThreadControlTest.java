
public class ThreadControlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CThread t= new CThread();
		t.start();
		
		//3초후에 일시정지(pause) - wait()메소드 이용!
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		//t.wait();//이렇게 바로 호출하는 것은 바람직하지 않음
		t.pauseThread();
		
		
		//3초후에 이어하기(resume)  - notify()메소드 이용!
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		//t.resumeThread();	
		
		
		//3초후에 퇴근(Thread종료)
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		//run()을 종료시키는 명령 있음.
		//t.stop();//deprecate 된 메소드, 강제종료이므로 작업의 마무리가 안된상태에서 갑자기 멈출여지가 있어서..
		//t.isRun= false;
		//객체의 멤버값은 그 객체가 직접하도록 하는 것이 OOP의 기본 원칙!!
		t.stopThread();
		
		
		System.out.println("main종료 : 퇴근!!");
	}

}

class CThread extends Thread{
	
	private boolean isRun= true;
	private boolean isWait= false;
	
	@Override
	public void run() {
		//타이어 4개 조립하는 작업..
		while(isRun) {
			System.out.println("1번 타이어 조립");
			System.out.println("2번 타이어 조립");
			System.out.println("3번 타이어 조립");
			System.out.println("4번 타이어 조립");
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
			
		}//while문..
		
		System.out.println("직원 퇴근!!!");
		
	}//run method...
	
	//isRun변수의 값을 변경하는 메소드
	public void stopThread() {		
		isRun= false;
		synchronized (this) {
			this.notify();
		}
	}
	
	//isWait을 true로 변경하는 메소드
	//일시정지하는 메소드
	public void pauseThread() {
		isWait= true;
	}
	
	//이어하기 메소드
	public void resumeThread() {
		isWait= false;//이걸 바꿔나야 다시 wait되지 않음.
		synchronized (this) {
			this.notify();
		}		
	}
	
}//CThread class..













