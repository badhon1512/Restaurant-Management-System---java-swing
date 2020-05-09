import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class ManagerHome extends JFrame implements ActionListener {
	
	private Login loginInstance;
	private JButton buttonFinancial, buttonLogout, buttonBill;
	private JLabel labelHeader, labelName2;
	private Font font;
	private JPanel panel1;
	private Cursor cursor;
	
public ManagerHome(Login loginInstance) {
		
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
	
	labelHeader = new JLabel("Cafe Java");
	labelHeader.setBounds(190,50,200,30);
	labelHeader.setFont(new Font ("Arial",Font.BOLD,40));
	panel1.add(labelHeader);
	
	labelName2=new JLabel("Manager Home Page");
	 labelName2.setBounds(200,110,200,30);
	 labelName2.setFont(font);
	 panel1.add(labelName2);
	
	 buttonFinancial=new JButton("Financial Information");
	 buttonFinancial.setBounds(180,155,200,35);
	 panel1.add(buttonFinancial);
	 buttonFinancial.addActionListener(this);
	 buttonFinancial.setCursor(cursor);
	 
	 buttonBill=new JButton("Billing System");
	 buttonBill.setBounds(180,200,200,35);
	 panel1.add(buttonBill);
	 buttonBill.addActionListener(this);
	 buttonBill.setCursor(cursor);
	 
	 buttonLogout=new JButton("Logout");
	 buttonLogout.setBounds(510,10,75,30);
	 panel1.add(buttonLogout);
	 buttonLogout.addActionListener(this);
	 buttonLogout.setCursor(cursor);
	 
	 add(panel1);
	 setVisible(true);
	 
	 
}

public void actionPerformed(ActionEvent e) {
	if(e.getActionCommand().equals("Logout")) {
		this.dispose();
		loginInstance.setVisible(true);
	}
	else if(e.getActionCommand().equals("Financial Information")) {
		this.setVisible(false);
		new FinancialForManager (this, loginInstance);
	}
	else if(e.getActionCommand().equals("Billing System")) {
		new BillingSystem(this,loginInstance);
		this.setVisible(false);
		
	}
}
	
}
