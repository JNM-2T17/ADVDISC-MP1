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
		switch(s) {
			case ELLIPSE:
				return new CreateEllipsePanel(control);
			case LINE_SEGMENT:
				return new CreateLineSegmentPanel(control);
			case PARABOLA:
				return new CreateParabolaPanel(control);
			case HYPERBOLA:
				return new CreateHyperbolaPanel(control);
			case POINT:
				return new CreatePointPanel(Shape.POINT,control);
			case POLYGON:
				return new CreatePolygonPanel(control);
			case VECTOR:
				return new CreatePointPanel(Shape.VECTOR,control);
			default:
				return null;
		}
	}
}