package mp1.controller;

import java.util.ArrayList;

import mp1.model.Shape;
import mp1.model.object.*;
import mp1.view.*;
import mp1.view.transform.*;
import mp1.view.draw.*;

/**
 *
 * @author Austin Fernandez
 */
public class GraphicsController2 extends GraphicsController {
	private ArrayList<Object2D> objects;
	private CreatePanelFactory createFactory;
	private CreateFrame createFrame;
	private CreateMenu createMenu;
	private GraphPanel2 mainGraphPanel;

	public GraphicsController2() {
		super();
		objects = new ArrayList<Object2D>();
		createFactory = CreatePanelFactory.getInstance(this);
		createFrame = new CreateFrame();
		createMenu = new CreateMenu(this);
		mainGraphPanel = new GraphPanel2(25,this);
		gf.setJMenuBar(createMenu);
		gf.setLocationRelativeTo(null);
		showMain();
	}

	public void showMain() {
		gf.setMain(mainGraphPanel);
		director.setBuilder(new TransformPanelBuilder2(activeObject,this));
		transformPanel = director.getTransformPanel(null,null);
		gf.setSide(transformPanel);
		gf.setSize(1194,680);
	}

	public void shapeScreen(Shape s) {
		AbstractCreatePanel createPanel = createFactory.getPanel(s);
		createFrame.setPanel(createPanel);
		createFrame.setVisible(true);
	}

	public void createShape(Shape s, double[] params) {
		super.createShape(s,params);
		objects.add(activeObject);
		createFrame.setVisible(false);
		mainGraphPanel.addMain(s,activeObject);
		mainGraphPanel.setMain(s,activeObject);
		setGraphs(s);
	}

	public void setGraphs(Shape s) {
		director.setBuilder(new TransformPanelBuilder2(activeObject,this));
		transformPanel = director.getTransformPanel(activeObject,s);
		gf.setSide(transformPanel);
		gf.setMain(mainGraphPanel);
		gf.setSize(1194,680);
		gf.setLocationRelativeTo(null);
	}


	public void transform(ITransform trans) {
		Object2D obj = trans.transform(mainGraphPanel.getLast());
		mainGraphPanel.addTransform(mainGraphPanel.getMain(),obj);
		transformPanel.setTransformed(obj);
	}

	public void delete(Object2D obj) {
		director.setBuilder(new TransformPanelBuilder2(null,this));
		transformPanel = director.getTransformPanel(null,null);
		gf.setSide(transformPanel);
		mainGraphPanel.deleteMain(obj);
	}

	public void setMain(Object2D obj) {
		Shape s = null;
		if( obj instanceof Point) {
			s = Shape.POINT;
		} else if( obj instanceof Vector) {
			s = Shape.VECTOR;
		} else if( obj instanceof LineSegment ) {
			s = Shape.LINE_SEGMENT;
		} else if( obj instanceof Polygon ) {
			s = Shape.POLYGON;
		} else if( obj instanceof Parabola ) {
			s = Shape.PARABOLA;
		} else if( obj instanceof Hyperbola ) {
			s = Shape.HYPERBOLA;
		} else if( obj instanceof Ellipse ) {
			s = Shape.ELLIPSE;
		} 
		director.setBuilder(new TransformPanelBuilder2(obj,this));
		transformPanel = director.getTransformPanel(obj,s);
		gf.setSide(transformPanel);
		mainGraphPanel.setMain(s,obj);	
	} 

	public void undo() {
		mainGraphPanel.undoTransform(mainGraphPanel.getMain());
	}
}