
public class Dog extends Animal{
	
	@Override
	void say() {
		System.out.println("멍멍!!");
	}
	
	//Dog만 가지고 있는 기능..
	void guardHouse() {
		System.out.println("겁나 잘지켜!!!");
	}

}
