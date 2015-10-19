package mp1.model;

/**
 *
 * @author Austin Fernandez
 */
public enum Transformation {
	TRANSLATE("Translate"),
	ROTATE_SET("Static Rotate"),
	ROTATE_DOUBLE("Dynamic Rotate"),
	SHEAR("Shear"),
	REFLECT("Reflect"),
	SCALE("Scale");

	private String name;

	Transformation(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}