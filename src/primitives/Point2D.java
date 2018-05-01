package primitives;

public class Point2D {
	protected Coordinate _x;
	protected Coordinate _y;

	// ***************** Constructors ********************** //
	
	/**
	 * Constructors with 2 doubles
	 * @param x
	 * @param y
	 */
	public Point2D(double x, double y) {
		_x = new Coordinate(x);
		_y = new Coordinate(y);
	}
	/**
	 * Constructors with 2 Coordinate
	 * @param x
	 * @param y
	 */
	public Point2D(Coordinate x, Coordinate y) {
		_x = new Coordinate(x);
		_y = new Coordinate(y);
	}
	/**
	 * copy Constructors  
	 * @param Point2D other
	 */
	public Point2D(Point2D other) {
		_x = new Coordinate(other._x);
		_y = new Coordinate(other._y);
	}
	
	// ***************** Getters/Setters ********************** //
	
	/**
	 * get the X value 
	 * @return Coordinate
	 */
	public Coordinate getX() {
		return _x;
	}
	/**
	 * get the Y value 
	 * @return Coordinate
	 */
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
		return "(" + _x + "," + _y + ")";
	}

	// ***************** Operations ******************** // 
	/**
	 * Calculate the distance between 2 Points2D
	 * @param P2D
	 * @return
	 */
	public double distance(Point2D P2D) {
		double dx = _x.get()-P2D.getX().get();
		double dy = _y.get()-P2D.getY().get();
		return Math.sqrt(dx*dx + dy*dy);
	}
}
