
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		First f= new First();   //����ε� ĳ����		
		Second s= new Second(); //����ε� ĳ����
		
		//�ٸ� ������ ĳ����(��Ӱ��迡����...)
		f= new Second(); //�̰��� ������..�θ����������� �ڽİ�ü�� ������ �� ����.(��? �ڽİ�ü�� ������ �θ�ü�� ����� ������ �����ϱ�..) --> �� ĳ����
		//s= new Fisrt();  //�̰��� ����..�ڽ����������� �θ�ü�� �����Ҽ��� ����.(��? �θ�ü�� �ڽİ�ü�� ����� ������ ���� �����Ƿ�)    --> �ٿ� ĳ����(error)
		
		//�θ����������� ��������� �� ����.
		//��, �θ�ü�� ����� ������ �� ����.
		f.a=10;
		f.showFirst();
		//�ڽİ�ü�� ������ ���� �ִ���.
		//�ڽİ�ü�� ����� ������� �� ���� ����.
		//f.showSecond();//error
		
		//�׷����� �ڽİ�ü���� ����� ����ϰ� �ʹٸ�?
		f= new Second(); //�� ĳ����!(������ ����ȯ!)
		Second s2; //�ڽ����������� ������ ��.
		s2= (Second)f; //(�ڽ���-->�θ�) : �ٿ� ĳ���� -����� ����ȯ!
		s2.showFirst();
		s2.showSecond();
		
		
//		First f3= new First(); //����ε� casting
//		Second s3; //�ڽ�
//		s3= (Second)f3;//�ٿ�ĳ���� : �ڽ�->�θ�
//		s3.showSecond();//error -- casting ����!!
//		
//		Second s4= new Second(); //����ε� casting
//		First f4= s4; //�� ĳ����(������ ����ȯ)
//		f4.showFirst();
		//f4.showSecond();//error : ���� ��ü�� showSecond()�� �ִ��� ����
		
		//�׷� �� �̷� ��ĳ������ ����ұ�???..�� �˾ƺ��� ���� ���!!
		//Ȥ�� �������̵��� �޼ҵ尡 �ִٸ�?? ����ɱ�??
		//First�� show() ... �� �������̵��ؼ� Second�� show() �߰�
		
		Second s5= new Second(); //����ε� ĳ����
		s5.show();//�������̵� �޼ҵ�ȣ��(Second�� show)
		
		//��ĳ���� �Ǿ�����!!
		First f5= new Second();
		f5.show();//���� �����ϴ� ��ü�� �������̵�� �޼ҵ尡 ����!
		
		//�׷� �� ����� ���� �����Ѱǰ�??
		//�θ��������� �ϳ��� �ڽ��� ��� ���� ����!!
		
		First obj;//�������� 1��!
		
		obj= new First();
		obj.show();
				
		obj= new Second();
		obj.show();
		
		obj= new Test();
		obj.show();
		
		obj= new Third();//���θ�->���� ��������
		obj.show();
		
		

	}

}








