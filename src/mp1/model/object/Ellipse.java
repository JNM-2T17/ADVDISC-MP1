package mp1.model.object;

public class Ellipse implements AdvancedObject2D{
	
	private double centerX;
	private double centerY;
	private double horizDistance;
	private double vertDistance;


	public Ellipse(double x, double y){

		centerX = x;
		centerY = y;
	}

	public Object2D translate(double x, double y){

		return new Ellipse(centerX + x, centerY + y);
	}

	public Object2D rotate(int x){
		
		return null;

	}

	public Object2D scale(double x){
		return null;

	}

	public Object2D reflect(int x){

		return null;
	}
}