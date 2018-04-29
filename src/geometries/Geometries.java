package geometries;

import java.util.*;

import primitives.*;

public class Geometries extends Geometry {
	private List<Geometry> _geometries = new ArrayList<>();

	public Geometries() {
	}

	/**
	 * 
	 * @param g
	 * @throws Exception
	 */
	public Geometries(Geometries g) throws Exception {
		if (g == null) {
			throw new Exception("list can't be null");
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

}
