package mp1.view.draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

import mp1.controller.IController;
import mp1.model.Shape;
import mp1.model.object.*;

public class GraphPanel2 extends GraphPanel {
	private Graph2 graph2;
	private SelectionPanel selectPanel;

	private IController control;

	public GraphPanel2(int size,IController control) {
		super(size);
		this.control = control;
		
		graph2 = new Graph2(size);
		graph2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		graphPanel.add(graph2,BorderLayout.CENTER);

		add(graphPanel,BorderLayout.CENTER);

		selectPanel = new SelectionPanel(graph2.getObjects(), control);
		add(selectPanel,BorderLayout.EAST);		

		graph2.repaint();
	}

	public GraphPanel2(Shape s, Object2D main, int size,IController control) {
		super(s,main,size);
		this.control = control;

		graph2 = new Graph2(s,main,size);
		graph2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		graphPanel.add(graph2,BorderLayout.CENTER);

		add(graphPanel,BorderLayout.CENTER);
		
		selectPanel = new SelectionPanel(graph2.getObjects(), control);
		add(selectPanel,BorderLayout.EAST);		

		graph2.repaint();
	}

	public void addMain(Shape s, Object2D obj) {
		graph2.addMain(s,obj);
		selectPanel.setModel(graph2.getObjects());
	}

	public void deleteMain(Object2D obj) {
		graph2.deleteMain(obj);
		selectPanel.setModel(graph2.getObjects());
	}

	public void addTransform(Object2D obj, Object2D trans) {
		graph2.addTransform(obj,trans);
	}

	public void replaceTransform(Object2D obj, Object2D trans) {
		graph2.replaceTransform(obj,trans);
	}

	public Object2D getMain() {
		return graph2.getMain();
	}

	public Object2D getLast() {
		return graph2.getLast();
	}

	public void setMain(Shape s, Object2D obj) {
		graph2.setMain(s,obj);
		selectPanel.setSelected(obj);
	}

	public void setTrans(Object2D obj) {
		graph2.setTrans(obj);
	}

	public void undoTransform(Object2D obj) {
		graph2.undoTransform(obj);
	}
}