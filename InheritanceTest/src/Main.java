
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Robot robot= new Robot();
		robot.attack();
		robot.move();
		
		//����ٴϴ� �κ��� ������ ������....
		//��, �κ��� �κ��ε� ���� ����� �߰��� �κ�...
		//���� RobotŬ������ ���� ����� �߰��ϸ� ���� �κ��� �����.
		//�׷��Ƿ� ���ο� Ŭ������ ���� ���� ��� �߰�!!
		FlyRobot fr= new FlyRobot();
		fr.attack();
		fr.move();
		fr.fly();
		
		//�̹����� �����ϴ� �κ���..�ʿ��ϴٸ�..?
		//�� ���� �۾��� �ϴ� Ŭ������ ����� �߰��� swimming()����� �߰�!!
		//�̷��� �ڹ��� '���'�̶�� ������ ����ϸ� �ս��� ���ο� Ŭ���� ���谡��!
		SwimmingRobot sr= new SwimmingRobot();
		sr.attack();
		sr.move();
		sr.name="aa";
		sr.HP=100;
		sr.swimming();

	}

}








