package geometries;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import primitives.*;

public class Plane extends Geometry {
	protected Point3D _p;
	protected Vector _normal;

	// ***************** Constructors ********************** //

	/**
	 * 
	 * @param _p
	 * @param _normal
	 * @param emission
	 * @param material
	 */
	public Plane(Point3D _p, Vector _normal, Color emission, Material material) {
		if (_normal.equals(Vector.ZeroVector))
			throw new IllegalArgumentException("Normal to plane must not be the a zero vector");
		this._p = new Point3D(_p);
		this._normal = new Vector(_normal).normalization();
		this._emission = new Color(emission);
		this._material = new Material(material);

	}

	/**
	 * 
	 * @param p
	 */
	public Plane(Plane p) {
		this._p = new Point3D(p._p);
		this._normal = new Vector(p._normal);
		this._emission = new Color(p._emission);
		this._material = new Material(p._material);

	}

	/**
	 * 
	 * @param _p1
	 * @param _p2
	 * @param _p3
	 * @param emission
	 * @param material
	 */
	public Plane(Point3D _p1, Point3D _p2, Point3D _p3, Color emission, Material material) {
		Vector v = Vector.calc_perpendicular(_p1, _p2, _p3).normalization();
		if (v.equals(Vector.ZeroVector))
			throw new IllegalArgumentException("planes and triangles points must not be colliniar");
		this._p = new Point3D(_p1);
		this._normal = new Vector(v);
		this._emission = new Color(emission);
		this._material = new Material(material);

	}

	// ***************** Getters/Setters ********************** //

	public Point3D get_p() {
		return _p;
	}

	/*
	 * public void set_p(Point3D _p) { this._p = _p; }
	 */

	public Vector get_normal() {
		return _normal;
	}

	/*
	 * public void set_normal(Vector _normal) { this._normal = _normal; }
	 */

	/**
	 * checks if given point is in plane
	 * @param p1
	 * @return boolean
	 */
	public boolean is_on_plane(Point3D p1) {
		if (Coordinate.isToCloseToZero(new Vector(p1.subtract(this._p)).dot_product(_normal)))
			return true;
		return false;
	}
	// ***************** Administration ******************** //

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
		// if(!this.is_on_plane(p))
		// throw new Exception("Point must be on plane");
		return new Vector(this._normal);
	}

	@Override
	public Map<Geometry, List<Point3D>> findIntersections(Ray r) {
		Map<Geometry, List<Point3D>> intersections = new HashMap<Geometry, List<Point3D>>();
		ArrayList<Point3D> arrPoints = new ArrayList<>();

		double mechane = (this._normal.dot_product(r.getDirection()));

		if (Coordinate.isToCloseToZero(mechane)) // Dan said to check but maybe unnecessary???
			return intersections;

		double mone = this._normal.dot_product(this._p.subtract(r.getP3D()));
		double t = mone / mechane;

		if (t <= 0 || Coordinate.isToCloseToZero(t))
			return intersections;

		arrPoints.add(r.getP3D().add(r.getDirection().multiply(t)));

		if (arrPoints.size() != 0)
			intersections.put(this, arrPoints);

		return intersections;

	}
}
