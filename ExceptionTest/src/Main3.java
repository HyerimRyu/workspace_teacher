
public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//코드를 통해 예외를 강제로 발동!!
		try {
			
			System.out.println("aaa");
			//억지로 예외 발생!!- 억지로 catch문으로 이동시키는 문법
			throw new Exception("Hi~~~"); 
			
			//System.out.println("bbb");//throw하면 이 코드가 실행될 수 없으므로 에러.
			
		}catch(ArithmeticException e) {
			System.out.println("예외발생!!");
		}catch(NullPointerException e) {
			System.out.println("null 에러");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		//[활용 예]
		//메소드에 계산을 요청했을 때 절대 음수의 결과가 나오지 않았으면..
		//즉, 만약 음수가 나오면 예외상황이다 라고 인지 했으면 함!
		//Java언어에서는 계산 결과가 음수라고 해서 예외라고 판단하는 알고리즘은 없음.
		int n;
		try {			
			n= aaa(10, 5);
			n= aaa(10, 15);
		}catch(Exception e) {
			System.out.println("계산결과가 음수입니다.");
			System.out.println( e.getMessage() );
		}
		

	}
	
	static int aaa(int a, int b) throws Exception{
		
		//음수가 나오는 상황일때, 강제로 예외 발생!!
		if(a<b) {
			throw new MyException("aaa");//내가 만든 예외클래스 객체
		}
		
		//만약, throw가 되면 아래 있는 뺄셈 작업은 수행하지 않음.
		return a-b;		
	}
	
	

}//


class MyException extends Exception{
	
	public MyException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
	
	
}




















