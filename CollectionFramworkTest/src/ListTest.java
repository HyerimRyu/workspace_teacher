import java.util.List;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//List는 인터페이스임. 직접 객체 생성이 불가!
		//List arr= new List();//error: 인터페이스는 바로 객체생성 불가!!
		
		//List인터페이스를 구현한 하위 클래스를 객체로 만들어 사용해야 함.
		//List계열 : ArrayList, LinkedList, Vector(멀티스레드 동기화가 되어 있음)
		
		//먼저, 가장 잘 알려지고 사용되었던 ArrayList 부터!!
		//ArrayList특징 : 빈번한 추가,삭제시에는 속도가 느림! 대신, 특정 요소를 접근하는 속도 빠름.
		ArrayList<String> arrList= new ArrayList<String>();
		
		//List가 가지고있는 주요 기능(메소드)들 알아보기
		//List는 Collection인터페이스를 상속받은 만큼 Collection인터페이스의 (추상)메소드를 가지고 있다고 확신할 수 있음.
		//ex) add(), remove(), clear(), size(), contains()...etc..
		
		//1.요소의 개수
		System.out.println("요소 개수 : "+arrList.size());
		
		//2.요소의 추가
		String s= new String("aa");
		arrList.add(s);
		arrList.add( new String("bb"));
		arrList.add( new String("cc"));
		System.out.println("요소 개수 : "+arrList.size());
		
		//3.요소 얻어오기
		String str= arrList.get(0);
		System.out.println(str);
		System.out.println(arrList.get(1));
		System.out.println(arrList.get(2));
		
		//4.요소 삭제하기
		arrList.remove(1);
		System.out.println("요소 개수 : "+arrList.size());
		System.out.println( arrList.get(0) );
		System.out.println( arrList.get(1) );
		//System.out.println( arrList.get(2) );//error
		
		//5. 특정위치에 요소추가하기
		arrList.add(1, "dd");
		System.out.println(arrList.get(0));
		System.out.println(arrList.get(1));
		System.out.println(arrList.get(2));
		
		
		//6. 제거할 때 인덱스 번호가 아닌 객체 참조주소로 제거 가능
		String s2= new String("Test");
		arrList.add(s2);
		System.out.println("요소 개수 : "+arrList.size());
		arrList.remove(s2);
		System.out.println("요소 개수 : "+arrList.size());
		
		//7. 요소 모두 지우기
		arrList.clear();
		System.out.println("요소 개수 : "+arrList.size());
		
		//8. 중복된 데이터의 추가 가능함.
		arrList.add("aa");
		arrList.add("aa");
		arrList.add("aa");
		System.out.println( arrList.get(0) );
		System.out.println( arrList.get(1) );
		System.out.println( arrList.get(2) );
		
		//9. 요소의 비교관련기능들
		//arrList.clear();
		System.out.println( arrList.isEmpty() );//비어 있는지 여부[true, false]
		System.out.println( arrList.contains("aa") );//그 데이터가 있는지 여부[true, false]
		System.out.println( arrList.contains("bb") );
		
		//10. 한번에 여러요소들 추가하기
		arrList.clear();
		arrList.add("aa");
		arrList.add("bb");
		arrList.add("cc");
		
		ArrayList<String> arrList2= new ArrayList<String>();
		arrList2.add("kk");
		arrList2.add("ss");
		
		arrList.addAll(arrList2);
		System.out.println( arrList.toString() );//자동 요소들을 [,,,]해서 출력해줌.(편의기능)
		
		//특정 위치에 여러개 한방에 추가하기
		arrList.addAll(1,arrList2);
		System.out.println( arrList.toString() );
		
		
		
		//11. 특정 요소들을 한방에 제거하기
		ArrayList<String> arrList3= new ArrayList<String>();
		arrList3.add("aa");
		arrList3.add("ss");
		arrList.removeAll(arrList3);
		System.out.println( arrList.toString() );
		
		//12. 특정 요소만 남기고 제거..
		arrList3.clear();
		arrList3.add("kk");
		arrList.retainAll(arrList3);//"KK"빼고 다 제거!!
		System.out.println( arrList.toString() );
		
		
		//13. 특정 요소들이 모두 포함되어 있는지 한방에 비교
		arrList.clear();
		arrList2.clear();
		
		arrList.add("aa");
		arrList.add("bb");
		arrList.add("cc");
		arrList.add("dd");
		arrList.add("ee");
		arrList.add("ff");
		arrList.add("cc");
		arrList.add("aa");
		arrList.add("gg");
		
		arrList2.add("aa");
		arrList2.add("dd");
		arrList2.add("kk");
		
		System.out.println( arrList.containsAll(arrList2) );
		
		
		//14. List계열에만 있는 기능!!
		//특정 요소가 몇번방에 있는지 -- 리턴값은 int형(방번호-index번호)
		System.out.println(  arrList.indexOf("cc")  );
		System.out.println(  arrList.lastIndexOf("cc")  );
		
		
		
		//요소들을 순차적으로 얻어오기..
		//방법1. for문 사용하기
		for(int i=0; i<arrList.size(); i++) {
			System.out.println( arrList.get(i) );
		}
		System.out.println();
		
		//방법2. foreach문 사용하기
		for( String t : arrList ) {
			System.out.println( t );
		}
		System.out.println();
		
		//방법3. 배열로 변경해서 출력!
		//즉, List객체를 --> 배열객체로 변환!!!
		String[] arr= new String[arrList.size()];
		arrList.toArray(arr);
		System.out.println( Arrays.toString(arr) );
		
		//방법4. iterator()..를 이용하는 기술!! -->Set수업때 사용해보기
		
				
