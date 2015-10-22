package mp1.view.transform;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mp1.controller.IController;
import mp1.controller.GraphicsController2;
import mp1.model.Shape;
import mp1.model.object.Object2D;
import mp1.view.layout.AGBLayout;

/**
 *
 * @author Austin Fernandez
 */
public class TransformPanel2 extends TransformPanel {
	public JButton undoButton;

	public TransformPanel2(Object2D model, IController control) {
		super(model,control);
		
		remove(backButton);

		undoButton = new JButton("Undo");
		undoButton.setFont(new Font("Segoe UI",Font.PLAIN,14));
		undoButton.addActionListener(new UndoListen());
		AGBLayout.addComp(this,undoButton,1,0,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.NONE);
	}

	private class UndoListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GraphicsController2 gc2 = (GraphicsController2)control;

			gc2.undo();
		}
	}
}