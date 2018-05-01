package geometries;

import java.util.ArrayList;

import primitives.*;

public class Plane extends Geometry {
	protected Point3D _p;
	protected Vector _normal;
	
	// ***************** Constructors ********************** //
	
	public Plane(Point3D _p, Vector _normal) throws IllegalArgumentException {
		if(_normal.equals(Vector.ZeroVector))
			throw new IllegalArgumentException("Normal to plane must not be the a zero vector");
		this._p = new Point3D(_p);
		this._normal = new Vector(_normal).normalization();
	}

	public Plane(Plane p) {
		this._p = new Point3D(p._p);
		this._normal = new Vector(p._normal);
	}
	
	public Plane(Point3D _p1, Point3D _p2, Point3D _p3) throws IllegalArgumentException {
		
		Vector v = Vector.calc_perpendicular(_p1, _p2, _p3).normalization();
		if(v.equals(Vector.ZeroVector))
			throw new IllegalArgumentException("planes and triangles points must not be colliniar");
		this._p = new Point3D(_p1);
		this._normal = new Vector(v);
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
		if(Coordinate.ZERO.equals(new Coordinate(new Vector(p1.subtract(this._p)).dot_product(_normal))))
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
	public Vector getNormal(Point3D p) {
		//if(!this.is_on_plane(p))
		//	throw new Exception("Point must be on plane");
		return new Vector(this._normal);
	}

	@Override
	public ArrayList<Point3D> findIntersections(Ray r) {
		
		ArrayList<Point3D> arrPoints = new ArrayList<>();
		
		
		double mechane = (this._normal.dot_product(r.getDirection()));
		
		if(Coordinate.ZERO.equals(mechane))
			return arrPoints;
		
		double mone = this._normal.dot_product(this._p.subtract(r.getP3D()));
		double t = mone/mechane;
		
		if(t <= 0)
			return arrPoints;
		
		arrPoints.add(r.getP3D().add(r.getDirection().multiply(t)));
		return arrPoints;
	}
}
