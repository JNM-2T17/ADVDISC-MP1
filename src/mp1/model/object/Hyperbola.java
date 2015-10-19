package mp1.model.object;

import java.lang.Math;

/**
 *
 * @author Austin Fernandez
 */
public class Hyperbola implements AdvancedObject2D {
    
    double h;
    double k;
    double horizDistance;
    double vertDistance;
    boolean openingVertical;
    
    public Hyperbola(double h,double k,double horizDistance, double vertDistance
                    ,boolean openingVertical) {
        this.h = h;
        this.k = k;
        this.horizDistance = horizDistance;
        this.vertDistance = vertDistance;
        this.openingVertical = openingVertical;
    }

    @Override
    public Object2D rotate(int direction) throws IllegalArgumentException {
        switch(direction) {
            case AdvancedObject2D.ROTATE_LEFT_90:
                return new Hyperbola(k,-h,vertDistance,horizDistance
                                    ,!openingVertical);
            case AdvancedObject2D.ROTATE_RIGHT_90:
                return new Hyperbola(-k,h,vertDistance,horizDistance
                                    ,!openingVertical);
            case AdvancedObject2D.ROTATE_180:
                return new Hyperbola(-h,-k,horizDistance,vertDistance
                                    ,openingVertical);
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public Object2D scale(double magnitude) {
        return new Hyperbola(h,k,magnitude*horizDistance,magnitude*vertDistance
                                ,openingVertical);
    }

    @Override
    public Object2D reflect(int axis) throws IllegalArgumentException {
        switch(axis) {
            case AdvancedObject2D.REFLECT_X_AXIS:
                return new Hyperbola(h,-k,horizDistance,vertDistance
                                        ,openingVertical);
            case AdvancedObject2D.REFLECT_Y_AXIS:
                return new Hyperbola(-h,k,horizDistance,vertDistance
                                        ,openingVertical);
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public Object2D translate(double x, double y) {
        return new Hyperbola(h + x, k + y, horizDistance, vertDistance
                                ,openingVertical );
    }

    public String toString() {
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        double e = 0;
        String ret = "" ;

        if(openingVertical) {
            a = -vertDistance * vertDistance;
            b = horizDistance * horizDistance;
            c = 2 * vertDistance * vertDistance * h;
            d = -2 * horizDistance * horizDistance * k;
            e = -horizDistance * horizDistance * vertDistance * vertDistance
                 + horizDistance * horizDistance * k * k 
                 - vertDistance * vertDistance * h * h;
            ret = (a == -1 ? "-" : a) + "x<sup>2</sup> + " + (b == 1 ? "" : b) 
                    + "y<sup>2</sup>";
        } else {
            a = vertDistance * vertDistance;
            b = -horizDistance * horizDistance;
            c = -2 * vertDistance * vertDistance * h;
            d = 2 * horizDistance * horizDistance * k;
            e = -horizDistance * horizDistance * vertDistance * vertDistance
                + vertDistance * vertDistance * h * h - horizDistance 
                * horizDistance * k * k; 
            ret = (a == 1 ? "" : a) + "x<sup>2</sup> " + (b == -1 ? "-" : b ) 
                    + "y<sup>2</sup>";
        }

        if( c != 0 ) {
            if( c == 1 ) {
                ret += " + x";
            } else if( c == -1 ) {
                ret += " - x";
            } else if( c < 0 ) {
                ret += " " + c + "x";
            } else {
                ret += " + " + c + "x";
            }
        }

        if( d != 0 ) {
            if( d == 1 ) {
                ret += " + y";
            } else if( d == -1 ) {
                ret += " - y";
            } else if( d < 0 ) {
                ret += " " + d + "y";
            } else {
                ret += " + " + d + "y";
            }
        }
        
        if( e != 0 ) {
            if( e < 0 ) {
                ret += " " + e;
            } else {
                ret += " + " + e;
            }
        }

        return ret + " = 0";        
    }
}
