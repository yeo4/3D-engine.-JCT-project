package primitives;

public class Ray {
	private Point3D _P3D;
	private Vector _direction;
	private double _t;
	
	// ***************** Constructors ********************** // 
	public Ray(Point3D P3D, Vector direction) {
		_P3D = new Point3D(P3D);
		_direction = new Vector(direction).normalization();
		_t = direction.length();
	}
	public Ray(Ray ray) {
		_P3D = new Point3D(ray.getP3D());
		_direction = new Vector(ray.getDirection());
		_t = ray._t;
	}
	// ***************** Getters/Setters ********************** //

	public Point3D getP3D() {
		return _P3D;
	}

	public Vector getDirection() {
		return _direction;
	}
	
	public double getT() {
		return _t;
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
		return "[Point=" + _P3D + ", Vector=" + _direction + "]";
	}
}
