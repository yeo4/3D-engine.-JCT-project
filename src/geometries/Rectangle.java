package geometries;

import java.util.List;
import java.util.Map;

import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

public class Rectangle extends Plane {
	private final static double FRAMESIZE = 15;
	private Ray _r1;
	private Ray _r2;
	// ***************** Constructors ********************** // 
	
		public Rectangle(Ray _r1, Ray r2, Point3D _p, Color emission, Material material){
			super(_p, _r1.getDirection().cross_product(r2.getDirection()), emission,material);
			this._r1 = new Ray(_r1);
			this._r2 = new Ray(_r2);
		}
		public Rectangle(Point3D _p1, Point3D _p2, Point3D _p3, Color emission, Material material){
			super(_p1,_p2,_p3, emission,material);
			this._r1 = new Ray(_p1, _p2.subtract(_p1));
			this._r2 = new Ray(_p1, _p3.subtract(_p1));
			
		}
		public Rectangle(Rectangle t) {
			super(t._p,t._normal, t._emission,t._material);
			this._r1 = new Ray(t._r1);
			this._r2 = new Ray(t._r2);
		}
		
		// ***************** Getters/Setters ********************** //  

		public Ray get_r1() {
			return _r1;
		}

		public Ray get_r2() {
			return _r2;
		}
		
		@Override
		public Color get_emission(Point3D p) {
		    Vector v = p.subtract(this._p);
		    
		    double d1 = v.dot_product(_r1.getDirection());
		    double d2 = v.dot_product(_r2.getDirection());	
		    
			if(d1 <= this.FRAMESIZE || d2 <= this.FRAMESIZE || _r1.getT() - d1 <= this.FRAMESIZE || _r2.getT() - d2 <= this.FRAMESIZE)
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
			Rectangle other = (Rectangle) obj;
			if (_r1 == null) {
				if (other._r1 != null)
					return false;
			} else if (!_r1.equals(other._r1))
				return false;
			if (_r2 == null) {
				if (other._r2 != null)
					return false;
			} else if (!_r2.equals(other._r2))
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return super.toString() + "Rectangle [_r1=" + _r1 + ", _r2=" + _r2 + "]";
		}
		
		// ***************** Operations ******************** //
		
		
		@Override
		public Vector getNormal(Point3D p) {
			return super.getNormal(p);
		}
		
		@Override
		public Map<Geometry, List<Point3D>> findIntersections(Ray r) {
			Map<Geometry, List<Point3D>> intersections = super.findIntersections(r);
			for (int i=0; i < intersections.size(); i++) {
				
			    Point3D p = intersections.get(this).get(i);
			    Vector v = p.subtract(this._p);
			    
			    double d1 = v.dot_product(_r1.getDirection());
			    
			    if(d1 < 0 || d1 > _r1.getT())
				{
					intersections.clear();
					return intersections;
				}
			    
			    double d2 = v.dot_product(_r2.getDirection());	
			    
			    if(d2 < 0 || d2 > _r2.getT())
				{
					intersections.clear();
					return intersections;
				}
				
			}		
			
			return intersections;
		}
}
