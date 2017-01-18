package view;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class ConsoleWindow {
	private static JFrame frame;
	private static JTextField textField;
	// private static String selectedFile;
	private static DefaultListModel<SearchRecords> listModelUsers;
	private static JList<SearchRecords> jListUsers;

	static void initialize() {

		// frame
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setTitle("Sample Log Console");
		// panel in frame
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		// version information
		JLabel lblCurrentUniprotVersion = new JLabel("Sample Log Console");
		lblCurrentUniprotVersion.setBounds(0, 0, 150, 25);
		panel.add(lblCurrentUniprotVersion);
		frame.setVisible(true);

		// new analysis button and listener
		JButton btnNewAnalysis = new JButton("New analysis");
		btnNewAnalysis.setBounds(75, 25, 150, 25);
		btnNewAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				NewAnalysis.initialize();
				
			}
		});
		panel.add(btnNewAnalysis);

		// new Current analysis button and listener
		JButton btnCurrAnalysis = new JButton("Active analyses");
		btnCurrAnalysis.setBounds(75, 55, 150, 25);
		btnCurrAnalysis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				
				ActiveAnalyses.initialize();
				System.out.println("Current/active analysis button pressed");
			}
		});
		panel.add(btnCurrAnalysis);

		// Search analyses archive button and listener
		JButton btnSearchAnalyses = new JButton("Search Analyses");
		btnSearchAnalyses.setBounds(75, 85, 150, 25);
		btnSearchAnalyses.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SearchAnalyses.initialize();
				
			}
		});
		panel.add(btnSearchAnalyses);

		// Generate report archive button and listener
		JButton btnGenerateReport = new JButton("Generate Report");
		btnGenerateReport.setBounds(75, 115, 150, 25);
		btnGenerateReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				GenerateReports.initialize();
				
			}
		});
		panel.add(btnGenerateReport);

		
		// View stats button and listener
		JButton btnUsageStats = new JButton("View Usage Stats");
		btnUsageStats.setBounds(75, 145, 150, 25);
		btnUsageStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO: will open view stats report screen
				System.out.println("Usage Stats button pressed");
			}
		});
		panel.add(btnUsageStats);
	}

	/*
	 * //add list of all users listModelUsers = new DefaultListModel<User>();
	 * ArrayList<User> names = runSQLQuery();
	 * 
	 * 
	 * for (User an : names) { //System.out.println(an[0]);
	 * listModelUsers.addElement(an);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * jListUsers = new JList<User>(listModelUsers);
	 * jListUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	 * jListUsers.setBounds(169, 30, 350, 180); JScrollPane scrollPane = new
	 * JScrollPane(jListUsers);
	 * scrollPane.setVerticalScrollBarPolicy(JScrollPane.
	 * VERTICAL_SCROLLBAR_ALWAYS); scrollPane.setBounds(169, 30, 350, 180);
	 * panel.add(scrollPane);
	 * 
	 * JButton btnSelectUser = new JButton("Select User");
	 * btnSelectUser.addActionListener(new ActionListener() { public void
	 * actionPerformed(ActionEvent e) { if (!jListUsers.isSelectionEmpty()){
	 * EventQueue.invokeLater(new Runnable() { public void run() { try { //pass
	 * User to new instance of NewAnalysis window User names =
	 * listModelUsers.get(jListUsers.getSelectedIndex()); System.out.println(
	 * "Name: "+ names.toString() + "\nUsername: " + names.getUsername() );
	 * 
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } } });}
	 * 
	 * } }); btnSelectUser.setBounds(169, 221, 150, 23);
	 * panel.add(btnSelectUser);}
	 */
/*
	static ArrayList<SearchRecords> runSQLQuery() {

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement pst = null;
		ArrayList<SearchRecords> names = new ArrayList<SearchRecords>();

		String url = "jdbc:mysql://www.helmfarm.com:3306/MSFacility";
		String user = "jrault";
		String password = "Astbury7019";

		try {

			String analysis_type = "mass_analysis";

			con = DriverManager.getConnection(url, user, password);

			pst = con.prepareStatement("SELECT `firstName`, `lastName`, `Username` FROM `Users` ORDER BY `lastName`");

			rs = pst.executeQuery();

			while (rs.next()) {
				SearchRecords u = new SearchRecords(rs.getString(3), rs.getString(1), rs.getString(2));
				names.add(u);

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
		return names;
	}
*/
}
