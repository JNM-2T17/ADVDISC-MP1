package mp1.controller;

import mp1.model.Shape;
import mp1.view.GraphicsFrame;

public class GraphicsController implements IController {
	private GraphicsFrame gf;

	public GraphicsController() {
		gf = new GraphicsFrame(this);
	}

	public void shapeScreen(Shape s) {
		
	}
}