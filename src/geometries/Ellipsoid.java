package geometries;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import primitives.*;


public class Ellipsoid extends Geometry {
	private Point3D _center;
	private double _a;
	private double _b;
	private double _c;
	private Point3D _inverses;
	
	// ***************** Constructors ********************** //
	
	public Ellipsoid(Point3D center, double a, double b, double c, Color emission, Material material) {
		if(a <= 0 || b <= 0 || c <= 0)
			throw new IllegalArgumentException("Radius must be positive");
		this._center = new Point3D(center);
		this._a = a;
		this._b = b;
		this._c = c;
		this._inverses = new Point3D(1/this._a, 1/this._b, 1/this._c);
		this._emission = new Color(emission);
		this._material = new Material(material);
	}
	
	public Ellipsoid(Ellipsoid e) {
		this._center = new Point3D(e._center);
		this._a = e._a;
		this._b = e._b;
		this._c = e._c;
		this._inverses = new Point3D(e._inverses);
		this._emission = new Color(e._emission);
		this._material = new Material(e._material);

		
	}
	
	// ***************** Getters/Setters ********************** //

	public Point3D get_center() {
		return _center;
	}

	public double get_a() {
		return _a;
	}

	public double get_b() {
		return _b;
	}

	public double get_c() {
		return _c;
	}

	// ***************** Administration ******************** //

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ellipsoid other = (Ellipsoid) obj;
		if (Double.doubleToLongBits(_a) != Double.doubleToLongBits(other._a))
			return false;
		if (Double.doubleToLongBits(_b) != Double.doubleToLongBits(other._b))
			return false;
		if (Double.doubleToLongBits(_c) != Double.doubleToLongBits(other._c))
			return false;
		if (_center == null) {
			if (other._center != null)
				return false;
		} else if (!_center.equals(other._center))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ellipsoid [_center=" + _center + ", _a=" + _a + ", _b=" + _b + ", _c=" + _c + "]";
	}

	// ***************** Operations ******************** //

	@Override
	public Vector getNormal(Point3D p) {
		Point3D temp = new Point3D(p.getX().get()/this._a, p.getY().get()/this._b, p.getZ().get()/this._c);
		temp = temp.add(new Vector(p));
		
		return new Vector(temp).normalization();
	}

	@Override
	public Map<Geometry, List<Point3D>> findIntersections(Ray r) {
		Map<Geometry, List<Point3D>> intersections = new HashMap<Geometry, List<Point3D>>();
		ArrayList<Point3D> arrPoints = new ArrayList<>();
		
		Vector v1 = new Vector(r.getDirection().get().getX().get()/this._a, r.getDirection().get().getY().get()/this._b, r.getDirection().get().getZ().get()/this._c);
		Point3D p1 = new Point3D((r.getP3D().getX().get() - this._center.getX().get())/this._a,(r.getP3D().getY().get() - this._center.getY().get())/this._b, (r.getP3D().getZ().get() - this._center.getZ().get())/this._c);
		Vector p1Vec = new Vector(p1);
		
		double A = v1.dot_product(v1);
		double B = 2*(p1Vec.dot_product(v1));
		double C = p1Vec.dot_product(p1Vec) - 1;
		
		double discriminant = B*B - 4*A*C;
		
		if(Coordinate.isToCloseToZero(discriminant))
			discriminant = 0;
		if(discriminant < 0)
			return intersections;
		
		double discriminantRoot = Math.sqrt(discriminant);
		double t1 = (-B + discriminantRoot)/(2*A);
		double t2 = (-B - discriminantRoot)/(2*A);
		
		if(t1 > 0)
			arrPoints.add(r.getP3D().add(r.getDirection().multiply(t1)));
		if(t2 > 0 && discriminant!=0)
			arrPoints.add(r.getP3D().add(r.getDirection().multiply(t2)));
		
		if(arrPoints.size() != 0)
			intersections.put(this, arrPoints);
		
		return intersections;

	}

}
