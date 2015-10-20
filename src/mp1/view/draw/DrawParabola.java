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

public class DrawParabola implements IDraw {
	private final int axis;

	public DrawParabola(int axis) {
		this.axis = axis;
	}

	public void drawObject(Object2D obj,Graphics2D g2) {
		Parabola p = (Parabola)obj;
		Shape s;
		double[] roots;

		if( p.isOpeningVertical() ) {
			if( p.getMagnitude() > 0 ) {
				roots = p.getRoots(axis);
				s = new QuadCurve2D.Double(roots[0] + axis, 0.0, p.getH() + axis
											,-p.getK() + 2 * axis
											,roots[1] + axis,0.0);
			} else {
				roots = p.getRoots(-axis);
				s = new QuadCurve2D.Double(roots[0] + axis, 2.0 * axis
											, p.getH() + axis
											,-p.getK(),roots[1] + axis
											,2.0 * axis);
			}
		} else {
			if( p.getMagnitude() > 0 ) {
				roots = p.getRoots(axis);
				s = new QuadCurve2D.Double(2.0 * axis,-roots[0] + axis
											,p.getH()
											,-p.getK() + axis,2.0 * axis
											,-roots[1] + axis);
			} else {
				roots = p.getRoots(-axis);
				s = new QuadCurve2D.Double(0.0,-roots[0] + axis
											,p.getH() + 2 * axis
											,-p.getK() + axis,0.0
											,-roots[1] + axis);
			}
		}

		g2.draw(s);
	}
}