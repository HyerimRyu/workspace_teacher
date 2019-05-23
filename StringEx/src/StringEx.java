import java.util.Scanner;

public class StringEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s=new String("Hello");
		
		//String class의 주요 메소드(기능들)
		//1. 문자열 데이터의 길이(글자수)를 리턴시키는 기능(Method)		
		int len= s.length();
		System.out.println(  len );
		
		//2. 문자열값의 비교
		System.out.println( s=="Hello");//false : 주소비교
		System.out.println( s.equals("Hello") );
		System.out.println( s.equals(new String("Hello")) );
		String s1= "Hello";
		System.out.println( s.equals(s1) );
		System.out.println( "Hello".equals(s)  );
		
		//2-1.대소문자 비교
		System.out.println(  s.equals("hello") );
		System.out.println( s.equalsIgnoreCase("hello"));
		
		//3. 문자열에서 특정 char 얻어오기!
		char ch= s.charAt(0);
		System.out.println(  ch  );
		System.out.println(  s.charAt(1) );
		System.out.println(  s.charAt(2) );
		System.out.println(  s.charAt(3) );
		System.out.println(  s.charAt(4) );
		//System.out.println(  s.charAt(5) );//error
				
		for(int i=0; i<s.length(); i++) {
			System.out.println( s.charAt(i) );
		}
		
		//Scanner를 이용해서 한문자(char) 입력받기
		Scanner scan= new Scanner(System.in);		
//		String str=scan.next();
//		char c= str.charAt(0);
//		System.out.println( c );	
		
		
		//4. 문자열안에 특정 문자가 몇번째에 있는지..
		int index= s.indexOf('l');
		System.out.println( index );		
		System.out.println( s.lastIndexOf('l')  );
		
		System.out.println( s.indexOf("eo")   );
		System.out.println( s.indexOf('e', 2) );
		
		//5. 파라미터로 전달된 문자열이 내 문자열안에 포함되었는가?
		s= "Hello world! Hello android! nice world!";
		boolean b= s.contains("world");		
		System.out.println( b );
		
		//6. 문자열 결합
		String s2= s.concat("nice android!");
		System.out.println(  s );
		System.out.println(  s2 );
		
		//7. 특정문자열로 시작하는가??
		System.out.println(  s.startsWith("Hello")  );
		System.out.println(  s.startsWith("world")  );
		
		//7-1. 특정문자열로 종료되는가?
		System.out.println(  s.endsWith("Hello")  );
		System.out.println(  s.endsWith("world!")  );
		
		//8. 대소문자 자동 변환
		System.out.println(  s.toUpperCase()  );
		System.out.println(  s.toLowerCase()  );
		System.out.println(  s  );
		
		//9. 문자열의 양끝쪽 공백문자를 제거하기!!(중간 공백문자는 제거안함)
		s=" Hello       ";
		System.out.println( "["+ s + "]");
		System.out.println(   s.equals("Hello"));
		
		s= s.trim();
		System.out.println( "["+ s + "]");
		System.out.println(   s.equals("Hello"));
		
		//10. 특정문자 바꿔치기!!
		s= "Hello world! Hello android! nice world!";		
		System.out.println(  s.replace('H', 'K')   );
		System.out.println(  s.replace("android", "ios")   );
		//중간 공백문자도 제거할 수 있음.
		System.out.println(  s.replace(" ", "")   );
		
		//11. 문자열 잘라내기!!!
		String s4= s.substring(5);
		System.out.println( s4 );
		
		String s5= s.substring(6, 12);
		System.out.println( s5 );
		
		//12. 문자열 비교!!
		char ch1='a';
		char ch2='b';
		System.out.println( ch1 > ch2);
		
		String s6= "aaa";
		String s7= "aab";
		
		//System.out.println( s6 > s7 );//error :주소비교는 안됨
		System.out.println( s6.compareTo(s7)  );
		
		//13. 문자열 분리!!!(문자열을 분리해서 배열로 만들어줌)
		s="android:ios:nice:windows";
		String[] arr= s.split(":");
		
		for(int i=0; i<arr.length; i++) {
			System.out.println( arr[i] );			
		}
		
		
		
		
		//기본형 Data를 문자열객체로 변환!!	
		String s10= String.valueOf(10);
		System.out.println( s10.length() );
		
		s10= String.valueOf(3.14);
		System.out.println( s10.length() );
		
		s10= String.valueOf(false);
		System.out.println( s10.length() );
		
		s10= 10+"";
		s10= 3.14+"";
		s10= true+"";
		
		//문자열을 기본형으로...(Integer, Double, Float, Byte......Boolean....)
		//Wrapper클래스
		int n= Integer.parseInt("100");
		double d= Double.parseDouble("3.14");
		
		//Static 메소드
		// 포멧만들어주는 ..  like... printf()
		int h=10, m=5, sec=12;
		System.out.println( h+":"+m+":"+sec  );
		String str= String.format("%02d:%02d:%02d", h,m,sec);
		System.out.println( str );
		
		
	}

}

























