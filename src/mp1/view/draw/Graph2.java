package mp1.view.draw;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;
import javax.swing.JComponent;

import mp1.model.object.*;

public class Graph2 extends Graph {
	private HashMap<Object2D,ArrayList<Object2D>> mainObjects;
	private HashMap<Object2D,mp1.model.Shape> shapes;

	public Graph2(int size) {
		super(size);

		mainObjects = new HashMap<Object2D,ArrayList<Object2D>>();
		shapes = new HashMap<Object2D,mp1.model.Shape>();
	}

	public Graph2(mp1.model.Shape s, Object2D main, int size) {
		super(s,main,size);

		mainObjects = new HashMap<Object2D,ArrayList<Object2D>>();
		shapes = new HashMap<Object2D,mp1.model.Shape>();

		addMain(s,main);
		setMain(s,main);
	}

	public void addMain(mp1.model.Shape s, Object2D obj) {
		mainObjects.put(obj,new ArrayList<Object2D>());
		shapes.put(obj,s);
		Iterator itr = mainObjects.entrySet().iterator();
		repaint();
	}

	public void deleteMain(Object2D obj) {
		mainObjects.remove(obj);
		shapes.remove(obj);
		repaint();
	}

	public void addTransform(Object2D obj, Object2D trans) {
		mainObjects.get(obj).add(trans);
		repaint();
	}

	public void replaceTransform(Object2D obj, Object2D trans) {
		mainObjects.get(obj).set(mainObjects.get(obj).size() - 1,trans);
		repaint();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;

		g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 2 * getAxis(), 2 * getAxis());
        g2.setPaint(Color.BLACK);
        drawGrid(g2);
		g2.setStroke(new BasicStroke(2));
		
		Iterator s = mainObjects.entrySet().iterator();

		while(s.hasNext()) {
			Map.Entry me = (Map.Entry)s.next();
			Object2D key = (Object2D)me.getKey();
			ArrayList<Object2D> temp = (ArrayList<Object2D>)me.getValue();
			
			g2.setPaint(key == mainObject ? Color.GREEN 
							: new Color(0,127,0));
			setStrat(shapes.get(key));
			drawStrategy.drawObject(key,g2);
			if(temp.size() != 0) {
				g2.setPaint(key == mainObject ? Color.RED 
								: new Color(127,0,0));
				drawStrategy.drawObject(transObject,g2);
			}
			System.out.println(key);
		}
	}
}