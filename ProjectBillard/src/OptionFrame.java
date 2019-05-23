import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class OptionFrame extends JFrame {	
	
	private JTable billiardCharge;
	private ArrayList<DrinkList> drinkList= new ArrayList<>();
	
	public OptionFrame() {
		// TODO Auto-generated constructor stub

		Toolkit toolkit= Toolkit.getDefaultToolkit();
		setIconImage(toolkit.getImage("images/OptionIcon.png"));
		
		JPanel optionPanel = new JPanel();
		optionPanel.setLayout(new BorderLayout());

		TimeThread timeThread = new TimeThread();
		timeThread.setDaemon(true);
		timeThread.start();

		optionPanel.add(timeThread.getTimeLabel(), BorderLayout.NORTH);

		JPanel editPanel = new JPanel();
		editPanel.setLayout(new GridLayout(0, 1));
		optionPanel.add(editPanel, BorderLayout.CENTER);

		JPanel billiardChargePanel= new JPanel();
		billiardChargePanel.setLayout(new BorderLayout());
		
		try {
			FileReader fourFileReader = new FileReader("Text/Four.txt");
			BufferedReader fourBufReader = new BufferedReader(fourFileReader);
			
//			FileReader threeFileReader = new FileReader("Text/Three.txt");
//			BufferedReader threeBufReader = new BufferedReader(threeFileReader);
			
			FileReader pocketFileReader = new FileReader("Text/Pocket.txt");
			BufferedReader pocketBufReader = new BufferedReader(pocketFileReader);
			
			String[] billiardEdit1 = { "종목", "10분당 요금", "기본요금" };
			String[][] billiardEdit2 = { 
					{ "4구 / 3구", fourBufReader.readLine(), fourBufReader.readLine() }, 
//					{ "3구", threeBufReader.readLine(), threeBufReader.readLine() }, 
					{ "포켓볼", pocketBufReader.readLine(), pocketBufReader.readLine() } 
			};
			
			fourFileReader.close();
//			threeFileReader.close();
			pocketFileReader.close();
			
			DefaultTableModel billiardModel = new DefaultTableModel(billiardEdit2, billiardEdit1);
			billiardCharge = new JTable(billiardModel);
			JScrollPane scrollBilliardCharge = new JScrollPane(billiardCharge);
			scrollBilliardCharge.getViewport().setBackground(new Color(0, 104, 56));
			
			scrollBilliardCharge.setBorder(BorderFactory.createTitledBorder("당구 요금"));
			
			billiardChargePanel.add(scrollBilliardCharge, BorderLayout.CENTER);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		editPanel.add(billiardChargePanel);
		
		JButton btnSaveBC = new JButton();
		btnSaveBC.setText("SAVE");
		btnSaveBC.setBackground(Color.WHITE);
		btnSaveBC.setForeground(new Color(0, 104, 56));
		btnSaveBC.setFont(new Font("mexcellent 3d", Font.PLAIN, 30));
		
		btnSaveBC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					for(int i=1; i<billiardCharge.getRowCount(); i++) {
						for(int j=0; j<3; j++) {
							Integer.parseInt((String)billiardCharge.getValueAt(j, i));
						}
					}
					
					FileWriter fourFileWriter = new FileWriter("Text/Four.txt");
//					FileWriter threeFileWriter = new FileWriter("Text/Three.txt");
					FileWriter pocketFileWriter = new FileWriter("Text/Pocket.txt");

					for(int i=1; i<billiardCharge.getRowCount(); i++) {
						fourFileWriter.write((String)billiardCharge.getValueAt(0, i)+"\n");
//						threeFileWriter.write((String)billiardCharge.getValueAt(1, i)+"\n");
						pocketFileWriter.write((String)billiardCharge.getValueAt(2, i)+"\n");
					}
					
					fourFileWriter.close();
//					threeFileWriter.close();
					pocketFileWriter.close();
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(editPanel, "요금은 숫자를 입력해야 합니다.");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		billiardChargePanel.add(btnSaveBC, BorderLayout.SOUTH);
		
		JPanel drinkChargePanel= new JPanel();
		drinkChargePanel.setLayout(new BorderLayout());
		
		String[] drinkEdit1 = {"No", "먹거리", "가격", "재고수량"};
		
		DefaultTableModel drinkModel = new DefaultTableModel(drinkEdit1, 0);
		JTable drinkListTable= new JTable(drinkModel);
		JScrollPane scrollDrinkCharge = new JScrollPane(drinkListTable);
				
		for(int i=0; i<new File("Drink").listFiles().length; i++) {
			try {
				File drinkFile= new File("Drink/" + i + ".txt");
				FileReader drinkFileReader = new FileReader(drinkFile);
				BufferedReader drinkBF = new BufferedReader(drinkFileReader);
				String[] drinkDatas= { drinkBF.readLine(), drinkBF.readLine(), drinkBF.readLine(), drinkBF.readLine() };
				drinkList.add(new DrinkList( drinkDatas[1], Integer.parseInt(drinkDatas[2]), Integer.parseInt(drinkDatas[3]) ));
				drinkModel.addRow(drinkDatas);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		scrollDrinkCharge.setBorder(BorderFactory.createTitledBorder("먹거리 요금"));
		scrollDrinkCharge.getViewport().setBackground(new Color(0, 104, 56));
		
		JPanel drinkChargePanel2 = new JPanel();
		drinkChargePanel2.setLayout(new BorderLayout());
		
		drinkChargePanel2.add(scrollDrinkCharge, BorderLayout.CENTER);
		
		JPanel drinkEditPanel= new JPanel();
		drinkEditPanel.setBackground(Color.WHITE);
		
		JTextField drinkNameField= new JTextField(15);
		JLabel drinkNameLabel= new JLabel("먹거리");
		JTextField drinkPriceField= new JTextField(15);
		JLabel drinkPriceLabel= new JLabel("가격");
		JTextField drinkStockField= new JTextField(15);
		JLabel drinkStockLabel= new JLabel("재고수량");
		
		JButton drinkAddBtn= new JButton();
		drinkAddBtn.setText("ADD");
		drinkAddBtn.setBackground(new Color(0, 104, 56));
		drinkAddBtn.setForeground(Color.WHITE);
		
		drinkAddBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					
					drinkList.add(new DrinkList(drinkNameField.getText(), Integer.parseInt(drinkPriceField.getText()), Integer.parseInt(drinkStockField.getText())));
				
				}catch(NumberFormatException e){
					JOptionPane.showMessageDialog(editPanel, "가격과 수량에는 숫자를 입력해야 합니다.");
				}				
				
				drinkModel.setNumRows(0);

				for(int i=0; i<drinkList.size(); i++) {
					String drinkName= drinkList.get(i).getDrinkName();
					int drinkPrice= drinkList.get(i).getDrinkPrice();
					int drinkStock= drinkList.get(i).getDrinkStock();
					
					String[] drinkDatas= { i+1+"", drinkName, drinkPrice+"", drinkStock+"" };
					drinkModel.addRow(drinkDatas);
				}
				
				drinkNameField.setText("");
				drinkPriceField.setText("");
				drinkStockField.setText("");
			}
		});
		
		JButton drinkDelBtn= new JButton();
		drinkDelBtn.setText("DEL");
		drinkDelBtn.setBackground(new Color(0, 104, 56));
		drinkDelBtn.setForeground(Color.WHITE);
		
		drinkDelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				int rowNum= drinkListTable.getSelectedRow();
				if(rowNum==-1) return;
				drinkList.remove(rowNum);
				drinkModel.setNumRows(0);
				
				for(int i=0; i<drinkList.size(); i++) {
					String drinkName= drinkList.get(i).getDrinkName();
					int drinkPrice= drinkList.get(i).getDrinkPrice();
					int drinkStock= drinkList.get(i).getDrinkStock();
					String[] drinkDatas= { i+1+"", drinkName, drinkPrice+"", drinkStock+"" };
					drinkModel.addRow(drinkDatas);
				}
				
			}
		});
		
		drinkEditPanel.add(drinkNameLabel);
		drinkEditPanel.add(drinkNameField);
		drinkEditPanel.add(drinkPriceLabel);
		drinkEditPanel.add(drinkPriceField);
		drinkEditPanel.add(drinkStockLabel);
		drinkEditPanel.add(drinkStockField);
		drinkEditPanel.add(drinkAddBtn);
		drinkEditPanel.add(drinkDelBtn);

		drinkChargePanel2.add(drinkEditPanel, BorderLayout.SOUTH);
		
		drinkChargePanel.add(drinkChargePanel2, BorderLayout.CENTER);
	
		JButton btnSaveDC = new JButton();
		btnSaveDC.setText("SAVE");
		btnSaveDC.setBackground(Color.WHITE);
		btnSaveDC.setForeground(new Color(0, 104, 56));
		btnSaveDC.setFont(new Font("mexcellent 3d", Font.PLAIN, 30));
		
		btnSaveDC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				File drinkFile;
				File deleteFile;
				File[] deleteFiles;
				
				FileWriter drinkFileWriter;
				PrintWriter drinkPrintWriter;
				
				for(int i=0; i<drinkList.size(); i++) {
					try {
						drinkFile= new File("Drink/" + i + ".txt");
						drinkFileWriter= new FileWriter(drinkFile);
						drinkPrintWriter= new PrintWriter(drinkFileWriter);
						
						for(int j=0; j<drinkModel.getColumnCount(); j++) {
							drinkPrintWriter.println((String)drinkModel.getValueAt(i, j));;
						}
						
						drinkFileWriter.flush();
						drinkFileWriter.close();
						
						deleteFile= new File("Drink");
						deleteFiles= deleteFile.listFiles();
						
						for(int k=drinkModel.getRowCount(); k<deleteFiles.length; k++) {
							deleteFiles[k].delete();
						}
						
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		
		drinkChargePanel.add(btnSaveDC, BorderLayout.SOUTH);
		
		editPanel.add(drinkChargePanel);
		
		add(optionPanel);
		setTitle("Option");
		setBounds(100, 100, 800, 600);
		setVisible(true);

	}

}
