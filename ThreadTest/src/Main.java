
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//동시에 했으면 하는 작업 2개 구현
		//예) 다운로드 하면서 음악득기 or 채팅하기 etc...
		
		//아직 네트워크를 배우지 않았으니까..그냥..느낌만...주는 코드
		
		//20개의 파일을 다운로드하는 작업..
//		for(int i=0; i<20; i++) {
//			System.out.println(i + "번 파일 다운로드중....");
//			
//			//강제로 잠시 대기...
//			for(long k=0; k<1000000000L; k++) {				
//			}			
//		}
//		System.out.println("파일다운로드 완료!!!");
		
		
		//20개의 음악을 재생하는 작업..느낌만..
//		for(int i=0; i<20; i++) {
//			System.out.println(i+"번 음악 재생~~");
//			
//			//강제로 잠시 대기...
//			for(long k=0; k<1000000000L; k++) {				
//			}
//		}
//		System.out.println("음악재생 완료!!!");
		
		
		//위 2개의 작업이 동시에 되면 더 빠르게 작업처리를 하겠죠?
		//어떻게?? 직원을 더 채용하면 가능하겠죠..
		//여기서 보통 일반객체와 Thread를 혼동함...
		//객체를 따로 만든다고 해서 새로운 직원이 생기는 것은 아님!!
		//서로 다른 객체에 기능을 실행킴.
//		WorkerA workerA= new WorkerA();
//		workerA.work();
//		
//		WorkerB workerB= new WorkerB();
//		workerB.work();
		//위 작업은 객체가 2마리일뿐 실제로는 MainThread(사장)가 혼자서 작업한 것임.
		//그래서 동시 작업 안됨!!
		
		
		//그럼 진짜 사장(MainThread)말고.. 직원(Thread)객체를 만들어야 
		//동시작업이 가능함. how?? Thread능력하사받기-->Thread클래스 상속!!
		//즉, 일반 클래스가 아니라 Thread를 상속한 클래스를 객체로 만들어서 사용!
		
		//다운로드 작업 <-별도의 Thread객체에게 작업 맡기기..
		ThreadA a= new ThreadA(); //직업채용
		a.start();//작업 시작 요청(Thread객체의 run()메소드가 자동으로 실행)
		
		//음악재생 작업 <-별도의 Thread객체에게 작업 맡기기..
		ThreadB b= new ThreadB();
		b.start();
		
		//Thread의 우선권(cpu점유시간) 순위 부여 가능(0~10)(낮음~높음)
		a.setPriority(1);//낮음
		b.setPriority(10);//높음
		
		//Thread.sleep()을 하면 우선순위가 무의미해짐.
		//반복횟수가 너무 적으면 우선순위가 별 의미가 없음.
		//즉, 작업에 소요되는 시간이 짧으면 우선순위 의미 없음.
		//반복횟수를 좀 길게.. 20-->2000
		//Main Thread는 기본 우선순위(5)로 지점되어 있음.
		
		//MainThread도 Thread이므로 위 a, b 작업자(Thread)와 동시에 별개의 작업 가능.
		for(int k=100; k<120; k++) {
			//현재 이 코드를 실행키는 스레드가 누구인지?
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
		System.out.println("Main Thread종료!!!");		

	}

}

//파일 다운로드를 하는 클래스(Thread를 상속받은)
class ThreadA extends Thread{
	//모든 Thread클래스의 작업이 이 메소드 안에서 작성해야만 함.
	//Thread클래스에 있는 run()메소드를 오버라이드해서 사용해야함.
	@Override
	public void run() {
		for(int i=0; i<20; i++) {
			String name= Thread.currentThread().getName();
			System.out.println(name+" : " + i + "번 파일 다운로드중....");
					
			//강제로 잠시 대기...(0.5초 : 500ms 대기)
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}			
		}
		System.out.println("파일다운로드 완료!!!");
	}
}


//음악을 재생하는 클래스(Thread상속받은)
class ThreadB extends Thread{
	@Override
	public void run() {
		for(int i=0; i<20; i++) {
			String name= Thread.currentThread().getName();
			System.out.println(name+" : " + i + "번 음악 재생~~");
					
			//강제로 잠시 대기...
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		System.out.println("음악재생 완료!!!");
	}	
}





//파일을 다운로드하는 클래스
class WorkerA{
	//20개의 파일을 다운로드하는 작업..메소드
	void work() {		
		for(int i=0; i<20; i++) {
			System.out.println(i + "번 파일 다운로드중....");
					
			//강제로 잠시 대기...
			for(long k=0; k<1000000000L; k++) {				
			}			
		}
		System.out.println("파일다운로드 완료!!!");		
	}
}


//음악을 재생하는 클래스
class WorkerB{
	//20개의 음악을 재생하는 작업..메소드
	void work() {		
		for(int i=0; i<20; i++) {
			System.out.println(i+"번 음악 재생~~");
					
			//강제로 잠시 대기...
			for(long k=0; k<1000000000L; k++) {				
			}
		}
		System.out.println("음악재생 완료!!!");
	}
}

























