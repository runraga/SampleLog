package view;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class GenerateReports {
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
		frame.setTitle("Generate usage report");
		// panel in frame
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Window main title
		JLabel lblFrameTitle = new JLabel("Generate a usage report:");
		lblFrameTitle.setBounds(10, 0, (int) lblFrameTitle.getPreferredSize().getWidth(), 25);
		panel.add(lblFrameTitle);
		// further info label
		JLabel lblInfo = new JLabel("Select a date range, an XML will be downloaded to the specified folder...");
		lblInfo.setBounds(10, 10 + (int) lblFrameTitle.getPreferredSize().getHeight(),
				(int) lblInfo.getPreferredSize().getWidth(), 25);
		lblInfo.setFont(new Font(lblInfo.getFont().getName(), Font.ITALIC, lblInfo.getFont().getSize()));
		panel.add(lblInfo);
		frame.setVisible(true);

		/////////////////// Start date://////////////////////

		// dtart date label
		JLabel lblStart = new JLabel("Start date:");
		lblStart.setBounds(100 - (int) lblStart.getPreferredSize().getWidth(), lblInfo.getY() + lblInfo.getHeight(),
				(int) lblStart.getPreferredSize().getWidth(), 25);

		panel.add(lblStart);

		// start date picker field
		UtilDateModel modelStart = new UtilDateModel();
		Calendar now = Calendar.getInstance();
		modelStart.setDate(now.get(Calendar.YEAR), now.get(Calendar.MONTH) - 1, now.get(Calendar.DATE));
		modelStart.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanelStart = new JDatePanelImpl(modelStart, p);
		JDatePickerImpl datePickerStart = new JDatePickerImpl(datePanelStart, new DateLabelFormatter());
		datePickerStart.setBounds(lblStart.getX() + lblStart.getWidth() + 10, lblStart.getY(), 120, 30);
		panel.add(datePickerStart);

		// end date label
		JLabel lblEnd = new JLabel("End date:");
		lblEnd.setBounds(100 - (int) lblEnd.getPreferredSize().getWidth(), 10 + lblStart.getY() + lblStart.getHeight(),
				(int) lblEnd.getPreferredSize().getWidth(), 25);

		panel.add(lblEnd);

		// end date picker field
		UtilDateModel modelEnd = new UtilDateModel();
		modelEnd.setSelected(true);
		Properties p1 = new Properties();
		p1.put("text.today", "Today");
		p1.put("text.month", "Month");
		p1.put("text.year", "Year");
		JDatePanelImpl datePanelEnd = new JDatePanelImpl(modelEnd, p1);
		JDatePickerImpl datePickerEnd = new JDatePickerImpl(datePanelEnd, new DateLabelFormatter());
		datePickerEnd.setBounds(lblEnd.getX() + lblEnd.getWidth() + 10, lblEnd.getY(), 120, 30);
		panel.add(datePickerEnd);

		/////////////////// File chooser path://////////////////////

		// path label
		JLabel lblPath = new JLabel("Save File to...:");
		lblPath.setBounds(100 - (int) lblPath.getPreferredSize().getWidth(), 10 + lblEnd.getY() + lblEnd.getHeight(),
				(int) lblPath.getPreferredSize().getWidth(), 25);

		panel.add(lblPath);

		// File path text field

		JTextField textChosenPath = new JTextField();
		textChosenPath.setBounds(10 + lblPath.getX() + lblPath.getWidth(), lblPath.getY(), 170, 25);
		// textField.setText(lblFirst);
		textChosenPath.setEditable(true);
		textChosenPath.setColumns(10);
		panel.add(textChosenPath);

		// choose folder path button
		JButton btnChoosePath = new JButton("Choose path...");
		btnChoosePath.setBounds(10 + textChosenPath.getX() + textChosenPath.getWidth(), textChosenPath.getY(),
				(int) btnChoosePath.getPreferredSize().getWidth(), 25);
		btnChoosePath.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					textChosenPath.setText(chooser.getSelectedFile().toString());
					System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
					System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
				} else {
					System.out.println("No Selection ");
				}

			}
		});
		panel.add(btnChoosePath);

		//////////////// Generate report////////////////////////

		JButton btnGenerate = new JButton("Generate");
		btnGenerate.setBounds(10, 10 + lblPath.getY() + lblPath.getHeight(),
				(int) btnGenerate.getPreferredSize().getWidth(), 25);
		btnGenerate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO: will open search results dialoge
				System.out.println("generate button pressed");

			}
		});
		panel.add(btnGenerate);

		// cancel button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10 + (int) btnGenerate.getPreferredSize().getWidth() + btnGenerate.getX(),
				btnGenerate.getY(), (int) btnGenerate.getPreferredSize().getWidth(), 25);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				frame.dispose();
				System.out.println("Cancel button pressed");
			}
		});
		panel.add(btnCancel);

	}

}
