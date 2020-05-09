import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class EditEmployee extends JFrame implements ActionListener  {
	
	private JTextField idText,nameText,jobText,salaryText,passText;
	private JLabel idl,namel,jobl,salaryl,passl, labelHeader;
	private JPanel panel1;
	private Font font;
	private JButton updatebtn, buttonBack, buttonLogout;
	private String id,name,job,salary;
	private DataAccess data;
	private Employee employeeInstance;
	private Login loginInstance;
	private Cursor cursor;
	public EditEmployee(String id,String name,String job,String salary, Employee empInstance,Login loginInstance) {
		super("Cafe java");
        data=new DataAccess();
		setBounds(300,100,600,550);
		this.loginInstance=loginInstance;
		this.employeeInstance=empInstance;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		this.id=id;
		this.name=name;
		this.job=job;
		this.salary=salary;
		
		
		initComponent();
	}
	
	public void initComponent() {
font=new Font("Arial",Font.BOLD,17);
		
		panel1=new JPanel();
		panel1.setBounds(0,0,600,550);
		panel1.setLayout(null);
		
		
		cursor=new Cursor(Cursor.HAND_CURSOR);
		
		labelHeader = new JLabel("Cafe Java");
		labelHeader.setBounds(190,10,200,30);
		labelHeader.setFont(new Font ("Arial",Font.BOLD,40));
		panel1.add(labelHeader);
		
		idl=new JLabel("id    :");
		idl.setBounds(20,70,70,50);
		idl.setFont(font);
		panel1.add(idl);
		
		idText=new JTextField(id);
		idText.setBounds(80,70,200,40);
		idText.setFont(font);
		idText.setEditable(false);
		panel1.add(idText);
		
		namel=new JLabel("Name :");
		namel.setBounds(20,130,70,50);
		namel.setFont(font);
		panel1.add(namel);
		
		nameText=new JTextField(name);
		nameText.setBounds(80,130,200,40);
		nameText.setFont(font);
		panel1.add(nameText);
		
		jobl=new JLabel("Job :");
		jobl.setBounds(20,190,70,50);
		jobl.setFont(font);
		panel1.add(jobl);
		
		jobText=new JTextField(job);
		jobText.setBounds(80,190,200,40);
	    jobText.setFont(font);
		panel1.add(jobText);
		
		
		salaryl=new JLabel("Salary :");
		salaryl.setBounds(20,250,70,50);
		salaryl.setFont(font);
		panel1.add(salaryl);
		
		salaryText=new JTextField(salary);
		salaryText.setBounds(80,250,200,40);
		salaryText.setFont(font);
		panel1.add(salaryText);
		
		
		
		updatebtn = new JButton("Update");
		updatebtn.setBounds(80,320,100,30);
		updatebtn.setFont(new Font ("Arial",Font.BOLD,15));
		panel1.add( updatebtn);
		updatebtn.addActionListener(this);
		updatebtn.setCursor(cursor);
		
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
		
		if(e.getActionCommand().equals("Update")) {
			
			String sql="UPDATE employee SET id='"+idText.getText()+"',name='"+nameText.getText()+"',job='"+jobText.getText()+"',salary="+salaryText.getText()+" WHERE id='"+id+"'";
			data.updateData(sql);
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
