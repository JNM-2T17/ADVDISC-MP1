package mp1.view.transform;

import mp1.controller.IController;
import mp1.model.Transformation;
import mp1.model.object.Object2D;

/**
 *
 * @author Austin Fernandez
 */
public class TransformPanelBuilder implements TransformBuilder {
	private TransformPanel transPanel;
	private IController control;

	public TransformPanelBuilder(Object2D model, IController control) {
		transPanel = new TransformPanel(model, control);
		this.control = control;
	}

	public void addTranslate() {
		transPanel.addPane(new TranslatePanel(control));
	}

	public void addRotate(boolean isDouble) {
		if( isDouble ) {
			transPanel.addPane(new ShearRotatePanel(Transformation
													.ROTATE_DOUBLE,control));
		} else {
			transPanel.addPane(new RotateSetPanel(control));
		}
	}

	public void addShear() {
		transPanel.addPane(new ShearRotatePanel(Transformation.SHEAR,control));
	}

	public void addReflect() {
		transPanel.addPane(new ReflectPanel(control));
	}

	public void addScale() {
		transPanel.addPane(new ScalePanel(control));
	}

	public TransformPanel build() {
		return transPanel;
	}

}