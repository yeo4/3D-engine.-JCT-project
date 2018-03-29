package geometries;

import primitives.*;

public class Sphere extends RadialGeometry {
	private Point3D _center;
	
	// ***************** Constructors ********************** // 
	
	public Sphere(double _r, Point3D _center) throws Exception {
		super(_r);
		this._center = _center;
	}
	
	public Sphere() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sphere(Sphere s) throws Exception {
		super(s._radius);
		this._center = s._center;
	}
	
	// ***************** Getters/Setters ********************** // 
	
	public Point3D get_center() {
		return _center;
	}

	/*public void set_center(Point3D _center) {
		this._center = _center;
	}*/

	// ***************** Administration ******************** //
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sphere other = (Sphere) obj;
		if (_center == null) {
			if (other._center != null)
				return false;
		} else if (!_center.equals(other._center))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Sphere [_center=" + _center + "]";
	}

	// ***************** Operations ******************** // 
	
	@Override
	public Vector GetNormal(Point3D p) {
		// TODO Auto-generated method stub
		return null;
	}


}
