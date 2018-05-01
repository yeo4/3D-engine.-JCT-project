package primitives;

public class Point3D extends Point2D {
	
	private Coordinate _z;

	// ***************** Constructors ********************** // 
	
	/**
	 * Constructors with 3 Coordinate
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(Coordinate x, Coordinate y , Coordinate z) {
		super(x, y);
		_z = new Coordinate(z);
	}
	/**
	 * Constructors with 3 doubles
	 * @param x
	 * @param y
	 * @param z
	 */
	public Point3D(double x, double y, double z) {
		super(x, y);
		_z = new Coordinate(z);
	}
	/**
	 * copy Constructors
	 * @param other
	 */
	public Point3D(Point3D other) {
		super(other);
		_z = new Coordinate(other._z);
	}

	
	// ***************** Getters/Setters ********************** //
	/**
	 * get the Z value 
	 * @return Coordinate
	 */	
	public Coordinate getZ() {
		return _z;
	}

	// ***************** Administration  ******************** //
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point3D other = (Point3D) obj;
		if (_z == null) {
			if (other._z != null)
				return false;
		} else if (!_z.equals(other._z))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "(" +_x + ","+ _y+"," + _z + ")";
	}
	
	// ***************** Operations ******************** // 
	/**
	 * return new point + vector param
	 * @param vector
	 * @return new Point3D
	 */
	public Point3D add(Vector v) {
		Coordinate x = this._x.add(v.get()._x);
		Coordinate y = this._y.add(v.get()._y);
		Coordinate z = this._z.add(v.get()._z);
		return new Point3D(x,y,z);
	}
	/**
	 * return new point - points param
	 * @param vector
	 * @return new Vector
	 */
	public Vector subtract(Point3D P3D) {
		Coordinate x =this._x.subtract(P3D.getX());
		Coordinate y =this._y.subtract(P3D.getY());
		Coordinate z =this._z.subtract(P3D.getZ());
		return new Vector(new Point3D(x,y,z));
	}
	/**
	 * return distance between 2 points
	 * @param vector
	 * @return new Point3D
	 */
	
	public double distance(Point3D P3D) {
		double dx = _x.get()-P3D.getX().get();
		double dy = _y.get()-P3D.getY().get();
		double dz = _z.get()-P3D.getZ().get();
		return Math.sqrt(dx*dx + dy*dy + dz*dz);
	}
	
	/**
	 * return distance Square between 2 points
	 * @param vector
	 * @return new Point3D
	 */
	
	public double distanceSquare(Point3D P3D) {
		double dx = _x.get()-P3D.getX().get();
		double dy = _y.get()-P3D.getY().get();
		double dz = _z.get()-P3D.getZ().get();
		return dx*dx + dy*dy + dz*dz;
	}
	
	// ***************** Helpers ******************** // 	
	


}
