
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//��, �ۿ� ĳƽ������ 3����(Dog, Cat, Pig)
		
		Dog d= new Dog();
		Cat c= new Cat();
		Pig p= new Pig();
		
		d.say();
		c.say();
		p.say();
		System.out.println();
		
		//���� �̷� �����鰴ü���� �����������???
		//Dog�� 5����, Cat�� 10����, Pig 4����..
		//�̷����̸�..
		//�迭�� ó���ϸ� �ݺ��������..�ս��� ���α׷�����
		//�������ٵ�.. 3���� Ŭ������ ���δٸ� �ڷ����̹Ƿ�
		//�ѹ��� �迭�� ���°� �Ұ�����.
		//Dog[] arr= new Dog[5];
		
		//�̷��� Dog,Cat,Pig�� Animal�� ��Ӱ�����!!!
		//AnimalŬ���� ����
		
		Animal ani= new Dog(); //�� ĳ���� : �θ����������� �ڽİ�ü �����ϱ�
		Animal ani2= new Cat();
		Animal ani3= new Pig();
		
		ani.say();
		ani2.say();
		ani3.say();
		System.out.println();
		
		//���� ���� ���� �����ϴٸ�.. �迭��..���� Animal������ ��ü�� ������ �� ����.
		Animal[] anis= new Animal[5];
		System.out.println( anis[0] );
		System.out.println( anis[1] );
		System.out.println( anis[2] );
		System.out.println( anis[3] );
		System.out.println( anis[4] );
		System.out.println();
		
		//anis[0].say();//null ����!!
		
		anis[0]= new Dog();
		anis[1]= new Cat();
		anis[2]= new Cat();
		anis[3]= new Pig();
		anis[4]= new Dog();
		
		System.out.println( anis[0] );
		System.out.println( anis[1] );
		System.out.println( anis[2] );
		System.out.println( anis[3] );
		System.out.println( anis[4] );
		System.out.println();
		
		anis[0].say();
		anis[1].say();
		anis[2].say();
		anis[3].say();
		anis[4].say();
		System.out.println();
		
		//���� ó���� �ݺ������� �ۼ�����..
		for(int i=0; i<5; i++) {
			anis[i].say();
		}
		System.out.println();
		
		//foreach�� �̿�...
		for( Animal t : anis) {
			t.say();
		}
		
		
		
		
		
		
		

	}

}








