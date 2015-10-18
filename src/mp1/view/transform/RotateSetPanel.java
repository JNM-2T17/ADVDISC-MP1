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

public class RotateSetPanel extends TransParamPanel {
	private JRadioButton left90Button;
	private JRadioButton right90Button;
	private JRadioButton rotate180Button;

	public RotateSetPanel(IController control) {
		super(Transformation.ROTATE_SET,control);
	}

	protected void addComponents() {
		ButtonGroup bg = new ButtonGroup();

		left90Button = new JRadioButton("90 degrees counterclockwise");
		left90Button.addActionListener(inputListen);
		bg.add(left90Button);
		AGBLayout.addComp(this,left90Button,0,0,1,1,100,100
							,GridBagConstraints.CENTER
							,GridBagConstraints.NONE);

		right90Button = new JRadioButton("90 degrees clockwise");
		right90Button.addActionListener(inputListen);
		bg.add(right90Button);
		AGBLayout.addComp(this,right90Button,0,1,1,1,100,100
							,GridBagConstraints.CENTER
							,GridBagConstraints.NONE);

		rotate180Button = new JRadioButton("180 degrees");
		rotate180Button.addActionListener(inputListen);
		bg.add(rotate180Button);
		AGBLayout.addComp(this,rotate180Button,0,2,1,1,100,100
							,GridBagConstraints.CENTER
							,GridBagConstraints.NONE);
	}

	protected ITransform getCommand() throws IllegalArgumentException {
		if( left90Button.isSelected() ) {
			return new RotateSet(AdvancedObject2D.ROTATE_LEFT_90);
		} else if( right90Button.isSelected() ) {
			return new RotateSet(AdvancedObject2D.ROTATE_RIGHT_90);
		} else {
			return new RotateSet(AdvancedObject2D.ROTATE_180);
		}
	}
}