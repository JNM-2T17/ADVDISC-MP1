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

/**
 *
 * @author Austin Fernandez
 */
public class TranslatePanel extends TransParamPanel {
	private JLabel xLabel;
	private JTextField xField;
	private JLabel yLabel;
	private JTextField yField;

	public TranslatePanel(IController control) {
		super(Transformation.TRANSLATE,control);
	}

	protected void addComponents() {
		xLabel = new JLabel("X-Translation:");
		xLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,xLabel,0,0,1,1,100,100,GridBagConstraints.EAST
							,GridBagConstraints.NONE);

		xField = new JTextField("0",15);
		xField.addKeyListener(inputListen);
		xField.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,xField,1,0,1,1,100,100,GridBagConstraints.WEST
							,GridBagConstraints.NONE);

		yLabel = new JLabel("");
		yLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,yLabel,0,1,1,1,100,100,GridBagConstraints.EAST
							,GridBagConstraints.NONE);

		yField = new JTextField("0",15);
		yField.addKeyListener(inputListen);
		yField.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,yField,1,1,1,1,100,100,GridBagConstraints.WEST
							,GridBagConstraints.NONE);

	}

	protected ITransform getCommand() throws IllegalArgumentException {
		double x = 0;
		double y = 0;
		String error = "";

		try {
			String text = xField.getText();
			text = text.length() == 0  || text.equals("-") ? "0" : text;
			x = Double.parseDouble(text);
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") + "Invalid x value";
		}	

		try {
			String text = yField.getText();
			text = text.length() == 0  || text.equals("-") ? "0" : text;
			y = Double.parseDouble(text);
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") + "Invalid y value";
		}

		if( error.length() == 0 ) {
			return new Translate(x,y);
		} else {
			throw new IllegalArgumentException(error);
		}
	}
}