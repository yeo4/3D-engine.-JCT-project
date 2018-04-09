package geometries;

import primitives.*;

public class Cylinder extends Tube {
	private double _hight;
	
	// ***************** Constructors ********************** //
	
	public Cylinder(double r, Point3D _axisPoint, Vector _axisDirection, double _hight) throws Exception {
		super(r, _axisPoint, _axisDirection);
		if(_hight <= 0)
			throw new Exception("Hight must be positive");
		this._hight = _hight;
	}
		
	public Cylinder(Cylinder c) throws Exception {
		super(c._radius, c._axisPoint, c._axisDirection);
		this._hight = c._hight;
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

}
