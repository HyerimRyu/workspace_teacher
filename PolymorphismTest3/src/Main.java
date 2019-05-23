import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//애니멀종류(Dog, Cat, Pig) 객체들을 만들어내는 애니멀공장객체 생성
		AnimalFactory af= new AnimalFactory();
		
		Dog d= (Dog)af.makeAnimal(1);
		d.say();
		d.guardHouse();
		
		Cat c= (Cat)af.makeAnimal(2);
		c.say();
		c.handleDeacon();
		
		Pig p= (Pig)af.makeAnimal(3);
		p.say();
		p.eatAndEat();
		System.out.println();
		
		Animal ani;
		ani= af.makeAnimal(1); //Dog
		ani.say();
		ani.sleep();
		Dog dog= (Dog)ani; //다운캐스팅
		dog.guardHouse();
		
		ani= af.makeAnimal(2);
		ani.say();
		((Cat)ani).handleDeacon();
		
		ani= af.makeAnimal(3);
		ani.say();
		((Pig)ani).eatAndEat();
		
		//makeAnimal() : 전달값만 랜덤하면 랜덤한 객체 생성 가능
		
		
		//여러마리를 다룰려면 배열로!!
		System.out.println();
		
		Random rnd= new Random();
		
		Animal[] anis= new Animal[5];
		for(int i=0; i<5; i++) {
			int n= rnd.nextInt(3)+1;//1,2,3
			
			anis[i]= af.makeAnimal(n);
		}
		
		//각 객체들의 기능 호출
		for(int i=0; i<anis.length; i++) {
			anis[i].say();
			anis[i].sleep();
			
			//각 배열요소객체들(Dog or Cat or Pig)
			//의 고유기능들 실행!!
			//Animal 참조변수가 가리키는 객체가 
			//어떤 클래스인지 알려주는 '연산자'!
			if( anis[i] instanceof Dog ) {
				
				Dog d4= (Dog)anis[i];//다운캐스팅
				d4.guardHouse();	
				
			}else if( anis[i] instanceof Cat) {
				
				((Cat)anis[i]).handleDeacon();
				
			}else if( anis[i] instanceof Pig) {
				
				((Pig)anis[i]).eatAndEat();
			}
			
		}
		
		
		//실수로 Animal객체를 만들면???
		//Animal 존재이유는 상속해주기 위해서..객체생성목적X
		//실수로 Animal객체가 생성되는 것을 막기위해서..
		//Animal을 추상클래스(abstract class)로 선언하기!!!!
		
		//추상클래스는 객체생성(new)가 불가능!!error
		//Animal ani5= new Animal();
		//ani5.say(); // ???
		
		
		
		

	}

}






