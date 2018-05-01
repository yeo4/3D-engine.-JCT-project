package primitives;

public class Vector {
	// ***************** Varibles ********************** // 
	public final static Vector ZeroVector = new Vector(new Point3D(0,0,0));
	//public static boolean 
	private Point3D _head;
	
	// ***************** Constructors ********************** // 
	public Vector(Point3D head) {
		_head = new Point3D(head);
	}
	
	public Vector(double x, double y, double z) {
		_head = new Point3D(x,y,z);
	}
	
	public Vector(Vector v) {
		_head = new Point3D(v.get());
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
		return "[ " +_head.toString() + " ]";
	}
	
	// ***************** Operations ******************** // 
	
	public static Vector calc_perpendicular(Point3D _p1, Point3D _p2, Point3D _p3) {
		return new Vector(_p2.subtract(_p1)).cross_product(new Vector(_p3.subtract(_p1))).normalization();
	}
	public Vector add(Vector v) {
		Coordinate _x = v.get().getX().add(_head.getX());
		Coordinate _y = v.get().getY().add(_head.getY());
		Coordinate _z = v.get().getZ().add(_head.getZ());
		return new Vector(new Point3D(_x,_y,_z));
	}	
	public Vector subtract(Vector v) {
		Coordinate _x = _head.getX().subtract(v.get().getX());
		Coordinate _y =  _head.getY().subtract(v.get().getY());
		Coordinate _z = _head.getZ().subtract(v.get().getZ());
		return new Vector(new Point3D(_x,_y,_z));	
	}	
	public Vector cross_product(Vector v) {
		Coordinate _x = (_head.getY().multiply(v.get().getZ()).subtract(_head.getZ().multiply(v.get().getY())));
		Coordinate _y =  (_head.getZ().multiply(v.get().getX())).subtract(_head.getX().multiply(v.get().getZ()));
		Coordinate _z = (_head.getX().multiply(v.get().getY())).subtract(_head.getY().multiply(v.get().getX()));
		return new Vector(new Point3D(_x,_y,_z));	
	}
	public Vector multiply(double d) {
		Coordinate _x = _head.getX().scale(d);
		Coordinate _y = _head.getY().scale(d);
		Coordinate _z = _head.getZ().scale(d);
		return new Vector(new Point3D(_x,_y,_z));	
	}
	public double dot_product(Vector v) {
		double s = _head.getX().multiply(v.get().getX()).get();
		s += _head.getY().multiply(v.get().getY()).get();
		s += _head.getZ().multiply(v.get().getZ()).get();
		return s;
	}
	public double length() {
		return Math.sqrt(_head.getX().get()*_head.getX().get() + _head.getY().get()*_head.getY().get() + _head.getZ().get()*_head.getZ().get());
	}
	public Vector normalization() {
		double len = length();
		if(len <= 0) {
			throw new IllegalArgumentException("len of this vector must be more then 0");
		}
		
		double _x = _head.getX().get()/len;
		double _y = _head.getY().get()/len;
		double _z = _head.getZ().get()/len;
		return new Vector(new Point3D(_x,_y,_z));	
	}
	
	public static boolean areCollinear(Vector v1,Vector v2,Vector v3) {
		return (v2.subtract(v1)).cross_product(v3.subtract(v1)).equals(Vector.ZeroVector);
	}
	
	// ***************** Helpers ******************** // 

}
