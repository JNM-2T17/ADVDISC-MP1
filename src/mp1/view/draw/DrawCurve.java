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

public class DrawCurve implements IDraw {
	private final int axis;

	public DrawCurve(int axis) {
		this.axis = axis;
	}

	public void drawObject(Object2D obj,Graphics2D g2) {
		Curve e = (Curve)obj;

		double[] interval = e.getInterval(axis * 1.0);
		double[] roots = e.getValue(-axis);
		double[] nextRoots;
		double i = -axis + 1;
		double vertex = interval[1];
		Shape s;
		
		for( int x = 0; x < interval.length; x++ ) {
			System.out.println(interval[x]);
		}

		if( interval.length == 2 ) {
			if( interval[0] == -axis) {
				roots = e.getValue(-axis);
				i = -axis + 1;
				vertex = interval[1];
				while( i < vertex ) {
					nextRoots = e.getValue(i);
					s = new Line2D.Double((i - 1) + axis, -roots[0] + axis
											,i + axis,-nextRoots[0] + axis);
					g2.draw(s);
					s = new Line2D.Double((i - 1) + axis, -roots[1] + axis
											,i + axis,-nextRoots[1] + axis);
					g2.draw(s);
					roots = nextRoots;
					i++;
				}
				s = new Line2D.Double((i - 1) + axis,-roots[0] + axis
										,interval[1] + axis
										,-e.getValue(interval[1])[0] + axis);
				g2.draw(s);
				s = new Line2D.Double((i - 1) + axis,-roots[1] + axis
										,interval[1] + axis
										,-e.getValue(interval[1])[0] + axis);
				g2.draw(s);
			} else if( interval[1] == axis) {
				roots = e.getValue(axis);
				i = axis - 1;
				vertex = interval[0];
				while( i > vertex ) {
					nextRoots = e.getValue(i);
					s = new Line2D.Double((i + 1) + axis, -roots[0] + axis
											,i + axis,-nextRoots[0] + axis);
					// System.out.print("Drawing " + ((i + 1) + axis) + "," + 
					// 					(-roots[0] + axis) + " " + (i + axis)
					// 					+ "," + (-nextRoots[0] + axis) + "\t");
					g2.draw(s);
					s = new Line2D.Double((i + 1) + axis, -roots[1] + axis
											,i + axis,-nextRoots[1] + axis);
					// System.out.println("Drawing " + ((i + 1) + axis) + "," + 
					// 					(-roots[1] + axis) + " " + (i + axis)
					// 					+ "," + (-nextRoots[1] + axis) );
					g2.draw(s);
					roots = nextRoots;
					i--;
				}
				double[] res = e.getValue(interval[0]);
				System.out.println(res[0] + " and " + res[1]);
				s = new Line2D.Double((i + 1) + axis,-roots[0] + axis
										,interval[0] + axis
										,-res[0] + axis);
				g2.draw(s);
				s = new Line2D.Double((i + 1) + axis,-roots[1] + axis
										,interval[0] + axis
										,-res[1] + axis);
				g2.draw(s);
			} else {
				double left = interval[0];
				double right = interval[1];
				double step = (right - left) / 300;

				roots = e.getValue(left);
				i = left + step;
				while( i <= right ) {
					nextRoots = e.getValue(i);
					s = new Line2D.Double((i - step) + axis, -roots[0] + axis
											,i + axis,-nextRoots[0] + axis);
					// System.out.println("Drawing " + ((i - step) + axis) + "," 
					// 					+ (-roots[0] + axis) + " " + (i + axis)
					// 					+ "," + (-nextRoots[0] + axis));
					g2.draw(s);
					s = new Line2D.Double((i - step) + axis, -roots[1] + axis
											,i + axis,-nextRoots[1] + axis);
					// System.out.println("Drawing " + ((i - step) + axis) + "," 
					// 					+ (-roots[1] + axis) + " " + (i + axis)
					// 					+ "," + (-nextRoots[1] + axis));
					g2.draw(s);
					roots = nextRoots;
					i += step;
				}

				double[] res = e.getValue(interval[1]);
				s = new Line2D.Double((i - step) + axis, -roots[0] + axis
											,interval[1] + axis,-res[0] + axis);
				g2.draw(s);
				s = new Line2D.Double((i - step) + axis, -roots[1] + axis
										,interval[1] + axis,-res[1] + axis);
				g2.draw(s);	
			}
		} else if( interval.length == 3 ) {
			roots = e.getValue(-axis);
			i = -axis + 1;
			boolean skip = false;
			while( i < axis ) {
				if( i == interval[1]) {
					nextRoots = e.getValue(i-0.0001);
					skip = true;
				} else {
					nextRoots = e.getValue(i);
				}
				
				s = new Line2D.Double((i - 1) + axis, -roots[0] + axis
										,i + axis,-nextRoots[0] + axis);
				g2.draw(s);
				if( skip ) {
					skip = false;
					nextRoots = e.getValue(i + 0.0001);
				}
				roots = nextRoots;
				i++;
			}
		} else {
			roots = e.getValue(-axis);
			i = -axis + 1;
			vertex = interval[1];
			while( i < vertex ) {
				nextRoots = e.getValue(i);
				s = new Line2D.Double((i - 1) + axis, -roots[0] + axis
										,i + axis,-nextRoots[0] + axis);
				g2.draw(s);
				s = new Line2D.Double((i - 1) + axis, -roots[1] + axis
										,i + axis,-nextRoots[1] + axis);
				g2.draw(s);
				roots = nextRoots;
				i++;
			}
			s = new Line2D.Double((i - 1) + axis,-roots[0] + axis
									,interval[1] + axis
									,-e.getValue(interval[1])[0] + axis);
			g2.draw(s);
			s = new Line2D.Double((i - 1) + axis,-roots[1] + axis
									,interval[1] + axis
									,-e.getValue(interval[1])[0] + axis);
			g2.draw(s);

			roots = e.getValue(axis);
			i = axis - 1;
			vertex = interval[2];
			while( i > vertex ) {
				nextRoots = e.getValue(i);
				s = new Line2D.Double((i + 1) + axis, -roots[0] + axis
										,i + axis,-nextRoots[0] + axis);
				g2.draw(s);
				s = new Line2D.Double((i + 1) + axis, -roots[1] + axis
										,i + axis,-nextRoots[1] + axis);
				g2.draw(s);
				roots = nextRoots;
				i--;
			}
			s = new Line2D.Double((i + 1) + axis,-roots[0] + axis
									,interval[2] + axis
									,-e.getValue(interval[2])[0] + axis);
			g2.draw(s);
			s = new Line2D.Double((i + 1) + axis,-roots[1] + axis
									,interval[2] + axis
									,-e.getValue(interval[2])[0] + axis);
			g2.draw(s);
		}
	}
}