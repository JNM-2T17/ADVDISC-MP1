package mp1.view.transform;

import mp1.model.object.Object2D;
import mp1.model.object.AdvancedObject2D;

/**
 *
 * @author Austin Fernandez
 */
public class Reflect implements ITransform {
	private int axis;

	public Reflect(int axis) {
		this.axis = axis;
	}
	
	public Object2D transform(Object2D obj) {
		AdvancedObject2D ao2 = (AdvancedObject2D)obj;
		return ao2.reflect(axis);
	}

	public String toString() {
		switch(axis) {
			case AdvancedObject2D.REFLECT_X_AXIS:
				return "Reflecting along x-axis";
			case AdvancedObject2D.REFLECT_Y_AXIS:
				return "Reflecting along y-axis";
			default:
				return null;
		}
	}
}