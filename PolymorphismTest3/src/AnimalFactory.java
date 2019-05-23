
public class AnimalFactory {
	
	//애니멀(Dog, Cat, Pig 객체)을 만들어내는 기능 메소드
	Animal makeAnimal(int n) {
		
		Animal ani=null;
		
		switch( n ) {
		case 1:
			ani= new Dog();
			break;
			
		case 2:
			ani= new Cat();
			break;
			
		case 3:
			ani= new Pig();
			break;
		}//switch
		
		return ani;		
		
	}//method...

}




