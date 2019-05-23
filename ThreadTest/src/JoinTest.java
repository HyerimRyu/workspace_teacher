
public class JoinTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JThread j= new JThread();
		j.start();//5초가 소요되는 작업시작!!
		
		//j의 작업이 끝날때 까지 다른 스레들은 작업 멈췄으면..(block)
		try {
			j.join();//jThread의 run()작업이 끝날때까지 다른 스레드들은 모두 올스톱
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		//synchronized와 다름..
		//synchronized는 같은 자원(객체)를 건드릴때 블럭킹됨.
		
		//join()은 같은 객체사용이고 뭐고 상관없이 그냥 다 블럭킹!!
		
		for(int i=0; i<10; i++) {
			System.out.println("main....");	
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
		
		

	}

}

class JThread extends Thread{
	@Override
	synchronized public void run() {
		for(int i=0; i<10; i++) {
			System.out.println("aaa");
			
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}	
}





