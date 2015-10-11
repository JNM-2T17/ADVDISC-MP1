package mp1.view.transform;

public interface TransformBuilder {
	public void addTranslate();
	public void addRotate(boolean isDouble);
	public void addShear();
	public void addReflect();
	public void addScale();
	public TransformPanel build();
}