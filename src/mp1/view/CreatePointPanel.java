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

public class CreatePointPanel extends AbstractCreatePanel {
	private JLabel pointLabel;
	private JLabel xLabel;
	private JLabel yLabel;
	private JTextField xField;
	private JTextField yField;
	private JButton createButton;

	public CreatePointPanel(Shape s, IController control) {
		super(s,control);
	}

	protected void createComponents() {
		pointLabel = new JLabel("Create a " + shape);
		pointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pointLabel.setFont(new Font("Segoe UI",Font.BOLD,24));
		pointLabel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
		AGBLayout.addComp(this,pointLabel,0,0,4,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		xLabel = new JLabel("X-coordinate:");
		xLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		xLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		xLabel.setBorder(BorderFactory.createEmptyBorder(20,5,20,5));
		AGBLayout.addComp(this,xLabel,0,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);

		xField = new JTextField(10);
		xField.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,xField,1,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		yLabel = new JLabel("Y-coordinate: ");
		yLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		yLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		yLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,5));
		AGBLayout.addComp(this,yLabel,2,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);

		yField = new JTextField(10);
		yField.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,yField,3,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		createButton = new JButton("Create " + shape);
		createButton.setFont(new Font("Segoe UI",Font.PLAIN,14));
		createButton.addActionListener(new CreateListener());
		createButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		AGBLayout.addComp(this,createButton,0,2,4,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.NONE);
	}

	protected void addBack() {
		AGBLayout.addComp(this,backButton,0,3,4,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.NONE);
	}

	protected double[] getParams() throws Exception {
		String error = "";
		double x = 0;
		double y = 0;

		try {
			x = Double.parseDouble(xField.getText());
		} catch(NumberFormatException nfe) {
			error += "Please input a numerical x-value";
		}

		try {
			y = Double.parseDouble(yField.getText());
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") 
					+ "Please input a numerical y-value";
		}

		if( error.length() == 0 ) {
			double[] params = new double[2];
			params[0] = x;
			params[1] = y;
			return params;
		} else {
			throw new Exception(error);
		}
	}

	protected void clear() {
		xField.setText("");
		yField.setText("");
	}
}