package geometries;

import java.util.*;

public class Geometries {
	private ArrayList<Geometry> _geometries;
	
	public Geometries(){
		_geometries = new ArrayList<>();
	}
	public Geometries(Geometries g) throws Exception{
		if(g == null){
			throw new Exception("list can't be null");
		}else{
			this._geometries = g._geometries;
		}
	}
	
	/*public ArrayList<Point3D> findIntersections(Ray r){
		ArrayList<Point3D> _intersections = new ArrayList<>();
		for(int i = 0; i<_geometries.size();i++){
			_intersections.addAll(_geometries.get(i).findIntersections(r));
		}
		return _intersections;
	}*/
	
	public boolean add(Geometry e) {
		return _geometries.add(e);
	}
	public void clear() {
		_geometries.clear();
	}
	public Geometry get(int index) {
		return _geometries.get(index);
	}
	public int indexOf(Object o) {
		return _geometries.indexOf(o);
	}
	public boolean isEmpty() {
		return _geometries.isEmpty();
	}
	public Geometry remove(int index) {
		return _geometries.remove(index);
	}
	public boolean remove(Object o) {
		return _geometries.remove(o);
	}
	public int size() {
		return _geometries.size();
	}
	public String toString() {
		return _geometries.toString();
	}
	
}
