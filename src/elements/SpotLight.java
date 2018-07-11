package elements;

import primitives.*;

public class SpotLight extends PointLight implements LightSource{	
	private Vector _direction;

	// ***************** Constructors ********************** //
	
	/**
	 * regular constructor
	 * @param _color
	 * @param _position
	 * @param _Kc
	 * @param _Kl
	 * @param _Kq
	 * @param _direction
	 */
	public SpotLight(Color _color, Point3D _position, double _Kc, double _Kl, double _Kq, Vector _direction) {
		super(_color, _position, _Kc, _Kl, _Kq);
		this._direction = _direction.normalization();
	}
	
	/**
	 * copy constructor
	 * @param SPL
	 */
	public SpotLight(SpotLight SPL) {
		this(SPL._color,SPL._position,SPL._Kc,SPL._Kl,SPL._Kq,SPL._direction);
	}
	
	// ***************** Operations ******************** //	
	
	/**
	 * returns the intensity of the light
	 */
	@Override
	public Color getIntensity(Point3D point) {
		double d = this._direction.dot_product(this.getL(point));
		if(d <= 0)
			d = 0;
		return super.getIntensity(point).scale(d);
	}

	/**
	 * returns the vector between the point and the light
	 */
	@Override
	public Vector getL(Point3D point) {
		return super.getL(point);
	}

	/**
	 * returns the vector between the point and the light
	 */
	@Override
	public Vector getD(Point3D point) {
		return this._direction;
	}
	
	
	// ***************** Getters/Setters ********************** // 

	public Vector get_direction() {
		return _direction;
	}

	public void set_direction(Vector _direction) {
		this._direction = _direction;
	}




}
