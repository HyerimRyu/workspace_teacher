
public class Tank implements Unit, Levelupable{

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("자주포 발사..");		
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("바퀴로 이동...");		
	}

	@Override
	public void levelUp() {
		// TODO Auto-generated method stub
		System.out.println("미친탱크로 변신!!!!");
	}

}



