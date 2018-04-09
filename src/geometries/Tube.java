package geometries;

import primitives.*;

public class Tube extends RadialGeometry {
	protected Point3D _axisPoint;
	protected Vector _axisDirection;
	
	// ***************** Constructors ********************** // 

	public Tube(double r, Point3D _axisPoint, Vector _axisDirection) throws Exception {
		super(r);
		if(_axisDirection == Vector.ZeroVector)
			throw new Exception("axis direction must not be the a zero vector");
		this._axisPoint = _axisPoint;
		this._axisDirection = _axisDirection;
	}
	
	public Tube(Tube t) throws Exception {
		super(t._radius);
		this._axisPoint = t._axisPoint;
		this._axisDirection = t._axisDirection;
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
	
	@Override
	public Vector GetNormal(Point3D p) {
		// TODO Auto-generated method stub
		return null;
	}

}
