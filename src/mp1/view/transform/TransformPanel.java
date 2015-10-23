package mp1.view.transform;

import java.awt.Dimension;
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
import mp1.model.Shape;
import mp1.model.object.Object2D;
import mp1.view.layout.AGBLayout;

/**
 *
 * @author Austin Fernandez
 */
public class TransformPanel extends JPanel {
	private Object2D model;
	private Object2D transformed;;

	private JTabbedPane transformPane;
	private JLabel transformLabel;
	private JPanel objectsPanel;
	private JScrollPane objectsPane;
	private JLabel objectLabel;
	private JLabel transLabel;
	protected JButton backButton;

	protected IController control;

	public TransformPanel(Object2D model, IController control) {
		this.model = model;
		this.control = control;

		setLayout(new AGBLayout());
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

		Dimension d = getPreferredSize();
		setPreferredSize(new Dimension(410,d.height));

		transformLabel = new JLabel("Select Transformation Parameters");
		transformLabel.setFont(new Font("Segoe UI",Font.BOLD,16));
		transformLabel.setBorder(BorderFactory.createEmptyBorder(5,10,5,5));
		AGBLayout.addComp(this,transformLabel,0,0,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		backButton = new JButton("Back to Main Menu");
		backButton.setFont(new Font("Segoe UI",Font.PLAIN,14));
		backButton.addActionListener(new BackListen());
		AGBLayout.addComp(this,backButton,1,0,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.NONE);

		objectsPanel = new JPanel(new AGBLayout());
		objectsPane = new JScrollPane(objectsPanel,JScrollPane
										.VERTICAL_SCROLLBAR_AS_NEEDED
										,JScrollPane
										.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		objectLabel = new JLabel("<html>Current Object: <br/>" + model 
								+ "</html>");
		objectLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(objectsPanel,objectLabel,0,0,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.NONE);

		transLabel = new JLabel();
		transLabel.setFont(new Font("Segoe UI",Font.PLAIN,14));
		AGBLayout.addComp(objectsPanel,transLabel,0,1,1,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.NONE);

		AGBLayout.addComp(this,objectsPane,0,1,2,1,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);

		transformPane = new JTabbedPane();
		AGBLayout.addComp(this,transformPane,0,2,2,2,100,100
							,GridBagConstraints.CENTER,GridBagConstraints.BOTH);
	}

	public void addPane(TransParamPanel panel) {
		transformPane.add(panel.getTransformation().toString(),panel);
	}

	public void setTransformed(Object2D obj) {
		transformed = obj;
		transLabel.setText("<html>Transformed Object:<br/> " + obj + "</html>");
	}

	public void clear() {
		transformPane.removeAll();
	}

	private class BackListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if( JOptionPane.showConfirmDialog(null,"Current object will be dele" 
												+ "ted. Are you sure you want " 
												+ "to go back?","Confirm"
												,JOptionPane.YES_NO_OPTION,
												JOptionPane.WARNING_MESSAGE,
												null) 
				== JOptionPane.YES_OPTION ) {
				control.showMain();
			}
		}
	}
}