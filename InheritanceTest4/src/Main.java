
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Robot r= new Robot();
		r.attack();
		r.move();
		System.out.println();
		
		FlyRobot fr= new FlyRobot();
		fr.attack();//기존(상속받은) 기능사용
		fr.move();  //기존(상속받은) 기능사용
		fr.fly();
		System.out.println();
		
		
		SwimmingRobot sr= new SwimmingRobot();
		sr.attack();  //기존(상속받은) 기능사용
		sr.move();    //기존(상속받은) 기능사용
		sr.swimming();
		System.out.println();
		

	}

}









