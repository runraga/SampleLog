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

public class AddUser {
	static JFrame frame;
	private final static int VERTICAL_BUFFER = 20;
	private static int frameWidth = 475;
	private static int frameHeight = 350;

	static void initialize(String addOrEdit) {

		// frame
		frame = new JFrame();
		frame.setBounds(250, 250, frameWidth, frameHeight);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setTitle("Add a new user");
		// panel in frame
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		// Window main title
		JLabel lblFrameTitle = new JLabel("Add a new user:");
		lblFrameTitle.setBounds(10, 0, (int) lblFrameTitle.getPreferredSize().getWidth(), 25);
		panel.add(lblFrameTitle);
		// further info label
		JLabel lblInfo = new JLabel("Please fill in the following details about the new user...");
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

		/////////////////// email address://////////////////////

		// email label
		JLabel lblEmail = new JLabel("Email address:");
		lblEmail.setBounds(100 - (int) lblEmail.getPreferredSize().getWidth(), lblSecond.getY() + lblSecond.getHeight(),
				(int) lblEmail.getPreferredSize().getWidth(), 25);

		panel.add(lblEmail);

		// First name text field

		JTextField textEmail = new JTextField();
		textEmail.setBounds(110, lblEmail.getY(), 170, 25);
		// textField.setText(lblFirst);
		textEmail.setEditable(true);
		textEmail.setColumns(10);
		panel.add(textEmail);

		/////////////////// PI name://////////////////////

		// pi label
		JLabel lblPI = new JLabel("PI surname:");
		lblPI.setBounds(100 - (int) lblPI.getPreferredSize().getWidth(), lblEmail.getY() + lblEmail.getHeight(),
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

		/////////////////// Department://////////////////////

		// department label
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setBounds(100 - (int) lblDepartment.getPreferredSize().getWidth(),
				lblPI.getY() + lblPI.getHeight(), (int) lblDepartment.getPreferredSize().getWidth(), 25);

		panel.add(lblDepartment);

		// status text field
		// TODO: make into dropdown of available status options
		JTextField textDepatment = new JTextField();
		textDepatment.setBounds(110, lblDepartment.getY(), 170, 25);
		// textField.setText(lblFirst);
		textDepatment.setEditable(true);
		textDepatment.setColumns(10);
		panel.add(textDepatment);

		/////////////////// User status://////////////////////

		// pi label
		JLabel lblStatus = new JLabel("User status:");
		lblStatus.setBounds(100 - (int) lblStatus.getPreferredSize().getWidth(),
				lblDepartment.getY() + lblDepartment.getHeight(), (int) lblStatus.getPreferredSize().getWidth(), 25);

		panel.add(lblStatus);

		// status text field
		// TODO: make into dropdown of available status options
		JTextField textStatus = new JTextField();
		textStatus.setBounds(110, lblStatus.getY(), 170, 25);
		// textField.setText(lblFirst);
		textStatus.setEditable(true);
		textStatus.setColumns(10);
		panel.add(textStatus);

		//////////////// Add new user////////////////////////

		JButton btnAdd = new JButton("Add User");
		btnAdd.setBounds(10, textStatus.getY() + textStatus.getHeight(), (int) btnAdd.getPreferredSize().getWidth(),
				25);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO: will insert new user record into database and if
				// successful
				// will close window and put user details into new analysis user
				// field
				// if insert is not successful, show error warning
				System.out.println("add user button pressed");

			}
		});
		panel.add(btnAdd);

		// cancel button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10 + (int) btnAdd.getPreferredSize().getWidth() + btnAdd.getX(), btnAdd.getY(),
				(int) btnCancel.getPreferredSize().getWidth(), 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				frame.dispose();
				System.out.println("Cancel button pressed");
			}
		});
		panel.add(btnCancel);

	}

}
