package primitives;

public class Vector {
	private Point3D _head;
	
	// ***************** Constructors ********************** // 
	public Vector(Point3D head) {
		_head = head;
	}
	
	/*public Vector(double x, double y, double z) {
		_head = new Point3D(x,y,z);
	}*/
	
	public Vector(Vector v) {
		_head = v.get();
	}
	// ***************** Getters/Setters ********************** //
	public Point3D get() {
		return _head;
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
		Vector other = (Vector) obj;
		if (_head == null) {
			if (other._head != null)
				return false;
		} else if (!_head.equals(other._head))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "[_head=" + _head + "]";
	}
	
	// ***************** Operations ******************** // 

	public Vector add(Vector v) {
		return new Vector(_add(v));
	}	
	public Vector subtract(Vector v) {
		return new Vector(_subtract(v));	
	}	
	public Vector multiply(Vector v) {
		return new Vector(_multiply(v));	
	}
	public Vector multiply(double d) {
		return new Vector(_multiply(d));	
	}
	public double dot_product(Vector v) {
		double s = _head.getX().multiply(v.get().getX()).get();
		s += _head.getY().multiply(v.get().getY()).get();
		s += _head.getZ().multiply(v.get().getZ()).get();
		//TODO: test
		return s;
	}
	public double length() {
		return Math.sqrt(Math.pow(_head.getX().get(), 2) + Math.pow(_head.getY().get(), 2) + Math.pow(_head.getZ().get(), 2));
	}
	public Vector normalization() {
		return new Vector(_normalization());	
	}
	
	// ***************** Helpers ******************** // 

	private Point3D _add(Vector v) {
		Coordinate _x = v.get().getX().add(_head.getX());
		Coordinate _y = v.get().getY().add(_head.getY());
		Coordinate _z = v.get().getZ().add(_head.getZ());
		return new Point3D(_x,_y,_z);
	}

	public Point3D _subtract(Vector v) {
		Coordinate _x = _head.getX().subtract(v.get().getX());
		Coordinate _y =  _head.getY().subtract(v.get().getY());
		Coordinate _z = _head.getZ().subtract(v.get().getZ());
		return new Point3D(_x,_y,_z);
	}

	private Point3D _multiply(Vector v) {
		Coordinate _x = (_head.getY().multiply(v.get().getZ()).subtract(_head.getZ().multiply(v.get().getY())));
		Coordinate _y =  (_head.getZ().multiply(v.get().getX())).subtract(_head.getX().multiply(v.get().getZ()));
		Coordinate _z = (_head.getX().multiply(v.get().getY())).subtract(_head.getY().multiply(v.get().getX()));
		return new Point3D(_x,_y,_z);
	}

	private Point3D _multiply(double d) {
		Coordinate _x = _head.getX().scale(d);
		Coordinate _y = _head.getY().scale(d);
		Coordinate _z = _head.getZ().scale(d);
		return new Point3D(_x,_y,_z);
	}

	private Point3D _normalization() {
		double len = length();
		double _x = _head.getX().get()/len;
		double _y = _head.getY().get()/len;
		double _z = _head.getZ().get()/len;
		return new Point3D(_x,_y,_z);
	}
}
