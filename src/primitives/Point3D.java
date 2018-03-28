package primitives;

public class Point3D extends Point2D{
	
	private Coordinate _z;

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
	
	public Point3D(double x, double y, double z) {
		super(x, y);
		_z = new Coordinate(z);
	}

	public Point3D(Point3D other) {
		super(other);
		_z = new Coordinate(other._z);
	}
	public Point3D add(Vector v) {
		return null;
	}
	public double distance(Point3D P3D) {
		return 0;
	}
	public Vector subtract(Point3D P3D) {
		return null;
	}

	@Override
	public String toString() {
		return "[" + super.toString()+"_z=" + _z + "]";
	}

}
