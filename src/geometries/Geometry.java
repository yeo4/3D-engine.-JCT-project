package geometries;

import java.util.List;
import java.util.Map;

import primitives.*;

public abstract class Geometry {
	protected Color _emission;
	protected Material _material;
	
	// ***************** Constructors ********************** //
	
	// ***************** Getters/Setters ********************** // 

	public Color get_emission() {
		return _emission;
	}
	
	public Material get_material() {
		return _material;
	}
	// ***************** Administration ******************** //

	@Override
	public String toString() {
		return "Geometry []";
	}

	// ***************** Operations ******************** //

	public abstract Vector getNormal(Point3D p);

	public abstract Map<Geometry,List<Point3D>> findIntersections(Ray r);
}
