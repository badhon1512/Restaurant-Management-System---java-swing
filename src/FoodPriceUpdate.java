import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FoodPriceUpdate extends JFrame implements ActionListener {

	
	private String name,price;
	private JPanel panel1;
	private JLabel titlel, namel,pricel;
	private JTextField nameT,priceT;
	private JButton updateButton;
	private DataAccess data;
	private JButton buttonBack,buttonLogout;
	private FoodItem fooditemInstance;
	private Login loginInstance;
	private Cursor cursor;
	public FoodPriceUpdate(String name,String price,FoodItem fooditemInstance,Login  loginInstance) {
		super("Cafe java");
		
		this.loginInstance=loginInstance;
		this.fooditemInstance=fooditemInstance;
		data=new DataAccess();
		this.name=name;
		this.price=price;
		
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
		
		titlel=new JLabel("Update Food Price");
		titlel.setBounds(230,80,150,50);
		panel1.add(titlel);
		
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
		
		
		namel=new JLabel("Food Name : ");
		namel.setBounds(50,140,100,50);
		panel1.add(namel);
		
		
		nameT=new JTextField(name);
		nameT.setBounds(160,140,150,50);
		nameT.setEditable(false);
		panel1.add(nameT);
		
		
		pricel=new JLabel("Food Price : ");
		pricel.setBounds(50,200,100,50);
		panel1.add(pricel);
		
		
		priceT=new JTextField(price);
		priceT.setBounds(160,200,150,50);
		panel1.add(priceT);
		
		updateButton=new JButton("Update Confirm");
		
		updateButton.setBounds(80,270,150,50);
		panel1.add(updateButton);
		updateButton.addActionListener(this);
		updateButton.setCursor(cursor);
		
		
		
		add(panel1);
		
		
		
		
		setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Update Confirm")) {
			String sql;
			sql="update fooditem set price="+ priceT.getText()+" where name='"+name+"'";
			data.updateData(sql);
			FoodItem.populateTable();
			fooditemInstance.setVisible(true);
			this.dispose();
			
			
			
		}
		else if(e.getActionCommand().equals("Logout")){
			loginInstance.setVisible(true);
			this.dispose();
		}
		else if(e.getActionCommand().equals("Back")){
			fooditemInstance.setVisible(true);
			this.dispose();
		}
		
	}
	
	
	
	
	
	
	
}
