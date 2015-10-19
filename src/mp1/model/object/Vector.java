package mp1.model.object;

import java.lang.Math;

/**
 *
 * @author Austin Fernandez
 * @author Jonah Syfu
 */
public class Vector implements AdvancedObject2D, ShearObject2D
								, DoubleRotateObject2D {

	private double x;
	private double y;

	public Vector(double x, double y){
		this.x = x;
		this.y = y;
	}

	public void setX(double x){
		this.x = x;
	}

	public void setY(double x){
		this.y = x;
	}

	public Object2D translate(double x, double w){
		return new Vector(this.x + x, this.y + w);
	}

	public Object2D rotate(int degree) {
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

	// Need to double check
	public Object2D rotate(double degree){
		double angleInRadian = Math.toRadians(degree);
		double cos = Math.cos(angleInRadian);
		double sin = Math.sin(angleInRadian);

		return new Vector(this.x * cos - this.y * sin, this.x * sin + this.y * cos);
	}

	public Object2D scale(double dd){
		return new Vector(this.x * dd, this.y * dd);
	}

	public Object2D reflect(int cas){
		switch(cas){
			case AdvancedObject2D.REFLECT_X_AXIS: 
				return new Vector(this.x, -this.y);
			case AdvancedObject2D.REFLECT_Y_AXIS: 	
				return new Vector(-this.x, this.y);
			default:
		}
		return null;
	}

	public Object2D shear(double degree){
		double angleInRadian = Math.toRadians(degree);
		double tan = Math.tan(angleInRadian);
		return new Vector(this.x + this.y * tan, this.y);
	}

	public String toString() {
		return ("v = [" + x + " " + y + "]");
	}
}