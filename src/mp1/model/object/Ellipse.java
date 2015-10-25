package mp1.model.object;

/**
 *
 * @author Austin Fernandez
 * @author John Joseph Andres
 */
public class Ellipse implements AdvancedObject2D,DoubleRotateObject2D
									,ShearObject2D{
	
	private double h;
	private double k;
	private double horizDistance;
	private double vertDistance;

	public Ellipse(double x, double y, double horizDistance
					, double vertDistance) {

		h = x;
		k = y;
		this.horizDistance = Math.abs(horizDistance);
		this.vertDistance = Math.abs(vertDistance);
	}

	public double getH() {
		return h;
	}

	public double getK() {
		return k;
	}

	private Curve getCurve() {
		//b^2(x-h)^2 + a^2(y-k)^2 = a^2b^2
		//b^2x^2 + a^2y^2 - 2b^2hx - 2a^2ky + b^2h^2+ a^2k^2 - a^2b^2;
		return new Curve(vertDistance*vertDistance,0,horizDistance*horizDistance
							,-2 * vertDistance * vertDistance * h, -2 
							* horizDistance * horizDistance, vertDistance 
							* vertDistance * h * h + horizDistance 
							* horizDistance * k * k - horizDistance 
							* horizDistance * vertDistance * vertDistance);
	}

	public Object2D rotate(double degree) {
		Curve c = getCurve();
		return c.rotate(degree);
	}

	public Object2D shear(double degree) {
		Curve c = getCurve();
		return c.shear(degree);	
	}

	public double getHorizDistance() {
		return horizDistance;
	}

	public double getVertDistance() {
		return vertDistance;
	}

	public Object2D translate(double x, double y){

		return new Ellipse(h + x, k + y
							, horizDistance, vertDistance);
	}

	public Object2D rotate(int x) throws IllegalArgumentException {
		switch( x ) {
			case AdvancedObject2D.ROTATE_LEFT_90:
				return new Ellipse(-k,h,vertDistance,horizDistance);
			case AdvancedObject2D.ROTATE_RIGHT_90:
				return new Ellipse(k,-h,vertDistance,horizDistance);
			case AdvancedObject2D.ROTATE_180:
				return new Ellipse(-h,-k,horizDistance,vertDistance);
			default:
				throw new IllegalArgumentException();
		}

	}

	public Object2D scale(double x) {
		return new Ellipse(h, k, horizDistance * x, vertDistance * x);
	}

	public Object2D reflect(int x) throws IllegalArgumentException {
		switch(x) {
			case AdvancedObject2D.REFLECT_X_AXIS:
				return new Ellipse(h,-k,horizDistance,vertDistance);
			case AdvancedObject2D.REFLECT_Y_AXIS:
				return new Ellipse(-h,k,horizDistance,vertDistance);
			default:
				throw new IllegalArgumentException();
		}
	}

	public String toString() {
		double a = vertDistance * vertDistance;
		double b = horizDistance * horizDistance;
		double c = -2 * vertDistance * vertDistance * h;
		double d = -2 * horizDistance * horizDistance * k;
		double e = -vertDistance * vertDistance * horizDistance * horizDistance 
					+ vertDistance * vertDistance * h * h + horizDistance 
					* horizDistance * k * k;
		String ret = (a == 1 ? "" : a) + "x<sup>2</sup> + " + (b == 1 ? "" : b)
					 + "y<sup>2</sup>";

		if( c != 0 ) {
			if( c == 1 ) {
				ret += " + x";
			} else if( c == -1 ) {
				ret += " - x";
			} else if( c < 0 ) {
				ret += " " + c + "x";
			} else {
				ret += " + " + c + "x";
			}
		}

		if( d != 0 ) {
			if( d == 1 ) {
				ret += " + y";
			} else if( d == -1 ) {
				ret += " - y";
			}  else if( d < 0 ) {
				ret += " " + d + "y";
			} else {
				ret += " + " + d + "y";
			}
		}

		if( e != 0 ) {
			if( e < 0 ) {
				ret += " " + e;
			} else {
				ret += " + " + e;
			}
		}

		return ret + " = 0";
	}
} 