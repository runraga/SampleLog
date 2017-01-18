package view;
import java.util.HashMap;

public class SearchRecords {
	private String[][] searchTerms;
	private String searchTable;
	private String[] returnedColumns;
	private String[][] data;
	
	
	//TODO: pass in parameters:search string, which table to serach and columns to return
	
	
	public SearchRecords(String[][] searchTerms, String searchTable, String[] returnedColumns){
		this.searchTerms = searchTerms;
		this.searchTable = searchTable;
		this.returnedColumns = returnedColumns;
	}

	
	public void setReturnedUsers(String[][] usersReturned){
		data = usersReturned;
	
	}
	public String getTable(){
		return searchTable;
	}
	public String[][] getSearchTerms(){
		return searchTerms;
		
	}
	public String[][] getData(){
		return data;
		
	}
	public String[] getReturnedColumns(){
		return returnedColumns;
	}
	public String[] getRecord(int record){
		
		
		return data[record];
		
		
	}

	public void printOut(){
		for (String[] sa : searchTerms){
			for(String s : sa){
				System.out.println(s);
			}
		}
		
	}
}

