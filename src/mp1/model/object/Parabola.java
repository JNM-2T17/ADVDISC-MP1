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

    double h;
    double k;
    double magnitude;
    boolean openingVertical;
    
    public Parabola (double h, double k, double magnitude, boolean openingVertical){
        this.h = h;
        this.k = k;
        this.magnitude = magnitude;
        this.openingVertical = openingVertical;
    }
    
    public void setH(double x){
        h = x;
    }
    
    public void setK(double y){
        k = y;
    }
    
    public void setOpeningVertical(boolean opening){
        openingVertical = opening;
    }
    
    @Override
    public Object2D rotate(int direction) throws IllegalArgumentException {
        if(openingVertical) {
            switch(direction) {
                case AdvancedObject2D.ROTATE_LEFT_90:
                    return new Parabola(-k,h,-magnitude,false);
                case AdvancedObject2D.ROTATE_RIGHT_90:
                    return new Parabola(k,-h,magnitude,false);
                case AdvancedObject2D.ROTATE_180:
                    return new Parabola(-h,-k,-magnitude,true);
                default:
                    return null;
            }
        } else {
            switch(direction) {
                case AdvancedObject2D.ROTATE_LEFT_90:
                    return new Parabola(-k,h,magnitude,true);
                case AdvancedObject2D.ROTATE_RIGHT_90:
                    return new Parabola(-k,-h,-magnitude,true);
                case AdvancedObject2D.ROTATE_180:
                    return new Parabola(-h,-k,-magnitude,false);
                default:
                    return null;
            }
        }
    }
    
    @Override
    public Object2D scale(double magnitude) {
        return new Parabola(h, k, magnitude*magnitude
                            , openingVertical);
    }

    @Override
    public Object2D reflect(int axis) throws IllegalArgumentException {
        switch(axis) {
            case AdvancedObject2D.REFLECT_X_AXIS:
                return new Parabola(h,-k,-magnitude,openingVertical);
            case AdvancedObject2D.REFLECT_Y_AXIS:
                return new Parabola(-h,k,magnitude,openingVertical);
            default:
                return null;
        }
    }

    @Override
    public Object2D translate(double x, double y) {
        return new Parabola(h + x,k + y,magnitude
                            ,openingVertical);
    }

    public String toString() {
        return ("Vertex: (" + h + "," + k + ")\np = " + magnitude 
                + "\nOpening " + (openingVertical ? "Vertical" : "Horizontal"));
    }
}
