import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Set �������̽� : �������X, index X, �ߺ�Data��� X
		
		//Set<String> set= new Set<String>();//error: �������̽��� ��ü�����Ұ�!
		
		//Set�������̽��� ����(implements)�� ����Ŭ������ ��ü�� ���� ���!
		//1. HashSet : ��������� �ľ��ϱ� �����. �ؽ����̺��̶�� ���� ��������� ������. Set�迭�߿��� ���� ���� ����.
		//2. TreeSet : ����� �������� ���� ���� ���ĵǴ� Set. red - black Ʈ����� ���. HashSet ���� ������ �ణ ����.
		//3. LinkedHashSet : ����� ������� ���� ���ĵ�. ������ ���� ������.
		
		//Set�������̽��� Collection�������̽��� ����Ͽ� ������� ��ŭ, Collection�������̽��� (�߻�)�޼ҵ带 ��� ������ �ִٰ� Ȯ���� �� ����.
		//ex). add(), remove(), clear(), size(), contains()...etc..
		
		HashSet<String> hs= new HashSet<String>();
		//TreeSet<String> hs= new TreeSet<String>();
		//LinkedHashSet<String> hs= new LinkedHashSet<String>();
		
		hs.add(new String("aaa"));
		hs.add("bbb");
		hs.add("ffc");
		hs.add("ggc");
		hs.add("ccc");
		hs.add("eee");
		hs.add("ddd");
		hs.add("ffc");
		hs.add("ggc");
		hs.add("ddc");
		
		System.out.println( hs.size() + " : " + hs.toString() );
		
		//��� ������.. get()�޼ҵ� ����: index��ȣ�� �����Ƿ�!!
		
		//������ ��� : ���ʷ� �����ϴ� ���
		//���1. foreach��...
		for( String t : hs) {
			System.out.println( t );
		}
		System.out.println();
		
		//���2. �ݺ���(iterator)
		Iterator<String> datas= hs.iterator();		
		while( datas.hasNext() ) {			
			String s= datas.next();
			System.out.println( s );			
		}
		System.out.println();
		
		//���3. Array�� �����ؼ� ����
		String[] arr= new String[hs.size()]; //Set�� ���� ������ �迭�����
		hs.toArray(arr);//�迭��ҿ� �� copy���ֱ�!!
		
		System.out.println( Arrays.toString(arr) );
		
		
		//��������� Ŭ������ Set����...	
		HashSet<AAA> hs1= new HashSet<AAA>();
		hs1.add( new AAA(10) );
		hs1.add( new AAA(20) );
		hs1.add( new AAA(10) );
		System.out.println( hs1.toString() );
		
		//��������� Ŭ������ ��� ���� ���������� ���Ϸ���...
		//Ŭ������ ������ ��, hashCod()��  equals()�� �������̵� �ؾ߸� ��.
		HashSet<BBB> hs2= new HashSet<BBB>();
		hs2.add( new BBB(10) );
		hs2.add( new BBB(20) );
		hs2.add( new BBB(10) );
		System.out.println( hs2.toString() );
		
		//TreeSet�� �������� ���� ���� ������������ ����!!
		// : Comparable�������̽��� ������ Ŭ������ TreeSet���� ���İ�����!!
		TreeSet<CCC> ts= new TreeSet<CCC>();
		ts.add(new CCC(10));
		ts.add(new CCC(20));
		ts.add(new CCC(40));
		ts.add(new CCC(50));
		ts.add(new CCC(30));
		System.out.println( ts.toString() );
		
		String s= "aaa";
		System.out.println(  s instanceof Comparable );
		System.out.println(  new CCC(10) instanceof Comparable );
		System.out.println(  new BBB(10) instanceof Comparable );
		System.out.println(  new Integer(10) instanceof Comparable );
		System.out.println(  new Double(10.5) instanceof Comparable );
		System.out.println(  new Boolean(true) instanceof Comparable );
		System.out.println(  new Character('A') instanceof Comparable );
		System.out.println(  new Random() instanceof Comparable );
		
		TreeSet<String> set4= new TreeSet<>( new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				//return o1.compareTo(o2);
				return o2.compareTo(o1);
			}
		});
		set4.add("aaa");
		set4.add("bbb");
		set4.add("aab");
		
		System.out.println( set4 );

	}

}


class CCC implements Comparable<CCC>{
	int a;
	public CCC(int a) {
		this.a= a;
	}

	@Override
	public int compareTo(CCC arg0) {
		// TODO Auto-generated method stub
		return a-arg0.a; //����� ������ ���� ��, ����� ����  ��!!
		//return arg0.a-a;//��������
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return a+"";
	}
	
}




class BBB{
	int a;
	public BBB(int a) {
		this.a= a;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return a;//����������� ���Ͻ�Ű����!
	}
	
	@Override
	public boolean equals(Object arg0) {
		// TODO Auto-generated method stub
		if( arg0 instanceof BBB) {
			BBB obj= (BBB)arg0;
			return this.a== obj.a;
		}
				
		return false;		
	}
}


class AAA{
	int a;
	public AAA(int a) {		
		this.a= a;
	}
}














