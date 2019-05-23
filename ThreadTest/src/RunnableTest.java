
public class RunnableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Thread를 만드는 방법은 2가지가 있음.
		//1. Thread클래스를 상속한(extends) 클래스를 선언하여 사용하는 방법
		//2. Runnable인터페이스를 구현한(implements) 클래스를 선언하여 사용하는 방법
	
		//왜 2가지 방법이 존재할까???
		//다중 상속의 효과를 보고 싶어서!!!!?????	
		//Person클래스의 능력을 가지면서 동시에 스레드의 능력도 보유한 객체 생성
		PersonThread pt= new PersonThread();
		
		//스레드 실행은 start()메소드로!!! run()은 직접호출하면 안된다!!
		//run()을 직접 호출하면 그건 별도의 스레드가 아닌 run()을 호출한 Main스레드가 실행시키는 상황!
		//pt.start();//불가능함. Runnable은 start()메소드가 없음.
		
		//Runnable객체(pt)를 실행시켜주는 별도의 trigger용 Thread가 필요함!
		Thread t= new Thread(pt);//생성자에 Runnable객체를 전달해줌.
		t.start();//전달받은 Runnable객체의 start()를 대신 해줌!!

		
	}
	
}

//Person의 멤버능력을 가지면서 Thread의 능력도 있었으면 클래스
class PersonThread extends Person implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<5; i++) {
			System.out.println("name : "+ name +" , age : " + age);
			
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}
		
	}
	
}

class Person{
	String name;
	int age;
}





















