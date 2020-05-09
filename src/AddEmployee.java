import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {

	private JTextField idText,nameText,jobText,salaryText,passText;
	private JLabel idl,namel,jobl,salaryl,passl, labelHeader, label1;
	private JPanel panel1;
	private Employee employeeInstance;
	private Login loginInstance;
	private Font font;
	private JButton addbtn, buttonBack, buttonLogout;
	private Cursor cursor;
	public AddEmployee(Employee empInstance,Login loginInstance) {
		
		super("Cafe java");
		
		
		this.loginInstance=loginInstance;
		this.employeeInstance=empInstance;
		
        setBounds(300,100,600,550);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		initComponent();
		
		
		
	}
	public void initComponent() {
		
		
		font=new Font("Arial",Font.BOLD,17);
		
		panel1=new JPanel();
		panel1.setBounds(0,0,600,550);
		panel1.setLayout(null);
		
		labelHeader = new JLabel("Cafe Java");
		labelHeader.setBounds(190,10,200,30);
		labelHeader.setFont(new Font ("Arial",Font.BOLD,40));
		panel1.add(labelHeader);
		
		cursor=new Cursor(Cursor.HAND_CURSOR);
		
		label1= new JLabel("Add Employee");
		label1.setBounds(220,70,150,30);
		label1.setFont(new Font ("Arial",Font.BOLD,20));
		panel1.add(label1);
		 
		
		idl=new JLabel("Id       :");
		idl.setBounds(150,120,70,50);
		idl.setFont(font);
		panel1.add(idl);
		
		idText=new JTextField();
		idText.setBounds(220,120,200,40);
		idText.setFont(font);
		panel1.add(idText);
		
		namel=new JLabel("Name  :");
		namel.setBounds(150,180,70,50);
		namel.setFont(font);
		panel1.add(namel);
		
		nameText=new JTextField();
		nameText.setBounds(220,180,200,40);
		nameText.setFont(font);
		panel1.add(nameText);
		
		jobl=new JLabel("Job    :");
		jobl.setBounds(150,240,70,50);
		jobl.setFont(font);
		panel1.add(jobl);
		
		jobText=new JTextField();
		jobText.setBounds(220,240,200,40);
	    jobText.setFont(font);
		panel1.add(jobText);
		
		
		salaryl=new JLabel("Salary :");
		salaryl.setBounds(150,300,70,50);
		salaryl.setFont(font);
		panel1.add(salaryl);
		
		salaryText=new JTextField();
		salaryText.setBounds(220,300,200,40);
		salaryText.setFont(font);
		panel1.add(salaryText);
		
		
		
		 addbtn = new JButton("Add");
		 addbtn.setBounds(220,380,100,40);
		 addbtn.setFont(font);
		panel1.add( addbtn);
		addbtn.addActionListener(this);
		addbtn.setCursor(cursor);
		 
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
		
		
		
		
		
		add(panel1);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Add")){
			
			String sql = "INSERT INTO employee VALUES ('"+idText.getText()+"','"+nameText.getText()+"','"+jobText.getText()+"',"+salaryText.getText()+")";
			DataAccess data = new DataAccess();
			data.addData(sql);
			Employee.populateTable();
			
			employeeInstance.setVisible(true);
			this.dispose();
			
		}	
		else if(e.getActionCommand().equals("Logout")){
			loginInstance.setVisible(true);
			this.dispose();
		}
		else if(e.getActionCommand().equals("Back")){
			employeeInstance.setVisible(true);
			this.dispose();
		}
		
		
		
	}
}
