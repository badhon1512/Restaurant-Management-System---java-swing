import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmployeeTableModel extends AbstractTableModel {

	
	private String [] columnName= {"id","name","job","Salary"};
	
	private ArrayList<EmployeeTemp> emp=new ArrayList<EmployeeTemp>();
	public EmployeeTableModel(String key) {
		String query = "select * from employee";  
		if(!key.equals(""))
			query = query + " where id ='"+key+"'";
		
		DataAccess da = new DataAccess();
		emp = da.getEmployee(query);
	}

	@Override
	public int getColumnCount() {
		
		return columnName.length;
	}
     
	public String getColumnName(int col) {
		return columnName[col];
	}
	@Override
	public int getRowCount() { 
		
		return emp.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		if(emp.size()==0)
			return null;
		try{
			
			EmployeeTemp emp1=emp.get(row);
			switch(column)
			{
				case 0:
					return emp1.id;
				case 1:
					return emp1.name;
				case 2:
					return emp1.job;
				case 3:
					return emp1.salary;
			
				default:
					return  null;
			}
		}
		catch(Exception ea) {
			
			return null;
			
		}
		
	
}
}