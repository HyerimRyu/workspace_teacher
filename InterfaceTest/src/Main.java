
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//�������̽��� ���� new ��ü���� �Ұ�!!
		//Test t= new Test();
		
		//����Ϸ���? ��ӹ��� Ŭ������ ���� ��ü �����ؾ߸� ��.!	
		First f= new First();
		f.aaa();
		f.ddd();
		
		Second s= new Second();
		s.aaa();
		s.ddd();
		
		Test t; //�������̽� ��������( �θ���������)
		t= new First();//������ : ��ĳ����
		t.aaa();
		t.ddd();
		
		t= new Second();
		t.aaa();
		t.ddd();
		
		
		Test.Hello h= new Test.Hello();//static �̳�Ŭ������ ��ü���� ����
		h.show();
		

	}

}






