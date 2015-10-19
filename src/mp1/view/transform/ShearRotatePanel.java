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

import mp1.controller.IController;
import mp1.model.Transformation;
import mp1.view.layout.AGBLayout;

public class ShearRotatePanel extends TransParamPanel {
	private JLabel thetaLabel;
	private JTextField thetaField;

	public ShearRotatePanel(Transformation trans,IController control) {
		super(trans,control);
	}

	protected void addComponents() {
		thetaLabel = new JLabel("Angle in degrees (counterclockwise):");
		thetaLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,thetaLabel,0,0,1,1,100,100
							,GridBagConstraints.EAST
							,GridBagConstraints.NONE);

		thetaField = new JTextField("0",15);
		thetaField.addKeyListener(inputListen);
		thetaField.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,thetaField,1,0,1,1,100,100
							,GridBagConstraints.WEST
							,GridBagConstraints.NONE);

	}

	protected ITransform getCommand() throws IllegalArgumentException {
		double theta = 0;
		String error = "";

		try {
			String text = thetaField.getText();
			text = text.length() == 0  || text.equals("-") ? "0" : text;
			theta = Double.parseDouble(text);
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") + "Invalid theta value";
		}	

		if( error.length() == 0 ) {
			switch(getTransformation()) {
				case SHEAR:
					return new Shear(theta);
				case ROTATE_DOUBLE:
					return new RotateDouble(theta);
				default:
					return null;
			}
		} else {
			throw new IllegalArgumentException(error);
		}
	}
}