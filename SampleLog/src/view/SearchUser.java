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
import javax.swing.JTextField;

public class SearchUser {
	static JFrame frame;
	private final static int VERTICAL_BUFFER = 20;
	private static int frameWidth = 475;
	private static int frameHeight = 300;

	static void initialize() {

		// frame
		frame = new JFrame();
		frame.setBounds(200, 200, frameWidth, frameHeight);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setTitle("Search for analysis");
		// panel in frame
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Window main title
		JLabel lblFrameTitle = new JLabel("Enter search information below:");
		lblFrameTitle.setBounds(10, 0, (int) lblFrameTitle.getPreferredSize().getWidth(), 25);
		panel.add(lblFrameTitle);
		// further info label
		JLabel lblInfo = new JLabel("You must fill in at least one field...");
		lblInfo.setBounds(10, 10 + (int) lblFrameTitle.getPreferredSize().getHeight(),
				(int) lblInfo.getPreferredSize().getWidth(), 25);
		lblInfo.setFont(new Font(lblInfo.getFont().getName(), Font.ITALIC, lblInfo.getFont().getSize()));
		panel.add(lblInfo);
		frame.setVisible(true);

		/////////////////// First name://////////////////////

		// first name label
		JLabel lblFirst = new JLabel("First name:");
		lblFirst.setBounds(100 - (int) lblFirst.getPreferredSize().getWidth(), lblInfo.getY() + lblInfo.getHeight(),
				(int) lblFirst.getPreferredSize().getWidth(), 25);

		panel.add(lblFirst);

		// First name text field

		JTextField textFirst = new JTextField();
		textFirst.setBounds(110, lblFirst.getY(), 170, 25);
		textFirst.setText(null);
		textFirst.setEditable(true);
		textFirst.setColumns(10);
		panel.add(textFirst);

		/////////////////// Second name://////////////////////

		// first name label
		JLabel lblSecond = new JLabel("Surname name:");
		lblSecond.setBounds(100 - (int) lblSecond.getPreferredSize().getWidth(), lblFirst.getY() + lblFirst.getHeight(),
				(int) lblSecond.getPreferredSize().getWidth(), 25);

		panel.add(lblSecond);

		// second name text field

		JTextField textSecond = new JTextField();
		textSecond.setBounds(110, lblSecond.getY(), 170, 25);
		textSecond.setText(null);
		textSecond.setEditable(true);
		textSecond.setColumns(10);
		panel.add(textSecond);

		/////////////////// email address://////////////////////

		// email label
		JLabel lblEmail = new JLabel("Email address:");
		lblEmail.setBounds(100 - (int) lblEmail.getPreferredSize().getWidth(), lblSecond.getY() + lblSecond.getHeight(),
				(int) lblEmail.getPreferredSize().getWidth(), 25);

		panel.add(lblEmail);

		// First name text field

		JTextField textEmail = new JTextField();
		textEmail.setBounds(110, lblEmail.getY(), 170, 25);
		textEmail.setText(null);
		textEmail.setEditable(true);
		textEmail.setColumns(10);
		panel.add(textEmail);

		//////////////// Search////////////////////////

		JButton btnSearch = new JButton("Search for user");
		btnSearch.setBounds(10, textEmail.getY() + textEmail.getHeight(), (int) btnSearch.getPreferredSize().getWidth(),
				25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO: will open search results dialoge
				ArrayList<String[]> st = new ArrayList<String[]>();

				if (textFirst.getText().length() > 0) {

					st.add(new String[] { "firstName", textFirst.getText() });
				}
				if (textSecond.getText().length() > 0) {

					st.add(new String[] { "lastName", textSecond.getText() });
				}
				if (textEmail.getText().length() > 0) {
					
					st.add(new String[] { "emailAddress", textEmail.getText() });
				}
				SearchRecords sr = new SearchRecords(st.toArray(new String[st.size()][]), "Users",
						new String[] { "firstName", "lastName", "Username", "department" });

				UserSearchResults.initialize(sr);

			}
		});
		panel.add(btnSearch);

		// cancel button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10 + (int) btnSearch.getPreferredSize().getWidth() + btnSearch.getX(), btnSearch.getY(),
				(int) btnCancel.getPreferredSize().getWidth(), 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				frame.dispose();
				System.out.println("Cancel button pressed");
			}
		});
		panel.add(btnCancel);

	}

	public static void closeWindow() {
		frame.dispose();
	}
}
