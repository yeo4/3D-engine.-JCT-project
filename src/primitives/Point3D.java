package primitives;

public class Point3D extends Point2D{
	
	private Coordinate _z;

	// ***************** Constructors ********************** // 
	
	public Point3D(Coordinate x, Coordinate y , Coordinate z) {
		super(x, y);
		_z = z;
	}
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
		return "(" +_x + ","+ _y+"," + _z + ")";
	}
	
	// ***************** Operations ******************** // 

	public Point3D add(Vector v) {
		Coordinate x = this._x.add(v.get()._x);
		Coordinate y = this._y.add(v.get()._y);
		Coordinate z = this._z.add(v.get()._z);
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
	
	private Point3D _subtract(Point3D P3D) {
		Coordinate x =this._x.subtract(P3D.getX());
		Coordinate y =this._y.subtract(P3D.getY());
		Coordinate z =this._z.subtract(P3D.getZ());
		return new Point3D(x,y,z);
	}

}
