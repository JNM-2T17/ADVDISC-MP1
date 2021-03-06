package mp1.model.object;
import java.lang.Math;

/**
 *
 * @author Angelo Amadora
 * @author Austin Fernandez
 */
public class Parabola implements AdvancedObject2D, DoubleRotateObject2D
                                    ,ShearObject2D {

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

    public double getH() {
        return h;
    }
    
    public double getK() {
        return k;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public boolean isOpeningVertical() {
        return openingVertical;
    }

    private Curve getCurve() {
        if( openingVertical ) {
            //4p(y-k) = (x-h)^2
            //4py - 4pk = x^2 - 2hx + h^2
            //x^2 - 2hx - 4py + h^2 + 4pk = 0
            return new Curve(1,0,0,-2*h,-4*magnitude,h*h + 4 * magnitude * k);
        } else {
            //4p(x - h) = (y - k)^2
            //4px - 4ph = y^2 - 2ky + k^2
            //y^2 - 2ky + k^2 - 4px + 4ph = 0
            return new Curve(0,0,1,-4*magnitude,-2 * k,k*k + 4 * magnitude * h);
        }
    }

    public Object2D rotate(double degree) {
        Curve c = getCurve();
        return c.rotate(degree);
    }

    public Object2D shear(double degree) {
        Curve c = getCurve();
        return c.shear(degree);
    }

    public double[] getRoots(double single) {
        double[] roots = new double[2];
        if( openingVertical ) {
            roots[0] = -Math.sqrt(4 * magnitude * (single - k)) + h;
            roots[1] = Math.sqrt(4 * magnitude * (single - k)) + h;
        } else {
            roots[0] = -Math.sqrt(4 * magnitude * (single - h)) + k;
            roots[1] = Math.sqrt(4 * magnitude * (single - h)) + k;
        }
        return roots;
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
        double e;
        double f;
        double con;
        String ret = "";

        if( openingVertical ) {
            e = -2 * h;
            f = -4 * magnitude;
            con = h * h + 4 * magnitude * k;
            ret = "x<sup>2</sup>";
        } else {
            e = -4 * magnitude;
            f = -2 * k;
            con = k * k + 4 * magnitude * h;
            ret = "y<sup>2</sup>";
        }

        if( e != 0 ) {
            if( e == 1 ) {
                ret += " + x";
            } else if( e == -1 ) {
                ret += " - x";
            } else if( e < 0 ) {
                ret += " " + e + "x";
            } else {
                ret += " + " + e + "x";
            }
        }

        if( f != 0 ) {
            if( f == 1 ) {
                ret += " + y";
            } else if( f == -1 ) {
                ret += " - y";
            } else if( f < 0 ) {
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
