
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Robot r= new Robot();
		r.attack();
		r.move();
		System.out.println();
		
		FlyRobot fr= new FlyRobot();
		fr.attack();//����(��ӹ���) ��ɻ��
		fr.move();  //����(��ӹ���) ��ɻ��
		fr.fly();
		System.out.println();
		
		
		SwimmingRobot sr= new SwimmingRobot();
		sr.attack();  //����(��ӹ���) ��ɻ��
		sr.move();    //����(��ӹ���) ��ɻ��
		sr.swimming();
		System.out.println();
		

	}

}









