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
		return null;
	}
	public Vector subtract(Vector v) {
		return null;
	}
	public Vector multiply(Vector v) {
		return null;
	}
	public Vector multiply(double d) {
		return null;
	}
	public Vector dot_product(Vector v) {
		return null;
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
