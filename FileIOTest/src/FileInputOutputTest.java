import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���������� ���
		//String srcPath= "D:/files/aaa.txt";
		String srcPath= "";
		if(args.length!=0) srcPath= args[0];
		
		//String ���ϰ�η� ��ٷ� ��Ʈ�� ���� ������.
		try {
			FileInputStream fis= new FileInputStream(srcPath);
			
			//�о���� �����͸� ������ ������ ��ο� ���ϸ�����
			File dstPath= new File("D:/copy"); //��θ� ���� ����
			if( !dstPath.isDirectory() ) dstPath.mkdirs();
			
			//������� ���� ������ copy������ �ִٰ� Ȯ���� �� ����.
			//���ϸ��� ������ full��� File��ü ����
			File dstFile= new File(dstPath, "bbb.txt");//��� + ���ϸ� 
			//������� ���������ϱ��� �����ϴ� Stream��ü ����
			FileOutputStream fos= new FileOutputStream(dstFile);
			
			
			//�о�� ������ ������(1byte��)�� ��ٷ� dstFile�� ����!!
			while(true) {
				byte b= (byte)fis.read();//1����Ʈ�� �б�
				if(b == -1) break;
				
				//�о���� 1����Ʈ�� �ٷ� ���������Ͽ� ����
				fos.write(b);//1����Ʈ�� ����				
			}
			
			fos.flush();
			
			//���簡 ������...
			fis.close();
			fos.close();
			
			System.out.println("���� �Ϸ�Ǿ����ϴ�.");
			
		} catch (FileNotFoundException e) {
			System.out.println("������ ã�� �� �����ϴ�.");
		} catch (IOException e) {
			System.out.println("���� �� ������ �߻��Ͽ����ϴ�.");
		}

	}

}





