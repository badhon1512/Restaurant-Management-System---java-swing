import javax.swing.JTable.*;
import javax.swing.table.AbstractTableModel;
import java.util.*;

public class FoodTableModel extends AbstractTableModel {
	
	private String []columnName= {"foodid","Food Name","price"};
	private ArrayList<FoodTemp> food=new ArrayList<FoodTemp>();
	private DataAccess data;
	
	public FoodTableModel() {
		
		data=new DataAccess();
		
		String sql="Select * From fooditem";
		food=data.getFoodItem(sql);
		
		
		
		
	}
	
	
	
	
	public int getRowCount() {
		
		return food.size();
		
	}
	
  public int getColumnCount() {
		return columnName.length;
	}
  
  public String getColumnName(int col) {
		
	  return columnName[col];
	}
  public Object getValueAt(int row,int col) {
	  
	  
	  if(food.size()==0)
			return null;
		try{
			
			FoodTemp food1=food.get(row);
			switch(col)
			{
				case 0:
					return food1.foodid;
				case 1:
					return food1.foodName;
				case 2:
					return food1.price;
			
				default:
					return  null;
			}
		}
		catch(Exception ea) {
			
			return null;
			
		}
		
  }

}
