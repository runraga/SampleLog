package view;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InsertQuery {
	private static Connection con = null;
	private static Statement st = null;
	private static int rs;
	private static PreparedStatement pst = null;

	private static String url = "jdbc:mysql://www.helmfarm.com:3306/MSFacility";
	private static String user = "jrault";
	private static String password = "Astbury7019";
	
	static void initialize(SearchRecords sr){
		


		try
		{
			//TODO:need to build select query based on calling window
			String insert = "INSERT into `" + sr.getTable() + "` (";
			
			String[][] rc = sr.getSearchTerms();
			sr.printOut();
			
			for (int i=0; i < rc.length; i++){
				insert += "`" + rc[i][0] + "`";
				if (i != rc.length-1){
					insert += ", ";
				} else {
					insert += ") ";
				}
			}
			
			
			
			
			
			String values = "VALUES ";
			for (int i = 0; i < rc.length; i++){
				values += "(?)";
				
				if (i != rc.length -1){
					values += ", ";
				}
						
				
			}
			

			con = DriverManager.getConnection(url, user, password);
			
			pst = con.prepareStatement(insert+values);
			
			for (int j = 0; j < rc.length; j++){
				pst.setString(j+1, rc[j][1]);
			}
			rs = pst.executeUpdate();
			
			

		}catch(
		SQLException ex)
		{

			Logger lgr = Logger.getLogger(CheckConnection.class.getName());
			lgr.log(Level.SEVERE, ex.getMessage(), ex);

		}finally
		{

			try {

				

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
