package view;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class NewAnalysis {

	private static JFrame frame;
	private static JTextField textField;
	// private static String selectedUser = "Select a user...";
	private static String[] selectedUser = null;
	private static JTextField accountNumber;

	static void initialize() {

		// frame
		frame = new JFrame();
		frame.setBounds(150, 150, 475, 300);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setTitle("Log New Analysis");
		// panel in frame
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		// version information
		JLabel lblFrameTitle = new JLabel("Enter new analysis details:");
		lblFrameTitle.setBounds(0, 0, (int) lblFrameTitle.getPreferredSize().getWidth(), 25);
		panel.add(lblFrameTitle);
		frame.setVisible(true);

		///////////// Select user////////////////////

		// User label
		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(100 - (int) lblUser.getPreferredSize().getWidth(), 40,
				(int) lblUser.getPreferredSize().getWidth(), 25);

		panel.add(lblUser);

		// User selected
		textField = new JTextField();
		textField.setBounds(110, 40, 170, 25);
		textField.setText(getUserText());
		textField.setEditable(false);
		textField.setColumns(10);
		panel.add(textField);

		// search user button and listener
		JButton btnSearchUser = new JButton("Search for User");
		btnSearchUser.setBounds(285, 40, 150, 25);
		btnSearchUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				SearchUser.initialize();

			}
		});
		panel.add(btnSearchUser);

		// add new user button and listener
		JButton btnAddUser = new JButton("Add New User");
		btnAddUser.setBounds(285, 70, 150, 25);
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO: will open add new user dialog
				AddUser.initialize("add");

				System.out.println("Add new user button pressed");
			}
		});
		panel.add(btnAddUser);

		///////////// Select analysis type////////////////////

		// Analysis type label
		JLabel lblAnalysisType = new JLabel("Analysis Type:");
		lblAnalysisType.setBounds(100 - (int) lblAnalysisType.getPreferredSize().getWidth(), 100,
				(int) lblAnalysisType.getPreferredSize().getWidth(), 25);
		panel.add(lblAnalysisType);

		// Analysis type dropdown

		String[] analysisTypes = { "Mass", "ProteinID", "Native-MS", "HDX", "FPOP" };

		// Create the combo box, select item at index 4.
		// Indices start at 0, so 4 specifies the pig.
		String notSelectable = "--Choose analysis type--";

		JComboBox<String> analysisList = new JComboBox<String>();

		analysisList.setModel(new DefaultComboBoxModel<String>() {
			private static final long serialVersionUID = 1L;
			boolean selectionAllowed = true;

			@Override
			public void setSelectedItem(Object anObject) {
				if (!notSelectable.equals(anObject)) {
					super.setSelectedItem(anObject);
				} else if (selectionAllowed) {
					selectionAllowed = false;
					super.setSelectedItem(anObject);
				}
			}
		});
		analysisList.addItem(notSelectable);
		for (String s : analysisTypes) {
			analysisList.addItem(s);
		}
		analysisList.setBounds(110, 100, 170, 25);

		panel.add(analysisList);

		///////////// Number of samples ////////////////////

		// Analysis type label
		JLabel lblNumberSamples = new JLabel("No. samples:");
		lblNumberSamples.setBounds(100 - (int) lblNumberSamples.getPreferredSize().getWidth(), 130,
				(int) lblNumberSamples.getPreferredSize().getWidth(), 25);
		panel.add(lblNumberSamples);

		// Text field for number of samples
		String defaultNoSamplesText = "Enter number of samples...";
		String noSamplesText = "Enter number of samples...";
		JTextField numberSamples = new JTextField();
		numberSamples.setBounds(110, 130, 170, 25);
		numberSamples.setText(defaultNoSamplesText);
		numberSamples.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (defaultNoSamplesText == noSamplesText) {
					numberSamples.setText("");

				}

			}

			public void focusLost(FocusEvent arg0) {

			}

		});
		numberSamples.setColumns(10);
		panel.add(numberSamples);

		///////////// Account number details ////////////////////

		// Account number label
		JLabel lblAccountNumber = new JLabel("Account no.:");
		lblAccountNumber.setBounds(100 - (int) lblAccountNumber.getPreferredSize().getWidth(), 160,
				(int) lblAccountNumber.getPreferredSize().getWidth(), 25);
		panel.add(lblAccountNumber);

		// Text field for number of samples
		String defaultFieldText = "Enter account number...";
		String fieldText = "Enter account number...";
		accountNumber = new JTextField();
		accountNumber.setBounds(10 + (int) lblAccountNumber.getPreferredSize().getWidth() + lblAccountNumber.getX(),
				lblAccountNumber.getY(), 180, 25);
		accountNumber.setText(
				// TODO: check if user is FBS member and input default account
				// code if yes otherwise:
				fieldText);
		accountNumber.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (defaultFieldText == fieldText) {
					accountNumber.setText("");

				}

			}

			public void focusLost(FocusEvent arg0) {

			}

		});
		accountNumber.setColumns(10);
		panel.add(accountNumber);

		///////////// Submit analysis////////////////////

		// Log new analysis button
		JButton btnLogIn = new JButton("Log new analysis");
		btnLogIn.setBounds(110, 210, (int) btnLogIn.getPreferredSize().getWidth(), 25);
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO: will enter new analysis into database and return new
				// analysis number

				// String SQLQuery =

				// run SQL query

				// code from search user query, modify for insert query
				ArrayList<String[]> st = new ArrayList<String[]>();
				
				if (selectedUser != null) {
					
					String [] a = new String[] { "username", selectedUser[2] };
					st.add(a);
					
					
				}
				if (Arrays.asList(analysisTypes).contains(analysisList.getSelectedItem())) {
					
					
					String [] b = new String[] { "analysis_type", analysisTypes[analysisList.getSelectedIndex()] };
					st.add(b);
					
					
				}
				
				if (IsInt(numberSamples.getText())) {
					
					String [] c = new String[] { "number_samples", numberSamples.getText() };
					st.add(c);
					
				} else {
					// TODO: shows error message and prevents logging new sample
				}
				
				SearchRecords sr = new SearchRecords(st.toArray(new String[st.size()][]), "submission", null);
				
				InsertQuery.initialize(sr);

				System.out.println("Log in new analysis button pressed");
			}
		});
		panel.add(btnLogIn);

		// cancel button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(120 + (int) btnLogIn.getPreferredSize().getWidth(), 210,
				(int) btnCancel.getPreferredSize().getWidth(), 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				frame.dispose();
				System.out.println("Cancel button pressed");
			}
		});
		panel.add(btnCancel);

	}

	private static String getUserText() {
		if (selectedUser == null) {
			return "Select user...";
		} else {
			return selectedUser[0] + " " + selectedUser[1];
		}

	}

	public static void setUser(String[] u) {
		selectedUser = u;
		textField.setText(getUserText());
		// System.out.println(selectedUser[3]);
		checkOrigin();

	}

	private static void checkOrigin() {
		if (selectedUser[3] == "FBS" | selectedUser[3].contains("SMCB")) {
			accountNumber.setText("Free, no grant number needed");

			accountNumber.setEditable(false);
			for (FocusListener fl : accountNumber.getFocusListeners()) {
				accountNumber.removeFocusListener(fl);
			}

		}
	}

	private static boolean IsInt(String str) {
		try {
			
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

}
