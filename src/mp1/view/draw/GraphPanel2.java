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

public class GraphPanel2 extends GraphPanel {
	private Graph2 graph2;

	public GraphPanel2(int size) {
		super(size);

		graph2 = new Graph2(size);
		graph2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		graphPanel.add(graph2,BorderLayout.CENTER);

		add(graphPanel,BorderLayout.CENTER);
		graph2.repaint();
	}

	public GraphPanel2(Shape s, Object2D main, int size) {
		super(s,main,size);
	
		graph2 = new Graph2(s,main,size);
		graph2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		graphPanel.add(graph2,BorderLayout.CENTER);

		add(graphPanel,BorderLayout.CENTER);
		graph2.repaint();
	}

	public void addMain(Shape s, Object2D obj) {
		graph2.addMain(s,obj);
	}

	public void deleteMain(Object2D obj) {
		graph2.deleteMain(obj);
	}

	public void addTransform(Object2D obj, Object2D trans) {
		graph2.addTransform(obj,trans);
	}

	public void replaceTransform(Object2D obj, Object2D trans) {
		graph2.replaceTransform(obj,trans);
	}

	public void setMain(Shape s, Object2D obj) {
		graph2.setMain(s,obj);
	}

	public void setTrans(Object2D obj) {
		graph2.setTrans(obj);
	}
}