
public class Second {
	
	int g= 10; //�������
	
	void aaa() {//����޼ҵ�
		
		final int r= 50; //�������� : �ٸ� ���������� ���Ұ�!		
				
		//AAA k= new AAA();//����Ŭ������ ������ �Ŀ��� ��밡��
		
		//����Ŭ����( Local ) : �ٸ� ���������� �νĺҰ�!!
		class AAA{
			void show() {
				System.out.println("AAA ... show "+ g);
				System.out.println("AAA ... show "+ r);//�Ϲ� �����������Ұ�!
				//final ���������� ��밡��!!
			}
		}
		
		
		AAA obj= new AAA();
		obj.show();	
		
		AAA obj2= new AAA();
		obj2.show();	
		
		AAA obj3= new AAA();
		obj3.show();	
		
	}//aaa Method
	
	void bbb() {
		
		//AAA obj= new AAA(); //error
		
	}//bbb Method
	
	//Inner class.

}//Second class..




