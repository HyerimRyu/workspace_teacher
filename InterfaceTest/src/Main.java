
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//인터페이스는 직접 new 객체생성 불가!!
		//Test t= new Test();
		
		//사용하려면? 상속받은 클래스를 만들어서 객체 생성해야만 함.!	
		First f= new First();
		f.aaa();
		f.ddd();
		
		Second s= new Second();
		s.aaa();
		s.ddd();
		
		Test t; //인터페이스 참조변수( 부모참조변수)
		t= new First();//가능함 : 업캐스팅
		t.aaa();
		t.ddd();
		
		t= new Second();
		t.aaa();
		t.ddd();
		
		
		Test.Hello h= new Test.Hello();//static 이너클래스는 객체생성 가능
		h.show();
		

	}

}






