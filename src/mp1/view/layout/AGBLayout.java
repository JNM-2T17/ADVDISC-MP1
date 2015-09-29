package mp1.view.layout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JComponent;

/**
* @author Austin Fernandez
* GridBagLayout with custom function that allows easy adding
*/
public class AGBLayout extends GridBagLayout
{
   
   public AGBLayout()
   {
      super();
   }
   
   /**
   * allows easy adding of components to a container
   * @param container where to add the component
   * @param comp component to add
   * @param x x-coordinate to add component
   * @param y y-coordinate to add component
   * @param width width of component
   * @param height height of component
   * @param anchor where to align component if it is too small
   * @param fill how to stretch component if it is too small
   */
   public static void addComp( JPanel container, JComponent comp, int x, int y, 
                        int width, int height, int anchor, int fill )
   {
      //creates new constraints
	  GridBagConstraints gc = new GridBagConstraints();
	  
	  //sets values
	  gc.gridx = x;
	  gc.gridy = y;
	  gc.gridwidth = width;
	  gc.gridheight = height;
	  gc.weightx = 100;
	  gc.weighty = 100;
	  gc.insets = new Insets( 1, 1, 1, 1 );
	  gc.anchor = anchor;
	  gc.fill = fill;
	  
	  //adds component to container
	  container.add( comp, gc );
   }
   
   /**
   * allows easy adding of components to a container
   * @param container where to add the component
   * @param comp component to add
   * @param x x-coordinate to add component
   * @param y y-coordinate to add component
   * @param width width of component
   * @param height height of component
   * @param weightx extra horizontal space to give to this component
   * @param weighty extra vertical space to give to this component
   * @param anchor where to align component if it is too small
   * @param fill how to stretch component if it is too small
   */
   public static void addComp( JPanel container, JComponent comp, int x, int y, 
                        int width, int height, int weightx, int weighty, 
						int anchor, int fill )
   {
      //creates new constraints
	  GridBagConstraints gc = new GridBagConstraints();
	  
	  //sets values
	  gc.gridx = x;
	  gc.gridy = y;
	  gc.gridwidth = width;
	  gc.gridheight = height;
	  gc.weightx = weightx;
	  gc.weighty = weighty;
	  gc.insets = new Insets( 1, 1, 1, 1 );
	  gc.anchor = anchor;
	  gc.fill = fill;
	  
	  //adds component to container
	  container.add( comp, gc );
   }
}