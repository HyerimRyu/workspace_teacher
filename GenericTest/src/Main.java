import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�����͸� �ϳ� ��������� �����Ͽ� ������ �ִ� Box��ü.
		Box box= new Box();
		
		box.setA(10);
		System.out.println( box.getA() );
		
		box.setA(3.14);
		System.out.println( box.getA() );
		
		box.setA("Hello");
		System.out.println( box.getA() );
		
		//���ɹڽ��� ���� �� ó��.����..�Ϻ� ������ ����.
		//���� �����ö� �� ¥����!!(�ٿ�ĳ�����̶� ��������� ����ȯ�� �ؾ߸� ��)
		box.setA(10);
		int n= (int)box.getA(); // (Object->integer->int)
		
		box.setA(3.14);
		double d= (double)box.getA();
		
		//Ŭ���� �Ѱ��� �����ؼ� �����ڷ����� ��δ� ���� �� �ִ� ��ü�������� �����
		Box2<String> box2= new Box2<String>();
		box2.a="aaa";
		
		int[] arr= new int[5];
		Random[] arr2= new Random[5];
		Box2<String>[] arr3= new Box2[5];
		
		
		Box2<Random> box3= new Box2<Random>();
		box3.a= new Random();
		
		//<>�ȿ� ���� �ڷ����� ���� �������� ����, ��, �⺻���ڷ����� ���Ұ�!!
		//Box2<int> box4= new Box2<int>();
		
		//�̷� �� �⺻���� ���������� ���� WrapperŬ�������� �̿�
		Box2<Integer> box4= new Box2<Integer>();
		box4.a= 10;//����ڽ� : �⺻��ó�� ����ص� ��!!		
		int k= box4.getA();//�����ڽ�
		

		Box3<String, Integer> box5= new Box3<String, Integer>();
		box5.a="Hello";
		box5.b= 10;
		
		Box3<Integer, Random> box6= new Box3<Integer, Random>();
		box6.a= 20;
		box6.b= new Random();
	}

}



//Generic ����ϱ� : ���赵���� ���鶧 �ڷ����� �������� �ʰ�..����Ҷ� �����ϵ���!!
class Box2<T>{
	
	T a;//�������
	
	public T getA() {
		return a;
	}
	
	public void setA(T a) {
		this.a = a;
	}
	
}


//��Ƽ ���׸�
class Box3<T, K>{
	T a;
	K b;
}



class Box{
	//���� �ڷ���!! � ��ü�� ���� �� �� �ִ� �����������!!
	Object a;	
	
	public void setA(Object a) {
		this.a = a;
	}
	
	public Object getA() {
		return a;
	}
	
}


















