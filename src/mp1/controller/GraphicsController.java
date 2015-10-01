package mp1.controller;

import mp1.model.Shape;
import mp1.view.*;

public class GraphicsController implements IController {
	private GraphicsFrame gf;
	private MainGraphicsPanel mgPanel;

	public GraphicsController() {
		gf = new GraphicsFrame(this);
		mgPanel = new MainGraphicsPanel(this);
		gf.setMain(mgPanel);
	}

	public void showMain() {
		gf.setMain(mgPanel);
	}

	public void shapeScreen(Shape s) {
		System.out.println(s);
	}
}