package mp1.model.object;

public class Ellipse implements DoubleRotateObject2D, AdvancedObject2D{
	
	private double centerX;
	private double centerY;
	private double horizDistance;
	private double vertDistance;


	public Point(double x, double y){

		centerX = x;
		centerY = y;
	}

	public Object2D translate(double x, double y){

		return new Ellipse(centerX + x, CenterY + y);
	}

	public Object2D rotate(int x){
		
		

	}

	public Object2D scale(double x){


	}

	public Object2D reflect(int x){


	}
}