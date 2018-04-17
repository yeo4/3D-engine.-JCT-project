package geometries;

import primitives.*;

public class Plane extends Geometry {
	protected Point3D _p;
	protected Vector _normal;
	
	// ***************** Constructors ********************** //
	
	public Plane(Point3D _p, Vector _normal) throws Exception {
		if(_normal == Vector.ZeroVector)
			throw new Exception("Normal to plane must not be the a zero vector");
		this._p = new Point3D(_p);
		this._normal = new Vector(_normal);
	}

	public Plane(Plane p) {
		this._p = new Point3D(p._p);
		this._normal = new Vector(p._normal);
	}
	
	public Plane(Point3D _p1, Point3D _p2, Point3D _p3) throws Exception {
		if(Vector.areCollinear(new Vector(_p1), new Vector(_p2), new Vector(_p3)))
			throw new Exception("planes and triangles points must not be colliniar");
		this._p = _p1;
		this._normal = new Vector(_p1).calc_perpendicular(_p1, _p2, _p3).normalization();
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
	public boolean is_on_plane(Point3D p1) {
		if(Coordinate.ZERO.equals(new Coordinate(new Vector(p1.subtract(this._p)).dot_product(new Vector(this._p.add(_normal))))))
			return true;
		return false;
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
		//if(!this.is_on_plane(p))
		//	throw new Exception("Point must be on plane");
		return new Vector(p.add(this._normal)).normalization();
	}
}
