package view;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class ActiveAnalyses {
	private final static int VERTICAL_BUFFER = 20;
	private static int frameWidth = 800;
	private static int frameHeight = 400;
	public static JFrame frame;

	static void initialize() {

		// frame
		frame = new JFrame();
		frame.setBounds(150, 150, frameWidth, frameHeight);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		frame.setTitle("Active analyses");
		// panel in frame
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		// Window main title
		JLabel lblFrameTitle = new JLabel("The following analyses are still open:");
		lblFrameTitle.setBounds(10, 0, (int) lblFrameTitle.getPreferredSize().getWidth(), 25);
		panel.add(lblFrameTitle);
		// further info label
		JLabel lblInfo = new JLabel("Select an analysis below to view/edit...");
		lblInfo.setBounds(10, 10 + (int) lblFrameTitle.getPreferredSize().getHeight(),
				(int) lblInfo.getPreferredSize().getWidth(), 25);
		lblInfo.setFont(new Font(lblInfo.getFont().getName(), Font.ITALIC, lblInfo.getFont().getSize()));
		panel.add(lblInfo);
		frame.setVisible(true);

		//////////////// Table to display active
		//////////////// analyses////////////////////////
		String[] columnNames = { "1", "2", "3", "4", "5", "6" };
		Object[][] data = { { "1", "A", "A", "A", "A", "A" }, { "1", "A", "A", "A", "A", "A" },
				{ "1", "A", "A", "A", "A", "A" }, { "1", "A", "A", "A", "A", "A" }, { "1", "A", "A", "A", "A", "A" },
				{ "1", "A", "A", "A", "A", "A" }

		};

		JTable table = new JTable(data, columnNames);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(10, lblInfo.getY() + lblInfo.getHeight(), frameWidth - 30, 200);
		table.setFillsViewportHeight(true);
		
		panel.add(scrollPane);

		//////////////// View/Edit analysis////////////////////////

		JButton btnViewEdit = new JButton("View/Edit analysis");
		
		btnViewEdit.setBounds(10, scrollPane.getY() + scrollPane.getHeight(),
				(int) btnViewEdit.getPreferredSize().getWidth(), 25);
		btnViewEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				// TODO: will open view/edit dialoge for active analysis
				
				
			}
		});
		panel.add(btnViewEdit);

		// cancel button
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10 + (int) btnViewEdit.getPreferredSize().getWidth() + btnViewEdit.getX(), btnViewEdit.getY(),
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
