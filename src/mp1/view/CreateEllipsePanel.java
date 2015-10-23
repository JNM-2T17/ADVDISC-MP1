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

/**
 *
 * @author Austin Fernandez
 */
public class CreateEllipsePanel extends AbstractCreatePanel {
	private JLabel pointLabel;
	private JLabel hLabel;
	private JLabel kLabel;
	private JTextField hField;
	private JTextField kField;
	private JLabel hdLabel;
	private JLabel vdLabel;
	private JTextField hdField;
	private JTextField vdField;
	private JButton createButton;

	public CreateEllipsePanel(IController control) {
		super(Shape.ELLIPSE,control);
	}

	protected void createComponents() {
		pointLabel = new JLabel("Create an Ellipse");
		pointLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pointLabel.setFont(new Font("Segoe UI",Font.BOLD,24));
		pointLabel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
		AGBLayout.addComp(this,pointLabel,0,0,4,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		hLabel = new JLabel("Center X-coordinate:");
		hLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		hLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		hLabel.setBorder(BorderFactory.createEmptyBorder(20,5,20,5));
		AGBLayout.addComp(this,hLabel,0,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);

		hField = new JTextField(10);
		hField.setFont(new Font("Segoe UI",Font.PLAIN,14));
		hField.addKeyListener(new CreateListener());
		AGBLayout.addComp(this,hField,1,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		kLabel = new JLabel("Center Y-coordinate: ");
		kLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		kLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		kLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,5));
		AGBLayout.addComp(this,kLabel,2,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);

		kField = new JTextField(10);
		kField.setFont(new Font("Segoe UI",Font.PLAIN,14));
		kField.addKeyListener(new CreateListener());
		AGBLayout.addComp(this,kField,3,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		hdLabel = new JLabel("Horizontal Distance:");
		hdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		hdLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		hdLabel.setBorder(BorderFactory.createEmptyBorder(20,5,20,5));
		AGBLayout.addComp(this,hdLabel,0,2,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);

		hdField = new JTextField(10);
		hdField.setFont(new Font("Segoe UI",Font.PLAIN,14));
		hdField.addKeyListener(new CreateListener());
		AGBLayout.addComp(this,hdField,1,2,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		vdLabel = new JLabel("Vertical Distance: ");
		vdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		vdLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		vdLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,5));
		AGBLayout.addComp(this,vdLabel,2,2,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);

		vdField = new JTextField(10);
		vdField.setFont(new Font("Segoe UI",Font.PLAIN,14));
		vdField.addKeyListener(new CreateListener());
		AGBLayout.addComp(this,vdField,3,2,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		createButton = new JButton("Create Ellipse");
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
		double h = 0;
		double k = 0;
		double hd = 0;
		double vd = 0;

		try {
			h = Double.parseDouble(hField.getText());
		} catch(NumberFormatException nfe) {
			error += "Please input a numerical x-value for the center.";
		}

		try {
			k = Double.parseDouble(kField.getText());
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") 
					+ "Please input a numerical y-value for the center.";
		}

		try {
			hd = Double.parseDouble(hdField.getText());
			if( hd == 0 ) {
				error += (error.length() == 0 ? "" : "\n") 
						+ "Horizontal distance cannot be zero.";
			}
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") 
					+ "Please input a numerical horizontal distance.";
		}

		try {
			vd = Double.parseDouble(vdField.getText());
			if( vd == 0 ) {
				error += (error.length() == 0 ? "" : "\n") 
						+ "Vertical distance cannot be zero.";
			}
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") 
					+ "Please input a numerical vertical distance.";
		}

		if( error.length() == 0 ) {
			double[] params = new double[4];
			params[0] = h;
			params[1] = k;
			params[2] = hd;
			params[3] = vd;
			return params;
		} else {
			throw new Exception(error);
		}
	}

	protected void clear() {
		hField.setText("");
		kField.setText("");
		hdField.setText("");
		vdField.setText("");
	}
}