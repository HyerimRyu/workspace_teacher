
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test t= new Test();
		System.out.println( t.a );
		System.out.println( t.p );//참조형의 기본값 null
		System.out.println();
		
		//멤버변수 값 설정
		t.a= 10;
		t.p= new Person(); //객체 생성하여 참조변수에 대입
		
		System.out.println( t.a );
		System.out.println( t.p );//참조값 출력
		//멤버변수로 존재하는 또 다른객체의 멤버변수 값 출력
		System.out.println( t.p.name );
		System.out.println( t.p.age );
		System.out.println();
		
		//결국 멤버변수로 존재하는 객체의 멤버값도 대입해 주어야 함.
		t.p.name= "sam";
		t.p.age= 20;
		System.out.println( t.a );
		System.out.println( t.p.name );
		System.out.println( t.p.age );
		System.out.println();
		
		//Person의 멤버값 출력을 위해 일일이 쓰는 것 짜증!
		//Person클래스에 멤버값 출력기능
		System.out.println( t.a );
		t.p.show(); //자기값을 자기가 출력!!
		System.out.println();
		
		
		//그럼 Test클래스도 출력기능이 있다면..좋겠죠..
		t.show();
		System.out.println();
		
		//새로운 Test객체를 만들어도 어렵지 않게..멤버값 출력가능!!
		Test t2= new Test();
		t2.a= 100;
		t2.p= new Person();
		//t2.p.name= "robin";
		//t2.p.age= 25;
		//이런식으면 객체값 대입도 메소드를 이용하면 편하겠죠.
		String s= new String("robin");
		t2.p.setMembers( s, 25);		
		t2.show();
		
		//위 상황를 볼때 Test클래스도 입력기능이 있으면..
		//더 편하게 값 대입 가능하겠죠!!
		Test t3= new Test();
		//Person객체가 있어야 멤버대입 가능
		Person p= new Person();
		p.setMembers("hong", 30);
				
		t3.setMembers(10, p);
		t3.show();
		
		//위를 보면 결국 Test클래스 객체의 멤버값을 줄 때
		//a값과 더불어 name, age까지 모두 대입해주어야함.
		Test t4= new Test();
		t4.setMembers(10, "kim", 35);
		t4.show();
		
		
		//여기까지 보니까... 객체생성후 멤버값 대입을 위해
		//매번.. setMembers()메소드를 호출하는 코드를 써야함.
		//객체생성할 때 멤버값을 미리 대입해줄 수 있으면 좋겠죠!!
		//객체 생성시 자동으로 1번 호출되는 메소드 : 생성자 메소드(Constructor)
		Test t5= new Test(10, new String("lee"), 40);
		t5.show();		
			
		Test t6= new Test(20, new Person("park", 45));
		t6.show();
		
		Test t7= new Test();
		t7.show();
		
		
		

	}

}









