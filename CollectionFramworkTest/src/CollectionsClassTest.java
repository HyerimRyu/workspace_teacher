import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class CollectionsClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CollectionsŬ������ static�޼ҵ�
		//1) Collections.sort();
		//2) Collections.shuffle();
		//3) Coolections.binarySearch();
		
		
		ArrayList<String> datas= new ArrayList<String>();
		
		datas.add("asdfasd");
		datas.add("Nice");
		datas.add("World");
		datas.add("Hello");
		datas.add("hello");
		datas.add("World");		
		System.out.println( datas.toString() );
		
		Collections.sort(datas);
		System.out.println( datas.toString() );
		
		
		Collections.shuffle(datas);
		System.out.println( datas.toString() );
		
		
		//Stack�� Queue�ڷᱸ�������� ���� �޼ҵ�� �Ұ�
		//1. Stack : push(����߰�), pop(��� ������) - FILO
		//2. Queue : offer(����߰�), poll(��� ������) - FIFO
		
		Stack<String> stack= null;
		stack.push("aaa");
		String s= stack.pop();		
		
		Queue<String> queue= null;
		queue.offer("aaa");
		String s2= queue.poll();
	}

}








