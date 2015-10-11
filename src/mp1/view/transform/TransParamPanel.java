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
import mp1.model.Transformation;
import mp1.view.layout.AGBLayout;

public abstract class TransParamPanel extends JPanel {
	private Transformation trans;

	protected IController control;

	public TransParamPanel(Transformation trans, IController control) {
		this.trans = trans;
		this.control = control;
	}

	public Transformation getTransformation() {
		return trans;
	}
}