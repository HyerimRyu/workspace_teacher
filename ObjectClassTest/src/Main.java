import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Object class : ��� Ŭ������ �θ� Ŭ����(�ֻ��� Ŭ����)
		//Java����� �����ϴ� Ŭ�������� extends�� ��ÿ��ο� �������
		//������ Object Ŭ������ ��ӹ��� ���·� �������!
		
		//ObjectŬ������ �ֿ� �޼ҵ��
		//1. toString() - ��ü�� �����ϴ� ���ڿ��� �����ϴ� �޼ҵ�
		//2. equals(Object obj) - ���޹��� obj�� ���� ��ü���� ����[true, false]
		//3. hashCode() - ��ü�� �ؽ��ڵ带 ��ȯ[����Ÿ�� int]
		//4. getClass() - Ŭ������ ������ ����[����Ÿ�� Class]
		//5. finalize() - �Ҹ���!(�������� �ݴ�)
		//6. wait(), notify(), notifyAll() - �̰� Thread���� �Ŀ� ��������.
		
		//���߿��� �׸��� ����ϴ� ��, toString(), hashCode(), getClass()
		
		Test t= new Test();
		//TestŬ������ ��������� �ƹ��͵� ������� �ʾ����� �⺻ Object�� ��ӹ��� ����
		
		//1. toString()�޼ҵ� : ��ü�� ���� �Ұ� ���ڿ� ����
		t.toString();//��ӹ��� �޼ҵ� ȣ��!
		String s= t.toString(); //���ϵ� ���ڿ��� �޾ƾ���.
		System.out.println( s  ); //[default : "Ŭ������@�ؽ��ڵ�"]
		//�ؽ��ڵ� : �޸� �����ּҸ� ������� �ּҷ� ǥ���� ����(�ڹٿ����� �ּ�) : ��) ����â���� ��ǰ��ΰ��� ����.
		
		Test t2= new Test();
		String s2= t2.toString();
		System.out.println( s2 ); 
		
		Random rnd= new Random();
		String s3= rnd.toString();
		System.out.println( s3 ); //[default : "��Ű����.Ŭ������@�ؽ��ڵ�"]
		
		//Ȥ�� �� ��ü�� ���� �Ұ����� �����ϰ� �ʹٸ�?? ��, ������� �� ��°���..���ҷ�..
		//��, toString()�� �������̵� �ؼ� ����� �� �ְ���!
		First f= new First();
		String s4= f.toString();//�������̵��� ���ڿ��� ����!
		System.out.println( s4 );
		
		//��ǥ������ ����ϴ� Ŭ����: String
		String str= new String("Hello");
		String s5= str.toString();
		System.out.println( s5 );
		
		First f2= new First();
		System.out.println( f2.toString() );
		
		//Ư���� ����.. 
		//�� println()�̶�� �޼ҵ�� ��ü�� ���������� �Ű������� ���޵Ǹ�
		//�ڵ����� �� ���������� �����ϴ� ��ü�� toString()�޼ҵ带 �����Ŵ!
		System.out.println( f2  );//���������� ������ ����.
		System.out.println( f2.toString() );		
		//�� 2�� ����� �Ȱ��� �����! why? �ڵ� toString()ȣ��Ǿ��� ������!!!
		
		
		//2. equals(Object obj) : ���� ��ü���� Ȯ���ϴ� �޼ҵ�
		Test t3= new Test();
		Test t4= new Test();
		System.out.println(  t3.equals(t4)  );//false
		
		Test t5= t3;
		System.out.println(  t3.equals(t5)  );//true
		
		//������� �Ƚ�..??
		System.out.println(  t3==t4  );
		System.out.println(  t3==t5  );
		
		
		//3. getClass() : Ŭ������ ����
		Test t6= new Test();
		Class c= t6.getClass();
		System.out.println(  c.getName()   );
		System.out.println(  c.getSuperclass() );
		System.out.println(  c.getPackage() );
		
		
		//4. hashCode() : �ڹٿ����� �ּҰ�(����)
		Test t7= new Test();
		int hc= t7.hashCode();
		System.out.println( hc );
		
		Test t8= new Test();
		hc= t8.hashCode();
		System.out.println( hc );
		
		//5. finalize()- �Ҹ��� : �������� �ݴ�
		//��ü�� �Ҹ�ɶ� �ڵ� ȣ��Ǵ� �ޙ�
		Sample sample= new Sample();
		sample= null; //���������� ���̻� ��ü�� �������� �ʵ���
		//�׷��� �Ǹ� GC(Garbage Collector)�� �ڵ����� ��ü�� �Ҹ��Ŵ
		
		
		//Object���������� ��� Ŭ������ �θ��̸��� �ƹ��� ��ĳ�������� ���� ������!
		//���� ��������
		Object obj=null;
		obj= new Test();
		obj= new First();
		obj= new Sample();
		obj= new String();
		obj= new Random();
		
		//��ǥ�� ���ó- �޼ҵ��� �Ķ���ͷ� � ��ü�� �ް� ���� ��!!
		//System.out.println(Object x)
		System.out.println( new Random() );
		System.out.println( new String() );
		System.out.println( new Test() );
		
		
		String k=null;
		
		if( k==null | k.length()==0 ) {
			System.out.println("aa");
		}
		
		
		

	}

}









