package geometries;

import java.util.List;
import java.util.Map;

import primitives.*;

public class FramedStraightRectangles extends Plane {
	private final static double FRAMESIZE = 5;
	private double _x1;
	private double _x2;
	private double _y1;
	private double _y2;
	private double _z1;
	private double _z2;

	// ***************** Constructors ********************** // 
	
	public FramedStraightRectangles(double _x1, double _x2, double _y1, double _y2, double _z1, double _z2, Point3D _p, Vector _normal, Color emission, Material material){
		super(_p, _normal, emission,material);
		this._x1 = _x1;
		this._x2 = _x2;
		this._y1 = _y1;
		this._y2 = _y2;
		this._z1 = _z1;
		this._z2 = _z2;
	}
	public FramedStraightRectangles(double _x1, double _x2, double _y1, double _y2, double _z1, double _z2,Point3D _p1, Point3D _p2, Point3D _p3, Color emission, Material material){
		super(_p1,_p2,_p3, emission,material);
		this._x1 = _x1;
		this._x2 = _x2;
		this._y1 = _y1;
		this._y2 = _y2;
		this._z1 = _z1;
		this._z2 = _z2;
	}
	public FramedStraightRectangles(FramedStraightRectangles t) {
		super(t._p,t._normal, t._emission,t._material);
		this._x1 = t._x1;
		this._x2 = t._x2;
		this._y1 = t._y1;
		this._y2 = t._y2;
		this._z1 = t._z1;
		this._z2 = t._z2;
	}
	
	// ***************** Getters/Setters ********************** //  

	public double get_x1() {
		return _x1;
	}

	public double get_x2() {
		return _x2;
	}

	public double get_y1() {
		return _y1;
	}
	
	public double get_y2() {
		return _y2;
	}
	
	public double get_z1() {
		return _z1;
	}
	
	public double get_z2() {
		return _z2;
	}
	
	@Override
	public Color get_emission(Point3D p) {
		if(this.isOnFrameGivenOnPlane(p))
			return new Color(255,255,255);
		return _emission;
	}
	// ***************** Administration ******************** //
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		FramedStraightRectangles other = (FramedStraightRectangles) obj;
		if (Double.doubleToLongBits(_x1) != Double.doubleToLongBits(other._x1))
			return false;
		if (Double.doubleToLongBits(_x2) != Double.doubleToLongBits(other._x2))
			return false;
		if (Double.doubleToLongBits(_y1) != Double.doubleToLongBits(other._y1))
			return false;
		if (Double.doubleToLongBits(_y2) != Double.doubleToLongBits(other._y2))
			return false;
		if (Double.doubleToLongBits(_z1) != Double.doubleToLongBits(other._z1))
			return false;
		if (Double.doubleToLongBits(_z2) != Double.doubleToLongBits(other._z2))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return super.toString() + "Rectangle [_x1=" + _x1 + ", _x2=" + _x2 + ", _y1=" + _y1 + ", _y2=" + _y2 + ", _z1=" + _z1 + ", _z2="
				+ _z2 + "]";
	}
	
	// ***************** Operations ******************** //
	
	public boolean isOnFrameGivenOnPlane(Point3D p)
	{
		if(Math.abs(p.getX().get() - _x1) < FramedStraightRectangles.FRAMESIZE || Math.abs(p.getX().get() - _x2) < FramedStraightRectangles.FRAMESIZE ||
				Math.abs(p.getY().get() - _y1) < FramedStraightRectangles.FRAMESIZE || Math.abs(p.getY().get() - _y2) < FramedStraightRectangles.FRAMESIZE || 
					Math.abs(p.getZ().get() - _z1) < FramedStraightRectangles.FRAMESIZE || Math.abs(p.getZ().get() - _z2) < FramedStraightRectangles.FRAMESIZE) {
				return true;
	}
		return false;
	}
	
	@Override
	public Vector getNormal(Point3D p) {
		return super.getNormal(p);
	}
	
	@Override
	public Map<Geometry, List<Point3D>> findIntersections(Ray r) {
		Map<Geometry, List<Point3D>> intersections = super.findIntersections(r);
		for (int i=0; i < intersections.size(); i++) {
			
		    Point3D p = intersections.get(this).get(i);
		    
			if(p.getX().get() < this._x1 || p.getX().get() > this._x2)
			{
				intersections.clear();
				return intersections;
			}
			
			if(p.getY().get() < this._y1 || p.getY().get() > this._y2)
			{
				intersections.clear();
				return intersections;
			}
			
			if(p.getZ().get() < this._z1 || p.getZ().get() > this._z2)
			{
				intersections.clear();
				return intersections;
			}
		}		
		
		return intersections;
	}
		
		
	
}
