package mp1.model.object;

import java.lang.Math;

public class Vector implements AdvancedObject2D, ShearObject2D {

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
		return null;
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
			case 3: return new Vector((this.x - this.y) * 2, this.y);

			case 4: return new Vector(this.x, (this.y - this.x) * 2);
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