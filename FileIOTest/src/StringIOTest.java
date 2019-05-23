import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class StringIOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//���ڿ������͸� ���پ� �Ǵ� �Ѵܾ �аų� ������?? Ư��, �о���϶�..
		//���� ����Ʈ��Ʈ�� ����� InputStream�� �����Ʈ�� �о�� ���� �ľ��ϱ� �����.
		//�׷��� �� �� ���ϰ� ���ڿ������� �������� IO�� �����ϱ�����
		//���� ��Ʈ�� ����� ���.(Reader, Writer)
		
		//����� �Է��� �޾� �� �����͸� ���Ͽ� ���������� �����ϴ� ���α׷�
		
		Scanner scanner= new Scanner(System.in);
		
		while(true) {
			System.out.print("������ �ܾ� �Է� (no�� �Է��ϸ� ����): ");
			String str= scanner.next();
			
			if( str.equalsIgnoreCase("no") ) {//��ҹ��� �������!
				System.out.println("�Է��� ����˴ϴ�.");
				break;
			}
			
			//������� �ʾҴٸ� ���Ͽ� ����..
			//��ǥ��ġ : "����������Ʈ/files/data.txt"
			File path= new File("files");
			if( !path.exists() ) path.mkdirs();
			
			//��� + ���ϸ�.Ȯ���� : ������ ��ü���
			File file= new File(path, "data.da");
			
			//���ϰ� ������ ��Ʈ��(���ڽ�Ʈ��)
			//�� �����͸� ���������� ������������ ��Ʈ��(OutputStream-->Writer)
			//�ڹٹ����� data.txt�������̿� �������ε�(FileWriter)��ü ����
			try {
				FileWriter fileWriter= new FileWriter(file, true);//append���
//				fileWriter.write(str);//������ ������ �ܾ���̳� Ư�� Format���� �����Ű�� ���� �����.
//				fileWriter.flush();
//				fileWriter.close();
				
				//FileWriter�� �ٷ� ����ϱ� ���� �� �� �ͼ��� ������� �����Ű�� ����.
				//��, �ܼ� â ����ϵ���.. ��ġ..System.out.printn()�̷��� ������..
				//�� �� �ֵ��� ���� ��Ʈ�� Ŭ������ �غ�Ǿ� ����.
				PrintWriter writer= new PrintWriter(fileWriter);
				writer.println(str);
				writer.flush();
				writer.close();//�ڵ����� FileWriter�� close()��.
				
			} catch (IOException e) {
				System.out.println("���Ͼ��� ����!!");
			}
			
		}//while��...
		
		System.out.println();
		System.out.println("--------------------------------");		
		System.out.println("����� ������ �����͵��� ȭ�鿡 ����մϴ�.");
		System.out.println("--------------------------------");
		System.out.println();
		
		//���ٿ� �Ѵܾ ������ �о���� �ܾ ArrayList�� �߰���Ű��..
		ArrayList<String> datas= new ArrayList<String>();
		
		File file= new File("files/data.da");
		//�о�� ���ϰ� ��Ʈ������ �۾� ����!
		try {
			FileReader fr= new FileReader(file);
			
//			int a= fr.read();//�ѱ��ھ� �б�: ����� 1����Ʈ, �ѱ��̸� 2~3����Ʈ�� �о���. ���� �˾Ƽ� ����Ʈ�� ����
//			System.out.println(a);
//			//�� ����� �ݺ����� �ʿ��Ͽ� �����ϸ�..���������� ��� �о���̱� ������.
			
			//�׷��� �о���̱� ���ϰ� ���� ���� ��Ʈ�� Ŭ�������� ������.
			//���� ���� ���� ���Ǵ� BufferedReader�� ���!
			BufferedReader reader= new BufferedReader(fr);
			//���پ� �о�鿩..
			String line= reader.readLine();
			while(line!=null) {
				//�о�� �����͸� ArrayList�� �߰�
				datas.add(line);
				
				line= reader.readLine();//������ �о����
			}
			
			System.out.println("���� �б� ����!!");
			
			//ArrayList�� �߰��� �����͸� ���ʷ� ȭ�鿡 ����ϱ�!!
			for(int i=0; i<datas.size(); i++) {
				System.out.println(i +" : "+ datas.get(i));
			}
			
			
			reader.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (IOException e) {
			System.out.println("�����б� ����!");
		}
		
		
		

	}//main method...

}








