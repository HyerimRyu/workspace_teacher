import aaa.Person;

public class Main extends aaa.Second{

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
				
		//같은 패키지의 클래스 객체생성
		First f= new First();
		//f.a=50; //private은 접근 불가!!
		
		//같은 패키지 안에서는 private을 제외한 모든 접근제어자에 접근가능
		f.b= 10;
		f.c= 20;
		f.d= 30;
		
		f.aaa(); //같은 패키지면 default메소드 접근 가능
		
		
		//다른 패키지의 클래스 객체 생성
		aaa.Second s= new aaa.Second();
		//s.a=10; //private : error
		//s.b= 20;  //default : error
		//s.c= 30;  //protected : error
		
		//다른 패키지 클래스의 객체멤버는 public만 접근 가능
		s.d= 40;
		//단, 다른 패키지라하더라도 상속받으면 protected접근 가능
		
		//s.aaa(); //default - error
		s.bbb(); //public  - OK
		
		//aaa.Third t;
		
		
		//기본적으로 OOP에서는 정보은닉이 중요한 개념이어서
		//멤버변수(데이터:정보)를 외부에 노출하지 않도록 하는것이 미덕!!(안전한 class의 설계)
		//멤버변수(Field)는 기본적으로 private으로 설정!!
		//멤버메소드는 기본적으로 public으로 설정!!
		//예) 앱 사용자 정보 저장 : 사용자 정보 : 이름, 나이, 국적
		Person p= new Person();
		//p.name= "sam"; //불가능!!
		//private멤버값은 대입을 어떻게?? 메소드를 이용하는 방법 권장!
		p.setMembers("sam", 20, "Ghana");		
		p.show(); 
		
		//멤버하나의 값 변경.. 나이변경, 국적변경
		//p.age= 21; //불가!!
		p.setAge(21);//대입가능
		
		//나이에 따라 조건식
		if( p.getAge() < 20 ) {
			System.out.println("미성년자!!");
		}
		
		
		
		
		
	 }

}







