package geometries;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import primitives.*;

public class Tube extends RadialGeometry {
	protected Point3D _axisPoint; 
	protected Vector _axisDirection;
  
	// ***************** Constructors ********************** // 
	public Tube(double r, Point3D _axisPoint, Vector _axisDirection, Color emission, Material material) {
		super(r, emission, material);
		if(_axisDirection.equals(Vector.ZeroVector))
			throw new IllegalArgumentException("axis direction must not be the a zero vector");
		this._axisPoint = new Point3D(_axisPoint);
		this._axisDirection = _axisDirection.normalization();
	}
	 
	public Tube(Tube t) {
		super(t._radius, t._emission, t._material);
		this._axisPoint = new Point3D(t._axisPoint);
		this._axisDirection = new Vector(t._axisDirection);
	}
	
	// ***************** Getters/Setters ********************** //
	
	public Point3D get_axisPoint() {
		return _axisPoint;
		
	} 

	
	
	/*public void set_axisPoint(Point3D _axisPoint) {
		this._axisPoint = _axisPoint;
	}*/

	public Vector get_axisDirection() {
		return _axisDirection;
	}

	/*public void set_axisDirection(Vector _axisDirection) {
		this._axisDirection = _axisDirection;
	}*/
	
	// ***************** Administration ******************** //
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tube other = (Tube) obj;
		if (_axisDirection == null) {
			if (other._axisDirection != null)
				return false;
		} else if (!_axisDirection.equals(other._axisDirection))
			return false;
		if (_axisPoint == null) {
			if (other._axisPoint != null)
				return false;
		} else if (!_axisPoint.equals(other._axisPoint))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Tube [_axisPoint=" + _axisPoint + ", _axisDirection=" + _axisDirection + "]";
	}

	// ***************** Operations ******************** // 
	
	public boolean is_on_tube(Point3D p1) {
		/*if() {
			return true;
		}
		return false;*/
		return false;
	}
	
	@Override
	public Vector getNormal(Point3D p) {
		//if(is not on Tube)
		//	throw new...
		double d = (this._axisDirection.dot_product(p.subtract(this._axisPoint)));
		Point3D o = this._axisPoint.add(p.subtract(this._axisPoint).normalization().multiply(d));
		return p.subtract(o).normalization();
	}

	@Override
	public Map<Geometry, List<Point3D>> findIntersections(Ray r) {
		Map<Geometry, List<Point3D>> intersections = new HashMap<Geometry, List<Point3D>>();
		ArrayList<Point3D> arrPoints = new ArrayList<>();

		Vector deltaP = r.getP3D().subtract(this._axisPoint);
		double dotProduct1 = r.getDirection().dot_product(this.get_axisDirection());
		double dotProduct2 = deltaP.dot_product(this.get_axisDirection());
		Vector temp1 = r.getDirection().subtract(this._axisDirection.multiply(dotProduct1));
		Vector temp2 = deltaP.subtract(this._axisDirection.multiply(dotProduct2));
				
		double A = temp1.dot_product(temp1);
		double B = 2 * (temp1.dot_product(temp2));
		double C = temp2.dot_product(temp2) - this._radius * this._radius;
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
