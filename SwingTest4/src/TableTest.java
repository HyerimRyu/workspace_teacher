import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;

public class TableTest extends JFrame{
	
	public TableTest() {
		// TODO Auto-generated constructor stub
		setTitle("ȸ����� ��� Table");
		setBounds(200, 100, 350, 220);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//ǥ�� �� �׸��(ĭ����:column�� ����)
		String[] colNames=new String[] {"Name", "Age", "Gender", "Address"};
		
		//ǥ�� �� �����͵�
		Object[][] datas= {
				{ "sam" , 20 , "male" , "seoul" },
				{ "robin" , 25 , "female" , "new york" },
				{ "hong" , 27 , "male" , "tokyo" },
				{ "kim" , 28 , "female" , "busan" },
				{ "lee" , 30 , "male" , "LA" }
		};
		
		//���� ���� ����� �����͵�� ǥ(Table)�����
		JTable table= new JTable(datas, colNames);
		//add(table, BorderLayout.CENTER);//ǥ�Ʒ����� �Ⱥ��� �� ����.
		JScrollPane scrollPane= new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
		
		JButton btn= new JButton("BUTTON");
		add(btn, BorderLayout.SOUTH);
		
		//��ưŬ������ �� ���̺��� ������ �о�ͼ� �ܼ�â�� ����غ���~!!!
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//JTable�ȿ��� ���� ǥ(table)�� �����͸� �����ϴ� ��ü ������!
				TableModel model= table.getModel();
				
				//�÷�(��, ĭ)�� ���� ������
				int colCnt= model.getColumnCount();
				
				//�÷��� ������ͼ� ����ϱ�!
				for(int i=0; i<colCnt; i++) {
					String colName= model.getColumnName(i);
					System.out.print(colName+"\t");
				}
				System.out.println();
				
				//�� ��(row)�� �ִ� ������ ������!
				int rowCnt= model.getRowCount();
				for(int i=0; i<rowCnt; i++) {
					
					for(int k=0; k<colCnt; k++) {						
						Object obj= model.getValueAt(i, k);
						System.out.print(obj+"\t");						
					}
					System.out.println();
					
				}
				
				
			}
		});
		
		
		//���̺��� ��ĭ(��:Cell)�� �޺��ڽ��������� ����
		JComboBox<String> comboBox= new JComboBox<String>();
		comboBox.addItem("seoul");
		comboBox.addItem("new york");
		comboBox.addItem("tokyo");
		comboBox.addItem("busan");
		comboBox.addItem("LA");
		
		//���̺��� �ϳ��� �÷�(��) ������!!
		TableColumn column= table.getColumnModel().getColumn(3);//�ε�����ȣ�� 3���� ��(column)
		column.setCellEditor(new DefaultCellEditor(comboBox));
		
		
		
		
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TableTest();
	}

}
