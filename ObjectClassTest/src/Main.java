import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Object class : 모든 클래스의 부모 클래스(최상위 클래스)
		//Java언어의 존재하는 클래스들은 extends의 명시여부와 상관없이
		//무조건 Object 클래스를 상속받은 상태로 만들어짐!
		
		//Object클래스의 주요 메소드들
		//1. toString() - 객체를 설명하는 문자열를 리턴하는 메소드
		//2. equals(Object obj) - 전달받은 obj와 같은 객체인지 리턴[true, false]
		//3. hashCode() - 객체의 해쉬코드를 반환[리턴타입 int]
		//4. getClass() - 클래스의 정보를 리턴[리턴타입 Class]
		//5. finalize() - 소멸자!(생성자의 반대)
		//6. wait(), notify(), notifyAll() - 이건 Thread수업 후에 설명가능함.
		
		//이중에서 그마나 사용하는 건, toString(), hashCode(), getClass()
		
		Test t= new Test();
		//Test클래스는 명시적으로 아무것도 상속하지 않았지만 기본 Object를 상속받은 상태
		
		//1. toString()메소드 : 객체에 대한 소개 문자열 리턴
		t.toString();//상속받은 메소드 호출!
		String s= t.toString(); //리턴된 문자열을 받아야함.
		System.out.println( s  ); //[default : "클래스명@해쉬코드"]
		//해쉬코드 : 메모리 물리주소를 상대적인 주소로 표현한 숫자(자바에서의 주소) : 예) 물류창고에서 물품장부같은 느낌.
		
		Test t2= new Test();
		String s2= t2.toString();
		System.out.println( s2 ); 
		
		Random rnd= new Random();
		String s3= rnd.toString();
		System.out.println( s3 ); //[default : "패키지명.클래스명@해쉬코드"]
		
		//혹시 이 객체에 대한 소개글을 변경하고 싶다면?? 예, 멤버변수 값 출력같은..역할로..
		//즉, toString()을 오버라이드 해서 사용할 수 있겠죠!
		First f= new First();
		String s4= f.toString();//오버라이드한 문자열이 리턴!
		System.out.println( s4 );
		
		//대표적으로 사용하는 클래스: String
		String str= new String("Hello");
		String s5= str.toString();
		System.out.println( s5 );
		
		First f2= new First();
		System.out.println( f2.toString() );
		
		//특이한 것은.. 
		//저 println()이라는 메소드는 객체의 참조변수가 매개변수로 전달되면
		//자동으로 그 참조변수가 참조하는 객체의 toString()메소드를 실행시킴!
		System.out.println( f2  );//참조변수만 전달한 상태.
		System.out.println( f2.toString() );		
		//위 2개 명령이 똑같이 실행됨! why? 자동 toString()호출되었기 때문에!!!
		
		
		//2. equals(Object obj) : 같은 객체인지 확인하는 메소드
		Test t3= new Test();
		Test t4= new Test();
		System.out.println(  t3.equals(t4)  );//false
		
		Test t5= t3;
		System.out.println(  t3.equals(t5)  );//true
		
		//사람들은 안써..??
		System.out.println(  t3==t4  );
		System.out.println(  t3==t5  );
		
		
		//3. getClass() : 클래스의 정보
		Test t6= new Test();
		Class c= t6.getClass();
		System.out.println(  c.getName()   );
		System.out.println(  c.getSuperclass() );
		System.out.println(  c.getPackage() );
		
		
		//4. hashCode() : 자바에서의 주소값(숫자)
		Test t7= new Test();
		int hc= t7.hashCode();
		System.out.println( hc );
		
		Test t8= new Test();
		hc= t8.hashCode();
		System.out.println( hc );
		
		//5. finalize()- 소멸자 : 생성자의 반대
		//객체가 소멸될때 자동 호출되는 메솓
		Sample sample= new Sample();
		sample= null; //참조변수가 더이상 객체를 참조하지 않도록
		//그렇게 되면 GC(Garbage Collector)가 자동으로 객체를 소멸시킴
		
		
		//Object참조변수는 모든 클래스의 부모이르모 아무나 업캐스팅으로 참조 가능함!
		//만능 참조변수
		Object obj=null;
		obj= new Test();
		obj= new First();
		obj= new Sample();
		obj= new String();
		obj= new Random();
		
		//대표적 사용처- 메소드의 파라미터로 어떤 객체든 받고 싶을 때!!
		//System.out.println(Object x)
		System.out.println( new Random() );
		System.out.println( new String() );
		System.out.println( new Test() );
		
		
		String k=null;
		
		if( k==null | k.length()==0 ) {
			System.out.println("aa");
		}
		
		
		

	}

}









