
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Second s= new Second();
		//s.a= 10; //����Ŭ������ ����� �����ξ�....
		s.b= 20;
		
		//System.out.println("a : "+ s.a);
		System.out.println("b : "+ s.b);
		System.out.println();
		
		//��ü������ ���������� �����ϴ°��� X
		//����ϴ� ����� ���� ���!
		s.showFirst();
		System.out.println("b : "+ s.b);
		System.out.println();
		
		//Second�� ��±�� ����� �ְ���!
		s.showFirst(); //����Ŭ���� ����� �����ξ�....
		s.showSecond();
		System.out.println();
		
		//������� �ϰ���..
		//�ᱹ, Second��ü���� a, b��θ� 
		//����� �ִ°� �� ������!!
		//�̷��� �ܼ��ϰ� ��°���������!!		
		s.show();
		
		
		//�̷����̸� ���� �����ϴ� ��ɵ� �߰�����!
		//����Ŭ������ a���� �� ������ �Ǿ�� ��.
		s.setMembers(100, 200);
		s.show();
		
		Second s2= new Second();
		s2.setMembers(10, 50);
		s2.show();
		
		//����鼭 �� �����ϸ� �� �����ٵ�.........
		//�׷��� �����ϴ� ��ü ����(new)�� �ڵ����� ����Ǵ� �޼ҵ� �̿�!
		//������!!!
		//Second s3= new Second(5, 3);
		//s3.show();
		
		
		
		

	}

}








