package mp1.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mp1.controller.IController;

public class GraphicsFrame extends JFrame {
	private JPanel mainPanel;
	private JPanel sidePanel;

	private IController control;

	public GraphicsFrame(IController control) {
		this.control = control;

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Matrix Graphics");

		mainPanel = new JPanel(new BorderLayout());
		add(mainPanel,BorderLayout.CENTER);

		sidePanel = new JPanel(new BorderLayout());
		add(sidePanel,BorderLayout.WEST);

		setSize(600,400);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void setMain(JPanel panel) {
		mainPanel.removeAll();
		if( panel != null ) {
			mainPanel.add(panel,BorderLayout.CENTER);
			mainPanel.repaint();
			mainPanel.revalidate();
		}
	}

	public void setSide(JPanel panel) {
		sidePanel.removeAll();
		if( panel != null ) {
			sidePanel.add(panel,BorderLayout.CENTER);
			sidePanel.repaint();
			sidePanel.revalidate();
		}
	}	
}