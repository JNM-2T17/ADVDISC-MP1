package mp1.model.object;

import java.lang.Math;

/**
 *
 * @author Austin Fernandez
 * @author Jonah Syfu
 */
public class Polygon implements AdvancedObject2D, ShearObject2D
								, DoubleRotateObject2D {

	private double[] xs;
	private double[] ys;
	private int vertices;

	public Polygon(double[] xs, double[] ys, int n){
		this.xs = xs;
		this.ys = ys;
		this.vertices = n;
	}

	public double[] getXs() {
		return xs;
	}

	public double[] getYs() {
		return ys;
	}

	public int getVertices() {
		return vertices;
	}

	public Object2D translate(double x, double w){
		double[] newX = new double[vertices];
		double[] newY = new double[vertices];

		for( int i = 0; i < vertices; i++ ) {
			newX[i] = xs[i] + x;
			newY[i] = ys[i] + w;
		}

		return new Polygon(newX,newY,vertices); 
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
		double[] newX = new double[vertices];
		double[] newY = new double[vertices];

		for( int i = 0; i < vertices; i++ ) {
			newX[i] = xs[i] * cos - ys[i] * sin;
			newY[i] = xs[i] * sin + ys[i] * cos;
		}
		return new Polygon(newX,newY,vertices);
	}

	public Object2D scale(double dd){
		double[] newX = new double[vertices];
		double[] newY = new double[vertices];

		for( int i = 0; i < vertices; i++ ) {
			newX[i] = dd * xs[i];
			newY[i] = dd * ys[i];
		}

		return new Polygon(newX, newY, vertices);
	}

	public Object2D reflect(int cas){
		double[] newX = new double[vertices];
		double[] newY = new double[vertices];

		switch(cas){
			case AdvancedObject2D.REFLECT_X_AXIS: 
				for( int i = 0; i < vertices; i++ ) {
					newY[i] = -ys[i];
				}		
				return new Polygon(xs, newY,vertices);
			case AdvancedObject2D.REFLECT_Y_AXIS: 	
				for( int i = 0; i < vertices; i++ ) {
					newX[i] = -xs[i];
				}
				return new Polygon(newX, ys,vertices);
			default:
		}
		return null;
	}

	public Object2D shear(double degree){
		double angleInRadian = Math.toRadians(degree);
		double tan = Math.tan(angleInRadian);
		double[] newX = new double[vertices];

		for( int i = 0; i < vertices; i++ ) {
			newX[i] = xs[i] + tan * ys[i];
		}
		return new Polygon(newX,ys,vertices);
	}

	public String toString() {
		char label = 'A';
		String ret = "";
		for( int i = 0; i < vertices; i++, label++ ) {
			ret += (ret.length() == 0 ? "" : "<br/>") + label + " = [" + xs[i] 
					+ " " + ys[i] + "]";
		}
		return ret;
	}
}