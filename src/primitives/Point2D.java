package primitives;

public class Point2D {
	protected Coordinate _x;
	protected Coordinate _y;
	
	public Point2D(double x, double y) {
		_x = new Coordinate(x);
		_y = new Coordinate(y);
	}
	
	public Point2D(Point2D other) {
		_x = new Coordinate(other._x);
		_y = new Coordinate(other._y);
	}
	
	public Coordinate getX() {
		return _x;
	}
	
	public Coordinate getY() {
		return _y;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Point2D))
			return false;
		Point2D oth = (Point2D)obj;
		return _x.equals(oth._x) && _y.equals(oth._y);
	}

	@Override
	public String toString() {
		return "[" + _x + "," + _y + "]";
	}
	public double distance(Point2D P2D) {
		return 0;
	}
}
