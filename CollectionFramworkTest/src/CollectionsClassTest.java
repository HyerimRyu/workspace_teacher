import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class CollectionsClassTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Collections클래스의 static메소드
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
		
		
		//Stack과 Queue자료구조에서의 용어와 메소드명 소개
		//1. Stack : push(요소추가), pop(요소 꺼내기) - FILO
		//2. Queue : offer(요소추가), poll(요소 꺼내기) - FIFO
		
		Stack<String> stack= null;
		stack.push("aaa");
		String s= stack.pop();		
		
		Queue<String> queue= null;
		queue.offer("aaa");
		String s2= queue.poll();
	}

}








