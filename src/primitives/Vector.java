package primitives;

public class Vector {
	private Point3D _head;
	
	public Vector(Point3D head) {
		_head = head;
	}
	public Vector(Vector v) {
		_head = v.get();
	}
	
	public Vector add(Vector v) {
		double _x = v.get().getX().get() + (_head.getX().get());
		double _y = v.get().getY().get() +(_head.getY().get());
		double _z = v.get().getZ().get() + (_head.getZ().get());
		Point3D p = new Point3D(_x,_y,_z);
		return new Vector(p);
	}
	public Vector subtract(Vector v) {
		double _x = _head.getX().get() - v.get().getX().get();
		double _y =  _head.getY().get() - v.get().getY().get();
		double _z = _head.getZ().get() - v.get().getZ().get();
		Point3D p = new Point3D(_x,_y,_z);
		return new Vector(p);	
	}
	public Vector multiply(Vector v) {
		
		return null;
	}
	public Vector multiply(double d) {
		
		return null;
	}
	public double dot_product(Vector v) {
		return 0;
	}
	public double length() {
		return 0;
	}
	public Vector normalization() {
		return null;
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
