package view;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class UserSearchResults {
	private static String forename;
	private static String surname;
	private static String email;
	static JFrame frame;
	private final static int VERTICAL_BUFFER = 20;
	private static int frameWidth = 475;
	private static int frameHeight = 350;
	private static ArrayList<SearchRecords> returnedUsers = null;

	static void initialize(SearchRecords sr) {
		
		
		//////////////////perform search/////////////////////
		//TODO: needs to go in separate thread???
		//TODO: this needs to make a new Search records object to pass in table, serach terms and columns to return
		//TODO: then pass this to selectquery
		//eturnedUsers = null;

		
		SelectQuery.runQuery(sr);
		
		
		
		// frame
		frame = new JFrame();
		frame.setBounds(250, 250, frameWidth, frameHeight);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setTitle("Search for analysis");
		// panel in frame
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		// Window main title
		JLabel lblFrameTitle = new JLabel("Following users found:");
		lblFrameTitle.setBounds(10, 0, (int) lblFrameTitle.getPreferredSize().getWidth(), 25);
		panel.add(lblFrameTitle);
		// further info label
		JLabel lblInfo = new JLabel("Select user to view or edit or select Add User...");
		lblInfo.setBounds(10, 10 + (int) lblFrameTitle.getPreferredSize().getHeight(),
				(int) lblInfo.getPreferredSize().getWidth(), 25);
		lblInfo.setFont(new Font(lblInfo.getFont().getName(), Font.ITALIC, lblInfo.getFont().getSize()));
		panel.add(lblInfo);
		frame.setVisible(true);

		//////////////// Table to display found users/////////////////////
		
		String[] columnNames = { "First Name", "Surname", "Username"};
		ArrayList<String[]> dataArrayList = new ArrayList<String[]>();
		for (String[] r : sr.getData()){
			
			dataArrayList.add(r);
		}
		String[][] data = dataArrayList.toArray(new String[dataArrayList.size()][]);
		
		JTable table = new JTable(data, columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(10, lblInfo.getY() + lblInfo.getHeight(), frameWidth - 30, 200);
		table.setFillsViewportHeight(true);
		
		panel.add(scrollPane);

		//////////////// Select/View/Edit user////////////////////////
		JButton btnSelect = new JButton("Select user");
		btnSelect.setBounds(10, scrollPane.getY() + scrollPane.getHeight(),
				(int) btnSelect.getPreferredSize().getWidth(), 25);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// Set new analysis user variable and close search resutlts and serach dialogues
				
				SearchUser.closeWindow();
				frame.dispose();
				
				NewAnalysis.setUser(sr.getRecord(table.getSelectedRow()));
				
				

			}
		});
		panel.add(btnSelect);
		
		
		JButton btnViewEdit = new JButton("View/Edit User");
		btnViewEdit.setBounds(10 + btnSelect.getX() + btnSelect.getWidth(), btnSelect.getY(),
				(int) btnViewEdit.getPreferredSize().getWidth(), 25);
		btnViewEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO: will open view/edit user dialoge
				AddUser.initialize("edit");
				

			}
		});
		panel.add(btnViewEdit);
		
		JButton btnNewUser = new JButton("New User");
		
		btnNewUser.setBounds(10 + btnViewEdit.getX() + btnViewEdit.getWidth(), btnViewEdit.getY(),
				(int) btnNewUser.getPreferredSize().getWidth(), 25);
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO: will open add new user dialogue
				AddUser.initialize("add");
				frame.dispose();
				SearchUser.closeWindow();
				

			}
		});
		panel.add(btnNewUser);

		// cancel button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10 + (int) btnNewUser.getPreferredSize().getWidth() + btnNewUser.getX(),
				btnNewUser.getY(), (int) btnCancel.getPreferredSize().getWidth(), 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				frame.dispose();
				System.out.println("Cancel button pressed");
			}
		});
		panel.add(btnCancel);

	}
	public static void setReturnedUsers(ArrayList<SearchRecords> ru){
		returnedUsers = ru;
	}

}
