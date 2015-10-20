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

public class DrawVector implements IDraw {
	private final int axis;

	public DrawVector(int axis) {
		this.axis = axis;
	}

	public void drawObject(Object2D obj,Graphics2D g2) {
		Vector v = (Vector)obj;

		Shape s = new Line2D.Double(axis,axis,v.getX() + axis
								,-v.getY() + axis);
		g2.draw(s);
	}
}