
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Inner class : Nice클래스
		//Outter class : Test클래스
		
		Test t= new Test(); //일반적일 클래스들은 그냥인식됨.
		
		//이너 클래스는 그냥 인식불가!
		//Nice n= new Nice(); //error
		//Test.Nice n= new Test.Nice();//인식되더라도 객체생성불가!!
		
		//이너클래스 사용하기!! : 아웃터객체에게 이너객체 생성을 의뢰하기!!
		Test.Nice n= t.makeInnerClass();
		n.aaa();
		
		Test.Nice n2= t.new Nice();		
		
		
		//static 이너클래스 객체 생성 가능! : 아웃터객체 없이.
		First.Hello h= new First.Hello();
		
		h.show();

	}
	
	

}







