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
		//Set 인터페이스 : 순서대로X, index X, 중복Data허용 X
		
		//Set<String> set= new Set<String>();//error: 인터페이스는 객체생성불가!
		
		//Set인터페이스를 구현(implements)한 하위클래스를 객체로 만들어서 사용!
		//1. HashSet : 저장순서를 파악하기 어려움. 해시테이블이라는 것을 저장순서가 결정남. Set계열중에서 성능 가능 좋음.
		//2. TreeSet : 저장된 데이터의 값에 따라서 정렬되는 Set. red - black 트리기법 사용. HashSet 보다 성능이 약간 느림.
		//3. LinkedHashSet : 저장된 순서대로 값이 정렬됨. 성능이 가장 안좋음.
		
		//Set인터페이스도 Collection인터페이스를 상속하여 만들어진 만큼, Collection인터페이스의 (추상)메소드를 모두 가지고 있다고 확신할 수 있음.
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
		
		//요소 얻어오기.. get()메소드 없음: index번호가 없으므로!!
		
		//얻어오는 방법 : 차례로 접근하는 방법
		//방법1. foreach문...
		for( String t : hs) {
			System.out.println( t );
		}
		System.out.println();
		
		//방법2. 반복자(iterator)
		Iterator<String> datas= hs.iterator();		
		while( datas.hasNext() ) {			
			String s= datas.next();
			System.out.println( s );			
		}
		System.out.println();
		
		//방법3. Array로 변경해서 접근
		String[] arr= new String[hs.size()]; //Set과 같은 개수의 배열만들기
		hs.toArray(arr);//배열요소에 값 copy해주기!!
		
		System.out.println( Arrays.toString(arr) );
		
		
		//사용자정의 클래스의 Set사용시...	
		HashSet<AAA> hs1= new HashSet<AAA>();
		hs1.add( new AAA(10) );
		hs1.add( new AAA(20) );
		hs1.add( new AAA(10) );
		System.out.println( hs1.toString() );
		
		//사용자정의 클래스의 경우 같은 데이터인지 비교하려면...
		//클래스를 설계할 때, hashCod()와  equals()를 오버라이드 해야만 함.
		HashSet<BBB> hs2= new HashSet<BBB>();
		hs2.add( new BBB(10) );
		hs2.add( new BBB(20) );
		hs2.add( new BBB(10) );
		System.out.println( hs2.toString() );
		
		//TreeSet은 데이터의 값에 따라 오름차순으로 정렬!!
		// : Comparable인터페이스를 구현한 클래스만 TreeSet에서 정렬가능함!!
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
		return a-arg0.a; //결과가 음수면 내가 앞, 양수면 내가  뒤!!
		//return arg0.a-a;//내림차순
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
		return a;//멤버변수값을 리턴시키도록!
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














