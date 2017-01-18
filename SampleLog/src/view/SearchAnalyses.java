package view;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SearchAnalyses {
	static JFrame frame;
	private final static int VERTICAL_BUFFER = 20;
	private static int frameWidth = 475;
	private static int frameHeight = 300;

	static void initialize() {

		// frame
		frame = new JFrame();
		frame.setBounds(150, 150, frameWidth, frameHeight);
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

		// First name text field

		JTextField textSecond = new JTextField();
		textSecond.setBounds(110, lblSecond.getY(), 170, 25);
		// textField.setText(lblFirst);
		textSecond.setEditable(true);
		textSecond.setColumns(10);
		panel.add(textSecond);

		/////////////////// Account name://////////////////////

		// account label
		JLabel lblAccount = new JLabel("Account no.:");
		lblAccount.setBounds(100 - (int) lblAccount.getPreferredSize().getWidth(),
				lblSecond.getY() + lblSecond.getHeight(), (int) lblAccount.getPreferredSize().getWidth(), 25);

		panel.add(lblAccount);

		// First name text field

		JTextField textAccount = new JTextField();
		textAccount.setBounds(110, lblAccount.getY(), 170, 25);
		// textField.setText(lblFirst);
		textAccount.setEditable(true);
		textAccount.setColumns(10);
		panel.add(textAccount);

		/////////////////// PI name://////////////////////

		// pi label
		JLabel lblPI = new JLabel("PI surname:");
		lblPI.setBounds(100 - (int) lblPI.getPreferredSize().getWidth(), lblAccount.getY() + lblAccount.getHeight(),
				(int) lblPI.getPreferredSize().getWidth(), 25);

		panel.add(lblPI);

		// pi surname text field
		// TODO: make into dropdown of available PIs
		JTextField textPI = new JTextField();
		textPI.setBounds(110, lblPI.getY(), 170, 25);
		// textField.setText(lblFirst);
		textPI.setEditable(true);
		textPI.setColumns(10);
		panel.add(textPI);

		/////////////////// Analysis number://////////////////////

		// analysis label
		JLabel lblAnalysisNo = new JLabel("Analysis number:");
		lblAnalysisNo.setBounds(100 - (int) lblAnalysisNo.getPreferredSize().getWidth(),
				lblPI.getY() + lblPI.getHeight(), (int) lblAnalysisNo.getPreferredSize().getWidth(), 25);

		panel.add(lblAnalysisNo);

		// pi surname text field

		JTextField textAnalysisNo = new JTextField();
		textAnalysisNo.setBounds(110, lblAnalysisNo.getY(), 170, 25);
		// textField.setText(lblFirst);
		textAnalysisNo.setEditable(true);
		textAnalysisNo.setColumns(10);
		panel.add(textAnalysisNo);

		//////////////// Search////////////////////////

		JButton btnSearch = new JButton("Search archive");
		btnSearch.setBounds(10, textAnalysisNo.getY() + textAnalysisNo.getHeight(),
				(int) btnSearch.getPreferredSize().getWidth(), 25);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO: will open search results dialoge
				System.out.println("search button pressed");

			}
		});
		panel.add(btnSearch);

		// cancel button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10 + (int) btnSearch.getPreferredSize().getWidth() + btnSearch.getX(),
				btnSearch.getY(), (int) btnCancel.getPreferredSize().getWidth(), 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				frame.dispose();
				System.out.println("Cancel button pressed");
			}
		});
		panel.add(btnCancel);

	}
}
