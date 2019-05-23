
public class Sample {
	
	public Sample() {
		// TODO Auto-generated constructor stub
		System.out.println("Sample생성");
	}
	
	//객체가 소멸될때 자동으로 1번 실행되는 메소드
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("객체가 소멸되었습니다!!!");
	}

}
