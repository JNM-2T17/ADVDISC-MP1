package mp1.view.transform;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import mp1.controller.IController;
import mp1.model.Transformation;
import mp1.model.object.AdvancedObject2D;
import mp1.view.layout.AGBLayout;

public class ReflectPanel extends TransParamPanel {
	private JRadioButton xButton;
	private JRadioButton yButton;

	public ReflectPanel(IController control) {
		super(Transformation.REFLECT,control);
	}

	protected void addComponents() {
		ButtonGroup bg = new ButtonGroup();

		xButton = new JRadioButton("x-axis",true);
		xButton.addActionListener(inputListen);
		bg.add(xButton);
		AGBLayout.addComp(this,xButton,0,0,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.NONE);

		yButton = new JRadioButton("y-axis");
		yButton.addActionListener(inputListen);
		bg.add(yButton);
		AGBLayout.addComp(this,yButton,0,1,1,1,100,100,GridBagConstraints.CENTER
							,GridBagConstraints.NONE);
	}

	protected ITransform getCommand() throws IllegalArgumentException {
		if( xButton.isSelected() ) {
			return new Reflect(AdvancedObject2D.REFLECT_X_AXIS);
		} else {
			return new Reflect(AdvancedObject2D.REFLECT_Y_AXIS);
		}
	}
}