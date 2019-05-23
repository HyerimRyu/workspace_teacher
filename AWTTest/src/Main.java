import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//�ֻ��� �����̳� ��ü�� ����
		Frame f= new Frame("GUI TEST");
		f.setSize(500, 400);
		
		//x��ư Ŭ���ص� �ڵ����� Ŀ���� ����.
		//x��ư�� ������ �� �����ϰ� �ڵ�.
		WindowAdapter adapter= new WindowAdapter() {
			
			//Frame�� x��ư�� Ŭ���ϸ� �ڵ����� ����Ǵ� �޼ҵ�: �ݹ� �޼ҵ�
			@Override
			public void windowClosing(WindowEvent e) {
				//�� ������ â(window)�� ���ֱ�!!
				f.dispose();				
			}
		};
		
		f.addWindowListener(adapter);
		
		//�����̳� �ȿ� ������ ������Ʈ(�������)���� �߰��ϱ�!!
		
		//������Ʈ ����
		Button btn= new Button("Ȯ��");		
		Button btn2= new Button("���");
		Button btn3= new Button("Hello world");
		//btn3���� Ŭ�������� �۾� �����ϱ�!!
		//btn3��ü�� Ŭ���Ǿ������� �ٶ󺸰� �ִ� ����Ŀ��ü ���� �� �ٿ��ֱ�
		btn3.addActionListener(  new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				btn3.setLabel("Nice Java");
			}
			
		});
		
		
		//������Ʈ ��ġ�� ��� ���� �����ϴ� LayoutManager��ü�� ����
		FlowLayout layout= new FlowLayout();//���ʷ� ������ ��ġ�ϴ� �༮
		f.setLayout(layout);
		
		//������� ��ư�� �����̳�(Frame)�� �߰�!
		f.add(btn);
		f.add(btn2);
		f.add(btn3);
		
		
		//ȭ�鿡 ������!!
		f.setVisible(true);

	}

}