/*		//*. 삭제에대한 고찰!!
		arrList.add("aa");
		arrList.remove(new String("aa"));//사실 제거의 정확한 기준: hashCode()의 리턴이 같고 equals()의 리턴값이 true면 remove가 됨.
		System.out.println("요소 개수 : "+arrList.size());		
		
		//사용자 정의 클래스의 객체 삭제에 대한 고찰!
		Person p1= new Person(10);
		Person p2= new Person(20);
		//p1, p2는 다른 객체임.		
		
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		System.out.println(p1.equals(p2));//true
		
		//Person을 끌고다니는 기차 객체(ArrayList)
		ArrayList<Person> persons= new ArrayList<Person>();
		System.out.println( persons.size() );
		
		persons.add(p1);
		persons.remove(p2);//안 지워져야 하지만 지워짐.왜? hashCode()이 같고 equals()의 리턴값이 true여야만 같은 객체로 봄.
		System.out.println( persons.size() );*/
		
		
		
		//List인터페이스 하위 클래스로 LinkedList도 있음.
		//LinkedList 특징 : 빈번한 추가, 삭제시에 속도 좋음. 특정 위치를 찾아가는데 시간이 걸림.
		//사용방법은 ArrayList와 완전 같음.- 단, 성능차이만 있음.
		
		LinkedList<String> linkList= new LinkedList<String>();
		
		linkList.add("aaa");
		linkList.add("bbb");
		linkList.add("ccc");
		
		//특이한 것!
		linkList.addFirst("kkk");
		linkList.addLast("ssss");
		
		System.out.println(linkList.toString());
		
		
		//배열을 리스트로 변경하기!!!
		String[] arr2= new String[] {"aaa","bbb", "ccc"};
		List<String> list= Arrays.asList(arr2);
		System.out.println( list.toString() );
		
		//List<> 부모참조변수로 모든 자식 객체들(ArrayList, LinkedList, Vector)를 참조하여 제어할 수 있음.
		List<String> li= null;
		li= new ArrayList<>(5);
		li= new LinkedList<>();
		li= new Vector<>();
		
		
		//제네릭을 사용해야함. 단, 제네릭은 반드시 참조형 자료형만 가능!
		//ArrayList<int> arrList5;//error : 기본형은 끌고 다닐 수없음.
		//대신에 Integer Wrapper클래스 이용가능
		ArrayList<Integer> arrList5= new ArrayList<Integer>();
		arrList5.add(new Integer(10));
		arrList5.add(20);//오토박싱
		arrList5.add(30);
		arrList5.add(40);
		
		int n= arrList5.get(0); //언 오토박싱
		System.out.println( n );
		
		
		

	}

}

class Person{
	static int k=0;
	int age;
	public Person(int age) {
		this.age= age;
		k++;
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return age;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Person p= (Person)obj;
		return age==p.age;
	}
	
	
}














