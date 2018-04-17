package geometries;

import primitives.*;

public class Cylinder extends Tube {
	private double _hight;
	private Point3D _Pcenter1;
	private Point3D _Pcenter2;
	
	// ***************** Constructors ********************** //
	
	public Cylinder(double r, Point3D _axisPoint, Vector _axisDirection, double _hight) throws Exception {
		super(r, _axisPoint, _axisDirection);
		if(_hight <= 0)
			throw new Exception("Hight must be positive");
		this._hight = _hight;
		this._Pcenter1 = new Point3D(this._axisPoint.add(this._axisDirection.multiply(this._hight / 2)));
		this._Pcenter2 = new Point3D(this._axisPoint.add(this._axisDirection.multiply(-this._hight / 2)));
	}
		
	public Cylinder(Cylinder c) throws Exception {
		super(c._radius, c._axisPoint, c._axisDirection);
		this._hight = c._hight;
		this._Pcenter1 = new Point3D (c._Pcenter1);
		this._Pcenter2 = new Point3D (c._Pcenter2);
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
		
		if(Coordinate.ZERO.equals(new Coordinate(p.subtract(this._Pcenter1).dot_product(this._axisDirection))) && p.distance(this._Pcenter1) < this._radius)
			return true;
		return false;
			
	}
	
	public boolean is_on_cap2(Point3D p) {
		
		if(Coordinate.ZERO.equals(new Coordinate(p.subtract(this._Pcenter2).dot_product(this._axisDirection))) && p.distance(this._Pcenter2) < this._radius)
			return true;
		return false;
			
	}
	@Override
	public Vector GetNormal(Point3D p) {
		//if(is not on Cylinder)
		//	throw new...
		
		if(this.is_on_cap1(p))
			return p.subtract(this._axisPoint.add(new Vector(p.subtract(this._Pcenter1)))).normalization();
		if(this.is_on_cap2(p))
			return p.subtract(this._axisPoint.add(new Vector(p.subtract(this._Pcenter2)))).normalization();
		
		return super.GetNormal(p);
	}


}
