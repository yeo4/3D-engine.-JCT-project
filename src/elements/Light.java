package elements;

import primitives.Color;

public abstract class Light {
	protected Color _color;
	public abstract Color getIntensity();

	public Light(Color _color) {
		super();
		this._color = _color;
	}

	public Color get_color() {
		return _color;
	}
	public void set_color(Color _color) {
		this._color = _color;
	}
}
