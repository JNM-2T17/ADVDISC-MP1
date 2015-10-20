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

public class DrawEllipse implements IDraw {
	private final int axis;

	public DrawEllipse(int axis) {
		this.axis = axis;
	}

	public void drawObject(Object2D obj,Graphics2D g2) {
		Ellipse e = (Ellipse)obj;

		Shape s = new Ellipse2D.Double(axis + e.getH() - e.getHorizDistance()
										,axis - (e.getK() + e.getVertDistance())
										,2 * e.getHorizDistance()
										,2 * e.getVertDistance());
		g2.draw(s);
	}
}