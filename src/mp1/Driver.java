package mp1;

import javax.swing.UIManager;
import javax.swing.UIManager.*;

import mp1.controller.GraphicsController;
import mp1.controller.GraphicsController2;

/**
 *
 * @author Austin Fernandez
 */
public class Driver {
	public static void main(String[] args) {
		try {
			for(LookAndFeelInfo lafi: UIManager.getInstalledLookAndFeels()) {
				if( "Nimbus".equals(lafi.getName())) {
					UIManager.setLookAndFeel(lafi.getClassName());
				}
			}
		} catch( Exception e ) {
			e.printStackTrace();
		}

		new GraphicsController2();
	}
}