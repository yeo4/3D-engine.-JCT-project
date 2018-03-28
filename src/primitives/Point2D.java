package primitives;

public class Point2D {
	protected Coordinate _x;
	protected Coordinate _y;

	// ***************** Constructors ********************** //
	
	public Point2D(double x, double y) {
		_x = new Coordinate(x);
		_y = new Coordinate(y);
	}
	public Point2D(Coordinate x, Coordinate y) {
		_x = x;
		_y = y;
	}
	
	public Point2D(Point2D other) {
		_x = new Coordinate(other._x);
		_y = new Coordinate(other._y);
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Coordinate getX() {
		return _x;
	}
	
	public Coordinate getY() {
		return _y;
	}
	
	// ***************** Administration  ******************** //

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point2D other = (Point2D) obj;
		if (_x == null) {
			if (other._x != null)
				return false;
		} else if (!_x.equals(other._x))
			return false;
		if (_y == null) {
			if (other._y != null)
				return false;
		} else if (!_y.equals(other._y))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[" + _x + "," + _y + "]";
	}

	// ***************** Operations ******************** // 
	public double distance(Point2D P2D) {
		return Math.sqrt(Math.pow((_x.get()-P2D.getX().get()),2) + Math.pow((_y.get()-P2D.getY().get()),2));
	}
}
