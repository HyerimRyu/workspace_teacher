
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Inner class : NiceŬ����
		//Outter class : TestŬ����
		
		Test t= new Test(); //�Ϲ����� Ŭ�������� �׳��νĵ�.
		
		//�̳� Ŭ������ �׳� �νĺҰ�!
		//Nice n= new Nice(); //error
		//Test.Nice n= new Test.Nice();//�νĵǴ��� ��ü�����Ұ�!!
		
		//�̳�Ŭ���� ����ϱ�!! : �ƿ��Ͱ�ü���� �̳ʰ�ü ������ �Ƿ��ϱ�!!
		Test.Nice n= t.makeInnerClass();
		n.aaa();
		
		Test.Nice n2= t.new Nice();		
		
		
		//static �̳�Ŭ���� ��ü ���� ����! : �ƿ��Ͱ�ü ����.
		First.Hello h= new First.Hello();
		
		h.show();

	}
	
	

}







