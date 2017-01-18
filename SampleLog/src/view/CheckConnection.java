package view;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CheckConnection {

    public static void main(String[] args) {

        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        PreparedStatement pst = null;

        String url = "jdbc:mysql://www.helmfarm.com:3306/MSFacility";
        String user = "jrault";
        String password = "Astbury7019";

        try {
        	
        	String analysis_type = "mass_analysis";
            
            con = DriverManager.getConnection(url, user, password);
            
            pst = con.prepareStatement("SELECT `username`, `submission_number` FROM `submission` WHERE `analysis_type` = (?) AND `username` = (?)");
            pst.setString(1, analysis_type);
            pst.setString(2, "fbsjames");
            rs = pst.executeQuery();
            
            while (rs.next()){
            	System.out.print(rs.getString(1));
            	System.out.print(": ");
            	System.out.println(rs.getString(2));
            	
            }


        } catch (SQLException ex) {
        
            Logger lgr = Logger.getLogger(CheckConnection.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            
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
