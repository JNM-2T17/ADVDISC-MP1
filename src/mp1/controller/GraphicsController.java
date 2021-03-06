package mp1.controller;

import mp1.model.Shape;
import mp1.model.object.*;
import mp1.view.*;
import mp1.view.transform.*;
import mp1.view.draw.*;

/**
 *
 * @author Austin Fernandez
 */
public class GraphicsController implements IController {
	protected Object2D activeObject;
	private Object2D movedObject;

	protected GraphicsFrame gf;
	private MainGraphicsPanel mgPanel;
	protected TransformPanelDirector director;
	protected TransformPanel transformPanel;
	private GraphPanel graphPanel;

	public GraphicsController() {
		gf = new GraphicsFrame(this);
		mgPanel = new MainGraphicsPanel(this);
		director = new TransformPanelDirector(null,this);
		showMain();
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
				gf.setMain(new CreatePolygonPanel(this));
				pack();
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
				activeObject = new Hyperbola(params[0],params[1],params[2]
												,params[3],params[4] == 1);
				break;
			case POINT:
				activeObject = new Point(params[0],params[1]);
				break;
			case POLYGON:
				int vert = (int)params[0];
				double[] xs = new double[vert];
				double[] ys = new double[vert];

				for( int i = 0; i < vert; i++ ) {
					xs[i] = params[i + 1];
					ys[i] = params[i + 1 + vert];
				}
				activeObject = new Polygon(xs,ys,vert);
				break;
			case VECTOR:
				activeObject = new Vector(params[0],params[1]);
				break;
		}
		setGraphs(s);
	}

	public void setGraphs(Shape s) {
		transformPanel = director.getTransformPanel(activeObject,s);
		gf.setSide(transformPanel);
		graphPanel = new GraphPanel(s,activeObject,25);
		gf.setMain(graphPanel);
		gf.setSize(1064,645);
		gf.setLocationRelativeTo(null);
	}

	public void transform(ITransform transform) {
		movedObject = transform.transform(activeObject);
		transformPanel.setTransformed(movedObject);
		graphPanel.setTrans(movedObject);
	}
}