import java.awt.*;

import javax.swing.*;
//import java.Table.*;
import java.awt.event.*;

public class Users  extends JFrame implements ActionListener{
	
	private JLabel messageLabel;
	private JPanel panel1;
	private static JTable userTable;
	private JScrollPane scroll;
	private JButton addButton,updateButton,deleteButton,logoutButton,buttonBack;
	private UsersTableModel model;
	private DataAccess data;
	private AdminHome adminInstance;
	private Login loginInstance;
	private Cursor cursor;

	public Users(AdminHome adminInstance,Login loginInstance) {
		
		super("Cafe java");
		this.loginInstance=loginInstance;
		this.adminInstance=adminInstance;
		model=new UsersTableModel();
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
		
		
		logoutButton=new JButton("Logout");
		logoutButton.setBounds(510,10,75,30);
		panel1.add(logoutButton);
		logoutButton.addActionListener(this);
		logoutButton.setCursor(cursor);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(20,10,75,30);
		panel1.add(buttonBack);
		buttonBack.addActionListener(this);
		buttonBack.setCursor(cursor);
		
		 messageLabel=new JLabel("User Information");
		 messageLabel.setBounds(220,50,100,20);
		 panel1.add( messageLabel);
		 
		 userTable=new JTable();
		 userTable.setBackground(Color.white);
		 
		scroll=new JScrollPane(userTable);
		scroll.setBounds(0,80,600,320);
		panel1.add(scroll);
		
		addButton=new JButton("Add User");
		addButton.setBounds(80,420,130,50);
		panel1.add(addButton);
		addButton.addActionListener(this);
		addButton.setCursor(cursor);
		
		deleteButton=new JButton("Delete User");
		deleteButton.setBounds(220,420,130,50);
		panel1.add(deleteButton);
		deleteButton.addActionListener(this);
		deleteButton.setCursor(cursor);
		
		updateButton=new JButton("Update User");
		updateButton.setBounds(360,420,130,50);
		panel1.add(updateButton);
		updateButton.addActionListener(this);
		updateButton.setCursor(cursor);
		
		
		
		
		
		add(panel1);
		setVisible(true);
		populateTable();
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getActionCommand().equals("Delete User")) {
			
			
			int row=userTable.getSelectedRow();
			String user=(String)model.getValueAt(row,1);
			
			if(row>-1 && !user.equals("been12")){ 
				
			String selected=model.getValueAt(row,1).toString();
			//System.out.print(selected);
			
			String sql="Delete from users where username='"+selected+"'";
			data.deleteRow(sql);
			populateTable();
				
			}
			else
				JOptionPane.showMessageDialog(null,"No row Selected");
		}
		else if(e.getActionCommand().equals("Add User")) {
			
			new AddUser(this,loginInstance);
			this.dispose();
		}
      else if(e.getActionCommand().equals("Logout")) {
			
			this.loginInstance.setVisible(true);
			
			dispose();
		}
      else if(e.getActionCommand().equals("Back")) {
			
			this.adminInstance.setVisible(true);
			
			dispose();
		}
		
		
		else if(e.getActionCommand().equals("Update User")) {
			UsersTableModel model = new UsersTableModel ();
			
			int row = -1;
			row=userTable.getSelectedRow();
			if(row>-1) {
			//System.out.println(row);
			String name = model.getValueAt(row, 0).toString();
			String username = model.getValueAt(row, 1).toString();
			String job = model.getValueAt(row, 2).toString();
			String pass = model.getValueAt(row, 3).toString();
		
			
			//	String sql="delete from employee where id='"+selected+"' ";
				//data.deleteRow(sql);
			this.dispose();
			new EditUser(name,username,job,pass,this,loginInstance);
			populateTable();
			
			}
			else {
				JOptionPane.showMessageDialog(null, "no row selected");
			}
		
		}
	}
	
	public static void populateTable() {
		
		
		UsersTableModel model=new UsersTableModel();
		userTable.setModel(model);
	}

	
	
	
}
