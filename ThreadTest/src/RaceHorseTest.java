
public class RaceHorseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Horse h1= new Horse("õ����");
		Horse h2= new Horse("���丶");
		Horse h3= new Horse("ĳ��");
		
		System.out.println("���ֽ���!!");
		//���ֽ���!!!
		h1.start();
		h2.start();
		h3.start();
	}

}



class Horse extends Thread{
	
	String name;
	//������
	public Horse(String name) {
		this.name= name;
	}
	
	@Override
	public void run() {
		for(int i=0; i<2000000000; i++) {			
			for(int k=0; k<2; k++) {
				//�ð������ ��ü����
				String s= new String("aaa");
			}
			
		}
		
		System.out.println(name+ " ����!");		
	}	
}


















