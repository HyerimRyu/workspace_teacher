import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Frame����� ���
		//���1. ��ü�� ������ ���� �޼ҵ���� ȣ���ؼ� �����ϴ� ���!
		JFrame frame= new JFrame();
		frame.setSize(300, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//���2. JFrame��ӹ��� Ŭ������ü�� ����� �� Ŭ������ �����ھȿ��� �����۾��Ϸ�!
		//TestFrame f= new TestFrame();
		
		//���3. main()�޼ҵ带 ������ Main Class�� Ŭ�����ϱ� �� ģ���� Ȱ���ϱ�!!
		//JFrame�� ��ӹް� main()�޼ҵ嵵 ������ MyFrame����!!
		
		//JFrame�� ������ �޼ҵ��....
		
		//1. x��ư Ŭ������ ���α׷� ���ἳ��!!
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//JFrame.DO_NOTHING_ON_CLOSE : �ƹ����� ���°� ( AWT�� Frame )
		//JFrame.DISPOSE_ON_CLOSE : ������ ����� ���α׷����ᰡ ������ ��!!
		//JFrame.EXIT_ON_CLOSE : �����������ϸ� ���α׷��� ����!
		//JFrame.HIDE_ON_CLOSE : (�⺻��)	- �����Ӹ� �������� ���α׷��� ������ ����.
		
		
		//2. �������� ȭ�鿡�� ��Ÿ���� ��ġ. 
		frame.setLocation(100, 200); //�����ӻ����� �»������ ��ǥ
		
		//2-1. �������� ȭ���� �� ����� ��ġ..(��� : ������� ������, �������� ������)
		//��ũ�� ������ ������		
		Toolkit toolkit= Toolkit.getDefaultToolkit(); //�ü�� �븮�� ������
		Dimension screenSize= toolkit.getScreenSize(); 
		//System.out.println(screenSize.getWidth()+ " * " + screenSize.getHeight());
		
		int width= (int)screenSize.getWidth();
		int height= (int)screenSize.getHeight();
		
		frame.setLocation(width/2-150, height/2-100);
		
		//3. location + size �ѹ濡 ����!
		frame.setBounds(10, 20, 500, 300);
		
		//4. �������� ������ ���� ��뿩��
		frame.setResizable(false); //�⺻: true
		
		//5. �������� �������� �ʵ��� ���� ������ ��ġ..
		frame.setAlwaysOnTop(true);
		
		//6. �����ӿ� Ÿ��Ʋ
		frame.setTitle("JFrame Test");
		
		//7. �������� �����ܺ���
		Image img= toolkit.getImage("images/ms21.png");		
		frame.setIconImage(img);
		
		//8. ������Ʈ �߰�!!//�ݵ�� �߰��� setVisible()���� ���� �ۼ��Ǿ� �־�� ��.
		JButton btn= new JButton("Button");
		frame.add(btn);
		
		frame.setVisible(true);
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//9. ������Ʈ ����!!
		frame.remove(btn);
		
		//10. ������Ʈ�� ������ �����ϱ����� ȭ�鰻��!!
		frame.repaint();//�ٽ� �׷�!!!
		//SwingUtilities.updateComponentTreeUI(frame);
		
		
		// �ֻ��� Container( JFrame )�� ��ٷ� ������Ʈ��(JButton..etc)�� �߰��ϴ� ����� ��ȣ���� ����.
		// �Ϲ� Container�� JPanel(�г�) �̿��ϱ�...
		// JPanelTest.java...
		
		
		
		
//		for(int i=0; i<20; i++) {
//			System.out.println(i);
//			try {
//				Thread.sleep(500);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
		
			

	}//main method..

}//Main Class..

class TestFrame extends JFrame{
	//�����Ҷ� �ڵ����� ���صǴ� �޼ҵ� : ������
	public TestFrame() {
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}










