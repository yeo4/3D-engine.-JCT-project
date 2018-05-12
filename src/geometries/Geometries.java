package geometries;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

import primitives.*;
import primitives.Vector;

public class Geometries extends Geometry {
	private List<Geometry> _geometries;

	public Geometries() {
		_geometries = new ArrayList<>();
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
	
	
	public Map<Geometry,List<Point3D>> findIntersections(Ray r) {
		//_intersections = new CopyOnWriteArrayList<>();
		
		Map<Geometry,List<Point3D>> intersectionPoints = new HashMap<Geometry,List<Point3D>>();
		
		for (Geometry geometry : _geometries) {
			Map<Geometry, List<Point3D>> geometryIntersectionPoints = new HashMap<Geometry,List<Point3D>>(geometry.findIntersections(r));
			
			geometryIntersectionPoints.forEach((g,list) -> {
				if(list.size() > 0)
					intersectionPoints.put(g, list);
			});
		}
		return intersectionPoints;
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
