package bbb;

import aaa.AAA;

public class BBB extends AAA{
	
	//이미 멤버변수가 4개 존재함. 상속받았으니까....
	
	void show() {
		//System.out.println(a);
		//System.out.println(b);//패키지가 다르면 사용불가!
		System.out.println(c);//패키기자 달라도 상속이라면 사용가능
		System.out.println(d);
	}

}
