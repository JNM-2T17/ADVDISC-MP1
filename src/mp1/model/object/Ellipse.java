package mp1.model.object;

public class Ellipse implements AdvancedObject2D{
	
	private double centerX;
	private double centerY;
	private double horizDistance;
	private double vertDistance;


	public Ellipse(double x, double y, double horizDistance
					, double vertDistance) {

		centerX = x;
		centerY = y;
		this.horizDistance = horizDistance;
		this.vertDistance = vertDistance;
	}

	public Object2D translate(double x, double y){

		return new Ellipse(centerX + x, centerY + y
							, horizDistance, vertDistance);
	}

	public Object2D rotate(int x){
		
		



		return null;

	}

	public Object2D scale(double x){

		return new Ellipse(centerX, centerY
							, horizDistance * x, vertDistance * x);

	}

	public Object2D reflect(int x){

		return null;
	}

	public String toString() {
		return ("Center: (" + centerX + "," + centerY + ")\na = " 
				+ horizDistance + "\nb = " + vertDistance);
	}
} 