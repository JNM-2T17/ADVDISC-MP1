package mp1.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mp1.controller.IController;
import mp1.model.Shape;
import mp1.view.layout.AGBLayout;

public class CreateHyperbolaPanel extends AbstractCreatePanel {
	private JLabel pointLabel;
	private JLabel hLabel;
	private JLabel kLabel;
	private JTextField hField;
	private JTextField kField;
	private JLabel hdLabel;
	private JTextField hdField;
	private JLabel vdLabel;
	private JTextField vdField;
	private JLabel orientLabel;
	private JPanel orientPanel;
	private ButtonGroup orientGroup;
	private JRadioButton vertButton;
	private JRadioButton horizButton;
	private JButton createButton;

	public CreateHyperbolaPanel(IController control) {
		super(Shape.HYPERBOLA,control);
	}

	protected void createComponents() {
		pointLabel = new JLabel("Create a Hyperbola");
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
		AGBLayout.addComp(this,hdField,1,2,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		vdLabel = new JLabel("Vertical Distance:");
		vdLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		vdLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		vdLabel.setBorder(BorderFactory.createEmptyBorder(20,5,20,5));
		AGBLayout.addComp(this,vdLabel,2,2,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);

		vdField = new JTextField(10);
		vdField.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(this,vdField,3,2,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		orientLabel = new JLabel("Orientation: ");
		orientLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		orientLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		orientLabel.setBorder(BorderFactory.createEmptyBorder(20,20,20,5));
		AGBLayout.addComp(this,orientLabel,0,3,1,1,100,100
							,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);

		orientPanel = new JPanel(new GridLayout(1,2));

		orientGroup = new ButtonGroup();

		vertButton = new JRadioButton("Vertical");
		vertButton.setFont(new Font("Segoe UI",Font.PLAIN,14));
		vertButton.setSelected(true);
		orientGroup.add(vertButton);
		orientPanel.add(vertButton);

		horizButton = new JRadioButton("Horizontal");
		horizButton.setFont(new Font("Segoe UI",Font.PLAIN,14));
		orientGroup.add(horizButton);
		orientPanel.add(horizButton);

		AGBLayout.addComp(this,orientPanel,1,3,2,1,100,100
							,GridBagConstraints.CENTER
							,GridBagConstraints.HORIZONTAL);
		
		createButton = new JButton("Create Hyperbola");
		createButton.setFont(new Font("Segoe UI",Font.PLAIN,14));
		createButton.addActionListener(new CreateListener());
		createButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		AGBLayout.addComp(this,createButton,0,4,4,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.NONE);
	}

	protected void addBack() {
		AGBLayout.addComp(this,backButton,0,5,4,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.NONE);
	}

	protected double[] getParams() throws Exception {
		String error = "";
		double h = 0;
		double k = 0;
		double hd = 0;
		double vd = 0;
		boolean orient = true;

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
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") 
					+ "Please input a numerical horizontal distance.";
		}

		try {
			vd = Double.parseDouble(vdField.getText());
		} catch(NumberFormatException nfe) {
			error += (error.length() == 0 ? "" : "\n") 
					+ "Please input a numerical vertical distance.";
		}

		if( horizButton.isSelected() ) {
			orient = false;
		}

		if( error.length() == 0 ) {
			double[] params = new double[5];
			params[0] = h;
			params[1] = k;
			params[2] = hd;
			params[3] = vd;
			params[4] = orient ? 1 : 0;
			return params;
		} else {
			throw new Exception(error);
		}
	}

	protected void clear() {
		hField.setText("");
		kField.setText("");
		hdField.setText("");
	}
}