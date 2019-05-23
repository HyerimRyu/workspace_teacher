import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�ִϸ�����(Dog, Cat, Pig) ��ü���� ������ �ִϸְ��尴ü ����
		AnimalFactory af= new AnimalFactory();
		
		Dog d= (Dog)af.makeAnimal(1);
		d.say();
		d.guardHouse();
		
		Cat c= (Cat)af.makeAnimal(2);
		c.say();
		c.handleDeacon();
		
		Pig p= (Pig)af.makeAnimal(3);
		p.say();
		p.eatAndEat();
		System.out.println();
		
		Animal ani;
		ani= af.makeAnimal(1); //Dog
		ani.say();
		ani.sleep();
		Dog dog= (Dog)ani; //�ٿ�ĳ����
		dog.guardHouse();
		
		ani= af.makeAnimal(2);
		ani.say();
		((Cat)ani).handleDeacon();
		
		ani= af.makeAnimal(3);
		ani.say();
		((Pig)ani).eatAndEat();
		
		//makeAnimal() : ���ް��� �����ϸ� ������ ��ü ���� ����
		
		
		//���������� �ٷ���� �迭��!!
		System.out.println();
		
		Random rnd= new Random();
		
		Animal[] anis= new Animal[5];
		for(int i=0; i<5; i++) {
			int n= rnd.nextInt(3)+1;//1,2,3
			
			anis[i]= af.makeAnimal(n);
		}
		
		//�� ��ü���� ��� ȣ��
		for(int i=0; i<anis.length; i++) {
			anis[i].say();
			anis[i].sleep();
			
			//�� �迭��Ұ�ü��(Dog or Cat or Pig)
			//�� ������ɵ� ����!!
			//Animal ���������� ����Ű�� ��ü�� 
			//� Ŭ�������� �˷��ִ� '������'!
			if( anis[i] instanceof Dog ) {
				
				Dog d4= (Dog)anis[i];//�ٿ�ĳ����
				d4.guardHouse();	
				
			}else if( anis[i] instanceof Cat) {
				
				((Cat)anis[i]).handleDeacon();
				
			}else if( anis[i] instanceof Pig) {
				
				((Pig)anis[i]).eatAndEat();
			}
			
		}
		
		
		//�Ǽ��� Animal��ü�� �����???
		//Animal ���������� ������ֱ� ���ؼ�..��ü��������X
		//�Ǽ��� Animal��ü�� �����Ǵ� ���� �������ؼ�..
		//Animal�� �߻�Ŭ����(abstract class)�� �����ϱ�!!!!
		
		//�߻�Ŭ������ ��ü����(new)�� �Ұ���!!error
		//Animal ani5= new Animal();
		//ani5.say(); // ???
		
		
		
		

	}

}






