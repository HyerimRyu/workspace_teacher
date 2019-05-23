import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		//키-벨류 쌍( key-value pair)으로 데이터를 저장하는 방식!!
		
		//Map도 인터페이스이므로 직접 객체생성 불가!!
		//Map인터페이스를 구현한 하위 클래스들을 객체로 만들어서 사용.
		
		//1. HashMap : 저장순서 상관없음. 저장순서파악 어려움. Map중에서 성능 가장 좋음.
		//2. TreeMap : 값(키값의 순서에 따라) 에 따라 오름차순 정렬
		//3. LinkedHashMap : 저장된 순서대로 정렬됨. 성능 가장 안 좋음.
		//4. HashTable : HashMap과 99%같음. (멀티스레드일때 동기화 처리되어 있음)
		
		//Map인터페이스는 Collection인터페이스를 상속하지 않았으므로..
		//Collection인터페이스의 (추상)메소드를 모두 가지고 있다고 확실 할 수 없음.
		//ex) add(), remove()이런것을 가지고 있다고 확신할 수 없음.		
		//실제로 add()메소드 없음.!!!
		
		//<키 타입, 벨류 타입> //<-각각 참조형만 가능함.
		HashMap<String, String> map= new HashMap<String, String>();
		//TreeMap<String, String> map= new TreeMap<String, String>();
		//LinkedHashMap<String, String> map= new LinkedHashMap<String, String>();
		
		//요소추가
		map.put("Name", "Hong");
		map.put("Id", "abcd");
		map.put("Pass", "1234");
		map.put("kkk", "Hong");//키값은 다르고, 벨류는 같은 상황은 입력가능함.
		map.put("kkk", "asdf");//키값이 중복되면 저장이 안되는 것이 아니라 덮어쓰기가 되는 것임.
		map.put("A", "1");
		map.put("B", "10");
		
		System.out.println( map.size() );
		//요소얻어오기
		System.out.println( map.get("Name") );
		System.out.println( map.get("Id") );
		System.out.println( map.get("Pass") );
		System.out.println( map.get("kkk") );
		System.out.println( map.toString() );
		
		//순차적으로 저장된 값들 모두 얻어와서 출력하기!!
		//index가 없으므로 for문으로는 불가능
		//foreach문...도 문법적으로 안됨!!!
		
		//방법1. 
		//일단, Map에서 키값들만 쭉 뽑아와서 처리...
		Set<String> keys= map.keySet();
		//1-1. key값들을 foreach문으로 접근하기
		for( String key : keys ) {
			String value= map.get(key);
			System.out.println(key+ " : " + value );
		}
		System.out.println();
		
		//1-2. key값을 가지고 있는 Set의 iterator(반복자)를 이용
		Iterator<String> iterator= keys.iterator();
		while( iterator.hasNext() ) {
			String key= iterator.next();
			System.out.println(key +" : "+ map.get(key) );
		}
		
		
		//방법2. 
		//Map의 요소(키-벨류쌍) 객체인 Entry의 Set얻어오기
		Set<Entry<String, String>> entries= map.entrySet();
		//Entry를 가지고 하는 방법은 방법1과 같음.
		for( Entry<String, String> e : entries ) {
			System.out.println( e.getKey() +" : "+ e.getValue() );			
		}
		
		
		
		//식별자(Key)를 int형으로 사용하기
		HashMap<Integer, String> map2= new HashMap<Integer, String>();
		
		map2.put(new Integer(0), "aaa");
		map2.put(1, "bbb");//자동 new Integer(1)- 오토박싱
		map2.put(2, "ccc");
		
		String s1= map2.get(new Integer(0));
		String s2= map2.get(1);
		String s3= map2.get(2);
		
		for(int i=0; i<map2.size(); i++) {
			String s= map2.get(i);
			System.out.println( s );
		}
		
		
		
		
		
	}

}








