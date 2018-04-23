package geometries;

import java.util.ArrayList;

import primitives.*;

public abstract class Geometry {
	
	// ***************** Constructors ********************** //
	
	
	// ***************** Administration  ******************** // 
	
	@Override
	public String toString() {
		return "Geometry []";
	}
	
	// ***************** Operations ******************** // 
	
	public abstract Vector GetNormal(Point3D p) throws Exception;
	public abstract ArrayList<Point3D> findIntersections (Ray r);
}
