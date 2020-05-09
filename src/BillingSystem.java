

//package RestaurantManagement;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.*;
import javax.swing.table.*;
import java.util.stream.*;

public class BillingSystem extends JFrame implements ActionListener{

	private JPanel panel1, panel2, panelCart,panel3,panel4,panel5;
	private JButton buttonBack, buttonChickenBurger, buttonBeefBurger, buttonBBQPizza, buttonPepperoniPizza, buttonFrenchFries, buttonSoftDrinks, buttonShake, buttonLogout, buttonAdd, buttonClear, buttonBill;
	private JLabel labelFoodItem, labelCash, labelDiscount, labelCafeName, l1, l2,l3,l4,l5,l6,l7, labelCart, labelPrice, labelTotal, labelBillingCart ;
	private Font font;
	private JTextField t1,t2,t3,t4,t5,t6,t7,tCash, tDiscount; 
	private JComboBox cb1,cb2,cb3,cb4,cb5,cb6,cb7;
	private String str;
	private JTable cart;
	private DefaultTableModel model;
	private JScrollPane scroll;
	private String []column= {"   Item Name   ","Item Price"," Quantity ","total"};
	private String []row=new String[4];
	private double [] price=new double[8];
	private double totalPrice;
	private String[] prodtctPrice= {"0","1","2","3","4","5","6","7","8","9","10"};
	private ManagerHome managerInstance;
	private Login loginInstance;
	private DataAccess data;
	private FoodTableModel mod;
	private double returnCash;
	private double discount;
	private double finalBill;
	private Cursor cursor;
	
	
	
	
	private String bill;
	//private Container c;
	
	public void setDefaultPrice() {
		cb1.setSelectedIndex(0);
		cb2.setSelectedIndex(0);
		cb3.setSelectedIndex(0);
		cb4.setSelectedIndex(0);
		cb5.setSelectedIndex(0);
		cb6.setSelectedIndex(0);
		cb7.setSelectedIndex(0);

		model.getDataVector().removeAllElements();
		model.fireTableDataChanged();
		bill="\n";
		tDiscount.setText("");
		tCash.setText("");
		labelTotal.setVisible(false);
		 labelPrice.setVisible(false);
		 labelPrice.setText("");
	}
	
	public BillingSystem(ManagerHome managerInstance, Login loginInstance) {
		
		super("CAFE Java");
		data=new DataAccess();
        mod=new FoodTableModel();
		this.managerInstance=managerInstance;
		this.loginInstance=loginInstance;
		initComponents();
	}
	
