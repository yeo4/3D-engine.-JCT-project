package geometries;

import java.util.List;
import java.util.Map;

import primitives.*;

public abstract class Geometry {
	protected Color _emission;
	protected Material _material;
	
	// ***************** Constructors ********************** //
	
	// ***************** Getters/Setters ********************** // 

	/**
	 * returns the emission of the geometry at the given point
	 * @param p
	 * @return
	 */
	public Color get_emission(Point3D p) {
		return _emission;
	}
	
	/**
	 * returns the material of the geometry
	 * @return
	 */
	public Material get_material() {
		return _material;
	}
	// ***************** Administration ******************** //

	@Override
	public String toString() {
		return "Geometry []";
	}

	// ***************** Operations ******************** //

	/**
	 * returns the normal at the given point
	 * @param p
	 * @return
	 */
	public abstract Vector getNormal(Point3D p);

	/**
	 * returns the intersection points of the given ray with the geometry
	 * @param r
	 * @return
	 */
	public abstract Map<Geometry,List<Point3D>> findIntersections(Ray r);
}
