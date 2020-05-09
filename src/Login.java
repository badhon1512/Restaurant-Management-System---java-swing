//package Rstaurent;

//package restaurantManagement;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Login extends JFrame implements ActionListener {
	//
	
	private Font font;
	private JLabel labelName,labelUser,labelpass, labelHeader;
	private JButton buttonLogin,buttonClear,buttonBackToHome;
	private JTextField textUser;
	private JPasswordField pass;
	private DataAccess data;
	private JCheckBox passCheck;
	private JPanel panel1;
	private Cursor cursor;
	//private JButton buttonClear ,ButtonLogin;
	
	
	public Login() {
		super("Cafe java");
		
		data=new DataAccess();
		
		
		initComponent();
	}
	public void initComponent(){
		
		
		
		setBounds(300,100,600,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		panel1=new JPanel();
		panel1.setBounds(0,0,600,550);
		panel1.setLayout(null);
		panel1.setBackground(Color.lightGray);
		
		font=new Font("Arial",Font.BOLD,17);
		labelName=new JLabel("User Login");
		labelName.setBounds(230,130,150,50);
		labelName.setFont(new Font ("Arial",Font.BOLD,25));
		panel1.add(labelName);
		
		cursor=new Cursor(Cursor.HAND_CURSOR);
		
		labelHeader = new JLabel("Cafe Java");
		labelHeader.setBounds(200,60,200,30);
		labelHeader.setFont(new Font ("Arial",Font.BOLD,40));
		panel1.add(labelHeader);
		
		labelUser=new JLabel("User Name :");
		labelUser.setBounds(150,200,100,30);
		labelUser.setFont(font);
		panel1.add(labelUser);
		

		labelpass=new JLabel("Password :");
		labelpass.setBounds(150,250,100,30);
		labelpass.setFont(font);
		panel1.add(labelpass);
		
		textUser=new JTextField();
		textUser.setBounds(260,200,150,35);
		textUser.setFont(font);
		panel1.add(textUser);
		
		pass=new JPasswordField();
		pass.setBounds(260,250,150,35);
		pass.setEchoChar('*');
		pass.setFont(font);
		panel1.add(pass);
		
		passCheck = new JCheckBox();
		passCheck.setBounds(260,290,30,20);
		passCheck.setToolTipText("Show Password");
		passCheck.setBackground(Color.lightGray);
		panel1.add(passCheck);
		passCheck.addActionListener(this);
		
		 buttonLogin=new JButton("Login");
		 buttonLogin.setBounds(255,315,70,30);
		 panel1.add(buttonLogin);
		 buttonLogin.setCursor(cursor);
		 

		 buttonClear=new JButton("Clear");
		 buttonClear.setBounds(345,315,70,30);
		 panel1.add(buttonClear);
		 buttonClear.setCursor(cursor);
		 
		 
		 
		
		 buttonClear.addActionListener(this);
		 buttonLogin.addActionListener(this);
		
		 add(panel1);
		 setVisible(true);
		 
		 
		 
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(passCheck.isSelected()) {
			pass.setEchoChar((char)0);
		}
		else {
			pass.setEchoChar('*');
		}
		
		 if(e.getActionCommand().equals("Clear")) {
			
			textUser.setText("");
			pass.setText("");
		}
		else if(e.getActionCommand().equals("Login")) {
			//String b=data.adminLogin()
		try {
			String  job=data.login(textUser.getText(),pass.getText());
			//System.out.print(job);
			if(job.equals("admin")){
				
				textUser.setText("");
				pass.setText("");
				new AdminHome(this);
				dispose();
			}
			else if(job.equals("manager")) {
				textUser.setText("");
				pass.setText("");
				new ManagerHome(this);
				dispose();
			}
			else {
				JOptionPane.showMessageDialog(null,"User Name Or pass invalid");
			}
		}
		catch(Exception ea) {
			JOptionPane.showMessageDialog(null,"User Name Or pass invalid");
		}
			
		}
			
		}
}
		
		
	



