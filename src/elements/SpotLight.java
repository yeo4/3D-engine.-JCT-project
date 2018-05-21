package elements;

import primitives.*;

public class SpotLight extends PointLight implements LightSource{	
	private Vector _direction;

	// ***************** Constructors ********************** //

	public SpotLight(Color _color, Point3D _position, double _Kc, double _Kl, double _Kq, Vector _direction) {
		super(_color, _position, _Kc, _Kl, _Kq);
		this._direction = new Vector(_direction);
	}
	
	public SpotLight(SpotLight SPL) {
		this(SPL._color,SPL._position,SPL._Kc,SPL._Kl,SPL._Kq,SPL._direction);
	}
	
	// ***************** Operations ******************** //	
	
	@Override
	public Color getIntensity(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getL(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vector getD(Point3D point) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	// ***************** Getters/Setters ********************** // 

	public Vector get_direction() {
		return _direction;
	}

	public void set_direction(Vector _direction) {
		this._direction = _direction;
	}




}
