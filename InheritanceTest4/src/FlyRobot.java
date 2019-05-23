
public class FlyRobot extends Robot{
	
	//이미, attack(), move()
	
	//이미있는 attack()기능이 맘에들지 않아!!
	//기존 attack()메소드를 새로 다시 만들기
	//Overriding(오버라이딩) : 기존(상속받은) 메소드와 똑같은 메소드를 다시 정의
	void attack() {
		System.out.println("미사일 발사!!");		
	}
	
	//오버라이딩
	void move() {
		System.out.println("슝~~~~~~~~~");
	}
	
	
	//새로운 기능
	void fly() {
		System.out.println("오~난다!!!");
	}

}
