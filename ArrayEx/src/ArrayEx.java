import java.util.Random;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ArrayEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int�� 3ĭ¥�� �迭��ü ����
		int[] arr= new int[3];//���帹�� ���, �ùٸ��� ���
//		int [] arr2= new int[3];//OK
//		int arr3[]= new int[3]; //OK
//		
//		int[] arr4;//int�� �迭 ��������
//		arr4= new int[3];//����		
//		arr4= arr2;//����
		
		System.out.println(arr);
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		//System.out.println(arr[3]);
		
		//�迭��ҿ� �� ����
		arr[0]= 10;
		arr[1]= 20;
		arr[2]= 30;
		
		for(int i=0; i<arr.length; i++){
			System.out.println(arr[i]);			
		}
		
		//�迭�� �ʱ�ȭ
		int[] arr2= new int[] {10, 20, 30};
		//int[] arr3= new int[3] {10, 20, 30};//error : �ʱ�ȭ�ϸ� ���� ��� �Ұ�!
		//int[] arr3= new int[];//error
		
		//�ʱ�ȭ�� ���ǥ���
		int[] arr3= {10, 20, 30};//�ڵ� new int[]		
		
		for(int i=0; i<arr2.length; i++) {
			System.out.print(arr2[i]+" , ");
		}
		System.out.println();
		
		
		//�ʱ�ȭ�� �� ������ ������ �ټ��ִ°�?
		int n=10;		
		int[] arr4= new int[] {n, n+1, n+2};
		
		for(int i=0; i<arr4.length; i++) {
			System.out.print(arr4[i]+" , ");
		}
		System.out.println();
		
		//�迭�� ����(��Ұ���) ������ ���� ������.
		Scanner scan= new Scanner(System.in);
		
		//int k=scan.nextInt();
		int k=5;
		int[] arr5= new int[k];
		
		for(int i=0; i<arr5.length; i++) {
			System.out.print(arr5[i]+" , ");
		}
		System.out.println();
		
		int[] arr6= new int[0];
		System.out.println( arr6.length );
		
		//�迭���������� ������� �Ұ�!
		//int[3] arr7;//error
		
		//�迭�������� ������ ����
		double[] arr7= new double[] { 1.1, 2.2, 3.3 };
		double[] arr8;
		arr8= arr7; //���� �迭��ü�� �����ϰ� ��.
		//double[] arr9= arr8+arr7;//error �ּҿ����� �ȵ�.
		
		for(int i=0; i<arr7.length; i++) {
			System.out.print( arr7[i] + " , " );
		}
		System.out.println();
		
		for(int i=0; i<arr8.length; i++) {
			System.out.print( arr8[i] + " , " );
		}
		System.out.println();
		
		//�ٸ� ���������� ���� ������ ����!
		arr8[1]= 3.14;
		for(int i=0; i<arr7.length; i++) {
			System.out.print( arr7[i] + " , " );
		}
		System.out.println();
		
		
		//�迭��ü�� copy�ϱ�
		int[] arr9= new int[] {5, 6, 7};
		int[] arr10= new int[arr9.length];
		
		for(int i=0; i<arr9.length; i++)
			arr10[i]= arr9[i];
		
		//arr10�� ��ü�� arr9�� ��ü�� ���� �ٸ� ��ü��!
		
		
		//������������ �迭!
		int a, b, c;
		int[] arr11= new int[3];
		
		String s1, s2, s3;		
		s1= new String("Hello");
		s2= new String("Hello");
		s3= "Hello";
		System.out.println( s1 );
		
		String[] arr12= new String[3];
		
		System.out.println(  arr12 );
		System.out.println(  arr12[0] );
		System.out.println(  arr12[1] );
		System.out.println(  arr12[2] );
		
		arr12[0]= new String("Hello");
		arr12[1]= new String("nice");
		arr12[2]= "android";
		
		System.out.println( arr12[0]  );
		System.out.println( arr12[1]  );
		System.out.println( arr12[2]  );
		
		System.out.println( arr12[0].length()  );
		System.out.println( arr12[1].length()  );
		System.out.println( arr12[2].length()  );
		
		char ch= arr12[0].charAt(1);
		ch= arr12[2].charAt(3);
		System.out.println(  ch );
		
		
		//���������� �迭�� �ʱ�ȭ
		String[] arr13= new String[] {new String("Hello"), new String("nice"), new String("android")};
		String[] arr14= new String[] {"Hello", "nice", "android"};
		String[] arr15= {"Hello", "nice", "android"};
		
		//�� �ٸ� ������..
		Random[] arr16= new Random[3];
		arr16[0]= new Random();
		int m=arr16[0].nextInt();
		
		Random[] arr17= new Random[] { new Random(), new Random(), new Random() };
		Random[] arr18= { new Random(), new Random(), new Random() };
		
		
		//for each��..(Ȯ���� for��)
		for(int i=0; i<arr.length; i++) {			
			//arr[i]= scan.nextInt();			
		}
		
		//foreach
		for( int t : arr ) {
			t=40;
		}
		
		for( int t : arr ) {
			System.out.println( t );
		}
		
		String[] arr19= new String[3];
		arr19[0]= new String("Hello");
		arr19[1]= new String("nice");
		arr19[2]= new String("world");
		
		for( String t : arr19 ) {
			System.out.println( t.length() );
		}
		
		
		
		
		AAA[] aaa= new AAA[3];
		aaa[0]= new AAA();
		aaa[1]= new AAA();
		aaa[2]= new AAA();
		
		aaa[0].num=10;
		aaa[1].num=100;
		aaa[2].num=1000;
		
		for( AAA t : aaa) {
			t.num=40;
		}
		
		for( AAA t : aaa) {
			System.out.println( t.num );
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}

class AAA{
	int num;
	int b;
}





