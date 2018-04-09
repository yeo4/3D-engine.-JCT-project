package geometries;

import primitives.*;

public class Triangle extends Geometry {
	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;

	// ***************** Constructors ********************** // 
	
	public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) throws Exception {
		if(Vector.areCollinear(new Vector(_p1), new Vector(_p2), new Vector(_p3)))
			throw new Exception("triangles points must not be colliniar");
		this._p1 = _p1;
		this._p2 = _p2;
		this._p3 = _p3;
	}
		public Triangle(Triangle t) {
		this._p1 = t._p1;
		this._p2 = t._p2;
		this._p3 = t._p3;
	}
	// ***************** Getters/Setters ********************** //  

	public Point3D get_p1() {
		return _p1;
	}

	/*public void set_p1(Point3D _p1) {
		this._p1 = _p1;
	}*/

	public Point3D get_p2() {
		return _p2;
	}

	/*public void set_p2(Point3D _p2) {
		this._p2 = _p2;
	}*/

	public Point3D get_p3() {
		return _p3;
	}

	/*public void set_p3(Point3D _p3) {
		this._p3 = _p3;
	}*/
	
	// ***************** Administration ******************** //

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triangle other = (Triangle) obj;
		if (_p1 == null) {
			if (other._p1 != null)
				return false;
		} else if (!_p1.equals(other._p1))
			return false;
		if (_p2 == null) {
			if (other._p2 != null)
				return false;
		} else if (!_p2.equals(other._p2))
			return false;
		if (_p3 == null) {
			if (other._p3 != null)
				return false;
		} else if (!_p3.equals(other._p3))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Triangle [_p1=" + _p1 + ", _p2=" + _p2 + ", _p3=" + _p3 + "]";
	}

	// ***************** Operations ******************** //
	
	@Override
	public Vector GetNormal(Point3D p) {
		// TODO Auto-generated method stub
		return null;
	}

}
