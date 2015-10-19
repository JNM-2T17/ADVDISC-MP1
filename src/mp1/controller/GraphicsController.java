package mp1.controller;

import mp1.model.Shape;
import mp1.model.object.*;
import mp1.view.*;
import mp1.view.transform.*;

public class GraphicsController implements IController {
	private Object2D activeObject;
	private Object2D movedObject;

	private GraphicsFrame gf;
	private MainGraphicsPanel mgPanel;
	private TransformPanelDirector director;
	private TransformPanel transformPanel;

	public GraphicsController() {
		gf = new GraphicsFrame(this);
		mgPanel = new MainGraphicsPanel(this);
		showMain();
		director = new TransformPanelDirector(this);
	}

	public void showMain() {
		gf.setMain(mgPanel);
		gf.setSide(null);
		gf.setSize(600,400);
		gf.setLocationRelativeTo(null);
	}

	public void pack() {
		gf.pack();
		gf.setLocationRelativeTo(null);
	}

	public void shapeScreen(Shape s) {
		switch(s) {
			case ELLIPSE:
				gf.setMain(new CreateEllipsePanel(this));
				pack();break;
			case LINE_SEGMENT:
				gf.setMain(new CreateLineSegmentPanel(this));
				pack();
				break;
			case PARABOLA:
				gf.setMain(new CreateParabolaPanel(this));
				pack();
				break;
			case HYPERBOLA:
				gf.setMain(new CreateHyperbolaPanel(this));
				pack();
				break;
			case POINT:
				gf.setMain(new CreatePointPanel(Shape.POINT,this));
				pack();
				break;
			case POLYGON:
				break;
			case VECTOR:
				gf.setMain(new CreatePointPanel(Shape.VECTOR,this));
				pack();
				break;
		}
	}

	public void createShape(Shape s, double[] params) {
		switch(s) {
			case ELLIPSE:
				activeObject = new Ellipse(params[0],params[1],params[2]
												,params[3]);
				break;
			case LINE_SEGMENT:
				activeObject = new LineSegment(params[0],params[1],params[2]
												,params[3]);
				break;
			case PARABOLA:
				activeObject = new Parabola(params[0],params[1],params[2]
											,params[3] == 1);
				break;
			case HYPERBOLA:
				System.out.println("Center: (" + params[0] + "," + params[1] 
									+ ")\na = " + params[2] + "\nb = " 
									+ params[3] + "\nOpening " 
									+ (params[4] == 1 ? "Vertical" 
										: "Horizontal"));
				break;
			case POINT:
				activeObject = new Point(params[0],params[1]);
				break;
			case POLYGON:
				break;
			case VECTOR:
				activeObject = new Vector(params[0],params[1]);
				break;
		}
		transformPanel = director.getTransformPanel(activeObject,s);
		gf.setSide(transformPanel);
		pack();
		gf.setMain(null);
	}

	public void transform(ITransform transform) {
		movedObject = transform.transform(activeObject);
	}
}