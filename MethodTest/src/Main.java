import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�̸�, ����, ����, ���
		String name;
		int kor;
		int eng;
		double aver;
		
		name= "sam";
		kor= 80;
		eng= 70;
		aver= (double)(kor+eng)/2;
		
		//���� ���� ������� �������� �����ϴ� ���� ������..
		//�������� �ڷḦ �����ϴ� �迭�̿��ϱ�!!
		String[] arrName= new String[4];
		int[] arrKor= new int[4];
		int[] arrEng= new int[4];
		double[] arrAver= new double[4];
		
		arrName[0]= "sam";
		arrKor[0]= 80;
		arrEng[0]= 70;
		arrAver[0]= (double)(arrKor[0]+arrEng[0])/2;
		
		//��ó�� �ڷ������� ��� ����ϴ� ����� �������� ���� �� ����.
		//�׷��� �����ִ� Data����(�̸�, ����, ����, ���) ���
		//�����ϴ°� �� ȿ������....
		
		//�����ִ� �����ͳ����� ������ �����ϴ� class ����
		//���ο� Ŭ������ ����(����)�Ϸ��� ���ο� .java���Ͽ� �ۼ� ����!
		
		//���� ����� Student Ŭ������ ��ü�� ����!
		Student stu= new Student();
		stu.name= "sam";
		stu.kor= 80;
		stu.eng= 70;
		stu.aver= (double)(stu.kor+ stu.eng)/2;
		
		Student stu2= new Student();
		stu2.name= "robin";
		stu2.kor= 100;
		stu2.eng= 80;
		stu2.aver= (double)(stu2.kor+ stu2.eng)/2;
		
		//ȭ�����
		//System.out.println( stu ); //���������� ������ �ִ� ��ü�� �ּ�(�����ּ� �ƴ�!)
		System.out.println("�̸� : " + stu.name);
		System.out.println("���� : " + stu.kor);
		System.out.println("���� : " + stu.eng);
		System.out.println("��� : " + stu.aver);
		System.out.println();
		
		System.out.println("�̸� : " + stu2.name);
		System.out.println("���� : " + stu2.kor);
		System.out.println("���� : " + stu2.eng);
		System.out.println("��� : " + stu2.aver);
		System.out.println();
		
		//��ü�� �� ����
		int ko= 10;
		stu2.kor= ko;
		System.out.println("����� ����� : "+ stu2.kor);
		System.out.println();
		
		//�����(Ű����) �Է����� ��ü�� ����� ����!
		Scanner scanner= new Scanner(System.in);
		
		Student stu3= new Student();
		stu3.name= scanner.next();
		stu3.kor= scanner.nextInt();
		stu3.eng= scanner.nextInt();
		stu3.aver= (double)(stu3.kor+ stu3.eng)/2;
		
		//��ü�� ���..
		System.out.println("�̸� : " + stu3.name);
		System.out.println("���� : " + stu3.kor);
		System.out.println("���� : " + stu3.eng);
		System.out.println("��� : " + stu3.aver);
		System.out.println();
		//�̷������� ��ü�� ������ ����ϴ� ����� �ʹ� ¥��!!!
		
		//�̷������� ����� �� �ִٸ�????
		//stu3.�����(); //�̷����� ����� �ִٸ�...
		//�ٽø���, ��ü�� ��ɵ� �ִٸ�.. �� ���ϰ� ���α׷����� �����ϰ���!!
		
		//�ڹٴ� Ŭ�����ȿ� ��ɵ� ���� ��(������ ��) �ֵ��� �Ǿ� ����.
		//StudentŬ�����ȿ� ����߰��غ���!!
		stu3.show(); //���(�޼ҵ�) ȣ��
		
		//show()ó�� ����� ȣ���� �� ������..
		//����������� ���� ����ϴ� ��ɵ� ����� ȣ���� �� ����...
		stu3.output();
		
		//�̷����̸�.. ��հ���ϴ� ��..�� �������..
		//�ϸ� �� ������ �������???!!!
		Student stu4= new Student();
		stu4.name= "kim";
		stu4.kor= 70;
		stu4.eng= 100;
		stu4.calAverage();//��հ�� ���ȣ��!
		
		stu4.output();
		
		//�� ó�� �޼ҵ带 �� ����ϸ� �ڵ尡 �ξ�
		//�����ϰ� �������� ������.
		
		//�̷�������...
		//������� �ϳ��� �Է��ϴ� ��ɵ� ���� ���� �� �ְ���..
		//��, ���ٿ� ������� �Է��ϴ� ���!!
		//stu4= {"lee", 100, 50}; //�̰͵� �̻���! �̰��� �迭�� �ʱ�ȭ����!
		
		//stu4.�Է±��("lee", 100, 50);//�̷��������� ����� ������..�� ������.
		//��, �޼ҵ��� �Ķ���Ϳ� ���� �����ϴ� ���!!
		
		//�̰Եȴٸ�...�̷�������..
		//Student stu5= new Student();
		//stu5.�Է±��("park", 100, 50); //�̶� ��յ� �̹� ����� �Ǿ����.
		//stu5.��±��();//�Է°��� ���!
		
		
		
		

	}

}








