import java.awt.*;

import javax.swing.*;
//import java.Table.*;
import java.awt.event.*;

public class Financial  extends JFrame implements ActionListener{
	
	private JLabel messageLabel;
	private JPanel panel1;
	private static JTable financialTable;
	private JScrollPane scroll;
	private JButton addButton, buttonDaily, buttonMonthly, buttonYearly, updateButton,deleteButton,logoutButton,buttonBack;
	//private FinancialTableModel model;
	private DataAccess data;
	private AdminHome adminInstance;
	private Login loginInstance;
	private static JComboBox month;
	private static String selected;
	private String sql;
	private static String  []monthName= {"January","February","March","April","May","June","July","August","September","October","November","December"};
    private Cursor cursor;
	
	public Financial(AdminHome adminInstance,Login loginInstance) {
		
		super("Cafe java");
		
		
		this.loginInstance=loginInstance;
		this.adminInstance=adminInstance;
		//model=new FinancialTableModel();
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
		
		month=new JComboBox(monthName);
		month.setBounds(0,60,85,20);
		panel1.add(month);
		month.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent event) {
		        
		        populateTable();
		        
		    }
		});
		
		
		
		
		
		
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
		
		buttonDaily = new JButton("Daily Sale");
		buttonDaily.setBounds(180,410,110,40);
		panel1.add(buttonDaily);
		buttonDaily.addActionListener(this);
		buttonDaily.setCursor(cursor);
		
		buttonMonthly = new JButton("Monthly Sale");
		buttonMonthly.setBounds(300,410,110,40);
		panel1.add(buttonMonthly);
		buttonMonthly.addActionListener(this);
		buttonMonthly.setCursor(cursor);
		
		
		 messageLabel=new JLabel("Financial Information");
		 messageLabel.setBounds(220,50,150,20);
		 panel1.add( messageLabel);
		 
		 financialTable=new JTable();
		 financialTable.setBackground(Color.white);
		 
		scroll=new JScrollPane(financialTable);
		scroll.setBounds(0,80,600,320);
		panel1.add(scroll);
	
		
		add(panel1);
		setVisible(true);
		this.populateTable();
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		
		
			
      if(e.getActionCommand().equals("Logout")) {
			
			this.loginInstance.setVisible(true);
			
			dispose();
		}
      else if(e.getActionCommand().equals("Back")) {
			
			this.adminInstance.setVisible(true);
			
			dispose();
		}
      else if(e.getActionCommand().equals("Daily Sale")) {
    	  
    	  String sql="SELECT SUM(totalPrice) FROM financialinformation where date=CURRENT_DATE";
    	  String sale=data.getSale(sql);
    	 JOptionPane.showMessageDialog(null,"Total Daily Sale "+sale+" tk");
			
			
		}
      else if(e.getActionCommand().equals("Monthly Sale")) {
    	  if(selected.equals("January"))
 			 sql = "select * from financialinformation where date Like '%_____01%'"; 
 		else if(selected.equals("February"))
 			 sql = "select sum(totalprice) from financialinformation where date Like '%_____02%'"; 
 		else if(selected.equals("March"))
 			 sql = "select sum(totalprice) from financialinformation where date Like '%_____03%'"; 
 		else if(selected.equals("April"))
 			 sql = "select sum(totalprice) from financialinformation where date Like '%_____04%'";
 		else if(selected.equals("May"))
 			 sql = "select sum(totalprice) from financialinformation where date Like '%_____05%'"; 
 		else if(selected.equals("June"))
 			 sql = "select sum(totalprice) from financialinformation where date Like '%_____06%'"; 
 		else if(selected.equals("July"))
 			 sql = "select sum(totalprice) from financialinformation where date Like '%_____07%'"; 
 		else if(selected.equals("August"))
 			 sql = "select sum(totalprice) from financialinformation where date Like '%_____08%'";
 		else if(selected.equals("September"))
 			 sql = "select sum(totalprice) from financialinformation where date Like '%_____09%'";
 		else if(selected.equals("October"))
 			 sql = "select sum(totalprice) from financialinformation where date Like '%_____10%'"; 
 		else if(selected.equals("November"))
 			 sql = "select sum(totalprice) from financialinformation where date Like '%_____11%'"; 
 		else if(selected.equals("December"))
 		 sql = "select sum(totalprice) from financialinformation where date Like '%_____12%'"; 

    	  
    	  String sale=data.getSale(sql);
     	 JOptionPane.showMessageDialog(null,"Total Monthly Sale "+sale+" tk");
      }
      
 else if(e.getActionCommand().equals("Yearly Sale")) {
    	  
    	  String sql="SELECT SUM(totalPrice) FROM financialinformation where date=CURRENT_Year";
    	  String sale=data.getSale(sql);
    	 JOptionPane.showMessageDialog(null,"Total Daily Sale "+sale+" tk");
			
			
		}
    	  
      
		
		
		
		
	}
	
	public static void populateTable() {
		
		selected=month.getSelectedItem().toString();
		
		
		FinancialTableModel model=new FinancialTableModel(selected);
		financialTable.setModel(model);
	}

	
	
	
}
