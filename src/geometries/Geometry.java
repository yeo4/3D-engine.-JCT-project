package geometries;

import java.util.List;

import primitives.*;

public abstract class Geometry {

	// ***************** Constructors ********************** //

	// ***************** Administration ******************** //

	@Override
	public String toString() {
		return "Geometry []";
	}

	// ***************** Operations ******************** //

	public Vector getNormal(Point3D p) throws Exception {
		return null;
	}

	public abstract List<Point3D> findIntersections(Ray r);
}
