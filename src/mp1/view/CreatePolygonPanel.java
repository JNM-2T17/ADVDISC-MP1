package mp1.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mp1.controller.IController;
import mp1.model.Shape;
import mp1.model.object.Point;	
import mp1.view.layout.AGBLayout;

public class CreatePolygonPanel extends AbstractCreatePanel {
	private int sides;
	private ArrayList<MiniPointPanel> pointPanels;

	private JLabel shapeLabel;
	private JButton addButton;
	private JButton createButton;
	private ImageIcon deleteIcon;

	private JPanel sidesPanel;
	private JScrollPane sideScrollPane;

	public CreatePolygonPanel(IController control) {
		super(Shape.POLYGON,control);
	}

	protected void createComponents() {
		deleteIcon = new ImageIcon(getClass()
									.getResource("/assets/deleteicon.png"));
		Image i = deleteIcon.getImage();
		i = i.getScaledInstance(15,15,0);
		deleteIcon = new ImageIcon(i);

		shapeLabel = new JLabel("Create a Polygon");
		shapeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		shapeLabel.setFont(new Font("Segoe UI",Font.BOLD,24));
		shapeLabel.setBorder(BorderFactory.createEmptyBorder(5,10,10,10));
		AGBLayout.addComp(this,shapeLabel,0,0,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		addButton = new JButton("Add Vertex");
		addButton.setFont(new Font("Segoe UI",Font.BOLD,14));
		addButton.addActionListener(new AddListener());
		AGBLayout.addComp(this,addButton,0,1,1,1,100,100
							,GridBagConstraints.WEST,GridBagConstraints.NONE);		

		pointPanels = new ArrayList<MiniPointPanel>();

		sidesPanel = new JPanel(new AGBLayout());

		sides = 0;
		addSide();
		addSide();
		addSide();
		
		sideScrollPane = new JScrollPane(sidesPanel
								,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
								,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sideScrollPane.setSize(1000,500);
		AGBLayout.addComp(this,sideScrollPane,0,2,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		createButton = new JButton("Create Polygon");
		createButton.setFont(new Font("Segoe UI",Font.PLAIN,14));
		createButton.addActionListener(new CreateListener());
		createButton.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		AGBLayout.addComp(this,createButton,0,3,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.NONE);
	}

	protected void addBack() {
		AGBLayout.addComp(this,backButton,0,4,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.NONE);
	}

	protected double[] getParams() throws Exception {
		double[][] coords = new double[sides][2];
		int i = 0;
		String error = "";
		Point p = null;

		for( i = 0; i < pointPanels.size(); i++ ) {
			try {
				p = pointPanels.get(i).getPoint();
				coords[i][0] = p.getX();
				coords[i][1] = p.getY();
			} catch( IllegalArgumentException iae ) {
				error += (error.length() == 0 ? "" : "\n") + iae.getMessage();
			}
		}

		if( error.length() == 0 ) {
			double[] ret = new double[sides * 2 + 1];
			ret[0] = sides;
			for( i = 0; i < sides; i++ ) {
				ret[i + 1] = coords[i][0];
				ret[i + 1 + sides] = coords[i][1];
			}
			return ret;
		} else {
			throw new Exception(error);
		}
	}

	protected void clear() {
		while( sides > 3 ) {
			removeSide(0);
		}

		for(MiniPointPanel mpp: pointPanels) {
			mpp.clear();
		}
	}

	private void paintSidePanels() {
		sidesPanel.removeAll();
		for( int i = 0; i < pointPanels.size(); i++ ) {
			AGBLayout.addComp(sidesPanel,pointPanels.get(i),0,i,1,1,100,100
								,GridBagConstraints.CENTER
								,GridBagConstraints.BOTH);
		}
		sidesPanel.repaint();
		sidesPanel.revalidate();
	}

	public void addSide() {
		sides++;
		pointPanels.add(new MiniPointPanel(this,sides));

		for( int j = 0; j < sides; j++) {
			pointPanels.get(j).setDeletable(sides > 3);
		}
		paintSidePanels();
	}

	public void removeSide(int i) {
		if( i >= 0 && i < sides && sides > 3) {
			pointPanels.remove(i);
			sides--;
			for( int j = 0; j < sides; j++) {
				pointPanels.get(j).setNumber(j + 1);
				pointPanels.get(j).setDeletable(sides > 3);
			}
			paintSidePanels();
		}
	}

	private class AddListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			addSide();
		}
	}

	private class MiniPointPanel extends JPanel {
		private int number;
		private boolean isDeletable;

		private JLabel numberLabel;
		private JLabel xLabel;
		private JTextField xField;
		private JLabel yLabel;
		private JTextField yField;
		private JButton deleteButton;

		private CreatePolygonPanel master;

		public MiniPointPanel(CreatePolygonPanel master, int number) {
			this.master = master;
			this.number = number;

			setLayout(new AGBLayout());

			numberLabel = new JLabel("Vertex " + number);
			numberLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
			AGBLayout.addComp(this,numberLabel,0,0,1,1,100,100
								,GridBagConstraints.CENTER
								,GridBagConstraints.NONE);

			deleteButton = new JButton(deleteIcon);
			deleteButton.setBackground(Color.WHITE);
			deleteButton.setFont(new Font("Segoe UI",Font.PLAIN,14));
			deleteButton.addActionListener(new DeleteListen());
			AGBLayout.addComp(this,deleteButton,1,0,1,1,100,100
								,GridBagConstraints.WEST
								,GridBagConstraints.NONE);			

			xLabel = new JLabel("X-coordinate:");
			xLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
			xLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			AGBLayout.addComp(this,xLabel,0,1,1,1,100,100
								,GridBagConstraints.CENTER
								,GridBagConstraints.NONE);

			xField = new JTextField(15);
			xField.addKeyListener(new CreateListener());
			xField.setFont(new Font("Segoe UI",Font.PLAIN,14));
			AGBLayout.addComp(this,xField,1,1,1,1,100,100
								,GridBagConstraints.CENTER
								,GridBagConstraints.NONE);

			yLabel = new JLabel("Y-coordinate:");
			yLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
			yLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
			AGBLayout.addComp(this,yLabel,2,1,1,1,100,100
								,GridBagConstraints.CENTER
								,GridBagConstraints.NONE);

			yField = new JTextField(15);
			yField.addKeyListener(new CreateListener());
			yField.setFont(new Font("Segoe UI",Font.PLAIN,14));
			AGBLayout.addComp(this,yField,3,1,1,1,100,100
								,GridBagConstraints.CENTER
								,GridBagConstraints.NONE);
		}

		public void setNumber(int i) {
			number = i;
			numberLabel.setText("Vertex " + i);
		}

		public void setDeletable(boolean deletable) {
			isDeletable = deletable;
			deleteButton.setVisible(deletable);
		}

		public void clear() {
			xField.setText("");
			yField.setText("");
		}

		public Point getPoint() throws IllegalArgumentException {
			double x = 0;
			double y = 0;
			String error = "";

			try {
				x = Double.parseDouble(xField.getText());
			} catch(NumberFormatException nfe) {
				error += (error.length() == 0 ? "" : "\n") 
							+ "Enter a valid x coordinate for point " + number; 
			}

			try {
				y = Double.parseDouble(yField.getText());
			} catch(NumberFormatException nfe) {
				error += (error.length() == 0 ? "" : "\n") 
							+ "Enter a valid y coordinate for point " + number; 
			}

			if( error.length() == 0 ) {
				return new Point(x,y);
			} else {
				throw new IllegalArgumentException(error);
			}
		}

		public String toString() {
			return "Master: " + master + "\tNumber: " + number + "\tDeletable: " 
					+ isDeletable;
		}

		private class DeleteListen implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				master.removeSide(number - 1);
			}
		}
	}
}