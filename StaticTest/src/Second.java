
public class Second {
	
	int a;
	static int b=100;
	
	static
	{
		System.out.println("static �ʱ�ȭ");
		b=100;		
	}
	
	//�ʱ�ȭ ��!
	{
		System.out.println("instance �ʱ�ȭ");
		a=10;		
	}

}






