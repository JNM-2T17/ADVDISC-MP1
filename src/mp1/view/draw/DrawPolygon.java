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

public class DrawPolygon implements IDraw {
	private final int axis;

	public DrawPolygon(int axis) {
		this.axis = axis;
	}

	public void drawObject(Object2D obj,Graphics2D g2) {
		Polygon p = (Polygon)obj;
		double[] xs = p.getXs();
		double[] ys = p.getYs();

		for( int i = 0; i < xs.length; i++ ) {
			int temp = (i + 1) % xs.length;
			Shape s = new Line2D.Double(xs[i] + axis,-ys[i] + axis,xs[temp] 
										+ axis,-ys[temp] + axis);
			g2.draw(s);
		}
	}
}