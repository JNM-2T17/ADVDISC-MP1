package mp1.view.transform;

import mp1.model.object.Object2D;
import mp1.model.object.AdvancedObject2D;

public class Reflect implements ITransform {
	private int axis;

	public Reflect(int axis) {
		this.axis = axis;
	}
	
	public Object2D transform(Object2D obj) {
		AdvancedObject2D ao2 = (AdvancedObject2D)obj;
		return ao2.reflect(axis);
	}
}