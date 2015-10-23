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

public class DrawPoint implements IDraw {
	private final int axis;

	public DrawPoint(int axis) {
		this.axis = axis;
	}

	public void drawObject(Object2D obj,Graphics2D g2) {
		Point p = (Point)obj;

		Shape s = new Line2D.Double(p.getX() + axis,-p.getY() + axis
									,p.getX() + axis,-p.getY() + axis);
		g2.setStroke(new BasicStroke(10));
		g2.draw(s);
		g2.setStroke(new BasicStroke(2));
	}
}