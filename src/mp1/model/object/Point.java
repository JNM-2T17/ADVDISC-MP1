package mp1.model.object;

public class Point implements Object2D {
	
	private double x;
	private double y;

	public Point(double x, double y){

		this.x = x;
		this.y = y;
	}

	public Object2D translate(double x, double y){

		return new Point(this.x + x, this.y + y);
	}
}