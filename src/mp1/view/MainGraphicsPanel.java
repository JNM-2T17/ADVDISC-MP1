package mp1.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import mp1.controller.IController;
import mp1.model.Shape;
import mp1.view.layout.AGBLayout;

/**
 *
 * @author Austin Fernandez
 */
public class MainGraphicsPanel extends JPanel {
	private HashMap<JButton,Shape> keyMapping;

	private JLabel graphicsLabel;
	private JButton ellipseButton;
	private JButton lineSegmentButton;
	private JButton parabolaButton;
	private JButton hyperbolaButton;
	private JButton pointButton;
	private JButton polygonButton;
	private JButton vectorButton;

	private IController control;

	public MainGraphicsPanel(IController control) {
		this.control = control;
		keyMapping = new HashMap<JButton,Shape>();
		setLayout(new AGBLayout());
		setBorder(new EmptyBorder(10,10,10,10));
		
		graphicsLabel = new JLabel("Matrix Graphics");
		graphicsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		graphicsLabel.setFont(new Font("Segoe UI",Font.BOLD,32));
		AGBLayout.addComp(this, graphicsLabel, 0, 0, 3, 1, 100,100
							,GridBagConstraints.CENTER
							, GridBagConstraints.BOTH);

		ellipseButton = new JButton("Ellipse");
		ellipseButton.setFont(new Font("Segoe UI",Font.PLAIN,18));
		ellipseButton.addActionListener(new ShapeListen());
		keyMapping.put(ellipseButton,Shape.ELLIPSE);
		AGBLayout.addComp(this,ellipseButton,0,1,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		lineSegmentButton = new JButton("Line Segment");
		lineSegmentButton.setFont(new Font("Segoe UI",Font.PLAIN,18));
		lineSegmentButton.addActionListener(new ShapeListen());
		keyMapping.put(lineSegmentButton,Shape.LINE_SEGMENT);
		AGBLayout.addComp(this,lineSegmentButton,1,1,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		parabolaButton = new JButton("Parabola");
		parabolaButton.setFont(new Font("Segoe UI",Font.PLAIN,18));
		parabolaButton.addActionListener(new ShapeListen());
		keyMapping.put(parabolaButton,Shape.PARABOLA);
		AGBLayout.addComp(this,parabolaButton,2,1,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		hyperbolaButton = new JButton("Hyperbola");
		hyperbolaButton.setFont(new Font("Segoe UI",Font.PLAIN,18));
		hyperbolaButton.addActionListener(new ShapeListen());
		keyMapping.put(hyperbolaButton,Shape.HYPERBOLA);
		AGBLayout.addComp(this,hyperbolaButton,0,2,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		pointButton = new JButton("Point");
		pointButton.setFont(new Font("Segoe UI",Font.PLAIN,18));
		pointButton.addActionListener(new ShapeListen());
		keyMapping.put(pointButton,Shape.POINT);
		AGBLayout.addComp(this,pointButton,1,2,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		polygonButton = new JButton("Polygon");
		polygonButton.setFont(new Font("Segoe UI",Font.PLAIN,18));
		polygonButton.addActionListener(new ShapeListen());
		keyMapping.put(polygonButton,Shape.POLYGON);
		AGBLayout.addComp(this,polygonButton,2,2,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		vectorButton = new JButton("Vector");
		vectorButton.setFont(new Font("Segoe UI",Font.PLAIN,18));
		vectorButton.addActionListener(new ShapeListen());
		keyMapping.put(vectorButton,Shape.VECTOR);
		AGBLayout.addComp(this,vectorButton,1,3,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
	}

	private class ShapeListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			control.shapeScreen(keyMapping.get((JButton)e.getSource()));
		}
	}
}