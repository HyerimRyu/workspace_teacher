import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���� ���̸��� ��ǻ�� ��ü ����!!
		Computer com= new Computer();
		
		//��ǻ�� ��ü���� ���䰪�� �����ϰ� ����� ����!!
		com.makeNumbers();		
		
		Scanner scanner= new Scanner(System.in);
		while(true) {
			//Ű���� �Է¹ޱ�!!			
			String userNumber= scanner.next();
			
			//��ǻ�Ϳ��� ���� �Է¹��� ���� �������ְ� ������ ����ϵ���!!
			boolean result= com.checkAnswer(userNumber);
			
			//�����̸� �ݺ� ����!!
			if(result) break;			
			
		}//while
		
		//���Ǵ�?!!!		
		

	}

}






