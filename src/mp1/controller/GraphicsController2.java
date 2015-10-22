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
		mainGraphPanel = new GraphPanel2(25);
		gf.setJMenuBar(createMenu);
		gf.setMain(mainGraphPanel);
		transformPanel = director.getTransformPanel(null,null);
		gf.setSide(transformPanel);
		gf.setSize(1064,660);
		gf.setLocationRelativeTo(null);
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
		transformPanel = director.getTransformPanel(activeObject,s);
		gf.setSide(transformPanel);
		gf.setMain(mainGraphPanel);
		gf.setSize(1064,660);
		gf.setLocationRelativeTo(null);
	}


	public void transform(ITransform trans) {

	}
}