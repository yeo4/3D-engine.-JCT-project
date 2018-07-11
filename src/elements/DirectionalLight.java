package elements;

import primitives.*;

public class DirectionalLight extends Light implements LightSource{
	// direction of the light
	private Vector _direction;
	
	// ***************** Constructors ********************** //
	
	/**
	 * regular constructor
	 * @param direction
	 * @param color
	 */
	public DirectionalLight(Vector direction, Color color)
	{
		super(color);
		this._direction = new Vector(direction);
	}
	
	/**
	 * copy constructor
	 * @param d
	 */
	public DirectionalLight(DirectionalLight d)
	{
		super(d._color);
		this._direction = new Vector(d._direction);
	}

	// ***************** Getters/Setters ********************** //
	
	public Vector get_direction() {
		return _direction;
	}

	public void set_direction(Vector _direction) {
		this._direction = _direction;
	}

	/**
	 * gets the intensity of the ambient light
	 * 
	 */
	@Override
	public Color getIntensity(Point3D point) {
		return this._color;
	}
	
	/**
	 * returns the vector between the light source and the point
	 */
	@Override
	public Vector getL(Point3D point) {
		return this._direction;
	}

	/**
	 * returns the vector between the light source and the point
	 */
	@Override
	public Vector getD(Point3D point) {
		return this._direction;
	}
	
	
}