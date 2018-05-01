package geometries;

import java.util.ArrayList;

import primitives.*;

public class Cylinder extends Tube {
	private double _hight;
	private Point3D _Pcenter1;
	private Point3D _Pcenter2;
	private Plane _plane1;
	private Plane _plane2;
	
	// ***************** Constructors ********************** //
	
	public Cylinder(double r, Point3D _axisPoint, Vector _axisDirection, double _hight) throws Exception {
		super(r, _axisPoint, _axisDirection);
		if(_hight <= 0)
			throw new Exception("Hight must be positive");
		this._hight = _hight;
		this._Pcenter1 = this._axisPoint.add(this._axisDirection.multiply(this._hight / 2));
		this._Pcenter2 = this._axisPoint.add(this._axisDirection.multiply(-this._hight / 2));
		this._plane1 = new Plane(this._Pcenter1, this._axisDirection);
		this._plane2 = new Plane(this._Pcenter2, this._axisDirection);
	}
		
	public Cylinder(Cylinder c) throws Exception {
		super(c._radius, c._axisPoint, c._axisDirection);
		this._hight = c._hight;
		this._Pcenter1 = new Point3D (c._Pcenter1);
		this._Pcenter2 = new Point3D (c._Pcenter2);
		this._plane1 = new Plane(c._plane1);
		this._plane2 = new Plane(c._plane2);
	}

	// ***************** Getters/Setters ********************** // 
	
	public double get_hight() {
		return _hight;
	}
	
	/*public void set_hight(double _hight) {
		this._hight = _hight;
	}*/
	
	// ***************** Administration  ******************** //

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cylinder other = (Cylinder) obj;
		if (Double.doubleToLongBits(_hight) != Double.doubleToLongBits(other._hight))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + "Cylinder [_hight=" + _hight + "]";
	}
	
	// ***************** Operations ******************** // 
	
	public boolean is_on_cap1(Point3D p) {
		Vector v = p.subtract(_Pcenter1);
		if(Coordinate.ZERO.equals(p.subtract(this._Pcenter1).dot_product(this._axisDirection)) && v.dot_product(v) < this._radius * this._radius)
			return true;
		return false;
			
	}
	
	public boolean is_on_cap2(Point3D p) {
		Vector v = p.subtract(_Pcenter2);
		if(Coordinate.ZERO.equals(p.subtract(this._Pcenter2).dot_product(this._axisDirection)) && v.dot_product(v) < this._radius * this._radius)
			return true;
		return false;
			
	}
	
	public boolean is_on_cap1_given_on_plane(Point3D p) {
		Vector v = p.subtract(_Pcenter1);
		double a = v.dot_product(v);
		double rSquare = this._radius * this._radius;
		
		if(Coordinate.ZERO.equals(a - rSquare))
			return false;
		if(a < rSquare)
			return true;
		return false;
			
	}
	
	public boolean is_on_cap2_given_on_plane(Point3D p) {
		Vector v = p.subtract(_Pcenter2);
		double a = v.dot_product(v);
		double rSquare = this._radius * this._radius;
		
		if(Coordinate.ZERO.equals(a - rSquare))
			return false;
		if(a < rSquare)
			return true;
		return false;
			
	}
	
	@Override
	public Vector getNormal(Point3D p) {
		//if(is not on Cylinder)
		//	throw new...
		
		if(this.is_on_cap1(p))
			return p.subtract(this._axisPoint.add(p.subtract(this._Pcenter1))).normalization();
		if(this.is_on_cap2(p))
			return p.subtract(this._axisPoint.add(p.subtract(this._Pcenter2))).normalization();
		
		return super.getNormal(p);
	}

	@Override
	public ArrayList<Point3D> findIntersections(Ray r) {
		ArrayList<Point3D> arrPoints = new ArrayList<>();
		
		ArrayList<Point3D> plane1Points = this._plane1.findIntersections(r);
		ArrayList<Point3D> plane2Points = this._plane2.findIntersections(r);
		ArrayList<Point3D> tubePoints = super.findIntersections(r);
		
		if(plane1Points.size() != 0)
			if(is_on_cap1_given_on_plane(plane1Points.get(0)))
				arrPoints.add(plane1Points.get(0));
		if(plane2Points.size() != 0)
			if(is_on_cap2_given_on_plane(new Point3D(plane2Points.get(0))))
				arrPoints.add(new Point3D(plane2Points.get(0)));
		for(int i = 0; i < tubePoints.size(); i++)
		{
			double d1 = this.get_axisDirection().dot_product(tubePoints.get(i).subtract(this._Pcenter1));
			double d2 = this.get_axisDirection().dot_product(tubePoints.get(i).subtract(this._Pcenter2));
			if(d1 <= 0 && d2 >= 0)
				arrPoints.add(tubePoints.get(i));
			else if(new Coordinate(d1).equals(Coordinate.ZERO) && new Coordinate(d2).equals(Coordinate.ZERO))
				arrPoints.add(tubePoints.get(i));
		}
		
		return arrPoints;
	}
}
