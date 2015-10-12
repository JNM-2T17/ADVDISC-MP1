package mp1.model.object;

import java.lang.Math;

public class Vector implements AdvancedObject2D, ShearObject2D {

	private int x;
	private int y;

	public Vector(x, y){
		this.x = x;
		this.y = y;
	}

	public void setX(int x){
		this.x = x;
	}

	public void setY(int x){
		this.y = x;
	}

	public Object2D translate(double x, double w){
		return new Vector(this.x + x, this.y + w);
	}

	// Need to double check
	public Object2D rotate(int degree){
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
					break;

			case 4: return new Vector(this.x, (this.y - this.x) * 2);
					break;
		}
	}

	public Object2D shear(double x){
		double angleInRadian = Math.toRadians(degree);
		double tan = Math.tan(angleInRadian);
		return new Vector(this.x + this.y * tan, this.y);
	}
}