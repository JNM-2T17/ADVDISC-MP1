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

	private JPanel graphPanel;
	private Graph graph;

	public GraphPanel(Shape s, Object2D main, int size) {
		super(new BorderLayout());
		this.size = size;
	
		setSize(300,300);

		graph = new Graph(s,main,size);
		graph.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		graphPanel = new JPanel(new BorderLayout());
		graphPanel.add(graph,BorderLayout.CENTER);

		add(graphPanel,BorderLayout.CENTER);
		graph.repaint();
	}

	public void setTrans(Object2D obj) {
		graph.setTrans(obj);
	}
}