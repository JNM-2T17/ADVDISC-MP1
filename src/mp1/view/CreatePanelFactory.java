package mp1.view;

import mp1.controller.IController;
import mp1.model.Shape;

/**
 *
 * @author Ryan Austin Fernandez
 */
public class CreatePanelFactory {
	private static CreatePanelFactory instance;

	private IController control;

	private CreatePanelFactory(IController control) {
		this.control = control;
	}

	public static CreatePanelFactory getInstance(IController control) {
		if( instance == null ) {
			instance = new CreatePanelFactory(control);
		} 

		instance.setControl(control);

		return instance;
	}

	public void setControl(IController control) {
		this.control = control;
	}

	public AbstractCreatePanel getPanel(Shape s) {
		AbstractCreatePanel panel;
		switch(s) {
			case ELLIPSE:
				panel = new CreateEllipsePanel(control);
				break;
			case LINE_SEGMENT:
				panel = new CreateLineSegmentPanel(control);
				break;
			case PARABOLA:
				panel = new CreateParabolaPanel(control);
				break;
			case HYPERBOLA:
				panel = new CreateHyperbolaPanel(control);
				break;
			case POINT:
				panel = new CreatePointPanel(Shape.POINT,control);
				break;
			case POLYGON:
				panel = new CreatePolygonPanel(control);
				break;
			case VECTOR:
				panel = new CreatePointPanel(Shape.VECTOR,control);
				break;
			default:
				return null;
		}
		panel.setBackVisible(false);
		return panel;
	}
}