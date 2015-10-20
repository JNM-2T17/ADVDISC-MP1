package mp1.view.transform;

import mp1.model.object.Object2D;
import mp1.model.object.DoubleRotateObject2D;

/**
 *
 * @author Austin Fernandez
 */
public class RotateDouble implements ITransform {
	private double theta;

	public RotateDouble(double theta) {
		this.theta = theta;
	}
	
	public Object2D transform(Object2D obj) {
		DoubleRotateObject2D dro2 = (DoubleRotateObject2D)obj;
		return dro2.rotate(theta);
	}

	public String toString() {
		return "Rotating " + theta + " degrees";
	}
}