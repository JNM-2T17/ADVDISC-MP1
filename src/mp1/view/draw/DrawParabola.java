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
		double[] roots, nextRoots;

		if( p.isOpeningVertical() ) {
			if( p.getMagnitude() > 0 ) {
				roots = p.getRoots(axis);
				double i = axis - 1;
				while( i > p.getK() ) {
					nextRoots = p.getRoots(i);
					s = new Line2D.Double(roots[0] + axis,axis - (i + 1)
											, nextRoots[0] + axis, axis - i);
					g2.draw(s);
					s = new Line2D.Double(roots[1] + axis,axis - (i + 1)
											, nextRoots[1] + axis, axis - i);
					g2.draw(s);
					roots = nextRoots;
					i--;
				}

				s = new Line2D.Double(roots[0] + axis, axis - (i + 1)
										,p.getH() + axis,-p.getK() + axis);
				g2.draw(s);
				s = new Line2D.Double(roots[1] + axis, axis - (i + 1)
										,p.getH() + axis,-p.getK() + axis);
				g2.draw(s);
			} else {
				roots = p.getRoots(-axis);
				double i = -axis + 1;
				while( i < p.getK() ) {
					nextRoots = p.getRoots(i);
					s = new Line2D.Double(roots[0] + axis,axis - (i - 1)
											, nextRoots[0] + axis, axis - i);
					g2.draw(s);
					s = new Line2D.Double(roots[1] + axis,axis - (i - 1)
											, nextRoots[1] + axis, axis - i);
					g2.draw(s);
					roots = nextRoots;
					i++;
				}

				s = new Line2D.Double(roots[0] + axis, axis - (i - 1)
										,p.getH() + axis,-p.getK() + axis);
				g2.draw(s);
				s = new Line2D.Double(roots[1] + axis, axis - (i - 1)
										,p.getH() + axis,-p.getK() + axis);
				g2.draw(s);
			}
		} else {
			if( p.getMagnitude() > 0 ) {
				roots = p.getRoots(axis);
				double i = axis - 1;
				while( i > p.getH() ) {
					nextRoots = p.getRoots(i);
					s = new Line2D.Double(axis + (i + 1), -roots[0] + axis,
											axis + i, -nextRoots[0] + axis);
					g2.draw(s);
					s = new Line2D.Double(axis + (i + 1), -roots[1] + axis,
											axis + i, -nextRoots[1] + axis);
					g2.draw(s);
					roots = nextRoots;
					i--;
				}

				s = new Line2D.Double(axis + (i + 1), -roots[0] + axis
										,p.getH() + axis,-p.getK() + axis);
				g2.draw(s);
				s = new Line2D.Double(axis + (i + 1), -roots[1] + axis 
										,p.getH() + axis,-p.getK() + axis);
				g2.draw(s);
			} else {
				roots = p.getRoots(-axis);
				double i = -axis + 1;
				while( i < p.getH() ) {
					nextRoots = p.getRoots(i);
					s = new Line2D.Double(axis + (i - 1), -roots[0] + axis,
											axis + i, -nextRoots[0] + axis);
					g2.draw(s);
					s = new Line2D.Double(axis + (i - 1), -roots[1] + axis,
											axis + i, -nextRoots[1] + axis);
					g2.draw(s);
					roots = nextRoots;
					i++;
				}

				s = new Line2D.Double(axis + (i - 1), -roots[0] + axis
										,p.getH() + axis,-p.getK() + axis);
				g2.draw(s);
				s = new Line2D.Double(axis + (i - 1), -roots[1] + axis 
										,p.getH() + axis,-p.getK() + axis);
				g2.draw(s);
			}
		}
	}
}