
public class JoinTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JThread j= new JThread();
		j.start();//5�ʰ� �ҿ�Ǵ� �۾�����!!
		
		//j�� �۾��� ������ ���� �ٸ� �������� �۾� ��������..(block)
		try {
			j.join();//jThread�� run()�۾��� ���������� �ٸ� ��������� ��� �ý���
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		//synchronized�� �ٸ�..
		//synchronized�� ���� �ڿ�(��ü)�� �ǵ帱�� ��ŷ��.
		
		//join()�� ���� ��ü����̰� ���� ������� �׳� �� ��ŷ!!
		
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





