package mp1.model;

/**
 *
 * @author Austin Fernandez
 */
public enum Shape {
	CURVE("Curve"),
	ELLIPSE("Ellipse"),
	LINE_SEGMENT("Line Segment"),
	PARABOLA("Parabola"),
	HYPERBOLA("Hyperbola"),
	POINT("Point"),
	POLYGON("Polygon"),
	VECTOR("Vector");

	private String name;

	Shape(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}