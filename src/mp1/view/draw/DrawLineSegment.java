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

public class DrawLineSegment implements IDraw {
	private final int axis;

	public DrawLineSegment(int axis) {
		this.axis = axis;
	}

	public void drawObject(Object2D obj,Graphics2D g2) {
		LineSegment l = (LineSegment)obj;

		Shape s = new Line2D.Double(axis + l.getX1(),axis - l.getY1()
									,l.getX2() + axis,-l.getY2() + axis);
		g2.draw(s);
	}
}