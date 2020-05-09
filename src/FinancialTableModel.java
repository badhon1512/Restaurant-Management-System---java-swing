import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.util.ArrayList;
 
public class FinancialTableModel extends AbstractTableModel {

	
	private String [] columnName= {"Date","Time","TotalBill"};
	private DataAccess data ;
	
	 String sql;
	private ArrayList<FinancialTemp> finalcial=new ArrayList<FinancialTemp>();
	public  FinancialTableModel (String month) {
	
		//System.out.println(month);
		if(month.equals("January"))
			 sql = "select * from financialinformation where date Like '%_____01%'"; 
		else if(month.equals("February"))
			 sql = "select * from financialinformation where date Like '%_____02%'"; 
		else if(month.equals("March"))
			 sql = "select * from financialinformation where date Like '%_____03%'"; 
		else if(month.equals("April"))
			 sql = "select * from financialinformation where date Like '%_____04%'";
		else if(month.equals("May"))
			 sql = "select * from financialinformation where date Like '%_____05%'"; 
		else if(month.equals("June"))
			 sql = "select * from financialinformation where date Like '%_____06%'"; 
		else if(month.equals("July"))
			 sql = "select * from financialinformation where date Like '%_____07%'"; 
		else if(month.equals("August"))
			 sql = "select * from financialinformation where date Like '%_____08%'";
		else if(month.equals("September"))
			 sql = "select * from financialinformation where date Like '%_____09%'";
		else if(month.equals("October"))
			 sql = "select * from financialinformation where date Like '%_____10%'"; 
		else if(month.equals("November"))
			 sql = "select * from financialinformation where date Like '%_____11%'"; 
		else if(month.equals("December"))
		 sql = "select * from financialinformation where date Like '%_____12%'"; 

		
	//	System.out.print(month);
		
		
		data = new DataAccess();
		//System.out.println(sql);
		finalcial = data. getFinancial(sql);
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
		
		return finalcial.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		
		if(finalcial.size()==0)
			return null;
		try{
			
			FinancialTemp F=finalcial.get(row);
			switch(column)
			
			{
				
				case 0:
					return F.date;
				case 1:
					return F.time;
				case 2:
					return F.price;
			
				default:
					return  null;
			}
		}
		catch(Exception ea) {
			
			return null;
			
		}
		
	
}
}