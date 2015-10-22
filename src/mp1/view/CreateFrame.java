package mp1.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mp1.controller.IController;
import mp1.model.Shape;
import mp1.view.layout.AGBLayout;

/**
 *
 * @author Austin Fernandez
 */
public class CreateFrame extends JFrame {
	private AbstractCreatePanel createPanel;

	private JPanel mainPanel;

	public CreateFrame() {
		super();
		setTitle("Create Object");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		add(mainPanel,BorderLayout.CENTER);
	}

	public void setPanel(AbstractCreatePanel panel) {
		mainPanel.removeAll();
		mainPanel.add(panel,BorderLayout.CENTER);
		mainPanel.repaint();
		mainPanel.revalidate();
		center();
	}

	public void center() {
		pack();
		setLocationRelativeTo(null);
	}
}