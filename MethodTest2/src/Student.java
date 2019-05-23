
public class Student {
	
	//멤버변수들(필드: Field)
	String name;
	int kor;
	int eng;
	
	//멤버메소드	
	//멤버변수의 값을 출력하는 기능(Method) 정의
	void show() {
		System.out.println("이름 : " + name);
		System.out.println("국어 : " + kor );
		System.out.println("영어 : " + eng );
		System.out.println();
	}
	
	//멤버변수에 값을 대입하는 기능(Method) 정의
	void setMembers( String n, int k, int e ) {
		//멤버변수에 전달받은 값들을 대입해주기!!
		name= n;
		kor= k;
		eng= e;								
	}
	
	//name 멤버변수의 값 변경
	void setName(String n) {
		name= n;		
	}
	
	//kor 멤버변수의 값 변경
	void setKor(int k) {
		kor= k;		
	}
	
	//eng 멤버변수의 값 변경
	//잘못될 값을 대입을 막아줄 수 있음.!!
	void setEng(int e) {
		if( e<0 || e>100) {
			System.out.println("잘못된 값의 입력입니다.");
			return;//함수 종료!!
		}
		
		eng=e;		
	}
	
	
	//총점을 계산해주는 기능
	int calTotal() {
		int total= kor+eng;
		return total;
	}
	
	//리턴이 double형...
	double calAverage() {
		double a= (double)(kor+eng)/2;
		return a;
	}
	
	//멤버메소드에서 다른 멤버메소드를 호출!!
	double calAverage2() {
		int t= calTotal(); //다른 멤버메소드를 호출!!
		double a= (double)t/2;
		return a;		
	}
	
	
	//리턴을 2개해주기!! 불가능!!! error
//	int,double calTotalAndAverage() {
//		int total= calTotal();
//		double aver= calAverage();
//		
//		return total, aver; //error!!!!!!!!
//	}
	
	//멤버변수의 값 리턴하는 기능!!
	String getName() {
		return name;
	}
	
	int getKor() {
		return kor;		
	}
	
	int getEng() {
		return eng;
	}
	
	

}




















