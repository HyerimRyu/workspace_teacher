
public class Student {
	
	//�����ִ� �����͵��� ������ ������ ����
	//Field(�ʵ� : �������)
	String name;
	int kor;
	int eng;
	double aver;
	
	//����� ������ �� ����.
	//��) ȭ�鿡 aaa��� �۾��� ����ϴ� ���!(function -> Method)
	//Method(�޼ҵ�) ���� ����(c����� �Լ������ ����)
	void show() {
		//aaa��� �۾��� ����ϴ� ���๮!(�ڵ�)
		System.out.println("aaa");
	}
	//main�Լ����� ��ü�� ����� ������ ���� �޼ҵ带 ����! 
	
	//�������(�ʵ�)���� ���� ����ϴ� ���!(Method)
	void output() {
		System.out.println("�̸� : " + name); //������� ���!
		System.out.println("���� : " + kor);
		System.out.println("���� : " + eng);
		System.out.println("��� : " + aver);
		System.out.println();
	}
	
	//��հ��� ����Ͽ� aver(�������)�� �����ϴ� ���!
	void calAverage() {
		aver= (double)(kor+eng)/2;
	}
	

}










