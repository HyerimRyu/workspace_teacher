
public class Test {
	
	final int num= 20; //final �������
	//final int age;//error : ��������� final�ϸ鼭 ���������� �ʱ�ȭ ����� ��.	
	
	void aaa() {
		//num=30; //error : final ������� �� ���� �Ұ�!!
		bbb(10);
	}

	void bbb(final int k) { //�Ű��������� final ������.
		System.out.println( k );
		//k=50; //error			
	}
	
	//�޼ҵ忡 final���� : �������̵� �Ұ�!!!
	//Test�� ��ӹ޴� SampleŬ���� ����
	final void show() {
		System.out.println("TEST!!!");	
	}

}







