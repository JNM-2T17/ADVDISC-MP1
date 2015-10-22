package mp1.view.transform;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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

/**
 *
 * @author Austin Fernandez
 */
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

	protected class InputListener implements ActionListener,KeyListener {
		private boolean confirmed;

		public InputListener() {
			super();
			confirmed = true;
		}

		private void transform() {
			try {
				control.transform(getCommand());
				confirmed = true;
			} catch(IllegalArgumentException iae) {
				if( confirmed ) {
					JOptionPane.showMessageDialog(null,iae.getMessage(),"Error"
													,JOptionPane.ERROR_MESSAGE);
					confirmed = false;
				}
			}
		}

		public void actionPerformed(ActionEvent e) {
			transform();
		}

		public void keyPressed(KeyEvent e) {}

		public void keyTyped(KeyEvent e) {
			if( e.getKeyChar() == '\n') {
				transform();
			}
		}

		public void keyReleased(KeyEvent e) {
			//transform();
		}
	}
}