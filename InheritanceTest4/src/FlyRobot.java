
public class FlyRobot extends Robot{
	
	//�̹�, attack(), move()
	
	//�̹��ִ� attack()����� �������� �ʾ�!!
	//���� attack()�޼ҵ带 ���� �ٽ� �����
	//Overriding(�������̵�) : ����(��ӹ���) �޼ҵ�� �Ȱ��� �޼ҵ带 �ٽ� ����
	void attack() {
		System.out.println("�̻��� �߻�!!");		
	}
	
	//�������̵�
	void move() {
		System.out.println("��~~~~~~~~~");
	}
	
	
	//���ο� ���
	void fly() {
		System.out.println("��~����!!!");
	}

}
