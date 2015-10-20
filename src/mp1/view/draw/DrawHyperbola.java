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

public class DrawHyperbola implements IDraw {
	private final int axis;

	public DrawHyperbola(int axis) {
		this.axis = axis;
	}

	public void drawObject(Object2D obj,Graphics2D g2) {
		Hyperbola p = (Hyperbola)obj;
		Shape s1,s2;
		double[] roots;

		if( p.isOpeningVertical() ) {
			roots = p.getRoots(-axis);
			s1 = new QuadCurve2D.Double(roots[0] + axis,0.0,p.getH() + axis
										,-p.getK() + axis,roots[1] + axis,0.0);
			roots = p.getRoots(axis);
			s2 = new QuadCurve2D.Double(roots[0] + axis,2.0 * axis,p.getH() 
										+ axis,-p.getK() + axis
										,roots[1] + axis,2.0 * axis);
		} else {
			roots = p.getRoots(-axis);
			s1 = new QuadCurve2D.Double(0.0,-roots[0] + axis,p.getH() + axis
										,-p.getK() + axis,0.0,-roots[1] + axis);
			roots = p.getRoots(axis);
			s2 = new QuadCurve2D.Double(2.0 * axis,-roots[0] + axis,p.getH() 
										+ axis,-p.getK() + axis
										,2.0 * axis,-roots[1] + axis);
		}

		g2.draw(s1);
		g2.draw(s2);
	}
}