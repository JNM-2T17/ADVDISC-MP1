package mp1.view.draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import mp1.model.Shape;
import mp1.model.object.*;

public class GraphPanel extends JPanel {
	private final int size;

	protected JPanel graphPanel;
	private Graph graph;

	public GraphPanel(int size) {
		super(new BorderLayout());
		this.size = size;

		graph = new Graph(size);
		graph.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		graphPanel = new JPanel(new BorderLayout());
		graphPanel.add(graph,BorderLayout.CENTER);

		add(graphPanel,BorderLayout.CENTER);
		graph.repaint();
	}

	public GraphPanel(Shape s, Object2D main, int size) {
		super(new BorderLayout());
		this.size = size;
	
		graph = new Graph(s,main,size);
		graph.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		graphPanel = new JPanel(new BorderLayout());
		graphPanel.add(graph,BorderLayout.CENTER);

		add(graphPanel,BorderLayout.CENTER);
		graph.repaint();
	}

	public void setMain(Shape s, Object2D obj) {
		graph.setMain(s,obj);
	}

	public void setTrans(Object2D obj) {
		graph.setTrans(obj);
	}
}