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
	
	
	List<Point3D> _intersections = null;
	int i;
	public List<Point3D> findIntersections(Ray r) {
		//_intersections = new CopyOnWriteArrayList<>();
		_intersections = new ArrayList<>();
		 
		for (int i = 0; i < _geometries.size(); i++) {
			_intersections.addAll(_geometries.get(i).findIntersections(r));
		}
		//*/
		
		/*_intersections = new ArrayList<>();
		int size = _geometries.size();
		if(size > 0) {
			_intersections.addAll(_geometries.get(0).findIntersections(r));
		}

		
		for (i = 1; i < size ; i++) {
			new Thread()
			{
			    public void run() {
					_intersections.addAll(_geometries.get(i).findIntersections(r));
			    }
			}.start();
		}
		//*/
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
