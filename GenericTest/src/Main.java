import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//데이터를 하나 멤버변수로 저장하여 가지고 있는 Box객체.
		Box box= new Box();
		
		box.setA(10);
		System.out.println( box.getA() );
		
		box.setA(3.14);
		System.out.println( box.getA() );
		
		box.setA("Hello");
		System.out.println( box.getA() );
		
		//만능박스를 만든 것 처럼.보임..일부 인정할 만함.
		//값을 가져올때 좀 짜증남!!(다운캐스팅이라서 명시적으로 형변환을 해야만 함)
		box.setA(10);
		int n= (int)box.getA(); // (Object->integer->int)
		
		box.setA(3.14);
		double d= (double)box.getA();
		
		//클래스 한개를 설계해서 여러자료형을 모두다 가질 수 있는 객체로형으로 만들기
		Box2<String> box2= new Box2<String>();
		box2.a="aaa";
		
		int[] arr= new int[5];
		Random[] arr2= new Random[5];
		Box2<String>[] arr3= new Box2[5];
		
		
		Box2<Random> box3= new Box2<Random>();
		box3.a= new Random();
		
		//<>안에 쓰는 자료형은 오직 참조형만 가능, 즉, 기본형자료형은 사용불가!!
		//Box2<int> box4= new Box2<int>();
		
		//이럴 때 기본형을 참조형으로 만든 Wrapper클래스들을 이용
		Box2<Integer> box4= new Box2<Integer>();
		box4.a= 10;//오토박싱 : 기본형처럼 사용해도 됨!!		
		int k= box4.getA();//언오토박싱
		

		Box3<String, Integer> box5= new Box3<String, Integer>();
		box5.a="Hello";
		box5.b= 10;
		
		Box3<Integer, Random> box6= new Box3<Integer, Random>();
		box6.a= 20;
		box6.b= new Random();
	}

}



//Generic 사용하기 : 설계도면을 만들때 자료형을 결정하지 않고..사용할때 결정하도록!!
class Box2<T>{
	
	T a;//멤버변수
	
	public T getA() {
		return a;
	}
	
	public void setA(T a) {
		this.a = a;
	}
	
}


//멀티 제네릭
class Box3<T, K>{
	T a;
	K b;
}



class Box{
	//만능 자료형!! 어떤 객체든 참조 할 수 있는 멤버참조변수!!
	Object a;	
	
	public void setA(Object a) {
		this.a = a;
	}
	
	public Object getA() {
		return a;
	}
	
}


















