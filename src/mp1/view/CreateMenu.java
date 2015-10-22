package mp1.view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mp1.controller.IController;
import mp1.model.Shape;
import mp1.view.layout.AGBLayout;

public class CreateMenu extends JMenuBar {
	private HashMap<JMenuItem,Shape> hash;

	private IController control;
	private JMenu createMenu;
	private JMenuItem pointItem;
	private JMenuItem vectorItem;
	private JMenuItem lineSegmentItem;
	private JMenuItem polygonItem;
	private JMenuItem parabolaItem;
	private JMenuItem hyperbolaItem;
	private JMenuItem ellipseItem;

	public CreateMenu(IController control) {
		this.control = control;

		hash = new HashMap<JMenuItem,Shape>();

		createMenu = new JMenu("Create Shape");
		createMenu.setFont(new Font("Segoe UI",Font.PLAIN,14));
		add(createMenu);

		pointItem = new JMenuItem("Create Point");
		pointItem.setFont(new Font("Segoe UI",Font.PLAIN,14));
		hash.put(pointItem,Shape.POINT);
		pointItem.addActionListener(new MenuListen());
		createMenu.add(pointItem);

		vectorItem = new JMenuItem("Create Vector");
		vectorItem.setFont(new Font("Segoe UI",Font.PLAIN,14));
		hash.put(vectorItem,Shape.VECTOR);
		vectorItem.addActionListener(new MenuListen());
		createMenu.add(vectorItem);

		lineSegmentItem = new JMenuItem("Create Line Segment");
		lineSegmentItem.setFont(new Font("Segoe UI",Font.PLAIN,14));
		hash.put(lineSegmentItem,Shape.LINE_SEGMENT);
		lineSegmentItem.addActionListener(new MenuListen());
		createMenu.add(lineSegmentItem);

		polygonItem = new JMenuItem("Create Polygon");
		polygonItem.setFont(new Font("Segoe UI",Font.PLAIN,14));
		hash.put(polygonItem,Shape.POLYGON);
		polygonItem.addActionListener(new MenuListen());
		createMenu.add(polygonItem);

		parabolaItem = new JMenuItem("Create Parabola");
		parabolaItem.setFont(new Font("Segoe UI",Font.PLAIN,14));
		hash.put(parabolaItem,Shape.PARABOLA);
		parabolaItem.addActionListener(new MenuListen());
		createMenu.add(parabolaItem);

		hyperbolaItem = new JMenuItem("Create Hyperbola");
		hyperbolaItem.setFont(new Font("Segoe UI",Font.PLAIN,14));
		hash.put(hyperbolaItem,Shape.HYPERBOLA);
		hyperbolaItem.addActionListener(new MenuListen());
		createMenu.add(hyperbolaItem);

		ellipseItem = new JMenuItem("Create Ellipse");
		ellipseItem.setFont(new Font("Segoe UI",Font.PLAIN,14));
		hash.put(ellipseItem,Shape.ELLIPSE);
		ellipseItem.addActionListener(new MenuListen());
		createMenu.add(ellipseItem);
	}

	private class MenuListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			control.shapeScreen(hash.get((JMenuItem)e.getSource()));
		}
	}
}