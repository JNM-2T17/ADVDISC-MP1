package mp1.model.object;

public interface AdvancedObject2D extends Object2D {
	public static final int ROTATE_LEFT_90 = 0;
	public static final int ROTATE_RIGHT_90 = 1;
	public static final int ROTATE_180 = 2;
	public static final int REFLECT_X_AXIS = 3;
	public static final int REFLECT_Y_AXIS = 4;

	public abstract void rotate(int direction) throws IllegalArgumentException;

	public abstract void scale(double magnitude);

	public abstract void reflect(int axis) throws IllegalArgumentException;
}