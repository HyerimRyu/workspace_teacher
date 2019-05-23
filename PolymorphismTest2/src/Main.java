
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//예, 앱에 캐틱터종류 3종류(Dog, Cat, Pig)
		
		Dog d= new Dog();
		Cat c= new Cat();
		Pig p= new Pig();
		
		d.say();
		c.say();
		p.say();
		System.out.println();
		
		//만약 이런 동물들객체들이 여러마리라면???
		//Dog가 5마리, Cat이 10마리, Pig 4마리..
		//이런식이면..
		//배열로 처리하면 반복문적용등..손쉽게 프로그래밍이
		//가능할텐데.. 3개의 클래스가 서로다른 자료형이므로
		//한번에 배열로 묶는게 불가능함.
		//Dog[] arr= new Dog[5];
		
		//이럴때 Dog,Cat,Pig가 Animal과 상속관계라면!!!
		//Animal클래스 설계
		
		Animal ani= new Dog(); //업 캐스팅 : 부모참조변수로 자식객체 참조하기
		Animal ani2= new Cat();
		Animal ani3= new Pig();
		
		ani.say();
		ani2.say();
		ani3.say();
		System.out.println();
		
		//위와 같은 것이 가능하다면.. 배열로..여러 Animal종류의 객체를 참조할 수 있음.
		Animal[] anis= new Animal[5];
		System.out.println( anis[0] );
		System.out.println( anis[1] );
		System.out.println( anis[2] );
		System.out.println( anis[3] );
		System.out.println( anis[4] );
		System.out.println();
		
		//anis[0].say();//null 에러!!
		
		anis[0]= new Dog();
		anis[1]= new Cat();
		anis[2]= new Cat();
		anis[3]= new Pig();
		anis[4]= new Dog();
		
		System.out.println( anis[0] );
		System.out.println( anis[1] );
		System.out.println( anis[2] );
		System.out.println( anis[3] );
		System.out.println( anis[4] );
		System.out.println();
		
		anis[0].say();
		anis[1].say();
		anis[2].say();
		anis[3].say();
		anis[4].say();
		System.out.println();
		
		//위의 처리를 반복문으로 작성가능..
		for(int i=0; i<5; i++) {
			anis[i].say();
		}
		System.out.println();
		
		//foreach문 이용...
		for( Animal t : anis) {
			t.say();
		}
		
		
		
		
		
		
		

	}

}








