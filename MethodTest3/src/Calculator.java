
public class Calculator {
	
	//��� �޼ҵ�
	//���ϱ� ���
	int sum(int x, int y) {		
		return x+y;
	}
	
	//���� ���
	int subtract(int x, int y) {
		return x-y;
	}
	
	//���� ���
	int multiply(int x, int y) {
		return x*y;
	}
	
	//������ ���
	int divide(int x, int y) {
		return x/y;
	}
	
	
	//double�� ��Ģ���� ���..
	//�����ε�(Overloading):�޼ҵ��� �̸��� ����, �Ķ���Ͱ� �ٸ� �޼ҵ�..
	double sum(double x, double y) {
		return x+y;		
	}
	
	double subtract(double x, double y) {
		return x-y;		
	}
	
	double multiply(double x, double y) {
		return x*y;
	}
	
	double divide(double x, double y) {
		return x/y;
	}
	
	//���� ���ڿ��� �������
	int sum(String s1, String s2) {
		int n1= Integer.parseInt(s1);
		int n2= Integer.parseInt(s2);
		
		return n1+n2;		
	}
	
	

}

















