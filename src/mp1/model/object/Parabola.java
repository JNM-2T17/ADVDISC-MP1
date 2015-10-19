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
        return new Parabola(h, k, this.magnitude*magnitude
                            , openingVertical);
    }

    @Override
    public Object2D reflect(int axis) throws IllegalArgumentException {
        if(openingVertical){
            switch(axis) {
                case AdvancedObject2D.REFLECT_X_AXIS:
                    return new Parabola(h,-k,-magnitude,true);
                case AdvancedObject2D.REFLECT_Y_AXIS:
                    return new Parabola(-h,k,magnitude,true);
                default:
                    return null;
            }
        } else {
            switch(axis) {
                case AdvancedObject2D.REFLECT_X_AXIS:
                    return new Parabola(h,-k,magnitude,false);
                case AdvancedObject2D.REFLECT_Y_AXIS:
                    return new Parabola(-h,k,-magnitude,false);
                default:
                    return null;
            }
        }
    }

    @Override
    public Object2D translate(double x, double y) {
        return new Parabola(h + x,k + y,magnitude,openingVertical);
    }

    public String toString() {
        if( openingVertical ) {
            double e = -2 * h;
            double f = -4 * magnitude;
            double con = h * h + 4 * magnitude * k;
            String ret = "x^2";
            if( e != 0 ) {
                if( e < 0 ) {
                    ret += " " + e + "x";
                } else {
                    ret += " + " + e + "x";
                }
            }

            if( f != 0 ) {
                if( f < 0 ) {
                    ret += " " + f + "y";
                } else {
                    ret += " + " + f + "y";
                }
            }

            if( con != 0 ) {
                if( con < 0 ) {
                    ret += " " + con + "";
                } else {
                    ret += " + " + con + "";
                }
            }

            return ret + " = 0";
        } else {
            double e = -4 * magnitude;
            double f = -2 * k;
            double con = k * k + 4 * magnitude * h;
            String ret = "y^2";
            if( e != 0 ) {
                if( e < 0 ) {
                    ret += " " + e + "x";
                } else {
                    ret += " + " + e + "x";
                }
            }

            if( f != 0 ) {
                if( f < 0 ) {
                    ret += " " + f + "y";
                } else {
                    ret += " + " + f + "y";
                }
            }

            if( con != 0 ) {
                if( con < 0 ) {
                    ret += " " + con + "";
                } else {
                    ret += " + " + con + "";
                }
            }

            return ret + " = 0";
        }
    }
}
