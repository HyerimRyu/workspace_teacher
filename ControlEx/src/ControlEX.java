import java.util.Random;
import java.util.Scanner;

public class ControlEX {
	
	public static void main(String[] args) {
		
		//��������� Random�� ���
		int a= (int)(Math.random() * 10); //0~9
		
		
		
		//�������� ������ִ� ������(Random��ü) ����
		Random rnd= new Random();
		
		int r= rnd.nextInt(10);//0~9
		
		Scanner scan= new Scanner(System.in);
		
		while(true){
			
			System.out.print("input : ");
			int user= scan.nextInt();
			
			if(user>r) System.out.println(user+"���� �۽��ϴ�.");
			else if(user<r) System.out.println(user+"���� Ů�ϴ�.");
			else {
				System.out.println("�����Դϴ�.");
				break;
			}
			
		}//while
		
		System.out.println("���� ����!!");
		
		
		
		
		
		
	}	
}










