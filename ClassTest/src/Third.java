
public class Third {
	//�������(�ʵ�)
	int a;
	
	//����Լ�(�޼ҵ�)
	void show() {
		int k;//��������
		
		//����Ŭ���� : �޼ҵ�ȿ� Ŭ��������
		class Nice{
			int n;
			
			void aaa() {				
			}
			
		}//Nice class..
		
		class World{
			
		}
		
		//����Ŭ���� ��ȣ����...
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
	
	//Inner Ŭ����
	class Hello{
		
	}//Hello class...

}//Third class..

class Test{
	void show() {
		System.out.println("test");
	}
	
}

