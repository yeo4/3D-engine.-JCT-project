package elements;

import primitives.*;

public class DirectionalLight extends Light{
	Vector _direction;
	
	// ***************** Constructors ********************** //
	
	public DirectionalLight(Vector direction, Color color)
	{
		super(color);
		this._direction = new Vector(direction);
	}
	
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

	@Override
	public Color getIntensity() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}