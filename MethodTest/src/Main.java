import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//이름, 국어, 영어, 평균
		String name;
		int kor;
		int eng;
		double aver;
		
		name= "sam";
		kor= 80;
		eng= 70;
		aver= (double)(kor+eng)/2;
		
		//위와 같은 방법으로 변수들을 나열하는 것은 불편함..
		//여러개의 자료를 관리하는 배열이용하기!!
		String[] arrName= new String[4];
		int[] arrKor= new int[4];
		int[] arrEng= new int[4];
		double[] arrAver= new double[4];
		
		arrName[0]= "sam";
		arrKor[0]= 80;
		arrEng[0]= 70;
		arrAver[0]= (double)(arrKor[0]+arrEng[0])/2;
		
		//위처럼 자료형끼리 묶어서 사용하는 방식은 적합하지 않을 수 있음.
		//그래서 연관있는 Data끼리(이름, 국어, 영어, 평균) 묶어서
		//관리하는게 더 효과적임....
		
		//연관있는 데이터끼리의 묶음을 설계하는 class 정의
		//새로운 클래스를 정의(설계)하려면 새로운 .java파일에 작성 권장!
		
		//새로 설계된 Student 클래스로 객체를 생성!
		Student stu= new Student();
		stu.name= "sam";
		stu.kor= 80;
		stu.eng= 70;
		stu.aver= (double)(stu.kor+ stu.eng)/2;
		
		Student stu2= new Student();
		stu2.name= "robin";
		stu2.kor= 100;
		stu2.eng= 80;
		stu2.aver= (double)(stu2.kor+ stu2.eng)/2;
		
		//화면출력
		//System.out.println( stu ); //참조변수가 가지고 있는 객체의 주소(실제주소 아님!)
		System.out.println("이름 : " + stu.name);
		System.out.println("국어 : " + stu.kor);
		System.out.println("영어 : " + stu.eng);
		System.out.println("평균 : " + stu.aver);
		System.out.println();
		
		System.out.println("이름 : " + stu2.name);
		System.out.println("국어 : " + stu2.kor);
		System.out.println("영어 : " + stu2.eng);
		System.out.println("평균 : " + stu2.aver);
		System.out.println();
		
		//객체의 값 변경
		int ko= 10;
		stu2.kor= ko;
		System.out.println("변경된 국어성적 : "+ stu2.kor);
		System.out.println();
		
		//사용자(키보드) 입력으로 객체의 멤버값 대입!
		Scanner scanner= new Scanner(System.in);
		
		Student stu3= new Student();
		stu3.name= scanner.next();
		stu3.kor= scanner.nextInt();
		stu3.eng= scanner.nextInt();
		stu3.aver= (double)(stu3.kor+ stu3.eng)/2;
		
		//객체값 출력..
		System.out.println("이름 : " + stu3.name);
		System.out.println("국어 : " + stu3.kor);
		System.out.println("영어 : " + stu3.eng);
		System.out.println("평균 : " + stu3.aver);
		System.out.println();
		//이런식으로 객체의 값들을 출력하는 방식은 너무 짜증!!!
		
		//이런식으로 출력할 수 있다면????
		//stu3.출력해(); //이런식의 기능이 있다면...
		//다시말해, 객체가 기능도 있다면.. 더 편하게 프로그래밍이 가능하겠죠!!
		
		//자바는 클래스안에 기능도 가질 수(설계할 수) 있도록 되어 있음.
		//Student클래스안에 기능추가해보기!!
		stu3.show(); //기능(메소드) 호출
		
		//show()처럼 기능을 호출할 수 있으니..
		//멤버변수들의 값을 출력하는 기능도 만들어 호출할 수 있음...
		stu3.output();
		
		//이런식이면.. 평균계산하는 것..도 기능으로..
		//하면 더 편하지 않을까요???!!!
		Student stu4= new Student();
		stu4.name= "kim";
		stu4.kor= 70;
		stu4.eng= 100;
		stu4.calAverage();//평균계산 기능호출!
		
		stu4.output();
		
		//위 처럼 메소드를 잘 사용하면 코드가 훨씬
		//간결하고 가독성도 좋아짐.
		
		//이런식으면...
		//멤버값을 하나씩 입력하는 기능도 역시 만들 수 있겠죠..
		//즉, 한줄에 멤버값을 입력하는 기능!!
		//stu4= {"lee", 100, 50}; //이것도 이상함! 이것은 배열의 초기화문법!
		
		//stu4.입력기능("lee", 100, 50);//이런식으로의 기능이 있으면..더 간결함.
		//즉, 메소드의 파라미터에 값을 전달하는 기능!!
		
		//이게된다면...이런식으로..
		//Student stu5= new Student();
		//stu5.입력기능("park", 100, 50); //이때 평균도 이미 계산이 되어야함.
		//stu5.출력기능();//입력값들 출력!
		
		
		
		

	}

}








