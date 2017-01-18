package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SelectQuery {
	
	private static Connection con = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	private static PreparedStatement pst = null;

	private static String url = "jdbc:mysql://www.helmfarm.com:3306/MSFacility";
	private static String user = "jrault";
	private static String password = "Astbury7019";
	
	static void runQuery(SearchRecords sr){
		

	try
	{
		//TODO:need to build select query based on calling window
		String select = "SELECT ";
		String[] rc = sr.getReturnedColumns();
		for (int i=0; i < rc.length; i++){
			select += "`" + rc[i] + "`";
			if (i != rc.length-1){
				select += ", ";
			} else {
				select += " ";
			}
		}
		
		
		
		
		String from = "FROM `" + sr.getTable() + "` ";
		String where = "WHERE ";
		ArrayList<String> inputted = new ArrayList<String>();
		String[][] st = sr.getSearchTerms();
		for (int i = 0; i < st.length; i++){
			
			where += "`" + st[i][0] + "` = (?)";
			inputted.add(st[i][1]);
			if (i != st.length -1){
				where += " AND ";
			}
					
			
		}
		

		con = DriverManager.getConnection(url, user, password);
		
		pst = con.prepareStatement(
				select+from+where);
		
		for (int j = 0; j < st.length; j++){
			pst.setString(j+1, inputted.get(j));
		}
		rs = pst.executeQuery();
		ArrayList<String[]> usersReturned = new ArrayList<String[]>();
		while (rs.next()) {
			//TODO: needs to build array based on number of columns selected
			int length = rc.length;
			String[] d = new String[length];
			for (int i=0; i < length; i++){
				d[i] = rs.getString(i+1);
				
			}
			usersReturned.add(d);
			
		}
		
		sr.setReturnedUsers(usersReturned.toArray(new String[usersReturned.size()][]));

	}catch(
	SQLException ex)
	{

		Logger lgr = Logger.getLogger(CheckConnection.class.getName());
		lgr.log(Level.SEVERE, ex.getMessage(), ex);

	}finally
	{

		try {

			if (rs != null) {
				rs.close();
			}

			if (st != null) {
				st.close();
			}

			if (con != null) {
				con.close();
			}

		} catch (SQLException ex) {

			Logger lgr = Logger.getLogger(CheckConnection.class.getName());
			lgr.log(Level.WARNING, ex.getMessage(), ex);
		}
	}
}

}
