package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Point3D;

public class XZBOARDRECTANGLE extends Rectangle {
	private Color _c1;
	private Color _c2;
	private int _l;
	
	public XZBOARDRECTANGLE(Point3D _p1, Point3D _p2, Point3D _p3, Color emission, Material material, Color c1, Color c2, int l) {
		super(_p1, _p2, _p3, emission, material);
		_c1 = new Color(c1);
		_c2 = new Color(c2);
		_l = l;
		}
	
	
	@Override
	public Color get_emission(Point3D p) {
		double i1;
		double i2 = 0;
		if(p.getX().get() < 0 && p.getZ().get() > 0)
		{
			i1 = Math.abs(Math.floor(p.getX().get()) - _l/2);
			i2 = p.getZ().get();
			
		}else
			if(p.getZ().get() < 0 && p.getX().get() > 0)
			{
				i2 = Math.abs(Math.floor(p.getZ().get()) - _l/2);
				i1 = p.getX().get();
				
			}else
				if(p.getZ().get() < 0 && p.getX().get() < 0)
				{
					i1 = Math.abs(Math.floor(p.getX().get()) - _l/2);
					i2 = Math.abs(Math.floor(p.getZ().get()) - _l/2);
				}else
				{
					i1 = Math.floor(p.getX().get());
					i1 = Math.floor(p.getZ().get());
				}
		
		if(i1 % _l >= _l/2 ^ i2 % _l >= _l/2)
		{
			return new Color(_c1);
		}
		
		return new Color(_c2);
	}
}
