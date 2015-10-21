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
		double[] roots, nextRoots;

		if( p.isOpeningVertical() ) {
			roots = p.getRoots(-axis);
			
			double i = -axis + 1;

			while( i < p.getK() - p.getVertDistance()) {
				nextRoots = p.getRoots(i);
				s1 = new Line2D.Double(roots[0] + axis, axis - (i - 1)
										,nextRoots[0] + axis,axis - i);
				g2.draw(s1);
				s1 = new Line2D.Double(roots[1] + axis, axis - (i - 1)
										,nextRoots[1] + axis,axis - i);
				g2.draw(s1);
				roots = nextRoots;
				i++;
			}
			s1 = new Line2D.Double(roots[0] + axis, axis - (i - 1)
									, p.getH() + axis
									, -(p.getK() - p.getVertDistance()) + axis);
			g2.draw(s1);
			s1 = new Line2D.Double(roots[1] + axis, axis - (i - 1)
									, p.getH() + axis
									, -(p.getK() - p.getVertDistance()) + axis);
			g2.draw(s1);

			roots = p.getRoots(axis);
			
			i = axis - 1;

			while( i > p.getK() + p.getVertDistance()) {
				nextRoots = p.getRoots(i);
				s2 = new Line2D.Double(roots[0] + axis, axis - (i + 1)
										,nextRoots[0] + axis,axis - i);
				g2.draw(s2);
				s2 = new Line2D.Double(roots[1] + axis, axis - (i + 1)
										,nextRoots[1] + axis,axis - i);
				g2.draw(s2);
				roots = nextRoots;
				i--;
			}
			s2 = new Line2D.Double(roots[0] + axis, axis - (i + 1)
									, p.getH() + axis
									, -(p.getK() + p.getVertDistance()) + axis);
			g2.draw(s2);
			s2 = new Line2D.Double(roots[1] + axis, axis - (i + 1)
									, p.getH() + axis
									, -(p.getK() + p.getVertDistance()) + axis);
			g2.draw(s2);
		} else {
			roots = p.getRoots(-axis);

			double i = -axis + 1;

			while( i < p.getH() - p.getHorizDistance()) {
				nextRoots = p.getRoots(i);
				s1 = new Line2D.Double(axis + (i - 1), -roots[0] + axis
										,axis + i,-nextRoots[0] + axis);
				g2.draw(s1);
				s1 = new Line2D.Double(axis + (i - 1), -roots[1] + axis
										,axis + i,-nextRoots[1] + axis);
				g2.draw(s1);
				roots = nextRoots;
				i++;
			}
			s1 = new Line2D.Double(axis + (i - 1), -roots[0] + axis
										,axis + p.getH() - p.getHorizDistance()
										,-p.getK() + axis);
			g2.draw(s1);
			s1 = new Line2D.Double(axis + (i - 1), -roots[1] + axis
										,axis + p.getH() - p.getHorizDistance()
										,-p.getK() + axis);
			g2.draw(s1);

			roots = p.getRoots(axis);
			
			i = axis - 1;

			while( i > p.getH() + p.getHorizDistance()) {
				nextRoots = p.getRoots(i);
				s2 = new Line2D.Double(axis + (i + 1), -roots[0] + axis
										,axis + i,-nextRoots[0] + axis);
				g2.draw(s2);
				s2 = new Line2D.Double(axis + (i + 1), -roots[1] + axis
										,axis + i,-nextRoots[1] + axis);
				g2.draw(s2);
				roots = nextRoots;
				i--;
			}
			s2 = new Line2D.Double(axis + (i + 1), -roots[0] + axis
										,axis + p.getH() + p.getHorizDistance()
										,-p.getK() + axis);
			g2.draw(s2);
			s2 = new Line2D.Double(axis + (i + 1), -roots[1] + axis
										,axis + p.getH() + p.getHorizDistance()
										,-p.getK() + axis);
			g2.draw(s2);
		}
	}
}