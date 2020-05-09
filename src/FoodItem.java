
import java.awt.Color;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
public class FoodItem  extends JFrame implements ActionListener {
	
	private JLabel label1;
	
	private JPanel panel1;
	private static JTable foodTable;
	private JScrollPane scroll;
	private JButton updatebutton,buttonBack,buttonLogout;
	private AdminHome adminhomeInstance;
	private Login loginInstance;
	private Cursor cursor;
	
	
	public FoodItem(AdminHome adminhomeInstance,Login loginInstance) {
		super("Cafe java");
		this.loginInstance=loginInstance;
		this.adminhomeInstance=adminhomeInstance;
		initComponent();
	}
	
public void initComponent() {
		
	
	
	
		
		setBounds(300,100,600,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		panel1=new JPanel();
		panel1.setBounds(0,0,600,550);
		panel1.setLayout(null);
		
		
		cursor=new Cursor(Cursor.HAND_CURSOR);
		
		label1=new JLabel("Food Item");
		label1.setBounds(250,70,100,30);
		panel1.add(label1);
		
		

		buttonBack = new JButton("Back");
		buttonBack.setBounds(20,10,75,30);
		panel1.add(buttonBack);
		buttonBack.addActionListener(this);
		buttonBack.setCursor(cursor);
		
		 buttonLogout=new JButton("Logout");
		 buttonLogout.setBounds(510,10,75,30);
		 panel1.add(buttonLogout);
		 buttonLogout.addActionListener(this);
		 buttonLogout.setCursor(cursor);
		
		
		foodTable=new JTable();
		foodTable.setBackground(Color.white);
		
		scroll=new JScrollPane(foodTable);
		scroll.setBounds(0,100,600,300);
		panel1.add(scroll);
		
		updatebutton=new JButton("Update Price");
		updatebutton.setBounds(200,420,150,50);
		panel1.add(updatebutton);
		updatebutton.addActionListener(this);
		updatebutton.setCursor(cursor);
		
		
		
		
		add(panel1);
		setVisible(true);
		populateTable();
		
		
		
}

public void actionPerformed(ActionEvent e) {
	
	
	if(e.getActionCommand().equals("Update Price")) {
		
		FoodTableModel model = new FoodTableModel ();
		
		int row = -1;
		row=foodTable.getSelectedRow();
		if(row>-1) {
		//System.out.println(row);
		String name = model.getValueAt(row, 1).toString();
		String price = model.getValueAt(row, 2).toString();
		
	
		    new FoodPriceUpdate(name,price,this,loginInstance);
		    this.setVisible(false);
			populateTable();
		}
		else {
			JOptionPane.showMessageDialog(null, "no row selected");
		}
	
		
	}
	else if(e.getActionCommand().equals("Logout")){
		loginInstance.setVisible(true);
		this.dispose();
	}
	else if(e.getActionCommand().equals("Back")){
		adminhomeInstance.setVisible(true);
		this.dispose();
	}
}


public static void populateTable() {
	
	FoodTableModel food=new FoodTableModel();
	foodTable.setModel(food);
	
}

}
