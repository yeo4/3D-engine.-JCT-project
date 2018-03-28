package primitives;

public class Vector {
	private Point3D _head;
	
	public Vector(Point3D head) {
		_head = head;
	}
	public Vector(double x, double y, double z) {
		_head = new Point3D(x,y,z);
	}
	public Vector(Vector v) {
		_head = v.get();
	}
	public Vector add(Vector v) {
		return new Vector(_add(v));
	}
	private Point3D _add(Vector v) {
		double _x = v.get().getX().get() + (_head.getX().get());
		double _y = v.get().getY().get() +(_head.getY().get());
		double _z = v.get().getZ().get() + (_head.getZ().get());
		return new Point3D(_x,_y,_z);
	}
	public Vector subtract(Vector v) {
		return new Vector(_subtract(v));	
	}
	public Point3D _subtract(Vector v) {
		double _x = _head.getX().get() - v.get().getX().get();
		double _y =  _head.getY().get() - v.get().getY().get();
		double _z = _head.getZ().get() - v.get().getZ().get();
		return new Point3D(_x,_y,_z);
	}

	public Vector multiply(Vector v) {
		return new Vector(_multiply(v));	
	}
	private Point3D _multiply(Vector v) {
		double _x = (_head.getY().get() * v.get().getZ().get()) - (_head.getZ().get() * v.get().getY().get());
		double _y =  (_head.getZ().get() * v.get().getX().get()) - (_head.getX().get() * v.get().getZ().get());
		double _z = (_head.getX().get() * v.get().getY().get()) - (_head.getY().get() * v.get().getX().get());
		return new Point3D(_x,_y,_z);
	}

	public Vector multiply(double d) {
		return new Vector(_multiply(d));	
	}
	private Point3D _multiply(double d) {
		double _x = _head.getX().get() * d;
		double _y =  _head.getY().get() * d;
		double _z = _head.getZ().get() * d;
		return new Point3D(_x,_y,_z);
	}
	public double dot_product(Vector v) {
		double s = 0;
		s += _head.getX().get() * v.get().getX().get();
		s += _head.getY().get() * v.get().getY().get();
		s += _head.getZ().get() * v.get().getZ().get();
		//TODO: test
		return s;
	}
	public double length() {
		return Math.sqrt(Math.pow(_head.getX().get(), 2) + Math.pow(_head.getY().get(), 2) + Math.pow(_head.getZ().get(), 2));
	}
	public Vector normalization() {
		return new Vector(_normalization());	
	}
	private Point3D _normalization() {
		double len = length();
		double _x = _head.getX().get()/len;
		double _y = _head.getY().get()/len;
		double _z = _head.getZ().get()/len;
		return new Point3D(_x,_y,_z);
	}
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
	public Point3D get() {
		return _head;
	}
}
