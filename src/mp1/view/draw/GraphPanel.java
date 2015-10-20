package mp1.view.draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.JPanel;

import mp1.model.Shape;
import mp1.model.object.*;

public class GraphPanel extends JPanel {
	private final int size;

	private Object2D mainObject;
	private Object2D transObject;

	private JPanel graphPanel;
	private Graph graph;

	public GraphPanel(Shape s, Object2D main, int size) {
		super(new BorderLayout());
		this.size = size;
		mainObject = main;

		setSize(300,300);

		graph = new Graph(s,main,size);

		graphPanel = new JPanel(new BorderLayout());
		graphPanel.add(graph,BorderLayout.CENTER);

		add(graphPanel,BorderLayout.CENTER);
		graph.repaint();
	}

	public void setTrans(Object2D obj) {
		transObject = obj;
		graph.setTrans(obj);
	}
}