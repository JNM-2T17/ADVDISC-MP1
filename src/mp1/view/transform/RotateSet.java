package mp1.view.transform;

import mp1.model.object.Object2D;
import mp1.model.object.AdvancedObject2D;

/**
 *
 * @author Austin Fernandez
 */
public class RotateSet implements ITransform {
	private int rotation;

	public RotateSet(int rotation) {
		this.rotation = rotation;
	}
	
	public Object2D transform(Object2D obj) {
		AdvancedObject2D ao2 = (AdvancedObject2D)obj;
		return ao2.rotate(rotation);
	}

	public String toString() {
		switch(rotation) {
			case AdvancedObject2D.ROTATE_LEFT_90:
				return "Rotating 90 degrees counterclockwise";
			case AdvancedObject2D.ROTATE_RIGHT_90:
				return "Rotating 90 degrees clockwise";
			case AdvancedObject2D.ROTATE_180:
				return "Rotating 180 degrees";
			default:
				return null;
		}
	}
}