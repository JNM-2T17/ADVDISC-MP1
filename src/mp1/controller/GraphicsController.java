package mp1.controller;

import mp1.model.Shape;
import mp1.model.object.*;
import mp1.view.*;

public class GraphicsController implements IController {
	private Object2D activeObject;
	private Object2D movedObject;

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

	public void pack() {
		gf.pack();
		gf.setLocationRelativeTo(null);
	}

	public void shapeScreen(Shape s) {
		switch(s) {
			case ELLIPSE:
				break;
			case LINE_SEGMENT:
				break;
			case PARABOLA:
				break;
			case HYPERBOLA:
				break;
			case POINT:
				gf.setMain(new CreatePointPanel(Shape.POINT,this));
				pack();
				break;
			case POLYGON:
				break;
			case VECTOR:
				break;
		}
	}

	public void createShape(Shape s, double[] params) {
		switch(s) {
			case ELLIPSE:
				break;
			case LINE_SEGMENT:
				break;
			case PARABOLA:
				break;
			case HYPERBOLA:
				break;
			case POINT:
				//activeObject = new Point(params[0],params[1]);
				System.out.println("(" + params[0] + "," + params[1] + ")");
				break;
			case POLYGON:
				break;
			case VECTOR:
				break;
		}
	}
}