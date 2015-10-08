package mp1.controller;

import mp1.model.Shape;

public interface IController {
	public void showMain();
	public void pack();
	public void shapeScreen(Shape s);
	public void createShape(Shape s, double[] params);
}