import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student stu= new Student();		
		stu.name= "sam";
		stu.kor= 80;
		stu.eng= 70;
		
		stu.show();
		
		Student stu2= new Student();
		//���� ������ �����ϴ°� �ʹ� ¥��!!!
		
		//"robin", 100, 50 ������ �ѹ��� �Է��ϴ� ����� ������...
		//���(Method)�� ȣ���ϸ鼭 ���� ������ �� ����ϴ� ���� ( ) �Ķ����!!
		//stu2.�Է±��("robin", 100, 50); //StudentŬ������ ��ɼ���!
		//�����ϴ� ��(�μ�: argument)�� ������ �޼ҵ忡�� �μ��� ���� �� �ִ� 
		//�Ű�����(parameter)�� �غ��� ���ƾ���.
		stu2.setMembers("robin", 100, 50);
		stu2.show();
		
		
		Student stu3= new Student();
		stu3.setMembers("hong", 80, 45);
		stu3.show();
		
		//��������߿��� �ϳ��� �� �����ϱ�!!
		//���������ڸ� ���� �ʼ��� �������� ���!		
		//stu3.eng= 60;//�� ������ �Ұ����� �� ����.
		//����� �ϳ��� �����ϴ� ��ɵ� ����� �δ� ���� ����.
		stu3.setName("kim");
		
		
		//������� ������ �����ϴ� ��ɻ���ϱ�!!
		Student stu4= new Student();
		stu4.setName("lee");
		stu4.setKor(70);
		//stu4.eng= 800;//������ ���ɼ��� ����.		
		stu4.setEng(800);//�����ְԲ�.. �� �� ����.
		stu4.setEng(80);
		
		stu4.show();
		
		
		//�л��� ������ ����ϱ�!!
		int total= stu4.kor+ stu4.eng;
		System.out.println("���� : "+ total);
		
		total= stu3.kor+ stu4.eng;//�Ǽ����� ����.
		System.out.println("���� : "+ total);
		
		//������굵 Student��ü�� ������� ������ ������?!
		int t= stu4.calTotal();//total���� ����ؼ� ��������!!
		System.out.println("���� : "+ t);
		
		//��� return�� ���� ������ �޼ҵ�ȣ���� �ͼ���!
		Random rnd= new Random();
		int n= rnd.nextInt();//�̷� ����!!!
		
		//����� ������ִ� ���!!
		double aver= stu4.calAverage();//�޼ҵ��� �����ڷ��� ����!
		System.out.println("��� : "+ aver);
		
		aver= stu4.calAverage2();//�޼ҵ��� �����ڷ��� ����!
		System.out.println("��� : "+ aver);
		
		//��հ� ������ ��� ������ִ� ���?! �����ұ�?
		//��, 2���� return(����)�ϱ�??? ����??
		//���� 2���̻��� �Ұ���!!!!!!! ERROR!!!!!!!!!!!!
		
		//������� �ϳ��� ���� ���Ϲ޴� ���!!
		//������� �ϳ� �� �Է��ϱ�(setXXX)�� �ݴ���!!		
		//name������ stu4��ü�� name������� �� �����ϱ�!
		//����, ���������ڸ� ���� �Ұ�������!!
		String name= stu4.getName();
		int kor= stu4.getKor();
		int eng= stu4.getEng();
		
		
		
		//�޼ҵ常 �ִ� Ŭ������ ������!!
		//������ ���� �ʿ�� ��!!
		
		
		

	}

}

















