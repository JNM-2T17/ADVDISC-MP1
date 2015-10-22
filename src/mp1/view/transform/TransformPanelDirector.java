package mp1.view.transform;

import mp1.controller.IController;
import mp1.model.*;
import mp1.model.object.Object2D;

/**
 *
 * @author Austin Fernandez
 */
public class TransformPanelDirector {
	IController control;

	public TransformPanelDirector(IController control) {
		this.control = control;
	}

	public TransformPanel getTransformPanel(Object2D obj, Shape s) {
		TransformPanelBuilder builder = new TransformPanelBuilder(obj, control);
		if( s != null ) {
			builder.addTranslate();
			switch(s) {
				case LINE_SEGMENT:
				case POLYGON:
				case VECTOR:
					builder.addShear();
					builder.addRotate(true);
					// fall-through
				case ELLIPSE:
				case PARABOLA:
				case HYPERBOLA:
					builder.addRotate(false);
					builder.addScale();
					builder.addReflect();
					break;
				default:
			}
		}
		return builder.build();
	}

}