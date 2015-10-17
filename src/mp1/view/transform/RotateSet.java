package mp1.view.transform;

import mp1.model.object.Object2D;
import mp1.model.object.AdvancedObject2D;

public class RotateSet implements ITransform {
	private int rotation;

	public RotateSet(int rotation) {
		this.rotation = rotation;
	}
	
	public Object2D transform(Object2D obj) {
		AdvancedObject2D ao2 = (AdvancedObject2D)obj;
		return ao2.rotate(rotation);
	}
}