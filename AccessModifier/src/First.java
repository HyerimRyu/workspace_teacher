
public class First {
	
	//접근제한자가 부여된 멤버변수
	private int a;
	int b;
	protected int c;
	public int d;
	
	//멤버메소드
	void aaa() {
		//같은 클래스의 private멤버변수에 접근 당연 가능!
		a=20;
		//다른 제한자들은 더 당연히 가능
		b=30;
		c=40;
		d=50;
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}

}
