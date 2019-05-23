import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1. Error : 실행불가!!
		//2. Exception : 실행중(RunTime) 문제가 발생!!
		
		//Exception의 대표적인 예)
		//1) 사용자가 잘못된 데이터를 입력하는 경우 : 숫자입력상황에 문자입력..등..
		//2) 개발자가 로직이나 계산을 잘못한 경우 : 배열의 인덱스번호 오류, or 0으로 나눗셈.
		//3) 네트워크나 하드웨어 오류 (하드디스크의 파일제어 오류.. 특정사이트(서버)접속 오류 : URL 미스, 사이트서버 불량)
		//4) ?? 악의적인 과부하에 의한 오류(디도스 공격) : 해결이 어려움!!
		System.out.println("예외처리에 대해 알아봅시다.");
		
		//위의 예외상황에 대응하는 문법 소개..
		//int a=0;		
		//System.out.println( 10/a );
		//예외가 발생하면 그 순간 프로그램이 다운됨!!
		//이를 방지할 필요가 있음..즉, 문제가 생기는 부분만 실행하지 않고 다음 코드를 계속 실행하도록!!
		//if를 이용해서 a값이 0인 검사해보고 나눗셈을 실행할지 여부를 결정할 수 있음.
		//경우에 따라서는 일단 시도를 해보고 예외가 발생하면 그에 대응해야 하는 경우도 있음.
		//예): 인터넷 사이트에 접속하는 경우(www.naver.com): 접속은 해보는데 그 서버문제로 접속이 안되는 경우!
		//이럴 경우 예외처리 문법이 유용함!! 프로그래머들에게는 필수 기술!! 		
		
		//1) 0으로 나눗셈..
		int a=0;		
		
		try {//일단 한번 시도해보는 영역 : 예외가 발생될 여지가 있는 코드들 작성 영역
			
			System.out.println( 10/a );
			
		}catch( ArithmeticException e ) {
			//에러가 발생할 때 실행할 코드들..
			System.out.println("에러가 발생했습니다");
			System.out.println("에러메세지 : "+ e.getMessage() );
			System.out.println("에러메세지 풀버전: "+ e.toString() );
		}
		
		
		//2) 배열의 인덱스 번호 사용 오류..
		int[] arr= new int[5];
		
		try {
			//에러가 발생할 여지가 있는 코드는 try{ .. } 안에 작성!!
			for(int i=0; i<6; i++) {
				System.out.println( arr[i] );
			}
			
		}catch( ArrayIndexOutOfBoundsException e ) {
			System.out.println("에러!!!");			
		}
		
		
		//3) null참조변수로 객체 메소드 사용.(가장 많이발생..)
		String s= null;
		
		try {
			
			System.out.println( s.length() );
			
		}catch( NullPointerException e ) {
			System.out.println("null 에러!! : 객체 없어!!!!");
		}
		
		//4) 잘못된 데이터를 입력!!
		Scanner scanner= new Scanner(System.in);
		
		int n;
		try {
			
//			n= scanner.nextInt();
//			System.out.println(" n : " + n );
			
		}catch( InputMismatchException e ) {
			System.out.println(" 정수만 입력해!!! ");
		}
		
		
		//5) 숫자로 바꿀 수 없는 데이터를 숫자로 바꾸고자 할때!!
//		String str= scanner.next(); //문자열 입력
		
		//문자열을 int형으로 변환하기!
		try {
			
//			int num= Integer.parseInt(str);
//			System.out.println(" num : " + num);
			
		}catch( NumberFormatException e) {
			System.out.println("정수형 문자열이 아니여서 변환 불가!");
		}
		
		
		//예외가 한번에 여러가지 발생하는 경우도 있음!!!
		//예) 두 수를 입력받아 나눗셈을 하는 프로그램..
		//예외 안에 중첩으로 예외 필요..
		int c, d;
		
		try {
			
//			c= scanner.nextInt();
//			d= scanner.nextInt();
//			
//			try {
//				
//				System.out.println( c/d ); //d가 0인 문제가 있을 수 있음.
//				
//			}catch( ArithmeticException e) {
//				System.out.println("수학적 오류 : 0 나눗셈");
//			}			
			
			
		}catch( InputMismatchException e ) {
			System.out.println("정수가 아닌 값 입력 에러!!");
		}
		
		//중첩에 중첩.....중첩..이거 좀 짜증
		//if else중첩 대신에  if else if문..
		//다중 catch문으로 간결하게 처리하기!!
		try {
			
//			c= scanner.nextInt();
//			d= scanner.nextInt();
//			
//			System.out.println( c/d );
			
		}catch( InputMismatchException e) {
			System.out.println("정수가 아닌값을 입력!");
		}catch( ArithmeticException e) {
			System.out.println("수학오류 : 0나눗셈");
		}
		
		//멀티catch문은 개수제한이 없음.
		//만약 에러상황마다 대처할 내용은 똑같다면. 굳이 여러개의 catch문을
		//반복적으로 작성하는 것은 낭비!!
		//예외클래스들의 최상위 클래스인 Exception으로 모든 종류의 Exception객체를 catch할 수 있음.
		try {
//			c= scanner.nextInt();
//			d= scanner.nextInt();
//			
//			System.out.println( c/d );
		}catch( Exception e) {
			System.out.println("에러!!!");
		}
		
		
		//예외발생 여부와 상관없이 무조건 할 일이 있다면...??
		//보통 사용예)메모리를 관리하거나 외부(서버, 파일)와 연결통로 종료시키는 코드들..작성!
		int x=0;
		try {
			System.out.println(10/x);
			System.out.println("계산성공");
			
		}catch(ArithmeticException e) {
			
			System.out.println("계산실패");			
		}finally {
			//여기는 무조건 실행되는 영역!!!
			System.out.println("여긴 무조건 실행");
		}
		//가만 보니..finally를 안써도..어차피 cath{}다음 줄이 실행됨!!
		//그럼 어차피 무조건 실행되는 코드작성 가능함!! 
		//만약, 그냥쓰면 위의 try- catch문과는 상관없는 코드인것 처럼 인식될 가능성이 더 많음.
		
		//finally를 쓰게되면 catch문을 안써도 됨.
		try {
			
		}finally {}
		
		
		
		//Exception의 2가지 분류!
		//1. Checked Exception : 예외처리를 안하면 에러가 발생하여 실행조차도 못하는 예외들!!
		//2. UnChecked Exception : 예외처리(try문)을 해도되고 안해도 되는 예외들...지금까지 봤던 저 위의 예외들..
		
		//Checked Exception의 대표적인 것들..:반드시 예외처리해야만 사용가능!
		
		try {
			//URL url= new URL("http://www.naver.com");//예외처리를 안하면 실행도 안되는 기능!!
			URL url= new URL("www.naver.com");//주소오류: http://없어서..
			
			System.out.println("서버접속 완료!!");
			
		}catch( MalformedURLException e ) {
			System.out.println("서버 주소에 이상이 있습니다.");
		}
		
		
		File file= new File("D://aaa.txt");
		
		
		try {
			//예외처리를 안하면 에러나는 코드들!
			FileInputStream fis= new FileInputStream(file);
			
			System.out.println("파일접속 성공");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일접속 실패. 파일을 찾을 수 없습니다.");
		}
		
		
		
		
		
		
		System.out.println();
		System.out.println("aaaa");
		
		
		

	}

}






