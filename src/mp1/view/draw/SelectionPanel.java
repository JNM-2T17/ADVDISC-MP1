package mp1.view.draw;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import mp1.controller.IController;
import mp1.controller.GraphicsController2;
import mp1.model.Transformation;
import mp1.model.object.Object2D;
import mp1.view.layout.AGBLayout;

/**
 *
 * @author Austin Fernandez
 */
public class SelectionPanel extends JPanel {
	private ArrayList<JRadioButton> radioButtons;
	private HashMap<JRadioButton,Object2D> objectMap;

	private JPanel deletePanel;
	private Box listPanel;
	private JButton deleteButton;
	private JScrollPane listScroll;

	private IController control;

	public SelectionPanel(Iterator itr,IController control) {
		super(new BorderLayout());
		this.control = control;

		Dimension d = getPreferredSize();
		setPreferredSize(new Dimension(160,d.height));

		radioButtons = new ArrayList<JRadioButton>();
		objectMap = new HashMap<JRadioButton,Object2D>();

		deletePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		deleteButton = new JButton("Delete Selected");
		deleteButton.setFont(new Font("Segoe UI",Font.PLAIN,14));
		deleteButton.addActionListener(new DeleteListen());
		deleteButton.setVisible(false);
		deletePanel.add(deleteButton);

		add(deletePanel,BorderLayout.NORTH);

		listPanel = Box.createVerticalBox();
		listScroll = new JScrollPane(listPanel,JScrollPane
										.VERTICAL_SCROLLBAR_AS_NEEDED
										,JScrollPane
										.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		add(listScroll,BorderLayout.CENTER);
	}

	public void setModel(Iterator itr) {
		listPanel.removeAll();
		radioButtons.clear();

		ButtonGroup bg = new ButtonGroup();

		while(itr.hasNext()) {
			Object2D o = (Object2D)itr.next();

			JRadioButton radio = new JRadioButton(o.getClass().getSimpleName());
			radio.addActionListener(new SelectListen());
			radio.setFont(new Font("Segoe UI",Font.PLAIN,14));
			bg.add(radio);
			radioButtons.add(radio);
			objectMap.put(radio,o);
			listPanel.add(radio);
		}
		deleteButton.setVisible(false);

		listPanel.repaint();
		listPanel.revalidate();
	}

	public void setSelected(Object2D obj) {
		for(JRadioButton radio: radioButtons) {
			if( obj == objectMap.get(radio)) {
				radio.setSelected(true);
				deleteButton.setVisible(true);
				break;
			}
		}
	}

	private class DeleteListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			for( int i = 0; i < radioButtons.size(); i++ ) {
				if( radioButtons.get(i).isSelected()) {
					GraphicsController2 gc2 = (GraphicsController2)control;
					Object2D o2d = objectMap.get(radioButtons.get(i));
					gc2.delete(o2d);
					break;
				}
			}
		}
	}

	private class SelectListen implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GraphicsController2 gc2 = (GraphicsController2)control;
			gc2.setMain(objectMap.get((JRadioButton)e.getSource()));
			deleteButton.setVisible(true);
		}
	}
}