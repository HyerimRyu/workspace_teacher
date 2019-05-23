
public class Student {
	
	//연관있는 데이터들을 저장할 변수들 정의
	//Field(필드 : 멤버변수)
	String name;
	int kor;
	int eng;
	double aver;
	
	//기능을 설계할 수 있음.
	//예) 화면에 aaa라는 글씨를 출력하는 기능!(function -> Method)
	//Method(메소드) 정의 문법(c언어의 함수선언과 동일)
	void show() {
		//aaa라는 글씨를 출력하는 실행문!(코드)
		System.out.println("aaa");
	}
	//main함수에서 객체를 만들어 위에서 만든 메소드를 실행! 
	
	//멤버변수(필드)들의 값을 출력하는 기능!(Method)
	void output() {
		System.out.println("이름 : " + name); //멤버변수 출력!
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("평균 : " + aver);
		System.out.println();
	}
	
	//평균값을 계산하여 aver(멤버변수)에 저장하는 기능!
	void calAverage() {
		aver= (double)(kor+eng)/2;
	}
	

}











