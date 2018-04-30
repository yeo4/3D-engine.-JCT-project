package geometries;

import java.util.ArrayList;

import primitives.*;

public class Triangle extends Plane {
	private Point3D _p1;
	private Point3D _p2;
	private Point3D _p3;

	// ***************** Constructors ********************** // 
	
	public Triangle(Point3D _p1, Point3D _p2, Point3D _p3) throws Exception {
		super(_p1,_p2,_p3);
		this._p1 = new Point3D (_p1);
		this._p2 = new Point3D (_p2);
		this._p3 = new Point3D (_p3);
	}
	public Triangle(Triangle t) throws Exception {
		super(t._p,t._normal);
		this._p1 = new Point3D (t._p1);
		this._p2 = new Point3D (t._p2);
		this._p3 = new Point3D (t._p3);
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
		return super.toString() + "△ [_p1=" + _p1 + ", _p2=" + _p2 + ", _p3=" + _p3 + "]";
	}

	// ***************** Operations ******************** //
	
	@Override
	public ArrayList<Point3D> findIntersections(Ray r) {
		ArrayList<Point3D> arrPoints = super.findIntersections(r);
		for (int i=0;i<arrPoints.size();i++) {
			Vector v1 = this._p1.subtract(r.getP3D());
			Vector v2 = this._p2.subtract(r.getP3D());
			Vector v3 = this._p3.subtract(r.getP3D());
			Vector N1 = v1.cross_product(v2).normalization();
			Vector N2 = v2.cross_product(v3).normalization();
			Vector N3 = v3.cross_product(v1).normalization();
			
			boolean b3 = (new Coordinate(r.getDirection().dot_product(N1)).equals(Coordinate.ZERO) ||
					new Coordinate(r.getDirection().dot_product(N2)).equals(Coordinate.ZERO) ||
					new Coordinate(r.getDirection().dot_product(N3)).equals(Coordinate.ZERO));
			boolean b1 = !(r.getDirection().dot_product(N1) > 0 && r.getDirection().dot_product(N2) > 0 && r.getDirection().dot_product(N3) > 0);
			boolean b2 = !(r.getDirection().dot_product(N1) < 0 && r.getDirection().dot_product(N2) < 0 && r.getDirection().dot_product(N3) < 0);
				if((b1 && b2) || b3)
					arrPoints.clear();
		}		
		return arrPoints;
	}
}
