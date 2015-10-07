package mp1.view;

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
import mp1.model.Shape;
import mp1.view.layout.AGBLayout;

public abstract class AbstractCreatePanel extends JPanel {
	private Shape shape; 
	private IController control;

	public AbstractCreatePanel(Shape shape, IController control) {
		this.shape = shape;
		this.control = control;

		setLayout(new AGBLayout());
		setBorder(BorderFactory.createEmptyBorder(5,10,10,10));

		createComponents();
	}

	protected abstract void createComponents();

	protected abstract double[] getParams() throws Exception;

	protected abstract void clear();

	protected class CreateListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try {
				control.createShape(shape,getParams());
			} catch(Exception ex) {
				JOptionPane.showMessageDialog(null,ex.getMessage()
											,"Incorrect Input",
											JOptionPane.ERROR_MESSAGE);
				clear();
			}
		}
	}
}