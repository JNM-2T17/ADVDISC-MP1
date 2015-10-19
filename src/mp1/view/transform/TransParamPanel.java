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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mp1.controller.IController;
import mp1.model.Transformation;
import mp1.view.layout.AGBLayout;

public abstract class TransParamPanel extends JPanel {
	private Transformation trans;
	protected IController control;
	protected InputListener inputListen;

	public TransParamPanel(Transformation trans, IController control) {
		super(new AGBLayout());
		this.trans = trans;
		this.control = control;
		inputListen = new InputListener();

		addComponents();
	}

	public Transformation getTransformation() {
		return trans;
	}

	protected abstract void addComponents();
	protected abstract ITransform getCommand() throws IllegalArgumentException;

	protected class InputListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				control.transform(getCommand());
			} catch(IllegalArgumentException iae) {
				System.out.println(trans);
				JOptionPane.showMessageDialog(null,iae.getMessage(),"Error"
												,JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}