	public void initComponents(){
		

		setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setBounds(300,100,700,600);
		setResizable(false);
		
		
		font = new Font("Arial", Font.BOLD, 20);
		
		panel1 = new JPanel();
		
	
		panel1.setBackground(Color.gray);
        panel1.setBounds(0,0,200,600);
        panel1.setLayout(null);

		
		
		panel2 = new JPanel();
		panel2.setBounds(200,0,500,50);
		panel2.setBackground(Color.DARK_GRAY);
		panel2.setLayout(null);
		
		panel3=new JPanel();
		panel3.setBounds(200, 50, 500, 550);
		//panel3.setBackground(Color.DARK_GRAY);
		panel3.setLayout(null);
		
		
		
		panel4=new JPanel();
		panel4.setBounds(0, 0, 500, 20);
		panel4.setBackground(Color.lightGray);
		panel4.setLayout(null);
		panel3.add(panel4);
		
		panel5=new JPanel();
		panel5.setBounds(0, 470, 500 , 50);
		panel5.setBackground(Color.lightGray);
		panel5.setLayout(null);
		panel3.add(panel5);
		
		cursor=new Cursor(Cursor.HAND_CURSOR);
		
		
		labelFoodItem = new JLabel("Food Menu");
		labelFoodItem.setBounds(40,10, 140, 30);
		labelFoodItem.setFont(font);
		panel1.add(labelFoodItem);
		//add(labelFoodItem);
		
		
		labelCafeName = new JLabel("Cafe Java");
		labelCafeName.setBounds(160, 10, 100, 30);
		labelCafeName.setFont(font);
		labelCafeName.setForeground(Color.white);
		panel2.add(labelCafeName);
		//add(labelCafeName);
		
		labelTotal = new JLabel("Total Price");
		labelTotal.setBounds(255, 320, 80, 50);
		labelTotal.setFont(new Font("Calibari", font.BOLD, 15));
		labelTotal.setVisible(false);
		panel3.add(labelTotal);
		
		labelPrice = new JLabel();
		labelPrice.setBounds(380, 320, 80, 50);
		labelPrice.setFont(new Font("Calibari", font.BOLD, 20));
		labelPrice.setBackground(Color.black);
		panel3.add(labelPrice);
		
		labelBillingCart = new JLabel("Billing Cart");
		labelBillingCart.setBounds(220, 20, 100, 30);
		labelBillingCart.setFont( new Font("Calibari", Font.BOLD, 15));
		panel3.add(labelBillingCart);
		
		labelCash = new JLabel("Cash taken: ");
		labelCash.setBounds(50,340,100,30);
		labelCash.setFont( new Font("Calibari", Font.BOLD, 15));
		panel3.add(labelCash);
		
		tCash = new JTextField();
		tCash.setBounds(150, 340, 100, 30);
		tCash.setFont( new Font("Calibari", Font.PLAIN, 15));
		panel3.add(tCash);
		
		labelDiscount = new JLabel("Discount%: ");
		labelDiscount.setBounds(50,380,100,30);
		labelDiscount.setFont( new Font("Calibari", Font.BOLD, 15));
		panel3.add(labelDiscount);
		
		tDiscount = new JTextField();
		tDiscount.setBounds(150, 380, 100, 30);
		tDiscount.setFont( new Font("Calibari", Font.PLAIN, 15));
		panel3.add(tDiscount);
		
		
		l1 = new JLabel("Chicken Burger");
		l1.setBounds(20,40,140,50);
	    panel1.add(l1);

	
	    cb1=new JComboBox(prodtctPrice);
		cb1.setFont(font);
		cb1.setBounds(135,50, 50, 35);
		panel1.add(cb1);
		
		
		
		
		l2 = new JLabel("Beef Burger");
		l2.setBounds(20,93,140,50);
		panel1.add(l2);
		
		cb2 =new JComboBox(prodtctPrice);
		cb2.setFont(font);
		cb2.setBounds(135,100, 50, 35);
		panel1.add(cb2);
		
		
		l3 = new JLabel("BBQ Pizza");
		l3.setBounds(20,153,140,50);
		panel1.add(l3);
		
		cb3 = new JComboBox(prodtctPrice);
		cb3.setFont(font);
		cb3.setBounds(135,160, 50, 35);
		panel1.add(cb3);
		
		
		l4 = new JLabel("Veg Pizza");
		l4.setBounds(20,213,140,50);
		panel1.add(l4);
		
		cb4 = new JComboBox(prodtctPrice);
		cb4.setFont(font);
		cb4.setBounds(135,220, 50, 35);
		//panel1.add(t1);
		panel1.add(cb4);
		
		
		l5 = new JLabel("French Fries");
		l5.setBounds(20,273,140,50);
		panel1.add(l5);
		
		cb5 = new JComboBox(prodtctPrice);
		cb5.setFont(font);
		cb5.setBounds(135,280, 50, 35);
		panel1.add(cb5);
		
		
		l6 = new JLabel("Soft Drinks");
		l6.setBounds(20,333,140,50);
		panel1.add(l6);
		
		cb6 =new JComboBox(prodtctPrice);
		cb6.setFont(font);
		cb6.setBounds(135,340, 50, 35);
		panel1.add(cb6);
		
	
		
		l7 = new JLabel("Milk Shake");
		l7.setBounds(20,393,140,50);
		panel1.add(l7);
		
		cb7 = new JComboBox(prodtctPrice);
		cb7.setFont(font);
		cb7.setBounds(135,400, 50, 35);
		//panel1.add(t1);
		panel1.add(cb7);
		
		buttonLogout = new JButton("Logout");
		buttonLogout.setBounds(610 ,10, 75, 30); 
		add(buttonLogout);
		buttonLogout.addActionListener(this);
		buttonLogout.setCursor(cursor);
		
		buttonBack = new JButton("Back");
		buttonBack.setBounds(210 ,10, 75, 30); 
		add(buttonBack);
		buttonBack.addActionListener(this);
		buttonBack.setCursor(cursor);
		
		buttonAdd = new JButton("Add to Cart");
		buttonAdd.setBounds(45, 450, 100, 35);
		add(buttonAdd);
		buttonAdd.addActionListener(this);
		buttonBack.setCursor(cursor);
		
		
		cart=new JTable();
		model=new DefaultTableModel();
		
		model.setColumnIdentifiers(column);
		cart.setModel(model);
		cart.setBackground(Color.white);
		cart.setRowHeight(30);
		cart.setFont(new Font("Arial",Font.BOLD,14));
		
		scroll=new JScrollPane(cart);
		scroll.setBounds(15 , 50, 470,280);
		
		panel3.add(scroll);
		// cb1.addMouseListener(this);
		 
		 buttonClear = new JButton("Clear Cart");
		 buttonClear.setBounds(50, 420, 150,40);
		 panel3.add(buttonClear);
		 buttonClear.setCursor(cursor);
		 
		 buttonClear.addActionListener(this);
		 
		 buttonBill = new JButton("Confirm Bill");
		 buttonBill.setBounds(280, 420, 150,40);
		 panel3.add(buttonBill);
		 buttonBill.setCursor(cursor);
		 
		 buttonBill.addActionListener(this);
		
		add(panel1);
		add(panel2);	
		add(panel3);
		
		
		 setVisible(true);
		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("Logout")) {
			//new Login();
			loginInstance.setVisible(true);
			this.dispose();
		}
		else if(e.getActionCommand().equals("Back")) {
			managerInstance.setVisible(true);
			this.dispose();
			
		}
		else if(e.getActionCommand().equals("Clear Cart")) {
			model.getDataVector().removeAllElements();
			model.fireTableDataChanged();
			labelPrice.setVisible(false);
			labelTotal.setVisible(false);
			
			setDefaultPrice();
			
			
			
		}
		else if(e.getActionCommand().equals("Add to Cart")) {
			int q1,q2,q3,q4,q5,q6,q7;
			q1 = Integer.parseInt((String) cb1.getSelectedItem()); 
			q2 = Integer.parseInt((String) cb2.getSelectedItem()); 
			q3 = Integer.parseInt((String) cb3.getSelectedItem()); 
			q4 = Integer.parseInt((String) cb4.getSelectedItem()); 
			q5 = Integer.parseInt((String) cb5.getSelectedItem()); 
			q6 = Integer.parseInt((String) cb6.getSelectedItem()); 
			q7 = Integer.parseInt((String) cb7.getSelectedItem()); 
			for(byte i=0;i<price.length;i++)
				price[i]=0;
				
			
			 labelPrice.setText("");

		
			model.getDataVector().removeAllElements();
			model.fireTableDataChanged();
			
			if(q1==0 && q2==0 && q3==0 && q4==0 && q5==0 && q6==0 && q7==0) {
				JOptionPane.showMessageDialog(null,"No item Slected");
			}
			
			if(q1>0 || q2>0 || q3>0 || q4>0 || q5>0 || q6>0 || q7>0) {
				
				if(q1>0) {
					
					int price1=(int)(mod.getValueAt(0, 2));
					
					price[0]=q1*price1;
					
					row[0]=(String)(mod.getValueAt(0, 1));
					row[1]=Integer.toString(price1);
					row[2]=Integer.toString(q1);
				   row[3]=Double.toString(price[0]);
					model.addRow(row);
					
					bill=bill+"\n"+row[0]+"   "+Integer.toString(q1)+" x "+row[1]+"  "+price[0];
						
					
				}
				
				if(q2>0) {
					
					int price1=(int)(mod.getValueAt(1, 2));
					
                   price[1]=q2*price1;
					
					row[0]=(String)(mod.getValueAt(1, 1));
					row[1]=Integer.toString(price1);
					row[2]=Integer.toString(q2);
				   row[3]=Double.toString(price[1]);
					model.addRow(row);
					

					bill=bill+"\n"+row[0]+"         "+Integer.toString(q2)+" x "+row[1]+"  "+price[1];
						}
					
					
				if(q3>0) {
					
					int price1=(int)(mod.getValueAt(2, 2));
					 price[2]=q3*price1;
						
					row[0]=(String)(mod.getValueAt(2, 1));
					row[1]=Integer.toString(price1);
					row[2]=Integer.toString(q3);
					row[3]=Double.toString(price[2]);
					model.addRow(row);
					bill=bill+"\n"+row[0]+"            "+Integer.toString(q3)+" x "+row[1]+"  "+price[2];
				}
					
				if(q4>0) {
					int price1=(int)(mod.getValueAt(3, 2));
					
					price[3]=q4*price1; 
					
					row[0]=(String)(mod.getValueAt(3, 1));
					row[1]=Integer.toString(price1);
					row[2]=Integer.toString(q4);
					row[3]=Double.toString(price[3]);
					model.addRow(row);
					bill=bill+"\n"+row[0]+"             "+Integer.toString(q4)+" x "+row[1]+"  "+price[3];

					
					
					
				}
					
					
				if(q5>0) {
					int price1=(int)(mod.getValueAt(4, 2));
					 price[4]=q5*price1;
					
					row[0]=(String)(mod.getValueAt(4, 1));
					row[1]=Integer.toString(price1);
					row[2]=Integer.toString(q5);
					row[3]=Double.toString(price[4]);
					model.addRow(row);
					bill=bill+"\n"+row[0]+"        "+Integer.toString(q5)+" x "+row[1]+"  "+price[4];

			
				}
					
				if(q6>0) {
					
					int price1=(int)(mod.getValueAt(5, 2));
					 price[5]=q6*price1;
                  
					
					row[0]=(String)(mod.getValueAt(5, 1));
					row[1]=Integer.toString(price1);
					row[2]=Integer.toString(q6);
					row[3]=Double.toString(price[5]);
					model.addRow(row);
					bill=bill+"\n"+row[0]+"          "+Integer.toString(q6)+" x "+row[1]+"  "+price[5];

					
				}
					
					
				if(q7>0) {
					int price1=(int)(mod.getValueAt(6, 2));
					 price[6]=q7*price1;
					   
						
						row[0]=(String)(mod.getValueAt(6, 1));
						row[1]=Integer.toString(price1);
						row[2]=Integer.toString(q7);
						row[3]=Double.toString(price[6]);
						model.addRow(row);
						bill=bill+"\n"  +row[0]+  "          "+Integer.toString(q7)+" x "+row[1]+"  "+price[6];

				}
				 totalPrice=DoubleStream.of(price).sum();
				 //labelTotal.setEnabled(true);
				 labelTotal.setVisible(true);
				 labelPrice.setVisible(true);
				 
				 labelPrice.setText(Double.toString(totalPrice));
				// bill=bill+"\n\n    Total Bill:              "+Integer.toString(totalPrice);
				 
				 
					
				
			}
			
		}
		else if(e.getActionCommand().equals("Confirm Bill")){
			
			
			try{
			if((tDiscount.getText()).equals(""))
				discount=0;
			else
			discount = totalPrice*((Double.parseDouble(tDiscount.getText()))/(double)100);
			
			if(model.getRowCount()>0) {
				
				if(discount>100||discount<0) {
					JOptionPane.showMessageDialog(null, "Invalid Discount");
					tDiscount.setText("");
					
				}
				
				else {
				
				if(tCash.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Please insert taken cash");
				}
				
				else {
					
					if((tDiscount.getText()).equals("")) {
						
						finalBill = totalPrice;
					
					}
					
					else {
						
						//discount = totalPrice*((Double.parseDouble(tDiscount.getText()))/(double)100);
						finalBill= totalPrice - discount;
					}
					
				returnCash = Double.parseDouble((tCash.getText()))-finalBill;
				if(returnCash<0) {
					JOptionPane.showMessageDialog(null, "Given amount not valid");
				}
				else {
				bill+="\n\nCash Taken   :  "+(tCash.getText())+" tk";
				bill=bill+"\nTotal Bill:              "+Double.toString(finalBill)+" tk";
				bill=bill+"\nDiscount :             "+discount+" tk";
				bill+="\nReturn Amount:    "+Double.toString(returnCash)+" tk";
				JOptionPane.showMessageDialog(null, bill);
				String sql="Insert into FinancialInformation values(CURRENT_DATE,CURRENT_TIME,"+finalBill+")";
				
				data.addData(sql);

				
				setDefaultPrice();
					}
					
				  }
				}
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Cart is Empty!");
				
			}
			}
			catch(Exception ea) {
				JOptionPane.showMessageDialog(null,"Something wrong!");
				
			}
			
			
			
			
			}
		
		
	}
	
	
	
	//convert to intity class
		
		
		
	}