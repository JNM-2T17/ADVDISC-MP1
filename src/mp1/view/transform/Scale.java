package mp1.view.transform;

import mp1.model.object.Object2D;
import mp1.model.object.AdvancedObject2D;

public class Scale implements ITransform {
	private double scalar;

	public Scale(double scalar) {
		this.scalar = scalar;
	}
	
	public Object2D transform(Object2D obj) {
		AdvancedObject2D ao2 = (AdvancedObject2D)obj;
		return ao2.scale(scalar);
	}

	public String toString() {
		return "Scaling by factor of " + scalar; 
	}
}