import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EditUser extends JFrame implements ActionListener  {
	
	private DataAccess data;
	private JLabel namel,usernamel,jobl,passl, labelHeader;
	private JTextField nameT,usernameT,jobT;
	private JPasswordField passT;
	private JPanel panel1;
	private JCheckBox checkpass;
	private JButton updatebutton,buttonBack,buttonLogout;
	private String name,username,job,pass;
	private Users userInstance;
	private Login loginInstance;
	private Cursor cursor;
	
	public EditUser(String name,String username,String job,String pass,Users userInstance,Login loginInstance) {
		
		super("Cafe java");
		this.loginInstance=loginInstance;
		this.userInstance=userInstance;
		
		this.name=name;
		this.username=username;
		this.job=job;
		this.pass=pass;
		
        data=new DataAccess();
		setBounds(300,100,600,550);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		
		
		initComponent();
	}
	
	public void initComponent() {
		
		panel1=new JPanel();
		panel1.setLayout(null);
		panel1.setBounds(0,0,600,550);
		
		cursor=new Cursor(Cursor.HAND_CURSOR);
		
		labelHeader = new JLabel("Cafe Java");
		labelHeader.setBounds(190,20,200,30);
		labelHeader.setFont(new Font ("Arial",Font.BOLD,40));
		panel1.add(labelHeader);
		
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
		
		namel=new JLabel("Name     : ");
		namel.setBounds(30,100,80,50);
		panel1.add(namel);
		
		nameT=new JTextField(this.name);
		nameT.setBounds(130,100,150,40);
		panel1.add(nameT);
		
		usernamel=new JLabel("Username : ");
		usernamel.setBounds(30,160,80,50);
		panel1.add(usernamel);
		
		usernameT=new JTextField(this.username);
		usernameT.setBounds(130,160,150,40);
		usernameT.setEnabled(false);
		panel1.add(usernameT);
		


		
		jobl=new JLabel("Job      : ");
		jobl.setBounds(30,220,80,50);
		panel1.add(jobl);
		
		jobT=new JTextField(this.job);
		jobT.setBounds(130,220,150,40);
		panel1.add(jobT);
		
		
		passl=new JLabel("Password : ");
		passl.setBounds(30,280,80,50);
		panel1.add(passl);
		
		passT=new JPasswordField(this.pass);
		passT.setBounds(130,280,150,40);
		panel1.add(passT);
		
		checkpass=new JCheckBox();
		checkpass.setBounds(130,330,50,20);
        panel1.add( checkpass);
        checkpass.addActionListener(this);
        
        
        updatebutton=new JButton("Update");
        updatebutton.setBounds(130,360,100,40);
        panel1.add(updatebutton);
        updatebutton.addActionListener(this);
        updatebutton.setCursor(cursor);
        
       
        
		
		
		
		add(panel1);
		setVisible(true);
		
	
	
	}
	
	public void actionPerformed(ActionEvent e) {
		if(checkpass.isSelected())
        	passT.setEchoChar((char)0);
		else
			passT.setEchoChar('*');
		
		if(e.getActionCommand().equals("Update")) {
			
			
			
			
			
			String sql="Update users set name='"+nameT.getText()+"',username='"+username+"',job='"+jobT.getText()+"',password='"+passT.getText()+"' where username='"+username+"'";
			//System.out.print(sql);
			
			data. updateData(sql);
		    Users.populateTable();
		    userInstance.setVisible(true);
		    //new Users();
		    this.dispose();
		
		}
		else if(e.getActionCommand().equals("Logout")){
			this.dispose();
			loginInstance.setVisible(true);
			
		}
		else if(e.getActionCommand().equals("Back")){
			userInstance.setVisible(true);
			this.dispose();
		}
		
		
		
		
	}
}
