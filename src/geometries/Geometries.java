package geometries;

import java.util.*;

import primitives.*;
import primitives.Vector;

public class Geometries extends Geometry {
	private List<Geometry> _geometries = new ArrayList<>();

	public Geometries() {
	}

	/**
	 * 
	 * @param g
	 * @throws Exception
	 */
	public Geometries(Geometries g) throws NullPointerException {
		if (g == null) {
			throw new NullPointerException("list can't be null");
		} else {
			this._geometries = g._geometries;
		}
	}

	public List<Point3D> findIntersections(Ray r) {
		List<Point3D> _intersections = new ArrayList<>();
		for (int i = 0; i < _geometries.size(); i++) {
			_intersections.addAll(_geometries.get(i).findIntersections(r));
		}
		return _intersections;
	}

	public boolean add(Geometry e) {
		return _geometries.add(e);
	}

	public String toString() {
		return _geometries.toString();
	}

	@Override
	public Vector getNormal(Point3D p) {
		// TODO Auto-generated method stub
		return null;
	}

}
