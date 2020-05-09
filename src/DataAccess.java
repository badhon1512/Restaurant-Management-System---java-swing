import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class DataAccess {
	
	private Connection con;
	private Statement stat;
	private ResultSet res;
	private String sql;
	
	public DataAccess(){
		
		
		try {
			con=(Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurantmanagement","root","");
			stat=(Statement)con.createStatement();
		}
		catch (SQLException e){
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"Wrong ");
		}
		
		
	} 
	
	public String getSale(String sql) {
		try {
		//int a=(int)stat.executeQuery(sql);
			
		res =stat.executeQuery(sql);
		while (res.next()) {
			String name = res.getString(1);
			//System.out.println(name);
			return name;
		}
		
		
		
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null,"Something Wrong ");
			return null;
		}
		return null;
		
		
		
	}
	
	public String login(String username,String pass) {
		sql="SELECT Job  FROM users WHERE username='"+username+"' and password='"+pass+"'";
		try { 
			res=stat.executeQuery(sql);
			if(res.next()) {
				
				return res.getString("job");
				
			}
		}
		catch(Exception ae) {
			JOptionPane.showMessageDialog(null,"Wrong user name or password");
		}
		
		
		
		return null;
	}
	
//	public void  
	
	
	public void deleteRow(String sql) {
		try {
			stat.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"delete Complete");
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Something Wrong");
		}
		
	}
	
	public void addData(String sql) {
		try {
			
			//System.out.println(sql);
			stat.executeUpdate(sql);
			
			JOptionPane.showMessageDialog(null,"Successfully Done");
			
		}
		
		catch (Exception e){
			
			JOptionPane.showMessageDialog(null,"Wrong Information");
		}
		
	}
	
	public void updateData(String sql) {
		try {
			stat.executeUpdate(sql);
			JOptionPane.showMessageDialog(null,"Update Complete");
		}
		catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Something Wrong");
		}
		
	}
	
	
public ArrayList<FinancialTemp> getFinancial(String sql){
		
		ArrayList<FinancialTemp> list=new ArrayList<FinancialTemp>();
		
		try {
		
			//System.out.print(sql);
			
			res=stat.executeQuery(sql);
			while(res.next()) {
				FinancialTemp f=new FinancialTemp();
				//f.billno=res.getInt("id");
			  f.date=(res.getDate("date")).toString();
;			f.time=(res.getTime("time")).toString();
			f.price=res.getInt("totalprice");
				list.add(f);
				
			}
			
		}
		catch (SQLException e){
			
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null,"wrong");
			
		}
		return list;
	}
	
	
	
	public ArrayList<UserTemp> getUsers(String sql){
		
		ArrayList<UserTemp> list=new ArrayList<UserTemp>();
		
		try {
			
			res=stat.executeQuery(sql);
			while(res.next()) {
				UserTemp user=new UserTemp();
				user.name=res.getString("name");
				user.userName=res.getString("username");
				user.job=res.getString("job");
				user.password=res.getString("password");
				list.add(user);
				
			}
			
		}
		catch (SQLException e){
			
		}
		return list;
	}
	
	public ArrayList<FoodTemp> getFoodItem(String sql){
		
		ArrayList<FoodTemp> list=new ArrayList<FoodTemp>();
		
		try {
			res=stat.executeQuery(sql);
			while(res.next()) {
				
				FoodTemp food=new FoodTemp();
				food.foodid=res.getInt("foodid");
				food.foodName=res.getString("name");
				food.price=res.getInt("price");
				list.add(food);
			}
			
		}
       catch (SQLException e){
			
		}
		return list;
		
	}
	
	
	 
	public ArrayList<EmployeeTemp> getEmployee(String sql){
		ArrayList<EmployeeTemp> list = new ArrayList<EmployeeTemp>();
		
		try{
			res = stat.executeQuery(sql);
			while(res.next())
			{
				EmployeeTemp e = new EmployeeTemp();
				e.id=res.getString("id");
				e.name=res.getString("name");
				
				e.job=res.getString("job");
				e.salary=res.getString("salary");
				list.add(e);
			}
		}
		catch (SQLException e){
			
		}
		return list;
	}
	
	
	
	

}
