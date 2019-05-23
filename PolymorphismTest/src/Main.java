
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		First f= new First();   //제대로된 캐스팅		
		Second s= new Second(); //제대로된 캐스팅
		
		//다른 종류의 캐스팅(상속관계에서의...)
		f= new Second(); //이것이 가능함..부모참조변수는 자식객체를 참조할 수 있음.(왜? 자식객체는 무조건 부모객체의 멤버을 가지고 있으니까..) --> 업 캐스팅
		//s= new Fisrt();  //이것은 에러..자식참조변수가 부모객체를 참조할수는 없음.(왜? 부모객체는 자식객체의 멤버을 가지고 있지 않으므로)    --> 다운 캐스팅(error)
		
		//부모참조변수로 멤버제어할 수 있음.
		//단, 부모객체의 멤버만 제어할 수 있음.
		f.a=10;
		f.showFirst();
		//자식객체를 참조할 수는 있더라도.
		//자식객체의 멤버를 마음대로 쓸 수는 없음.
		//f.showSecond();//error
		
		//그럼에도 자식객체만의 멤버를 사용하고 싶다면?
		f= new Second(); //업 캐스팅!(묵시적 형변환!)
		Second s2; //자식참조변수를 만들어야 함.
		s2= (Second)f; //(자식이-->부모를) : 다운 캐시팅 -명시적 형변환!
		s2.showFirst();
		s2.showSecond();
		
		
//		First f3= new First(); //제대로된 casting
//		Second s3; //자식
//		s3= (Second)f3;//다운캐스팅 : 자식->부모
//		s3.showSecond();//error -- casting 에러!!
//		
//		Second s4= new Second(); //제대로된 casting
//		First f4= s4; //업 캐스팅(묵시적 형변환)
//		f4.showFirst();
		//f4.showSecond();//error : 실제 객체가 showSecond()가 있더라도 에러
		
		//그럼 왜 이런 업캐스팅을 사용할까???..를 알아보기 전에 잠깐!!
		//혹시 오버라이딩된 메소드가 있다면?? 어찌될까??
		//First에 show() ... 를 오버라이드해서 Second에 show() 추가
		
		Second s5= new Second(); //제대로된 캐스팅
		s5.show();//오버라이드 메소드호출(Second의 show)
		
		//업캐스팅 되었을때!!
		First f5= new Second();
		f5.show();//실제 참조하는 객체의 오버라이드된 메소드가 실행!
		
		//그럼 이 기술이 뭐에 유용한건가??
		//부모참조변수 하나라 자식을 모두 제어 가능!!
		
		First obj;//참조변수 1개!
		
		obj= new First();
		obj.show();
				
		obj= new Second();
		obj.show();
		
		obj= new Test();
		obj.show();
		
		obj= new Third();//조부모->손자 참조가능
		obj.show();
		
		

	}

}








