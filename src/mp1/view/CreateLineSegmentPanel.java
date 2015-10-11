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

public class CreateLineSegmentPanel extends AbstractCreatePanel {
	private JLabel pointLabel;
	private JLabel x1Label;
	private JLabel y1Label;
	private JTextField x1Field;
	private JTextField y1Field;
	private JLabel x2Label;
	private JLabel y2Label;
	private JTextField x2Field;
	private JTextField y2Field;
	private JButton createButton;

	public CreateLineSegmentPanel(IController control) {
		super(Shape.LINE_SEGMENT,control);
	}

	protected void createComponents() {
		pointLabel = new JLabel("Create a Line Segment");
		pointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pointLabel.setFont(new Font("Segoe UI",Font.BOLD,24));
		pointLabel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
		AGBLayout.addComp(this,pointLabel,0,0,4,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		x1Label = new JLabel("X-coordinate(Point 1):");
		x1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		x1Label.setFont(new Font("Segoe UI",Font.PLAIN,14));
		x1Label.setBorder(BorderFactory.createEmptyBorder(20,5,20,5));
		AGBLayout.addComp(this,x1Label,0,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);

		x1Field = new JTextField(10);
		x1Field.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,x1Field,1,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		y1Label = new JLabel("Y-coordinate(Point 1): ");
		y1Label.setHorizontalAlignment(SwingConstants.RIGHT);
		y1Label.setFont(new Font("Segoe UI",Font.PLAIN,14));
		y1Label.setBorder(BorderFactory.createEmptyBorder(20,20,20,5));
		AGBLayout.addComp(this,y1Label,2,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);

		y1Field = new JTextField(10);
		y1Field.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,y1Field,3,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		x2Label = new JLabel("X-coordinate(Point 2):");
		x2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		x2Label.setFont(new Font("Segoe UI",Font.PLAIN,14));
		x2Label.setBorder(BorderFactory.createEmptyBorder(20,5,20,5));
		AGBLayout.addComp(this,x2Label,0,2,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);

		x2Field = new JTextField(10);
		x2Field.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,x2Field,1,2,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		y2Label = new JLabel("Y-coordinate(Point 2): ");
		y2Label.setHorizontalAlignment(SwingConstants.RIGHT);
		y2Label.setFont(new Font("Segoe UI",Font.PLAIN,14));
		y2Label.setBorder(BorderFactory.createEmptyBorder(20,20,20,5));
		AGBLayout.addComp(this,y2Label,2,2,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);

		y2Field = new JTextField(10);
		y2Field.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,y2Field,3,2,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		createButton = new JButton("Create Line Segment");
		createButton.setFont(new Font("Segoe UI",Font.PLAIN,14));
		createButton.addActionListener(new CreateListener());
		createButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		AGBLayout.addComp(this,createButton,0,3,4,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.NONE);
	}

	protected void addBack() {
		AGBLayout.addComp(this,backButton,0,4,4,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.NONE);
	}

	protected double[] getParams() throws Exception {
		String error = "";
		double x1 = 0;
		double y1 = 0;
		double x2 = 0;
		double y2 = 0;

		try {
			x1 = Double.parseDouble(x1Field.getText());
		} catch(NumberFormatException nfe) {
			error += "Please input a numerical x-value for point 1.";
		}

		try {
			y1 = Double.parseDouble(y1Field.getText());
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") 
					+ "Please input a numerical y-value for point 1.";
		}

		try {
			x2 = Double.parseDouble(x2Field.getText());
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") 
					+ "Please input a numerical x-value for point 2.";
		}

		try {
			y2 = Double.parseDouble(y2Field.getText());
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") 
					+ "Please input a numerical y-value for point 2.";
		}

		if( error.length() == 0 ) {
			double[] params = new double[4];
			params[0] = x1;
			params[1] = y1;
			params[2] = x2;
			params[3] = y2;
			return params;
		} else {
			throw new Exception(error);
		}
	}

	protected void clear() {
		x1Field.setText("");
		y1Field.setText("");
		x2Field.setText("");
		y2Field.setText("");
	}
}