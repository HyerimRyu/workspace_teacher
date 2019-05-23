import java.util.Scanner;

public class StringEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s=new String("Hello");
		
		//String class�� �ֿ� �޼ҵ�(��ɵ�)
		//1. ���ڿ� �������� ����(���ڼ�)�� ���Ͻ�Ű�� ���(Method)		
		int len= s.length();
		System.out.println(  len );
		
		//2. ���ڿ����� ��
		System.out.println( s=="Hello");//false : �ּҺ�
		System.out.println( s.equals("Hello") );
		System.out.println( s.equals(new String("Hello")) );
		String s1= "Hello";
		System.out.println( s.equals(s1) );
		System.out.println( "Hello".equals(s)  );
		
		//2-1.��ҹ��� ��
		System.out.println(  s.equals("hello") );
		System.out.println( s.equalsIgnoreCase("hello"));
		
		//3. ���ڿ����� Ư�� char ������!
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
		
		//Scanner�� �̿��ؼ� �ѹ���(char) �Է¹ޱ�
		Scanner scan= new Scanner(System.in);		
//		String str=scan.next();
//		char c= str.charAt(0);
//		System.out.println( c );	
		
		
		//4. ���ڿ��ȿ� Ư�� ���ڰ� ���°�� �ִ���..
		int index= s.indexOf('l');
		System.out.println( index );		
		System.out.println( s.lastIndexOf('l')  );
		
		System.out.println( s.indexOf("eo")   );
		System.out.println( s.indexOf('e', 2) );
		
		//5. �Ķ���ͷ� ���޵� ���ڿ��� �� ���ڿ��ȿ� ���ԵǾ��°�?
		s= "Hello world! Hello android! nice world!";
		boolean b= s.contains("world");		
		System.out.println( b );
		
		//6. ���ڿ� ����
		String s2= s.concat("nice android!");
		System.out.println(  s );
		System.out.println(  s2 );
		
		//7. Ư�����ڿ��� �����ϴ°�??
		System.out.println(  s.startsWith("Hello")  );
		System.out.println(  s.startsWith("world")  );
		
		//7-1. Ư�����ڿ��� ����Ǵ°�?
		System.out.println(  s.endsWith("Hello")  );
		System.out.println(  s.endsWith("world!")  );
		
		//8. ��ҹ��� �ڵ� ��ȯ
		System.out.println(  s.toUpperCase()  );
		System.out.println(  s.toLowerCase()  );
		System.out.println(  s  );
		
		//9. ���ڿ��� �糡�� ���鹮�ڸ� �����ϱ�!!(�߰� ���鹮�ڴ� ���ž���)
		s=" Hello       ";
		System.out.println( "["+ s + "]");
		System.out.println(   s.equals("Hello"));
		
		s= s.trim();
		System.out.println( "["+ s + "]");
		System.out.println(   s.equals("Hello"));
		
		//10. Ư������ �ٲ�ġ��!!
		s= "Hello world! Hello android! nice world!";		
		System.out.println(  s.replace('H', 'K')   );
		System.out.println(  s.replace("android", "ios")   );
		//�߰� ���鹮�ڵ� ������ �� ����.
		System.out.println(  s.replace(" ", "")   );
		
		//11. ���ڿ� �߶󳻱�!!!
		String s4= s.substring(5);
		System.out.println( s4 );
		
		String s5= s.substring(6, 12);
		System.out.println( s5 );
		
		//12. ���ڿ� ��!!
		char ch1='a';
		char ch2='b';
		System.out.println( ch1 > ch2);
		
		String s6= "aaa";
		String s7= "aab";
		
		//System.out.println( s6 > s7 );//error :�ּҺ񱳴� �ȵ�
		System.out.println( s6.compareTo(s7)  );
		
		//13. ���ڿ� �и�!!!(���ڿ��� �и��ؼ� �迭�� �������)
		s="android:ios:nice:windows";
		String[] arr= s.split(":");
		
		for(int i=0; i<arr.length; i++) {
			System.out.println( arr[i] );			
		}
		
		
		
		
		//�⺻�� Data�� ���ڿ���ü�� ��ȯ!!	
		String s10= String.valueOf(10);
		System.out.println( s10.length() );
		
		s10= String.valueOf(3.14);
		System.out.println( s10.length() );
		
		s10= String.valueOf(false);
		System.out.println( s10.length() );
		
		s10= 10+"";
		s10= 3.14+"";
		s10= true+"";
		
		//���ڿ��� �⺻������...(Integer, Double, Float, Byte......Boolean....)
		//WrapperŬ����
		int n= Integer.parseInt("100");
		double d= Double.parseDouble("3.14");
		
		//Static �޼ҵ�
		// ���丸����ִ� ..  like... printf()
		int h=10, m=5, sec=12;
		System.out.println( h+":"+m+":"+sec  );
		String str= String.format("%02d:%02d:%02d", h,m,sec);
		System.out.println( str );
		
		
	}

}

























