/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mp1.model.object;
import java.lang.Math;
/**
 *
 * @author Angelo Amadora
 */
public class Parabola implements AdvancedObject2D {

    double vertexX;
    double vertexY;
    double magnitude;
    boolean openingVertical;
    
    public Parabola (double vertexX, double vertexY, double magnitude, boolean openingVertical){
        this.vertexX = vertexX;
        this.vertexY = vertexY;
        this.magnitude = magnitude;
        this.openingVertical = openingVertical;
    }
    
    public void setVertexX(double x){
        vertexX = x;
    }
    
    public void setVertexY(double y){
        vertexY = y;
    }
    
    public void setOpeningVertical(boolean opening){
        openingVertical = opening;
    }
    
    @Override
    public Object2D rotate(int direction) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Object2D scale(double magnitude) {
        return new Parabola(this.vertexX*magnitude, this.vertexY*magnitude, this.magnitude*magnitude, openingVertical);
    }

    @Override
    public Object2D reflect(int axis) throws IllegalArgumentException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object2D translate(double x, double y) {
        return new Parabola(this.vertexX+x,this.vertexY+y,this.magnitude,this.openingVertical);
    }

    public String toString() {
        return ("Vertex: (" + vertexX + "," + vertexY + ")\np = " + magnitude 
                + "\nOpening " + (openingVertical ? "Vertical" : "Horizontal"));
    }
}
