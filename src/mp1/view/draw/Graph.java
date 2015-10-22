package mp1.view.draw;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.*;
import javax.swing.JComponent;

import mp1.model.object.*;

public class Graph extends JComponent {
	private final int size;

	protected Object2D mainObject;
	protected Object2D transObject;

	protected IDraw drawStrategy;

	public Graph(int size) {
		this.size = size;
	}

	public Graph(mp1.model.Shape s, Object2D main, int size) {
		this.size = size;
		setStrat(s);
		mainObject = main;
	}

	public void setStrat(mp1.model.Shape s) {
		switch(s) {
			case ELLIPSE:
				drawStrategy = new DrawEllipse(getAxis());
				break;
			case LINE_SEGMENT:
				drawStrategy = new DrawLineSegment(getAxis());
				break;
			case PARABOLA:
				drawStrategy = new DrawParabola(getAxis());
				break;
			case HYPERBOLA:
				drawStrategy = new DrawHyperbola(getAxis());
				break;
			case POINT:
				drawStrategy = new DrawPoint(getAxis());
				break;
			case POLYGON:
				drawStrategy = new DrawPolygon(getAxis());
				break;
			case VECTOR:
				drawStrategy = new DrawVector(getAxis());
				break;
			default:
		}
	}

	protected void drawGrid(Graphics2D g2) {
		int start = 0;
		int end = 24 * size;
		for( int i = start; i <= end; i += size ) {
			for( int j = start; j <= end; j += size ) {
				Line2D.Double line = new Line2D.Double(start,start + i
														,end,start + i);
				g2.draw(line);

				line = new Line2D.Double(start + j, start
											, start + j, end);
				g2.draw(line);
			}
		}
		g2.setPaint(Color.BLUE);
		g2.setStroke(new BasicStroke(5));
		Line2D.Double axis = new Line2D.Double(start,getAxis(),end,getAxis());
		g2.draw(axis);
		axis = new Line2D.Double(getAxis(),start,getAxis(),end);
		g2.draw(axis);
	}

	public Object2D getMain() {
		return mainObject;
	}

	public int getAxis() {
		return size * 12;
	}

	public void setMain(mp1.model.Shape s, Object2D obj) {
		mainObject = obj;
		setStrat(s);
		repaint();
	} 

	public void setTrans(Object2D obj) {
		transObject = obj;
		repaint();
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D)g;

		g2.setColor(Color.WHITE);
        g2.fillRect(0, 0, 2 * getAxis(), 2 * getAxis());
        g2.setPaint(Color.BLACK);
        drawGrid(g2);
		g2.setStroke(new BasicStroke(2));
		if( mainObject != null ) {
			g2.setPaint(Color.GREEN);
			drawStrategy.drawObject(mainObject,g2);
		}

		if( transObject != null ) {
			g2.setPaint(Color.RED);
			drawStrategy.drawObject(transObject,g2);
		}
	}
}