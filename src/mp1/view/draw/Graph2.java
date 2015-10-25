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
		addMain(mp1.model.Shape.CURVE,new Curve(10000,16000,40000,0,0,-400000000));
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

	public Object2D getLast() {
		ArrayList<Object2D> list = mainObjects.get(mainObject);
		if(list.size() == 0) {
			return mainObject;
		} else {
			return list.get(list.size() - 1);
		}
	}

	public void addTransform(Object2D obj, Object2D trans) {
		mainObjects.get(obj).add(trans);
		repaint();
	}

	public void replaceTransform(Object2D obj, Object2D trans) {
		mainObjects.get(obj).set(mainObjects.get(obj).size() - 1,trans);
		repaint();
	}

	public void undoTransform(Object2D obj) {
		ArrayList<Object2D> trans = mainObjects.get(obj);
		if( trans.size() > 0 ) {
			trans.remove(trans.size() - 1);
		}
		repaint();
	}

	public Iterator getObjects() {
		Iterator itr = mainObjects.entrySet().iterator();
		ArrayList<Object2D> objects = new ArrayList<Object2D>();
		while( itr.hasNext()) {
			Map.Entry me = (Map.Entry)itr.next();
			objects.add((Object2D)me.getKey());
		}

		return objects.iterator();
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
							: new Color(0,192,0));
			setStrat(shapes.get(key));
			drawStrategy.drawObject(key,g2);
			if(temp.size() != 0) {
				g2.setPaint(key == mainObject ? Color.RED 
								: new Color(192,0,0));
				Object2D val = temp.get(temp.size() - 1);
				if( val instanceof Curve) {
					setStrat(mp1.model.Shape.CURVE);
				}
				drawStrategy.drawObject(temp.get(temp.size() - 1),g2);
			}
		}
	}
}