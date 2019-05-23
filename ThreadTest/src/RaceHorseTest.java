
public class RaceHorseTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Horse h1= new Horse("천리안");
		Horse h2= new Horse("적토마");
		Horse h3= new Horse("캐논");
		
		System.out.println("경주시작!!");
		//경주시작!!!
		h1.start();
		h2.start();
		h3.start();
	}

}



class Horse extends Thread{
	
	String name;
	//생성자
	public Horse(String name) {
		this.name= name;
	}
	
	@Override
	public void run() {
		for(int i=0; i<2000000000; i++) {			
			for(int k=0; k<2; k++) {
				//시간벌기용 객체생성
				String s= new String("aaa");
			}
			
		}
		
		System.out.println(name+ " 도착!");		
	}	
}


















