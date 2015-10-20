package mp1.view.transform;

import mp1.model.object.Object2D;
import mp1.model.object.ShearObject2D;

/**
 *
 * @author Austin Fernandez
 */
public class Shear implements ITransform {
	private double theta;

	public Shear(double theta) {
		this.theta = theta;
	}
	
	public Object2D transform(Object2D obj) {
		ShearObject2D so2 = (ShearObject2D)obj;
		return so2.shear(theta);
	}

	public String toString() {
		return "Shearing by " + theta + " degrees.";
	}
}