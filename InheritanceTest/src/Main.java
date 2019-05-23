
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Robot robot= new Robot();
		robot.attack();
		robot.move();
		
		//날라다니는 로봇도 있으면 좋겠음....
		//즉, 로봇은 로봇인데 나는 기능이 추가된 로봇...
		//기존 Robot클래스에 나는 기능을 추가하면 기존 로봇이 변경됨.
		//그러므로 새로운 클래스를 만들어서 나는 기능 추가!!
		FlyRobot fr= new FlyRobot();
		fr.attack();
		fr.move();
		fr.fly();
		
		//이번에는 수영하는 로봇도..필요하다면..?
		//또 같은 작업을 하는 클래스를 만들고 추가로 swimming()기능을 추가!!
		//이러때 자바의 '상속'이라는 개념을 사용하면 손쉽게 새로운 클래스 설계가능!
		SwimmingRobot sr= new SwimmingRobot();
		sr.attack();
		sr.move();
		sr.name="aa";
		sr.HP=100;
		sr.swimming();

	}

}








