package geometries;

import primitives.*;

public abstract class Geometry {
	
	// ***************** Constructors ********************** //
	
	public Geometry() {}
	
	public Geometry(Geometry g) {
		
	}
	
	// ***************** Administration  ******************** // 
	
	@Override
	public String toString() {
		return "Geometry []";
	}
	
	// ***************** Operations ******************** // 
	
	public abstract Vector GetNormal(Point3D p);

}
