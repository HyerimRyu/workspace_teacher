
public class YieldTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreadAA t1= new ThreadAA();
		ThreadBB t2= new ThreadBB();
		
		t1.start();
		t2.start();
		
		//5���Ŀ� B�� ����ǰ�..(A�� cpu����� �纸)
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.flag= false;
		
		//5���Ŀ� A�� ����ǰ�..(B�� cpu����� �纸)
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t2.flag= false;
		t1.flag= true;
		
		//5�ʵڿ� A,B�Ѵ� ����!!!????
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		t1.isRun= false;
		t2.isRun= false;		
		
		
	}

}

class ThreadAA extends Thread{
	
	boolean flag= true;
	boolean isRun= true;
	
	@Override
	public void run() {
		while(isRun) {
			if(flag) {
				System.out.println("AAThread running.....");
			}else {
				Thread.yield();//�ٸ� �����忡�� CPU������ �纸!!
			}			
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}		
	}
}

class ThreadBB extends Thread{
	
	boolean flag= true;
	boolean isRun= true;
	
	@Override
	public void run() {
		while(isRun) {
			if(flag) {
				System.out.println("BBThread running.....");
			}else {
				Thread.yield();//�ٸ� �����忡�� CPU������ �纸!!
			}			
			
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}		
	}
}






