import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//-������ �������̽��� �����ϰ� �߻�޼ҵ��� �̸��� ���ϸ� ��������
		// �� �̸��� ���� ����� �����Ͽ� Ŭ������ ������.
		// ���� : Unit �������̽� ����..
		// ����1 : MarineŬ���� ���� �� Uint ����..// �����̶�� �������� �⺻ ��� ����..(�޼ҵ� �̸� ����)
		// ����2 : TankŬ���� ���� �� Unit ����..
		// ����3 : RaceŬ���� ���� �� Uint ����..
		
		// Marine, Tank, Race��ü�� attack(), move()����� ������ Ȯ���� �� ����.
		
		
		//������ ������� Ŭ������ �̿��Ͽ� ��ü���� �� ���Ӿ˰����� �ڵ�!!!
		
		//�迭�� �̹� ���ֵ��� ������ �����ؾ߸� ��..(����)
		//���� ������ ������ ������ ���������� �����.(���� �� �Ҹ� �ݺ�!!)
		//Unit[] units= new Unit[200];
		//������ �迭.. ArrayListŬ���� �̿�!!
				
		ArrayList<Unit> units= new ArrayList<Unit>();
		//����� ���� �˾Ƴ���!
		int num= units.size();
		System.out.println("��Ұ��� : "+ units.size() );
		
		//�迭�� Unit��ü�� �����Ͽ� �߰�		
		units.add(new Marine());
		units.add(new Tank());
		units.add(new Marine());
		units.add(new Race());
		
		System.out.println("��Ұ��� : "+ units.size() );
		
//		for(int i=0; i<units.size(); i++) {
//			Unit u= units.get(i);
//			u.attack();
//			u.move();
//			
//			System.out.println();
//		}
		
		//foreach��...
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







