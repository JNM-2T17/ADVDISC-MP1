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

public class ScalePanel extends TransParamPanel {
	private JLabel scalarLabel;
	private JTextField scalarField;

	public ScalePanel(IController control) {
		super(Transformation.SCALE,control);
	}

	protected void addComponents() {
		scalarLabel = new JLabel("Scalar:");
		scalarLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,scalarLabel,0,0,1,1,100,100
							,GridBagConstraints.EAST
							,GridBagConstraints.NONE);

		scalarField = new JTextField(15);
		scalarField.addActionListener(inputListen);
		scalarField.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,scalarField,1,0,1,1,100,100
							,GridBagConstraints.WEST
							,GridBagConstraints.NONE);

	}

	protected ITransform getCommand() throws IllegalArgumentException {
		double scalar = 0;
		String error = "";

		try {
			scalar = Double.parseDouble(scalarField.getText());
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") + "Invalid scalar value";
		}	

		if( error.length() == 0 ) {
			return new Scale(scalar);
		} else {
			throw new IllegalArgumentException(error);
		}
	}
}