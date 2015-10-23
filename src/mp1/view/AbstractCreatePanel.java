package mp1.view;

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

import mp1.controller.IController;
import mp1.model.Shape;
import mp1.view.layout.AGBLayout;

/**
 *
 * @author Austin Fernandez
 */
public abstract class AbstractCreatePanel extends JPanel {
	protected Shape shape; 

	protected JButton backButton;

	private IController control;

	public AbstractCreatePanel(Shape shape, IController control) {
		this.shape = shape;
		this.control = control;

		setLayout(new AGBLayout());
		setBorder(BorderFactory.createEmptyBorder(5,10,10,10));

		backButton = new JButton("Back");
		backButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		backButton.addActionListener(new BackListener());

		createComponents();
		addBack();
	}

	protected abstract void createComponents();

	protected abstract void addBack();

	protected abstract double[] getParams() throws Exception;

	protected abstract void clear();

	public void setBackVisible(boolean visible) {
		backButton.setVisible(visible);
	}

	protected class CreateListener implements ActionListener, KeyListener{
		private void create() {
			try {
				control.createShape(shape,getParams());
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null,ex.getMessage()
											,"Incorrect Input",
											JOptionPane.ERROR_MESSAGE);
			}
		}

		public void actionPerformed(ActionEvent e) {
			create();
		}

		public void keyPressed(KeyEvent e) {}
		
		public void keyTyped(KeyEvent e) {
			if( e.getKeyChar() == '\n' ) {
				create();
			}
		}
		
		public void keyReleased(KeyEvent e) {}
	}

	protected class BackListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			control.showMain();
		}
 	}
}