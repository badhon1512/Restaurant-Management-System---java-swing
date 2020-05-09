import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;
public class UsersTableModel extends AbstractTableModel {
	
	private String []columnName= {"name","username","job"};
	private ArrayList<UserTemp> users=new ArrayList<UserTemp>();
	private String sql;
	private DataAccess data;
	
	public UsersTableModel() {
		data=new DataAccess();
		
		sql="Select * from users";
		users=data.getUsers(sql);
		
	}
	
	
	public int getColumnCount() {
		return columnName.length;
	}
	
	public String getColumnName(int col) {
		
		return columnName[col];
	}
	public int getRowCount() {
		return users.size();
	}
	
	public Object getValueAt(int row,int col) {
		
		
		if(users.size()==0)
			return null;
		try{
			
			UserTemp user1=users.get(row);
			switch(col)
			{
				case 0:
					return user1.name;
				case 1:
					
					return user1.userName;
				case 2:
					return user1.job;
				case 3:
					return user1.password;
			
				default:
					return  null;
			}
		}
		catch(Exception ea) {
			
			return null;
			
		}
		
		
	}

}
