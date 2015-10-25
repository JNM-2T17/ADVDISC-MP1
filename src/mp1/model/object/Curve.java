package mp1.model.object;

public class Curve implements AdvancedObject2D
								,ShearObject2D
								,DoubleRotateObject2D {
	private double x2;
	private double xy;
	private double y2;
	private double x;
	private double y;
	private double constant; 

	public Curve( double x2,double xy,double y2,double x,double y
					,double constant) {
		this.x2 = Math.abs(x2) < 0.0001 ? 0 : x2;
		this.xy = Math.abs(xy) < 0.0001 ? 0 : xy;
		this.y2 = Math.abs(y2) < 0.0001 ? 0 : y2;
		this.x = Math.abs(x) < 0.0001 ? 0 : x;
		this.y = Math.abs(y) < 0.0001 ? 0 : y;
		this.constant = Math.abs(constant) < 0.0001 ? 0 : constant;
	}

	public double[] getInterval(double axis) {
		if( y2 == 0 ) {
			//y = (-ax^2 - ex - h)/(bx+f)
			return new double[]{-axis,-y/xy,axis};
		} else {
			//cy^2 + (bx + f)y + ax^2 + ex + h = 0 
			//y = (-(bx + f) +- sqrt((b^2 - 4ac)x^2 + 2(bf - 2ce)x + f^2 - 4ch))/2c
			double linear = -xy/2/y2;
			double verticalShift = -y/2/y2;
			double divisor = 2 * y2;
			double innerX2 = xy * xy - 4 * x2 * y2;
			double innerX = 2 * (xy * y - 2 * y2 * x);
			double innerConst = y * y - 4 * y2 * constant;
			
			//a(x^2 + bx/a + b^2/4a^2) + c - b^2/4a
			//a(x + b/2a)^2 + c - b^2/4a
			double xMult = innerX2;
			double xShift = -innerX/2/innerX2;
			double innerShift = innerConst - innerX * innerX / 4 / innerX2;

			if( innerX2 == 0 ) {
				//x > -innerConst/innerX
				if( innerX > 0 ) {
					return new double[]{-innerConst / innerX,axis};
				} else {
					return new double[]{-axis,-innerConst/innerX};
				}
			} else {
				//y = linear(x) + verticalShift(x) +- sqrt(xMult(x-xShift)^2
				//		+innerShift)/divisor
				//xMult(x-xShift)^2 >= -innerShift
				// System.out.println(innerX2 + "x^2 + " + innerX + "x + " + innerConst);
				// System.out.println(xMult + "(x - " + xShift + ") + " + innerShift);
				if( xMult > 0 ) {
					//(x-xShift)^2 >= -innerShift/xMult
					return new double[]{-axis,-Math.sqrt(-innerShift/xMult) 
										+ xShift,Math.sqrt(-innerShift/xMult) 
										+ xShift,axis};
				} else {
					//(x-xShift)^2 <= -innerShift/xMult
					return new double[]{-Math.sqrt(-innerShift/xMult) + xShift
										,Math.sqrt(-innerShift/xMult) + xShift};
				}
			}
		}
	}

	public double[] getValue(double arg) {
		if( y2 == 0 ) {
			//y = (-ax^2 - ex - h)/(bx + f)
			return new double[]{(-x2 * arg * arg - x * arg - constant)
								/(xy * arg + y)};
		} else {
			//cy^2 + (bx + f)y + ax^2 + ex + h = 0 
			//y = (-(bx + f) +- sqrt((b^2 - 4ac)x^2 + 2(bf - 2ce)x + f^2 - 4ch))/2c
			double linear = -xy/2/y2;
			double verticalShift = -y/2/y2;
			double divisor = 2 * y2;
			double innerX2 = xy * xy - 4 * x2 * y2;
			double innerX = 2 * (xy * y - 2 * y2 * x);
			double innerConst = y * y - 4 * y2 * constant;
			
			double linearValue = linear * arg;
			double sqrt = 0;
			if( innerX2 == 0 ) {
				sqrt = Math.sqrt(innerX * arg + innerConst)/divisor;
			} else {

				//a(x^2 + bx/a + b^2/4a^2) + c - b^2/4a
				//a(x + b/2a)^2 + c - b^2/4a
				double xMult = innerX2;
				double xShift = -innerX/2/innerX2;
				double innerShift = innerConst - innerX * innerX / 4 / innerX2;
				double radicand = xMult*(arg - xShift)*(arg - xShift) 
										+ innerShift;
				if( Math.abs(radicand) < 0.0001 ) {
					radicand = 0;
				}

				sqrt = Math.sqrt(radicand)/divisor;
			}
			return new double[] { linearValue + verticalShift - sqrt
										,linearValue + verticalShift + sqrt};
		}
	}

	private double[][] matrixMultiply(double[][] a, double[][] b) 
		throws IllegalArgumentException {
		if(a[0].length != b.length) {
			throw new IllegalArgumentException("Matrices can't be multiplied");
		} else {
			double[][] result = new double[a.length][b[0].length];
			for( int i = 0; i < result.length; i++ ) {
				for( int j = 0; j < result[0].length; j++ ) {
					result[i][j] = 0;
					for( int k = 0; k < b.length; k++ ) {
						result[i][j] += a[i][k] * b[k][j];
					}
				}
			}

			return result;
		}
	}

	public Object2D translate(double x, double w){
		return null;
	}

	// Need to double check
	public Object2D rotate(double degree){
		double rads = Math.toRadians(degree);
		double cos = Math.cos(rads);
		double sin = Math.sin(rads);
		double[][] c = new double[][]{{x2,xy/2},{xy/2,y2}};
		double[][] g = new double[][]{{x,y}};
		double[][] p = new double[][]{{cos,sin},{-sin,cos}};
		double[][] pInv = new double[][]{{cos,-sin},{sin,cos}};
		double[][] cPrime = matrixMultiply(pInv,matrixMultiply(c,p));
		double[][] gPrime = matrixMultiply(g,p);

		Curve curve = new Curve(cPrime[0][0],cPrime[0][1] + cPrime[1][0],cPrime[1][1]
							,gPrime[0][0],gPrime[0][1],constant);
		return curve;
	}

	public Object2D rotate(int degree){
		double deg;
		switch(degree) {
			case AdvancedObject2D.ROTATE_LEFT_90:	
				deg = 90;
				break;
			case AdvancedObject2D.ROTATE_180:
				deg = 180;
				break;
			case AdvancedObject2D.ROTATE_RIGHT_90:
				deg = -90;
				break;
			default:
				deg = 0;
		}

		return rotate(deg);
	}

	public Object2D scale(double dd){
		return null;
	}

	public Object2D reflect(int cas){
		double iX;
		double iY;
		switch(cas) {
			case AdvancedObject2D.REFLECT_X_AXIS:
				iX = 1;
				iY = 0;
				break;
			case AdvancedObject2D.REFLECT_Y_AXIS:
				iX = 0;
				iY = 1;
				break;
			default:
				iX = 0;
				iY = 0;
		}
		double[][] c = new double[][]{{x2,xy/2},{xy/2,y2}};
		double[][] g = new double[][]{{x,y}};
		double[][] p = new double[][]{{iX*iX - iY*iY,iX*iY}
										,{iX*iY,iY*iY-iX*iX}};
		double[][] pInv = new double[][]{{iX*iX - iY*iY,iX*iY}
										,{iX*iY,iY*iY-iX*iX}};;
		double[][] cPrime = matrixMultiply(pInv,matrixMultiply(c,p));
		double[][] gPrime = matrixMultiply(g,p);

		Curve curve = new Curve(cPrime[0][0],cPrime[0][1] + cPrime[1][0],cPrime[1][1]
							,gPrime[0][0],gPrime[0][1],constant);
		return curve;
	}

	public Object2D shear(double degree){
		double rads = Math.toRadians(degree);
		double tan = Math.tan(rads);
		double[][] c = new double[][]{{x2,xy/2},{xy/2,y2}};
		double[][] g = new double[][]{{x,y}};
		double[][] p = new double[][]{{1,tan},{0,1}};
		double[][] pInv = new double[][]{{1,-tan},{0,1}};
		double[][] cPrime = matrixMultiply(pInv,matrixMultiply(c,p));
		double[][] gPrime = matrixMultiply(g,p);

		Curve curve = new Curve(cPrime[0][0],cPrime[0][1] + cPrime[1][0],cPrime[1][1]
							,gPrime[0][0],gPrime[0][1],constant);
		return curve;
	}

	public String toString() {
		String ret = "";

		if( x2 != 0 ) {
			if( x2 == 1 ) {
				ret += "x<sup>2</sup>";
			} else if(x2 == -1) {
				ret += "-x<sup>2</sup>";
			} else {
				ret += x2 + "x<sup>2</sup>";
			}
		}

		if( xy != 0 ) {
			if( xy == 1 ) {
				ret += " + xy";
			} else if(xy == -1) {
				ret += "-xy";
			} else if( xy > 0 ){
				ret += " + " + xy + "xy";
			} else {
				ret += " " + xy + "xy";
			}
		}

		if( y2 != 0 ) {
			if( y2 == 1 ) {
				ret += " + y<sup>2</sup>";
			} else if(y2 == -1) {
				ret += "-y<sup>2</sup>";
			} else if( y2 > 0 ){
				ret += " + " + y2 + "y<sup>2</sup>";
			} else {
				ret += " " + y2 + "y<sup>2</sup>";
			}
		}

		if( x != 0 ) {
			if( x == 1 ) {
				ret += " + x";
			} else if(x == -1) {
				ret += "-x";
			} else if( x > 0 ){
				ret += " + " + x + "x";
			} else {
				ret += " " + x + "x";
			}
		}

		if( y != 0 ) {
			if( y == 1 ) {
				ret += " + y";
			} else if(y == -1) {
				ret += "-y";
			} else if( y > 0 ){
				ret += " + " + y + "y";
			} else {
				ret += " " + y + "y";
			}
		}

		if( constant != 0 ) {
			if( constant > 0 ){
				ret += " + " + constant;
			} else {
				ret += " " + constant;
			}
		}

		return ret + (ret.length() == 0 ? "0" : "") + " = 0";
	}
}