package geometries;

import primitives.*;

public class Plane extends Geometry {
	private Point3D _p;
	private Vector _normal;
	
	// ***************** Constructors ********************** //
	
	public Plane(Point3D _p, Vector _normal) throws Exception {
		if(_normal == Vector.ZeroVector)
			throw new Exception("Normal to plane must not be the a zero vector");
		this._p = _p;
		this._normal = _normal;
	}

	public Plane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plane(Plane p) {
		this._p = p._p;
		this._normal = p._normal;
	}


	
	// ***************** Getters/Setters ********************** //

	public Point3D get_p() {
		return _p;
	}

	/*public void set_p(Point3D _p) {
		this._p = _p;
	}*/

	public Vector get_normal() {
		return _normal;
	}

	/*public void set_normal(Vector _normal) {
		this._normal = _normal;
	}*/
	
	// ***************** Administration  ******************** // 
	
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Plane other = (Plane) obj;
			if (_normal == null) {
				if (other._normal != null)
					return false;
			} else if (!_normal.equals(other._normal))
				return false;
			if (_p == null) {
				if (other._p != null)
					return false;
			} else if (!_p.equals(other._p))
				return false;
			return true;
		}
	
	@Override
		public String toString() {
			return "Plane [_p=" + _p + ", _normal=" + _normal + "]";
		}

	// ***************** Operations ******************** //
	
	@Override
	public Vector GetNormal(Point3D p) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
