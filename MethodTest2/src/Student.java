
public class Student {
	
	//���������(�ʵ�: Field)
	String name;
	int kor;
	int eng;
	
	//����޼ҵ�	
	//��������� ���� ����ϴ� ���(Method) ����
	void show() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + kor );
		System.out.println("���� : " + eng );
		System.out.println();
	}
	
	//��������� ���� �����ϴ� ���(Method) ����
	void setMembers( String n, int k, int e ) {
		//��������� ���޹��� ������ �������ֱ�!!
		name= n;
		kor= k;
		eng= e;								
	}
	
	//name ��������� �� ����
	void setName(String n) {
		name= n;		
	}
	
	//kor ��������� �� ����
	void setKor(int k) {
		kor= k;		
	}
	
	//eng ��������� �� ����
	//�߸��� ���� ������ ������ �� ����.!!
	void setEng(int e) {
		if( e<0 || e>100) {
			System.out.println("�߸��� ���� �Է��Դϴ�.");
			return;//�Լ� ����!!
		}
		
		eng=e;		
	}
	
	
	//������ ������ִ� ���
	int calTotal() {
		int total= kor+eng;
		return total;
	}
	
	//������ double��...
	double calAverage() {
		double a= (double)(kor+eng)/2;
		return a;
	}
	
	//����޼ҵ忡�� �ٸ� ����޼ҵ带 ȣ��!!
	double calAverage2() {
		int t= calTotal(); //�ٸ� ����޼ҵ带 ȣ��!!
		double a= (double)t/2;
		return a;		
	}
	
	
	//������ 2�����ֱ�!! �Ұ���!!! error
//	int,double calTotalAndAverage() {
//		int total= calTotal();
//		double aver= calAverage();
//		
//		return total, aver; //error!!!!!!!!
//	}
	
	//��������� �� �����ϴ� ���!!
	String getName() {
		return name;
	}
	
	int getKor() {
		return kor;		
	}
	
	int getEng() {
		return eng;
	}
	
	

}




















