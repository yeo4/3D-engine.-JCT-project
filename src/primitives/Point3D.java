package primitives;

public class Point3D extends Point2D{
	
	private Coordinate _z;

	// ***************** Constructors ********************** // 

	public Point3D(double x, double y, double z) {
		super(x, y);
		_z = new Coordinate(z);
	}
	public Point3D(Point3D other) {
		super(other);
		_z = new Coordinate(other._z);
	}
	
	// ***************** Getters/Setters ********************** //
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
		return "[" + super.toString()+"_z=" + _z + "]";
	}
	
	// ***************** Operations ******************** // 

	public Point3D add(Vector v) {
		double x =this._x.get() + v.get()._x.get();
		double y =this._y.get() + v.get()._y.get();
		double z =this._z.get() + v.get()._z.get();
		return new Point3D(x,y,z);
	}
	public Vector subtract(Point3D P3D) {
		Vector v = new Vector(_subtract(P3D));
		return v;
	}
	public double distance(Point3D P3D) {
		return Math.sqrt(Math.pow((_x.get()-P3D.getX().get()),2) + Math.pow((_y.get()-P3D.getY().get()),2) + Math.pow((_z.get()-P3D.getZ().get()),2));
	}
	
	// ***************** Helpers ******************** // 	
	
	public Point3D _subtract(Point3D P3D) {
		double x =this._x.get() - P3D.getX().get();
		double y =this._y.get() - P3D.getY().get();
		double z =this._z.get() - P3D.getZ().get();
		return new Point3D(x,y,z);
	}

}
