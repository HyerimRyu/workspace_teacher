import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileOutputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner= new Scanner(System.in);
		System.out.print("������ ������ �Է� : ");
		//���Ͽ� ������ ������
		String data= scanner.next();
		
		//�����͸� ������ ������ ��ο� ���ϸ�.Ȯ���ڱ��� ������ �ִ� ��ü ����
		//����������� ������ �⺻������ �� �ڹٹ����� �ִ� ������Ʈ������ ������.
		File file= new File("aaa.txt");
		
		//�����ȿ� ��������
		//������ ��α����ڴ� �ü������ �ٸ�.
		//windows������ ��������(\)�� �ǰ� ������(/)�� ��, ������, macOS /(������)�� ��������.
		
		file= new File("kkk\\aaa.txt"); //���������� 2�������.
		file= new File("kkk/aaa.txt"); //�� ���¸� ���� �����.
		//file= new File("kkk"+ File.separator +"aaa.txt");//�˾Ƽ� ������ ��������.
		
		// �̸� kkk������ ������ ������ ������..
		// ���� ���α׷������� ������ ����� �ʹٸ�.....
		// ������ ����� �޶�� ����� �����ؾ߸� ��.
		
		// ������ ���� �� ������ �ϰ���.. �׷��Ƿ� ������� �� �������� �ִ��� �˻�!
		//���ϸ��� ������ ��θ� ������ �ִ� File��ü ����		
		File path= new File("kkk");//������ �ۼ�
		if( !path.isDirectory() ) {//�� ������ ����??
			//���ٸ� ���丮�� �����(make)
			path.mkdirs();//���������� �����Ѵٸ� �� �������� ������ ��� �������.
		}
		
		//������ ���� ��ο� ���� ���� ���ϸ��� �����Ͽ� �ٽ� File��ü�� ����
		file= new File(path, "bbb.txt");//��ο� ���ϸ� ����!!
		
		//�� ������Ʈ�� �ƴ� Ư�� ������ ���� �ٷ� �����ϴ� �͵� ������.
		file= new File("d:/aaa.txt");
		
		//��θ� �Ѳ�����..���� �� ����.
		path= new File("d:/files/kkk");
		if( !path.isDirectory() ) path.mkdirs();
		
		file= new File(path, "hello.txt");
		
		
		//�� �����͸� ���Ͽ� �����ϱ�(���������� ��������:output)
		//�ָ������� ���Ͽ� �����͸� �������� �ݵ�� �������ε�(Stream)�� �ʿ���.
		
		//Stream�߿��� ������ ������ Stream�� OutputStream�̶�� ��.
		//�� �߿� ���Ͽ� ������ �ɷ��� ���� ��Ʈ��Ŭ������ ��ü�� ����
		try {
			//���� aaa.txt������ ���ٸ� �ڵ� ������Ŵ!��, ������ �ڵ��������� ����.
			FileOutputStream fos= new FileOutputStream(file);
			//FileOutputStream fos= new FileOutputStream(file, true);//�ι�° �Ķ����, append����[true,false]
			
			//��Ʈ���� ���� �����͸� ���Ͽ� �ۼ�(��������)
			//fos.write(65); //�̷������� ������ 1����Ʈ�� �����⶧���� �ݺ����� �ʿ���..������..
			//����Ʈ �迭(byt[])�� �����͵���� ������ ����� ��ȣ..			
			//����Ʈ��Ʈ���� String�� �Ķ���ͷ� ������ �� ������ �Ǿ�����.
			//�׷��� String-->byte[] ��ȯ			
			//fos.write(data.getBytes());
			//fos.flush();//Stream���ۿ� ��Ⱑ �������� �� �־ ��쵵��..(��������)
			
			//������ ��Ʈ���۾��� ������ ��Ʈ���� �ݴ� �۾� ����.
			fos.close();
			
			//������� Ŀ���� �Դٸ�...������ �����ٴ� ���� �ǹ���..
			System.out.println("���� ���� ����!!");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("������ �������� �ʽ��ϴ�.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�����۾� �� ������ �߻��߽��ϴ�.");
		}
		
		
		//FileŬ���� ��ü�� �ֿ� �޼ҵ�
		System.out.println( file.getName() );
		System.out.println( file.getPath() );
		System.out.println( file.getAbsolutePath() );
		

	}

}













