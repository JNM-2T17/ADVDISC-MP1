package mp1.model.object;

import java.lang.Math;

/**
 *
 * @author Jonah Syfu
 */
public class LineSegment implements AdvancedObject2D, ShearObject2D
									, DoubleRotateObject2D {

	private double x1;
	private double x2;

	private double y1;
	private double y2;

	public LineSegment(double x1, double y1, double x2, double y2){
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public double getX1() {
		return this.x1;
	}

	public double getY1() {
		return this.y1;
	}

	public double getX2() {
		return this.x2;
	}

	public double getY2() {
		return this.y2;
	}

	public void setX1(double x){
		this.x1 = x;
	}

	public void setY1(double x){
		this.y1 = x;
	}

	public void setX2(double x){
		this.x2 = x;
	}

	public void setY2(double x){
		this.y2 = x;
	}

	public Object2D translate(double x, double w){
		return new LineSegment(this.x1 + x, this.y1 + w, this.x2 + x, this.y2 + w);
	}

	// Need to double check
	public Object2D rotate(double degree){
		double angleInRadian = Math.toRadians(degree);
		double cos = Math.cos(angleInRadian);
		double sin = Math.sin(angleInRadian);

		return new LineSegment(this.x1 * cos - this.y1 * sin, this.x1 * sin 
								+ this.y1 * cos, this.x2 * cos - this.y2 * sin
								, this.x2 * sin + this.y2 * cos);
	}

	public Object2D rotate(int degree){
		double deg;
		switch(degree) {
			case AdvancedObject2D.ROTATE_LEFT_90:	
				deg = 90;
				break;
			case AdvancedObject2D.ROTATE_180:
				deg = 180;
				break;
			case AdvancedObject2D.ROTATE_RIGHT_90:
				deg = -90;
				break;
			default:
				deg = 0;
		}

		return rotate(deg);
	}

	public Object2D scale(double dd){
		return new LineSegment(this.x1 * dd, this.y1 * dd, this.x2 * dd
								, this.y2 * dd);
	}

	public Object2D reflect(int cas){
		switch(cas){
			case AdvancedObject2D.REFLECT_X_AXIS: 
				return new LineSegment(this.x1, -this.y1, this.x2,-this.y2);

			case AdvancedObject2D.REFLECT_Y_AXIS: 
				return new LineSegment(-this.x1, this.y1, -this.x2, this.y2);
		}
		return null;
	}

	public Object2D shear(double degree){
		double angleInRadian = Math.toRadians(degree);
		double tan = Math.tan(angleInRadian);
		return new LineSegment(this.x1 + this.y1 * tan, this.y1, this.x2 + this.y2 * tan, this.y2);
	}

	public String toString() {
		return "P = [" + x1 + " " + y1 + "], <br/> Q = [" + x2 + " " 
				+ y2 + "]";
	}
}