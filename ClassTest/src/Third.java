
public class Third {
	//멤버변수(필드)
	int a;
	
	//멤버함수(메소드)
	void show() {
		int k;//지역변수
		
		//내장클래스 : 메소드안에 클래스설계
		class Nice{
			int n;
			
			void aaa() {				
			}
			
		}//Nice class..
		
		class World{
			
		}
		
		//내장클래스 번호관련...
		new Test() {
			@Override
			void show() {
				System.out.println("aaaa");
			}
		};
		
		new Test() {
			@Override
			void show() {
				System.out.println("bbb");
			}
		};
		
	}//show method..
	
	//Inner 클래스
	class Hello{
		
	}//Hello class...

}//Third class..

class Test{
	void show() {
		System.out.println("test");
	}
	
}

