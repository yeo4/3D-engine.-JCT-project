package elements;

import primitives.*;

public class AmbientLight extends Light{
	private double Ka;

	public AmbientLight(Color _color,double ka) {
		super(_color);
		this.Ka = ka;
	}
	public AmbientLight() {
		super(new Color(25,100,100));
		this.Ka = 0.8;
	}
	
	@Override
	public Color getIntensity() {
		_color.scale(Ka);
		return _color;
	}
	
	public double getKa() {
		return Ka;
	}
	public void setKa(double ka) {
		Ka = ka;
	}

}
