package geometries;

import java.util.ArrayList;

import primitives.*;

public class Tube extends RadialGeometry {
	protected Point3D _axisPoint;
	protected Vector _axisDirection;
	
	// ***************** Constructors ********************** // 
	public Tube(double r, Point3D _axisPoint, Vector _axisDirection) throws Exception {
		super(r);
		if(_axisDirection.equals(Vector.ZeroVector))
			throw new Exception("axis direction must not be the a zero vector");
		this._axisPoint = new Point3D(_axisPoint);
		this._axisDirection = new Vector(_axisDirection.normalization());
	}
	
	public Tube(Tube t) throws Exception {
		super(t._radius);
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
	public Vector GetNormal(Point3D p) {
		//if(is not on Tube)
		//	throw new...
		double d = (this._axisDirection.dot_product(new Vector(p.subtract(this._axisPoint))));
		Point3D o = new Point3D(this._axisPoint.add(p.subtract(this._axisPoint).normalization().multiply(d)));
		return new Vector(p.subtract(o)).normalization();
	}

	@Override
	public ArrayList<Point3D> findIntersections(Ray r) {
		// TODO Auto-generated method stub
		return null;
	}

}
