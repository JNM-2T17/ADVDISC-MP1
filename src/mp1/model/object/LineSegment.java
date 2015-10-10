package mp1.model.object;

import java.lang.Math;

public class LineSegment implements AdvancedObject2D, ShearObject2D {

	private int x1;
	private int x2;

	private int y1;
	private int y2;

	public LineSegment(x1, x2, y1, y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public void setX1(int x){
		this.x1 = x;
	}

	public void setY1(int x){
		this.y1 = x;
	}

	public void setX2(int x){
		this.x2 = x;
	}

	public void setY2(int x){
		this.y2 = x;
	}

	public Object2D translate(double x, double w){
		return new LineSegment(this.x1 + x, this.x2 + x, this.y1 + w, this.y2 + w);
	}

	// Need to double check
	public Object2D rotate(int degree){
		double angleInRadian = Math.toRadians(degree);
		double cos = Math.cos(angleInRadian);
		double sin = Math.sin(angleInRadian);

		return new LineSegment(this.x1 * cos + this.y1 * sin, -1 * this.x1 * sin + this.y1 * cos, this.x2 * cos + this.y2 * sin, -1 * this.x2 * sin + this.y2 * cos);
	}

	public Object2D scale(double dd){
		return new LineSegment(this.x1 * dd, this.x2 * dd, this.y1 * dd, this.y2 * dd);
	}

	public Object2D reflect(int cas){
		switch(cas){
			case 3: return new LineSegment(this.x2, this.x1, this.y1, this.y2);
					break;

			case 4: return new LineSegment(this.x1, this.x2, this.y2, this.y1);
					break;
		}
	}

	public Object2D shear(double x){

	}
}