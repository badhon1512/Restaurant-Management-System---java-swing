import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddUser extends JFrame implements ActionListener {
	
	private JLabel namel,usernamel,jobl,passl, labelHeader;
	private JTextField nameT,usernameT,jobT;
	private JPasswordField passT;
	private JPanel panel1;
	private JCheckBox checkpass;
	private JButton adduserb,logoutButton,backButton;
	private DataAccess data;
	private Users userInstance;
	private Login loginInstance;
	private Cursor cursor;
	public AddUser(Users userInstance,Login loginInstance){
		
		super("Cafe java");
		
		this.loginInstance=loginInstance;
		this.userInstance=userInstance;
		
		data=new DataAccess();
		
		initComponent();
		
	}
	
	public void initComponent() {
		
		
		
		setBounds(300,100,600,550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0,0,600,550);
		
		cursor=new Cursor(Cursor.HAND_CURSOR);
		
		labelHeader = new JLabel("Cafe Java");
		labelHeader.setBounds(190,20,200,30);
		labelHeader.setFont(new Font ("Arial",Font.BOLD,40));
		panel1.add(labelHeader);
		

		logoutButton=new JButton("Logout");
		logoutButton.setBounds(510,10,75,30);
		panel1.add(logoutButton);
		logoutButton.addActionListener(this);
		logoutButton.setCursor(cursor);
		
		backButton = new JButton("Back");
		backButton.setBounds(20,10,75,30);
		panel1.add(backButton);
		backButton.addActionListener(this);
		backButton.setCursor(cursor);
		
		
		namel=new JLabel("Name     : ");
		namel.setBounds(30,100,80,50);
		panel1.add(namel);
		
		nameT=new JTextField();
		nameT.setBounds(130,100,150,40);
		panel1.add(nameT);
		
		usernamel=new JLabel("Username : ");
		usernamel.setBounds(30,160,80,50);
		panel1.add(usernamel);
		
		usernameT=new JTextField();
		usernameT.setBounds(130,160,150,40);
		panel1.add(usernameT);
		


		
		jobl=new JLabel("Job      : ");
		jobl.setBounds(30,220,80,50);
		panel1.add(jobl);
		
		jobT=new JTextField();
		jobT.setBounds(130,220,150,40);
		panel1.add(jobT);
		
		
		passl=new JLabel("Password : ");
		passl.setBounds(30,280,80,50);
		panel1.add(passl);
		
		passT=new JPasswordField();
		passT.setBounds(130,280,150,40);
		panel1.add(passT);
		
		checkpass=new JCheckBox();
		checkpass.setBounds(130,330,50,20);
        panel1.add( checkpass);
        checkpass.addActionListener(this);
        
        
        	
         
         adduserb=new JButton("Add User");
         adduserb.setBounds(130,360,100,40);
         panel1.add(adduserb);
         adduserb.addActionListener(this);
         adduserb.setCursor(cursor);
		
		
		
		add(panel1);
		setVisible(true);
	}

	
	public void actionPerformed(ActionEvent e) {
		if(checkpass.isSelected())
        	passT.setEchoChar((char)0);
		else
			passT.setEchoChar('*');
		
		if(e.getActionCommand().equals("Add User")) {
			
			
			if(!nameT.getText().equals("")&&!usernameT.getText().equals("")&&!jobT.getText().equals("")&&!passT.getText().equals("")) {
			String sql="Insert into users values('"+nameT.getText()+"','"+usernameT.getText()+"','"+jobT.getText()+"','"+passT.getText()+"')";
			
			data.addData(sql);
		    Users.populateTable();
		    userInstance.setVisible(true);
		   // new Users();
		    this.dispose();
			}
			else {
				
				JOptionPane.showMessageDialog(null,"Must fill all Field");
				
				 userInstance.setVisible(true);
				   // new Users();
				    this.dispose();
			}
		
		}
		else if(e.getActionCommand().equals("Logout")) {
			
		   this.loginInstance.setVisible(true);
		   this.dispose();
		}
		
		else if(e.getActionCommand().equals("Back")) {
			
			   this.userInstance.setVisible(true);
			   this.dispose();
			}
		
		
		
		
	}
}
