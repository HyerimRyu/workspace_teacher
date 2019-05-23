
public class Second {
	
	int a;
	static int b=100;
	
	static
	{
		System.out.println("static 초기화");
		b=100;		
	}
	
	//초기화 블럭!
	{
		System.out.println("instance 초기화");
		a=10;		
	}

}






