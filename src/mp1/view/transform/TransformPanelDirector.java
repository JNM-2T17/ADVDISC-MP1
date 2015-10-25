package mp1.view.transform;

import mp1.controller.IController;
import mp1.model.*;
import mp1.model.object.Object2D;

/**
 *
 * @author Austin Fernandez
 */
public class TransformPanelDirector {
	TransformBuilder builder;
	IController control;

	public TransformPanelDirector(TransformBuilder builder,IController control) {
		this.control = control;
		this.builder = builder;
	}

	public void setBuilder(TransformBuilder builder) {
		this.builder = builder;
	}

	public TransformPanel getTransformPanel(Object2D obj, Shape s) {
		if( builder == null ) {
			builder = new TransformPanelBuilder(obj,control);
		}
		
		if( s != null ) {
			if( s == Shape.CURVE ) {
				builder.addRotate(true);
				builder.addRotate(false);
				builder.addShear();
				builder.addReflect();
			} else {
				builder.addTranslate();
				boolean linear = false;
				switch(s) {
					case LINE_SEGMENT:
					case POLYGON:
					case VECTOR:
						linear = true;
						builder.addShear();
						builder.addRotate(true);
						// fall-through
					case ELLIPSE:
					case PARABOLA:
					case HYPERBOLA:
						if( !linear 
							&& builder instanceof TransformPanelBuilder2) {
							builder.addShear();
							builder.addRotate(true);
						}
						builder.addRotate(false);
						builder.addScale();
						builder.addReflect();
						break;
					default:
				}
			}
		}
		return builder.build();
	}

}