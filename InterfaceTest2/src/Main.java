import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//-팀장이 인터페이스를 설계하고 추상메소드의 이름을 정하면 팀원들은
		// 그 이름을 토대로 기능을 구현하여 클래스를 설계함.
		// 팀장 : Unit 인터페이스 설계..
		// 팀원1 : Marine클래스 정의 및 Uint 구현..// 유닛이라면 가져야할 기본 기능 구현..(메소드 이름 통일)
		// 팀원2 : Tank클래스 정의 및 Unit 구현..
		// 팀원3 : Race클래스 정의 및 Uint 구현..
		
		// Marine, Tank, Race객체는 attack(), move()기능이 있음을 확신할 수 있음.
		
		
		//팀장은 만들어진 클래스를 이용하여 객체생성 및 게임알고리즘을 코딩!!!
		
		//배열은 이미 유닛들의 개수를 고정해야만 함..(단점)
		//실제 게임은 유닛의 개수가 지속적으로 변경됨.(생성 및 소멸 반복!!)
		//Unit[] units= new Unit[200];
		//유동적 배열.. ArrayList클래스 이용!!
				
		ArrayList<Unit> units= new ArrayList<Unit>();
		//요소의 개수 알아내기!
		int num= units.size();
		System.out.println("요소개수 : "+ units.size() );
		
		//배열에 Unit객체들 생성하여 추가		
		units.add(new Marine());
		units.add(new Tank());
		units.add(new Marine());
		units.add(new Race());
		
		System.out.println("요소개수 : "+ units.size() );
		
//		for(int i=0; i<units.size(); i++) {
//			Unit u= units.get(i);
//			u.attack();
//			u.move();
//			
//			System.out.println();
//		}
		
		//foreach문...
		for( Unit u : units ) {
			u.attack();
			u.move();
			
			if( u instanceof Levelupable ) {
				Levelupable a= (Levelupable)u;
				a.levelUp();
			}		
			
			
			System.out.println();			
		}
		
		
//		Unit k= new Marine();
//		k.attack();
//		k.move();
//		
//		Levelupable s= (Levelupable)k;
//		s.levelUp();
		
		
	
		
		
		
		

	}

}







