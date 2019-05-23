
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Test t= new Test();
		t.aaa(); //원래 Test의 기능인 aaa()메소드 사용
		
		//두번째 Test객체 만들기
		Test t2= new Test();
		t2.aaa();//역시 Test클래스에 설계된대로 기능 "aaa"가 출력
		
		//세번째 Test객체 만드는데 이 친구만 특이하게 aaa() 출력이 다르게 나왔으면...
		//그렇다고 원래 Test클래스에 가서 aaa()메소드를 수정하면..
		//위 t, t2가 참조하는 객체의 능력도 영향을 받음..
		//이때 이 세번째 객체만 특이하게 기능을 변경하고 싶다면???
		//기능변경??? --- 오보라이드!! 이건 상속일 때만 되지 않나???
		//아래처럼...Test를 상속하는 별도의 클래스를 만들어서 오버라이드해야만 함.
		
		//Test의 능력( aaa() )을 상속받아 기능 변경한 First객체 생성
		Test t3= new First();
		t3.aaa(); //오버라이드된 aaa()실행
		
		//결국 First라는 이름의 파일이 새로 생기는 결과.
		//근데 이런식이면 많이 사용되지 않는 First클래스같은 파일들이
		//너무 많아짐. 쓰임새도 적고...이때..
		//클래스의 이름이 없는 클래스를 만들어서 1회성으로 객체 생성이 가능하다면..
		//더 합리적으로 코드작성이 가능해 짐.
		//이 기술을 익명클래스 : anonymous class
		
		//객체를 생성하면서 바로 { }를 통해 클래스를 설계 : 일종의 상속
		//즉, Test를 상속하여 클래스 설계 { ... }를 작성하는 형태!!
		//단, 클래스이름이 없는것을 뿐!(First클래스와 동일한 것임)
		//업캐스팅 상황임.
		Test t4= new Test() {
			@Override
			void aaa() {
				// TODO Auto-generated method stub
				System.out.println("aaa 변경 : 익명 클래스 aaa");
			}			
		};
		
		t4.aaa(); //기존 Test클래스와 다른 기능이 실행됨.
		
		//물론 이후에 다시 Test객체를 그냥 만들면??
		Test t5= new Test();
		t5.aaa();
				
		//익명클래스는 결국 이름만 없을 뿐 상속이므로 오버라이드말고 새로운 메소드를 만들어도 되겠죠?
		Test t6= new Test() {
			//새로운 메소드 추가
			void bbb() {
				System.out.println("bbb");
			}						
		};
		
		t6.aaa();
		//t6.bbb();//자식만의 메소드를 호출이 불가능하기에 잘 사용지 않는 기술!!
		
		new Test().aaa();
		new First().aaa();
		
		//익명클래스의 새로운 메소드 실행시키는 유일한 방법 !- 오직 1번 호출할 수 있음.
		new Test() {
			void bbb() {
				System.out.println("bbb"); 
			}
		}.bbb();
		
		
		
		//그럼 익명클래스는 그닥 많이 쓸것 같지 않죠?? -- 일반 클래스 잘 사용하지 않음		
		//보톤, 인터페이스를 객체로 만들고자 할 때 애용됨.
		
		//Clickable 인터페이스 설계
		//Clickable c= new Clickable();//error:객체 생성 불가!
		
		//인터페이스를 사용하려면 항상 새로운 클래스를 만들고 추상 메소드를 오버라이드하여
		//이를 객체로 만들어서 사용해야만 함...근데 만약, 그 새로운 클래스의 객체의 개수가
		//여러개 필요하지 않다면...굳이 별도로 클래스파일을 만드는게 더 불편함.
		
		//이럴때 익명클래스가 아주 유용함. : 1개뿐인 객체를 만들때 유용함.
		Clickable c= new Clickable() {
			@Override
			public void click() {
				// TODO Auto-generated method stub
				System.out.println("버튼 1번이 클릭되었습니다!");
			}
		};		
		c.click();
		
		//자동완성으로 익명클래스 만들기!
		Clickable c2= new Clickable() {			
			@Override
			public void click() {
				// TODO Auto-generated method stub
				System.out.println("버튼 2번이 클릭되었습니다.");
			}			
		};		
		c2.click();
		
		
		
		
		

	}

}














