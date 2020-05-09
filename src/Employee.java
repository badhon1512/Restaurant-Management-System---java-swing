import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Employee extends JFrame implements ActionListener  {
	
	private JPanel panel1,panel2,panel3;
	private static JTable empTable;
	private JScrollPane scroll;
	private static JTextField txtSearch;
	private JLabel  messageLabel;
	private Login loginInstance;
	private AdminHome adminInstance;
	private JButton btnSearch,btnAdd,btnDelete,btnEdit,buttonBack, buttonLogout,refreshButton;
	private DataAccess data;
	private Cursor cursor;
	
	public Employee(Login loginInstance, AdminHome adminInstance) {
		
		super("Cafe java");
		this.loginInstance=loginInstance;
		this.adminInstance=adminInstance;
		data=new DataAccess();
		//this.loginInstance=loginInstance;
		
		setBounds(300,100,600,550);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setResizable(false);
		
		initComponent();
		
		}
	public void initComponent() {
		panel1=new JPanel();
		panel1.setBounds(0,0,600,80);
		panel1.setLayout(null);
		panel1.setBackground(Color.LIGHT_GRAY);
		
		cursor=new Cursor(Cursor.HAND_CURSOR);
		
		 messageLabel=new JLabel("Employee Information");
		 messageLabel.setBounds(220,50,150,20);
		 panel1.add( messageLabel);
		 
		
		txtSearch=new JTextField();
		txtSearch.setBounds(210,10,100,30);
		panel1.add(txtSearch);
		
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
		
		btnSearch=new JButton("Search");
		btnSearch.setBounds(320,10,90,30);
		panel1.add(btnSearch);
		btnSearch.addActionListener(this);
		btnSearch.setCursor(cursor);
		
		refreshButton=new JButton("Refresh");
		refreshButton.setBounds(100,10,90,30);
		panel1.add(refreshButton);
		refreshButton.addActionListener(this);
		
		panel2=new JPanel();
		panel2.setBounds(0,80,600,320);
		panel2.setLayout(null);
		panel2.setBackground(Color.pink);
		
		empTable=new JTable();
		empTable.setBackground(Color.white);
		scroll=new JScrollPane(empTable);
		scroll.setBounds(0,0,600,320);
		panel2.add(scroll);
		
		
		
		 panel3 = new JPanel();
		 panel3.setBounds(0,400,600,150);
		 panel3.setLayout(null);
		 panel3.setBackground(Color.lightGray);
		 
		 btnAdd=new  JButton("Add Employee");
		 btnAdd.setBounds(120,30,120,40);
		 panel3.add(btnAdd);
		 btnAdd.addActionListener(this);
		 btnAdd.setCursor(cursor);
		 
		 btnDelete=new  JButton("Delete");
		 btnDelete.setBounds(240,30,120,40);
		 panel3.add(btnDelete);
		 btnDelete.addActionListener(this);
		 btnDelete.setCursor(cursor);
		 
		 
		 btnEdit=new  JButton("Edit");
		 btnEdit.setBounds(360,30,120,40);
		 panel3.add(btnEdit);
		 btnEdit.addActionListener(this);
		 btnEdit.setCursor(cursor);
		 
		
		
		
		add(panel1);
		add(panel3);
		add(panel2);
		
		populateTable();
		
		setVisible(true);
		
		
		
	}
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Search")){
			populateTable();
		}
		else if(e.getActionCommand().equals("Add Employee")){
			
			new AddEmployee(this,loginInstance);
			this.setVisible(false);
			
		}
		else if(e.getActionCommand().equals("Delete")) {
			EmployeeTableModel model = new EmployeeTableModel(txtSearch.getText());
			
				int row = empTable.getSelectedRow();
				if(row>-1) {
				String selected = model.getValueAt(row, 0).toString();
				
					String sql="delete from employee where id='"+selected+"' ";
					data.deleteRow(sql);
					populateTable();
				}
			
			else
				JOptionPane.showMessageDialog(null, "no row selected");
			
				
				
				
				
			}
		
		else if(e.getActionCommand().equals("Edit")) {
			EmployeeTableModel model = new EmployeeTableModel(txtSearch.getText());
			
				int row = -1;
				row=empTable.getSelectedRow();
				if(row>-1) {
				//System.out.println(row);
				String id = model.getValueAt(row, 0).toString();
				String name = model.getValueAt(row, 1).toString();
				String job = model.getValueAt(row, 2).toString();
				String salary = model.getValueAt(row, 3).toString();
			
				
				//	String sql="delete from employee where id='"+selected+"' ";
					//data.deleteRow(sql);
				new EditEmployee(id,name,job,salary, this, loginInstance);
				this.setVisible(false);
					populateTable();
				}
				
				else {
					JOptionPane.showMessageDialog(null, "no row selected");
				}
			
				
				}
		
		else if(e.getActionCommand().equals("Back")){
			adminInstance.setVisible(true);
			this.dispose();
		}
		
		else if(e.getActionCommand().equals("Logout")){
			loginInstance.setVisible(true);
			this.dispose();
		}
		
		else if(e.getActionCommand().equals("Refresh")){
			populateTable();
		}
			
			}
	
			
		
	
public static void populateTable() {
		
		EmployeeTableModel model = new EmployeeTableModel(txtSearch.getText());
		empTable.setModel(model);
	}

}
