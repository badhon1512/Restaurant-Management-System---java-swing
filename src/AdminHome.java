//package Rstaurent;
//package restaurantManagement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class AdminHome extends JFrame implements ActionListener {
	
	private JLabel labelHeader,labelName2;
	private Font font;
	private JButton buttonFinancial,buttonEmploye, buttonLogout,buttonProductPrice,buttonUsers, buttonBack;
	private Login loginInstance;
	private JPanel panel1;
	private ImageIcon img;
	private Cursor cursor;
	
	
	public AdminHome(Login loginInstance) {
		
		super("Cafe Java");
		this.loginInstance=loginInstance;
		
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
		panel1.setBackground(Color.lightGray);
		
		cursor=new Cursor(Cursor.HAND_CURSOR);

		
		font=new Font("Arial",Font.BOLD,17);
		
		//img = new ImageIcon(getClass().getResource("back1.png"));
		
		
		
		labelHeader = new JLabel("Cafe Java");
		labelHeader.setBounds(190,50,200,30);
		labelHeader.setFont(new Font ("Arial",Font.BOLD,40));
		panel1.add(labelHeader);
		 
		 labelName2=new JLabel("Admin Home Page");
		 labelName2.setBounds(200,110,200,30);
		 labelName2.setFont(font);
		 panel1.add(labelName2);
		 
		 buttonFinancial=new JButton("Financial Information");
		 buttonFinancial.setBounds(180,155,200,35);
		 panel1.add(buttonFinancial);
		 buttonFinancial.addActionListener(this);
		 buttonFinancial.setCursor(cursor);
		 
		 
		 
		 buttonEmploye=new JButton("Employee Information");
		 buttonEmploye.setBounds(180,200,200,35);
		 panel1.add(buttonEmploye);
		 buttonEmploye.addActionListener(this);
		 buttonEmploye.setCursor(cursor);
		 
		 buttonUsers=new JButton("Users Information");
		 buttonUsers.setBounds(180,250,200,35);
		 panel1.add(buttonUsers);
		 buttonUsers.addActionListener(this);
		 buttonUsers.setCursor(cursor);
		 
		 
		 
		 buttonProductPrice=new JButton("Food Item");
		 buttonProductPrice.setBounds(180,300,200,35);
		 panel1.add(buttonProductPrice);
		 buttonProductPrice.addActionListener(this);
		 buttonProductPrice.setCursor(cursor);
		 
				 
		 

		 buttonLogout=new JButton("Logout");
		 buttonLogout.setBounds(510,10,75,30);
		 panel1.add(buttonLogout);
		 buttonLogout.setCursor(cursor);
		 
		 buttonLogout.addActionListener(this);
		 add(panel1);
		 
		 setVisible(true);
		 
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Logout")) {
			
			loginInstance.setVisible(true);
			this.dispose();
		}
		else if(e.getActionCommand().equals("Food Item")) {
			
			new FoodItem(this,loginInstance);
			
			this.dispose();
		}
      else if(e.getActionCommand().equals("Users Information")){
			
			this.setVisible(false);
			new Users(this,loginInstance);
			
			
		}
		else if(e.getActionCommand().equals("Employee Information")){
			
			new Employee(loginInstance,this);
			this.dispose();
			
			//new Employee(this, loginInstance);
			
		}
		
       else if(e.getActionCommand().equals("Financial Information")){
			
			new Financial(this,loginInstance);
			this.dispose();
			
			
			
		}
		
		
		
		
		
		
	}
	
	
	

}
