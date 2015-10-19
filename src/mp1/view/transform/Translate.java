package mp1.view.transform;

import mp1.model.object.Object2D;

public class Translate implements ITransform {
	private double x;
	private double y;

	public Translate(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Object2D transform(Object2D obj) {
		return obj.translate(x,y);
	}

	public String toString() {
		return "Translating by [" + x + " " + y + "]";
	}
}