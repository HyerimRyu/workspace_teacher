import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�о�� ������ ���ϸ��� ������ �ִ� File��ü����
		File file= new File("aaa.txt");
		
		//���ϰ� �����ϴ� �������ε�(Stream)
		try {
			//������ �������� ������ �ڵ����� ����!! ���ܹ߻�!!
			FileInputStream fis= new FileInputStream(file);
			
			//������ ������ �б�
//			byte b= (byte)fis.read(); //���Ͽ��� 1����Ʈ�� �о��. �ݺ��� �ʿ�..			
//			while(b != -1) { //������ read()���� �� �о�� �����Ͱ� ������ -1��.
//				//System.out.println(b);//�о�°� �����ֱ�..�ƽ�Ű��ȣ�� �����
//				System.out.print((char)b);
//				b= (byte)fis.read();
//			}
			//�� ����� ��� �ƴ�(�ƽ�Ű�ڵ尡 �ƴ�) ���ڴ� �ùٷ� �о����� ����.
			
			//����Ʈ�迭(�����͵��)������ �о���ϰ���!!
			//�о���� �����͸� ������ �� ����Ʈ�迭�� ���� ����������.
			byte[] bytes= new byte[100];//�� ũ�� ���� ���۱�!!
			fis.read(bytes);//�Ķ���ͷ� ���޵� �迭�ȿ� �о�� ������ �־���.
			
			//�о�� ����Ʈ �迭�� String���� ��ȯ
			String s= new String(bytes);
			System.out.println(s);		
			
			
			
		} catch (FileNotFoundException e) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (IOException e) {
			System.out.println("�б� ������ ������ �߻��߽��ϴ�.");
		}
		

	}

}








