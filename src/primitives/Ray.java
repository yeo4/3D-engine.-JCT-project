package primitives;

public class Ray {
	private Point3D _P3D;
	private Vector _direction;
	
	public Point3D get_P3D() {
		return _P3D;
	}

	public Vector get_direction() {
		return _direction;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ray other = (Ray) obj;
		if (_P3D == null) {
			if (other._P3D != null)
				return false;
		} else if (!_P3D.equals(other._P3D))
			return false;
		if (_direction == null) {
			if (other._direction != null)
				return false;
		} else if (!_direction.equals(other._direction))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[_P3D=" + _P3D + ", _direction=" + _direction + "]";
	}
}
