
public class RunnableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Thread�� ����� ����� 2������ ����.
		//1. ThreadŬ������ �����(extends) Ŭ������ �����Ͽ� ����ϴ� ���
		//2. Runnable�������̽��� ������(implements) Ŭ������ �����Ͽ� ����ϴ� ���
	
		//�� 2���� ����� �����ұ�???
		//���� ����� ȿ���� ���� �;!!!!?????	
		//PersonŬ������ �ɷ��� �����鼭 ���ÿ� �������� �ɷµ� ������ ��ü ����
		PersonThread pt= new PersonThread();
		
		//������ ������ start()�޼ҵ��!!! run()�� ����ȣ���ϸ� �ȵȴ�!!
		//run()�� ���� ȣ���ϸ� �װ� ������ �����尡 �ƴ� run()�� ȣ���� Main�����尡 �����Ű�� ��Ȳ!
		//pt.start();//�Ұ�����. Runnable�� start()�޼ҵ尡 ����.
		
		//Runnable��ü(pt)�� ��������ִ� ������ trigger�� Thread�� �ʿ���!
		Thread t= new Thread(pt);//�����ڿ� Runnable��ü�� ��������.
		t.start();//���޹��� Runnable��ü�� start()�� ��� ����!!

		
	}
	
}

//Person�� ����ɷ��� �����鼭 Thread�� �ɷµ� �־����� Ŭ����
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





















