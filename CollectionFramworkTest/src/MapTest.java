import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class MapTest {

	public static void main(String[] args) {
		//Ű-���� ��( key-value pair)���� �����͸� �����ϴ� ���!!
		
		//Map�� �������̽��̹Ƿ� ���� ��ü���� �Ұ�!!
		//Map�������̽��� ������ ���� Ŭ�������� ��ü�� ���� ���.
		
		//1. HashMap : ������� �������. ��������ľ� �����. Map�߿��� ���� ���� ����.
		//2. TreeMap : ��(Ű���� ������ ����) �� ���� �������� ����
		//3. LinkedHashMap : ����� ������� ���ĵ�. ���� ���� �� ����.
		//4. HashTable : HashMap�� 99%����. (��Ƽ�������϶� ����ȭ ó���Ǿ� ����)
		
		//Map�������̽��� Collection�������̽��� ������� �ʾ����Ƿ�..
		//Collection�������̽��� (�߻�)�޼ҵ带 ��� ������ �ִٰ� Ȯ�� �� �� ����.
		//ex) add(), remove()�̷����� ������ �ִٰ� Ȯ���� �� ����.		
		//������ add()�޼ҵ� ����.!!!
		
		//<Ű Ÿ��, ���� Ÿ��> //<-���� �������� ������.
		HashMap<String, String> map= new HashMap<String, String>();
		//TreeMap<String, String> map= new TreeMap<String, String>();
		//LinkedHashMap<String, String> map= new LinkedHashMap<String, String>();
		
		//����߰�
		map.put("Name", "Hong");
		map.put("Id", "abcd");
		map.put("Pass", "1234");
		map.put("kkk", "Hong");//Ű���� �ٸ���, ������ ���� ��Ȳ�� �Է°�����.
		map.put("kkk", "asdf");//Ű���� �ߺ��Ǹ� ������ �ȵǴ� ���� �ƴ϶� ����Ⱑ �Ǵ� ����.
		map.put("A", "1");
		map.put("B", "10");
		
		System.out.println( map.size() );
		//��Ҿ�����
		System.out.println( map.get("Name") );
		System.out.println( map.get("Id") );
		System.out.println( map.get("Pass") );
		System.out.println( map.get("kkk") );
		System.out.println( map.toString() );
		
		//���������� ����� ���� ��� ���ͼ� ����ϱ�!!
		//index�� �����Ƿ� for�����δ� �Ұ���
		//foreach��...�� ���������� �ȵ�!!!
		
		//���1. 
		//�ϴ�, Map���� Ű���鸸 �� �̾ƿͼ� ó��...
		Set<String> keys= map.keySet();
		//1-1. key������ foreach������ �����ϱ�
		for( String key : keys ) {
			String value= map.get(key);
			System.out.println(key+ " : " + value );
		}
		System.out.println();
		
		//1-2. key���� ������ �ִ� Set�� iterator(�ݺ���)�� �̿�
		Iterator<String> iterator= keys.iterator();
		while( iterator.hasNext() ) {
			String key= iterator.next();
			System.out.println(key +" : "+ map.get(key) );
		}
		
		
		//���2. 
		//Map�� ���(Ű-������) ��ü�� Entry�� Set������
		Set<Entry<String, String>> entries= map.entrySet();
		//Entry�� ������ �ϴ� ����� ���1�� ����.
		for( Entry<String, String> e : entries ) {
			System.out.println( e.getKey() +" : "+ e.getValue() );			
		}
		
		
		
		//�ĺ���(Key)�� int������ ����ϱ�
		HashMap<Integer, String> map2= new HashMap<Integer, String>();
		
		map2.put(new Integer(0), "aaa");
		map2.put(1, "bbb");//�ڵ� new Integer(1)- ����ڽ�
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








