package mp1.model.object;

public class Point implements Object2D {
	
	private double x;
	private double y;

	public Point(double x, double y){

		this.x = x;
<<<<<<< HEAD
		this.y = y;
=======
		this y = y;
>>>>>>> origin/master
	}

	public Object2D translate(double x, double y){

<<<<<<< HEAD
		return new Point(this.x + x, this.y + y);
=======
		return new Point(this.x + x, this.y + y)
>>>>>>> origin/master
	}
}