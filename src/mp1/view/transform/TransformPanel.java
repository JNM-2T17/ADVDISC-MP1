package mp1.view.transform;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mp1.controller.IController;
import mp1.model.Shape;
import mp1.view.layout.AGBLayout;

public class TransformPanel extends JPanel {
	private JTabbedPane transformPane;
	private JLabel transformLabel;

	private IController control;

	public TransformPanel(IController control) {
		this.control = control;

		setLayout(new AGBLayout());

		transformLabel = new JLabel("Select Transformation Parameters");
		transformLabel.setFont(new Font("Segoe UI",Font.BOLD,32));
		AGBLayout.addComp(this,transformLabel,0,0,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		transformPane = new JTabbedPane();
		AGBLayout.addComp(this,transformPane,0,1,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
	}

	public void addPane(TransParamPanel panel) {
		transformPane.add(panel.getTransformation().toString(),panel);
	}

	public void clear() {
		transformPane.removeAll();
	}
}