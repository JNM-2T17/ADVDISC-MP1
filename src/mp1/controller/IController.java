package mp1.controller;

import mp1.model.Shape;
import mp1.view.transform.ITransform;

/**
 *
 * @author Austin Fernandez
 */
public interface IController {
	public void showMain();
	public void pack();
	public void shapeScreen(Shape s);
	public void createShape(Shape s, double[] params);
	public void transform(ITransform transform);
}